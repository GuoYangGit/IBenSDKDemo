package com.example.ibensdkdemo.ui;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ibensdkdemo.R;
import com.samton.ibensdk_common.IBenSDK;
import com.samton.ibensdk_common.factory.IBenPrintFactory;

import androidx.appcompat.app.AppCompatActivity;

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
 * 打印机测试类
 */
public class PrintActivity extends AppCompatActivity {
    private Bitmap mPrintImg;
    private Bitmap mPrintImgGray;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        mPrintImg = ((BitmapDrawable) getResources().getDrawable(R.mipmap.img_print)).getBitmap();
        mPrintImgGray = ((BitmapDrawable) getResources().getDrawable(R.mipmap.img_print)).getBitmap();
    }

    /**
     * 连接打印机
     */
    public void onConnect(View view) {
        IBenSDK.getInstance().getPrintFactory().connectPrinter(this);
    }

    /**
     * 关闭连接
     */
    public void onDisConnect(View view) {
        IBenSDK.getInstance().getPrintFactory().closePrint();
    }

    /**
     * 打印文字
     */
    public void onPrintText(View view) {
        if (!isConnect()) return;
        IBenSDK.getInstance().getPrintFactory()
                //设置打印字体大小,值为0-7
                .setFont(3)
                //设置打印字体位置,左-0、中-1、右-2
                .setPrinter(1)
                //设置打印字体内容
                .printText("这里是打印的文字\r\n");
    }

    /**
     * 打印图片
     */
    public void onPrintImg(View view) {
        if (!isConnect()) return;
        IBenSDK.getInstance().getPrintFactory().printColorImg(mPrintImg, IBenPrintFactory.PAlign.CENTER);
    }

    /**
     * 打印灰度图
     */
    public void onPrintImgGray(View view) {
        if (!isConnect()) return;
        IBenSDK.getInstance().getPrintFactory().printColorImg2Gray(mPrintImgGray, IBenPrintFactory.PAlign.CENTER);
    }

    /**
     * 切纸
     */
    public void onCutPaper(View view) {
        if (!isConnect()) return;
        IBenSDK.getInstance()
                .getPrintFactory()
                .printText("\r\n")
                .cutPaper();
    }

    /**
     * 判断是否连接打印机
     *
     * @return 是否连接
     */
    private boolean isConnect() {
        boolean isConnect = IBenSDK.getInstance().getPrintFactory().isConnect();
        if (!isConnect) {
            Toast.makeText(this, "当前打印机未连接", Toast.LENGTH_SHORT).show();
        } else {
            int status = IBenSDK.getInstance().getPrintFactory().getCurrentStatus();
            switch (status) {
                case 0:
                    return true;
                case -1:
                    Toast.makeText(this, "接收数据异常", Toast.LENGTH_SHORT).show();
                    return false;
                case -2:
                    Toast.makeText(this, "打印机缺纸", Toast.LENGTH_SHORT).show();
                    return false;
                case -3:
                    Toast.makeText(this, "打印纸即将用完，请更换", Toast.LENGTH_SHORT).show();
                    return false;
                case -4:
                    Toast.makeText(this, "打印机开盖，请检查", Toast.LENGTH_SHORT).show();
                    return false;
                case -5:
                    Toast.makeText(this, "发送数据异常", Toast.LENGTH_SHORT).show();
                    return false;
                default:
                    Toast.makeText(this, "打印失败，请重试", Toast.LENGTH_SHORT).show();
                    return false;
            }
        }
        return false;
    }
}
