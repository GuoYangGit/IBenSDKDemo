package com.example.ibensdkdemo.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.ibensdkdemo.R;
import com.google.gson.Gson;
import com.samton.ibensdk_common.IBenSDK;
import com.samton.ibensdk_common.data.MessageBean;
import com.samton.ibensdk_common.factory.IBenChatFactory;
import com.samton.ibensdk_common.factory.IBenVoiceFactory;
import com.samton.ibensdk_common.impl.VoiceFactoryImpl;

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
 * 语音聊天测试类
 */
public class VoiceActivity extends AppCompatActivity {
    private TextView mRecognizeTv, mTtsTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        mRecognizeTv = findViewById(R.id.recognize_result);
        mTtsTv = findViewById(R.id.tts_result);
        IBenSDK.getInstance().getVoiceFactory()
                .setLanguage(VoiceFactoryImpl.CHINESE)//设置识别语言、默认中文
                .setCAE(false, false)//设置是否开启cae模式、默认开启
                .setDynamic(true)// 设置开启动态修正、默认不开启
                .setCould(true)//设置是否使用在线音色、默认使用本地音色(本地音色资源在assets/tts目录下面)
                .setTtsName("xiaoyan")//设置发音人音色、默认使用xiaoyan
                .setTtsVolume("100")// 设置播报音量、默认100
                .setTtsPitch("50")// 设置播报语调、默认50
                .setTtsSpeed("60")// 设置播报语速、默认60
        ;
        // 添加QA消息回调监听事件
        IBenSDK.getInstance().getChatFactory().addMsgCallBack(this, new IBenChatFactory.IBenMsgCallBack() {
            @Override
            public void onSuccess(String result) {
                String ttsMsg = "好的,有需要请再来找我";
                try {
                    MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                    MessageBean.DataBean.AppMessageBean messageBean = bean.getData().getAppMessage().get(0);
                    ttsMsg = messageBean.getMessage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                startTTS(ttsMsg);
            }

            @Override
            public void onFail(String errorMsg) {
                startTTS(errorMsg);
            }
        });
    }

    @Override
    protected void onDestroy() {
        // 移除QA消息回调监听事件
        IBenSDK.getInstance().getChatFactory().removeMsgCallBack(this);
        super.onDestroy();
    }

    /**
     * 开始拾音
     */
    @SuppressLint("SetTextI18n")
    public void onStart(View view) {
        // 开启语音识别
        IBenSDK.getInstance().getVoiceFactory().startRecognize(new IBenVoiceFactory.IBenRecordCallBack() {
            @Override
            public void onBeginOfSpeech() {
                mRecognizeTv.setText("当前状态:开始拾音");
            }

            @Override
            public void onEndOfSpeech(String result, String errorMsg) {
                if (TextUtils.isEmpty(errorMsg)) {
                    mRecognizeTv.setText("当前状态:结束拾音---" + result);
                    IBenSDK.getInstance().getChatFactory().sendMessage(result, "", "");
                } else {
                    mRecognizeTv.setText("当前状态:结束拾音---" + errorMsg);
                }
            }

            @Override
            public void dynamicResult(String result) {
                mRecognizeTv.setText("当前状态:动态修正---" + result);
            }
        });
    }

    /**
     * 停止识音
     *
     * @param view
     */
    public void onEnd(View view) {
        IBenSDK.getInstance().getVoiceFactory().stopRecognize();
    }

    /**
     * 开始播报
     *
     * @param msg 播报内容
     */
    @SuppressLint("SetTextI18n")
    private void startTTS(String msg) {
        // 开始播报
        IBenSDK.getInstance().getVoiceFactory().startSpeaking(msg, new IBenVoiceFactory.IBenTTSCallBack() {
            @Override
            public void onSpeakBegin() {
                mTtsTv.setText("当前状态:开始播报----" + msg);
            }

            @Override
            public void onCompleted(String error) {
                mTtsTv.setText("当前状态:播报结束----" + error);
            }
        });
    }
}
