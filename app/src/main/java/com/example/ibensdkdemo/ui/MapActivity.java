package com.example.ibensdkdemo.ui;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.example.ibensdkdemo.R;
import com.example.ibensdkdemo.bean.InitBean;
import com.google.gson.Gson;
import com.samton.ibensdk_common.IBenSDK;
import com.samton.ibensdk_common.factory.IBenMoveFactory;
import com.samton.ibensdk_common.utils.FileUtils;
import com.samton.ibensdk_common.utils.LogUtils;
import com.samton.ibensdk_common.utils.SPUtils;
import com.slamtec.slamware.robot.Location;
import com.slamtec.slamware.robot.Pose;

import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {
    private static final String MAP_PATH = Environment.getExternalStorageDirectory().getPath() + "/IBenService/Reception/CurrentMap/currentMap";
    private InitBean mInitBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        try {
            String bean = SPUtils.getInstance().getString("initBean");
            mInitBean = new Gson().fromJson(bean, InitBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            mInitBean = new InitBean();
        }
        //进行底盘连接
        IBenSDK.getInstance().getMoveFactory().connectRobot("192.168.11.1", 1445, new IBenMoveFactory.ConnectCallBack() {
            @Override
            public void onConnectSuccess() {
                loadMap();
            }

            @Override
            public void onConnectFailed() {

            }
        });
    }

    /**
     * 进行地图加载
     */
    private void loadMap() {
        if (!FileUtils.isFileExists(MAP_PATH)) return;
        Pose cachePose = mInitBean.getCurrentMap().getPose();
        IBenSDK.getInstance().getMoveFactory().loadMap(MAP_PATH, cachePose, new IBenMoveFactory.MapCallBack() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailed() {

            }
        });
    }

    /**
     * 获取电量信息
     */
    private void getPowerInfo() {
        IBenSDK.getInstance().getMoveFactory().getBatteryInfo(new IBenMoveFactory.GetBatteryCallBack() {
            @Override
            public void onSuccess(String msg) {
                try {
                    JSONObject job = new JSONObject(msg);
                    // 获取是否在充电
                    boolean isCharging = job.optBoolean("isCharging");
                    // 获取电池电量百分比
                    int mBatteryPercent = job.optInt("batteryPercent");
                    Toast.makeText(MapActivity.this, msg, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailed() {

            }
        });
    }

    /**
     * 进行走点逻辑
     *
     * @param result 进行走点逻辑
     */
    private void goLocation(String result) {
        if (result.isEmpty() || !result.contains(",")) return;
        String[] points = result.split(",");
        if (points.length <= 3) return;
        float yaw = Float.parseFloat(points[3]);
        Location location = new Location(Float.parseFloat(points[0]), Float.parseFloat(points[1]), Float.parseFloat(points[2]));
        IBenSDK.getInstance().getMoveFactory().goLocation(location, yaw, isSuccess -> {
            LogUtils.d("是否已经到达该点位:" + isSuccess);
        }, isOn -> {
            // 当急停开启时该方法才会回调
            LogUtils.d("当前急停状态是否开启:" + isOn);
        });
    }
}