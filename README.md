# 关于IBenSDK使用指南

## 依赖方式(Gradle)

- 在项目的根目录`build.gradle`文件下面添加`maven`仓库地址

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://dl.bintray.com/guoyanggit/maven' }
    }
}
```

- 在`app`目录`build.gradle`文件下面添加`gradle`依赖

```gradle
implementation('com.guoyanggit.ibensdk:ibensdk:1.0.0')
```

- 进行项目资源文件配置

    1. 在项目的`assets/tts/`目录下配置发音人音色
    2. 在项目的`res/raw/`目录下配置人脸识别所需的`megviifacepp_0_5_2_model`文件

- 在`AndroidManifest`清单文件中进行`ID`配置(**具体ID请联系相关人员**)

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="...">
    
    <application>
        <!-- 语音相关Appkey -->
        <meta-data
            android:name="VOICE_APPKEY"
            android:value="这里是语音相关的appkey" />
        <!-- 人脸识别的Key -->
        <meta-data
            android:name="FACE_KEY"
            android:value="这里是人脸识别相关的key" />
        <!-- 人脸识别的Secret -->
        <meta-data
            android:name="FACE_SECRET"
            android:value="这里是人脸识别相关的secret" />
            ...
    </application>

</manifest>
```

- 在自定义的`Application`中对`SDK`进行初始化工作

```java
public class MyApplication extends Application {
    //是否是debug模式
    private static final boolean DEBUG = false;
    //机器人ID
    private static final String APP_KEY = "这里是机器人id，具体请联系相关人员";
    //BaseUrl
    private static final String BASE_URL = DEBUG ? "http://47.99.175.26:7080/XiaoBenManager/" : "http://kf.ibenrobot.com/";
    //QAUrl
    private static final String QA_URL = DEBUG ? "http://47.99.175.26:7080/" : "http://kf.ibenrobot.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        // 进行sdk初始化工作
        IBenSDK.init(DEBUG,this)
                .setAppKey(APP_KEY) // 设置AppKey
                .setType("rk3399l") // 设置主板类型
                .setBaseUrl(BASE_URL) // 设置BaseUrl
                .setQAUrl(QA_URL); // 设置QA问答地址
    }
}
```

- 在确保**网络正常**的情况下对`SDK`进行激活工作(**具体的`R.raw.megviifacepp_0_5_2_model`请联系相关人员**)

```java
// 进行机器人激活
IBenSDK.getInstance()
    .activeRobot()
    .subscribe(result -> SPUtils.getInstance().put("initBean", result),
            throwable -> Toast.makeText(this, "激活失败:" + throwable.getMessage(), Toast.LENGTH_SHORT).show());
// 进行人脸识别激活
FaceManager.getInstance()
    .initFace(this.getApplication(), R.raw.megviifacepp_0_5_2_model, new FaceManager.FaceCheckLicense() {
        @Override
        public void onSuccess() {

        }

        @Override
        public void onFail(String fail) {

        }
    });
```

## 功能使用

### 动作指令

- 唤醒监听功能

```java
// 开启监听唤醒功能
IBenSDK.getInstance().getActionFactory().addWakeCallBack(this, (type, angle) -> {
    // IWakeCallBack.LEFT_ARM 左臂唤醒,IWakeCallBack.RIGHT_ARM 右臂唤醒,IWakeCallBack.VOICE 语音唤醒
    mWakeTv.setText("当前唤醒方式是" + type + ",唤醒角度为" + angle);
});

// 关闭监听唤醒
IBenSDK.getInstance().getActionFactory().removeWakeCallBack(this);
```

- 头部

```java
//获取头部转动角度
IBenSDK.getInstance().getActionFactory().getHeadAngle();
//设置头部转动角度(左为负数、右为正数)
IBenSDK.getInstance().getActionFactory().headAction(getAngle());
```

- 左臂

```java
//获取左臂当前抬起角度
IBenSDK.getInstance().getActionFactory().getLeftArmAngle();
//设置左臂抬起角度
IBenSDK.getInstance().getActionFactory().leftArm(getAngle());
```

- 右臂

```java
//获取右臂当前抬起角度
IBenSDK.getInstance().getActionFactory().getRightArmAngle();
//设置右臂抬起角度
IBenSDK.getInstance().getActionFactory().rightArm(getAngle());
```

### 消毒功能

- 获取当前溶液余量

```java
IBenSDK.getInstance().getDisinfectFactory().getSolution(result -> {

});
```

- 开始消毒

```java
IBenSDK.getInstance().getDisinfectFactory().startDisinfect();
```

- 停止消毒

```java
IBenSDK.getInstance().getDisinfectFactory().stopDisinfect();
```

- 开启紫灯

```java
IBenSDK.getInstance().getDisinfectFactory().openUltravioletLamp();
```

- 关闭紫灯

```java
IBenSDK.getInstance().getDisinfectFactory().closeUltravioletLamp();
```

- 开启升降杆

```java
IBenSDK.getInstance().getDisinfectFactory().upLifter();
```

- 降落升降杆

```java
IBenSDK.getInstance().getDisinfectFactory().downLifter();
```

### 身份证识别功能

- 开始读取身份证信息

```java
IBenSDK.getInstance().getIDCardFactory().startReadIDCard(this, new IBenIDCardFactory.ReadIDCallBack<IDCardBean>() {

    @Override
    public void onSuccess(IDCardBean result) {
        mCardResult.setText("身份证信息识别成功:" + result.getName());
    }

    @Override
    public void onError(String error) {
        mCardResult.setText("身份证信息识别失败:" + error);
    }
});
```

- 结束读取身份证信息

```java
IBenSDK.getInstance().getIDCardFactory().stopReadCard();
```

### 打印功能

- 连接打印机

```java
IBenSDK.getInstance().getPrintFactory().connectPrinter(this);
```

- 关闭连接

```java
IBenSDK.getInstance().getPrintFactory().closePrint();
```

- 判断是否连接打印机

```java
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
```

- 打印文字

```java
IBenSDK.getInstance().getPrintFactory()
                //设置打印字体大小,值为0-7
                .setFont(3)
                //设置打印字体位置,左-0、中-1、右-2
                .setPrinter(1)
                //设置打印字体内容
                .printText("这里是打印的文字\r\n");
```

- 打印图片

```java
IBenSDK.getInstance().getPrintFactory()
                .printColorImg(mPrintImg, IBenPrintFactory.PAlign.CENTER);
```

- 打印灰度图

```java
IBenSDK.getInstance().getPrintFactory()
                .printColorImg2Gray(mPrintImgGray, IBenPrintFactory.PAlign.CENTER);
```

- 切纸

```java
IBenSDK.getInstance()
        .getPrintFactory()
        .printText("\r\n")
        .cutPaper();
```

### 测温功能

- 先在页面布局中申明两个`SurfaceView`，用于显示测温画面数据。

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:background="#0076d2">

    <SurfaceView
        android:id="@+id/check_face_temp"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />

    <SurfaceView
        android:id="@+id/check_face_color"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />
</LinearLayout>
```

```java
public class TempActivity extends AppCompatActivity {
    private SurfaceView mCheckFaceColor;
    private SurfaceView mCheckFaceTemp;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...
        mCheckFaceColor = findViewById(R.id.check_face_color);
        mCheckFaceTemp = findViewById(R.id.check_face_temp);
}
```

- 连接测温设备

```java
IBenSDK.getInstance().getCheckTempFactory().loginDevice(mCheckFaceColor, mCheckFaceTemp, new IBenCheckTempFactory.CheckTempCallBack() {
    /**
     * 登录成功回调
     */
    @Override
    public void onSuccess() {

    }

    /**
     * 登录失败回调
     * @param errorMsg 失败信息
     */
    @Override
    public void onFail(String errorMsg) {

    }

    /**
     * 温度报警回调
     */
    @Override
    public void tempAlarm() {

    }

    /**
     * 人脸抓拍回调
     * @param bean 人脸数据实体类
     */
    @Override
    public void tempFace(TempFaceBean bean) {
        runOnUiThread(()-> Toast.makeText(TempActivity.this, bean.toString(), Toast.LENGTH_SHORT).show());
    }
});
```

- 设置报警温度

```java
IBenSDK.getInstance().getCheckTempFactory().transmitXmlCommand(37.8f);
```

- 断开连接测温设备

```java
IBenSDK.getInstance().getCheckTempFactory().logoutDevice();
```

### 人脸识别相关

- 先在页面布局中申明人脸识别所需布局。

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center">

    <com.samton.camerautils.face.FaceCameraView
        android:id="@+id/faceView"
        android:layout_width="400dp"
        android:layout_height="400dp"
        app:mCanFaceBeauty="true"
        app:mCanRequestRender="true" />
</LinearLayout>
```

`mCanFaceBeauty`属性为是否美颜、`mCanRequestRender`属性为是否进行相机画面显示。

- 接下来可以在页面中进行调用

```java
public class FaceActivity extends AppCompatActivity {
    private FaceCameraView mFaceCameraView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);
        mFaceCameraView = findViewById(R.id.faceView);
        //设置相机数据回调
        mFaceCameraView.setCallBack((data, faces) -> {
            //data为相机数据
            //faces为人脸数据
        }
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
        mFaceCameraView.showCamera(false);
        super.onPause();
    }
}
```

### 语音识别/播报

- 详细参数设置、没有特殊需求可以不设置、都有默认值。

```java
IBenSDK.getInstance().getVoiceFactory()
                .setLanguage(VoiceFactoryImpl.CHINESE)//设置识别语言、默认中文
                .setCAE(true, false)//设置是否开启cae模式、默认开启
                .setDynamic(true)// 设置开启动态修正、默认不开启
                .setCould(false)//设置是否使用在线音色、默认使用本地音色(本地音色资源在assets/tts目录下面)
                .setTtsName("xiaoyan")//设置发音人音色、默认使用xiaoyan
                .setTtsVolume("100")// 设置播报音量、默认100
                .setTtsPitch("50")// 设置播报语调、默认50
                .setTtsSpeed("60")// 设置播报语速、默认60
```

- 开启语音识别

```java
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
                //发送给QA后台接口
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
```

- 开始播报

```java
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
```

- 添加QA消息回调监听

```java
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
```

- 移除QA消息回调监听事件

```java
IBenSDK.getInstance().getChatFactory().removeMsgCallBack(this);
```

### 底盘移动功能

- 进行底盘连接

```java
IBenSDK.getInstance().getMoveFactory().connectRobot("192.168.11.1", 1445, new IBenMoveFactory.ConnectCallBack() {
    @Override
    public void onConnectSuccess() {
        loadMap();
    }

    @Override
    public void onConnectFailed() {

    }
});
```

- 进行地图加载

```java
String MAP_PATH = Environment.getExternalStorageDirectory().getPath() + "/IBenService/Reception/CurrentMap/currentMap";
Pose cachePose = mInitBean.getCurrentMap().getPose();
IBenSDK.getInstance().getMoveFactory().loadMap(MAP_PATH, cachePose, new IBenMoveFactory.MapCallBack() {
    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailed() {

    }
});
```

- 获取电量信息

```java
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
```

- 进行走点逻辑

```java
String result = "0.06612311,0.60498834,0.0,-1.5764927";
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
```