package com.example.ibensdkdemo.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.ibensdkdemo.R;
import com.example.ibensdkdemo.utils.BitmapUtil;
import com.example.ibensdkdemo.utils.HttpUtils;
import com.megvii.facepp.sdk.Facepp;
import com.samton.camerautils.face.FaceCameraView;
import com.samton.ibensdk_common.IBenSDK;
import com.samton.ibensdk_common.factory.IBenVoiceFactory;

import java.io.File;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.disposables.Disposable;

/***
 *
 *   █████▒█    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 *  ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 *  ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 *  ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 *           ░     ░ ░      ░  ░
 *
 * Created by guoyang on 2020/5/11.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 * 人脸识别测试类
 */
public class FaceActivity extends AppCompatActivity {
    private FaceCameraView mFaceCameraView;
    private boolean isRecognition = false;
    // 网络请求
    private Disposable mFaceSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);
        mFaceCameraView = findViewById(R.id.faceView);
        //设置相机数据回调
        mFaceCameraView.setCallBack((data, faces) -> {
            if (isRecognition || faces.size() < 1) return;
            isRecognition = true;
            Bitmap bitmap = BitmapUtil.decodeToBitMap(data);
            if (bitmap == null) {
                isRecognition = false;
                return;
            }
            // 将bitmap存储在磁盘
            String path = BitmapUtil.saveBitmapToSd(bitmap);
            if (TextUtils.isEmpty(path)) {
                isRecognition = false;
                return;
            }
            File file = new File(path);
            if (!file.exists()) {
                isRecognition = false;
                return;
            }
            //进行人脸识别网络请求
            mFaceSubscribe = HttpUtils.recognitionFace(file)
                    .subscribe(bean -> {
                        if (bean.getRs().equals("1")) {
                            IBenSDK.getInstance().getVoiceFactory().startSpeaking(bean.getSpeach(), new IBenVoiceFactory.IBenTTSCallBack() {
                                @Override
                                public void onCompleted(String error) {
                                    isRecognition = false;
                                }
                            });
                        } else {
                            isRecognition = false;
                        }
                    }, throwable -> {
                        // 将人脸数据回调出去处理
                        isRecognition = false;
                    });
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //打开相机
        mFaceCameraView.showCamera(true);
    }

    @Override
    protected void onPause() {
        //关闭相机
        closeDiscern();
        super.onPause();
    }

    /**
     * 关闭识别
     */
    public void closeDiscern() {
        //取消图片上传
        if (mFaceSubscribe != null && !mFaceSubscribe.isDisposed()) {
            mFaceSubscribe.dispose();
            mFaceSubscribe = null;
        }
        if (mFaceCameraView != null) {
            mFaceCameraView.showCamera(false);
            mFaceCameraView = null;
        }
        isRecognition = false;
    }
}