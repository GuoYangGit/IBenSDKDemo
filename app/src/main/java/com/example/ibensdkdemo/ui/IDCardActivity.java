package com.example.ibensdkdemo.ui;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibensdkdemo.R;
import com.samton.ibensdk_common.IBenSDK;
import com.samton.ibensdk_common.data.IDCardBean;
import com.samton.ibensdk_common.factory.IBenIDCardFactory;

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
 * 身份证识别测试类
 */
public class IDCardActivity extends AppCompatActivity {
    private TextView mCardResult;
    private ImageView mAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_card);
        mCardResult = findViewById(R.id.card_result);
        mAvatar = findViewById(R.id.card_avatar);
    }

    @SuppressLint("SetTextI18n")
    public void onStart(View view) {
        // 开始读取身份证信息
        IBenSDK.getInstance().getIDCardFactory().startReadIDCard(this, new IBenIDCardFactory.ReadIDCallBack<IDCardBean>() {

            @Override
            public void onSuccess(IDCardBean result) {
                Toast.makeText(IDCardActivity.this, result.getName(), Toast.LENGTH_SHORT).show();
                mCardResult.setText("身份证信息识别成功:" + result.getName());
                mAvatar.setImageBitmap(BitmapFactory.decodeByteArray(result.getPortrait(), 0, result.getPortrait().length));
            }

            @Override
            public void onError(String error) {
                mCardResult.setText("身份证信息识别失败:" + error);
            }
        });
    }

    public void onEnd(View view) {
        // 结束读取身份证信息
        IBenSDK.getInstance().getIDCardFactory().stopReadCard();
    }
}