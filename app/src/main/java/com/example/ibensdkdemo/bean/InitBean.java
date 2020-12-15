package com.example.ibensdkdemo.bean;

import com.google.gson.annotations.SerializedName;
import com.slamtec.slamware.robot.Pose;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/10/30
 *     desc   : 初始化机器人实体类
 *     version: 1.0
 * </pre>
 */

public class InitBean {
    private boolean isSpeakPower30 = true;
    private boolean isSpeakPower15 = true;
    private int rs;
    private DataBean data;
    private SetBean set;
    private CurrentMapBean currentMap;
    private ExpressionMapBean expressionMap;
    private String robotName;
    private int robotMod;
    private MeetingBean meeting;
    private PreachGroupBean preachGroup;
    private PrintGroupBean printGroup;
    private WorkAttendanceBean workAttendance;
    private String voiceTag;
    private String preachWord;
    private String broadcastImg;
    private int carouselGroupId;
    private int workModeid;
    private CleverPreachBean cleverPreach;
    private String accout;
    private int enterpriseId;
    private String returnPileTime;
    private int lanType;
    private String warnSpeech;
    private float warnTemp;
    private String noMaskWarningSpeech;
    private List<String> sounds;
    private List<CarouselItemsBean> carouselItems;
    private List<String> functionManages;
    private List<String> statusBars;
    private RobotInfoBean robotInfo;
    private int expressionGroupId;
    private List<String> isContent;
    private List<String> noContent;
    private List<String> wholeContent;

    public InitBean() {
    }

    public String getWarnSpeech() {
        return this.warnSpeech;
    }

    public void setWarnSpeech(String warnSpeech) {
        this.warnSpeech = warnSpeech;
    }

    public float getWarnTemp() {
        return this.warnTemp;
    }

    public void setWarnTemp(float warnTemp) {
        this.warnTemp = warnTemp;
    }

    public String getNoMaskWarningSpeech() {
        return this.noMaskWarningSpeech;
    }

    public void setNoMaskWarningSpeech(String noMaskWarningSpeech) {
        this.noMaskWarningSpeech = noMaskWarningSpeech;
    }

    public String getReturnPileTime() {
        return this.returnPileTime;
    }

    public void setReturnPileTime(String returnPileTime) {
        this.returnPileTime = returnPileTime;
    }

    public int getEnterpriseId() {
        return this.enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getAccout() {
        return this.accout;
    }

    public void setAccout(String accout) {
        this.accout = accout;
    }

    public int getWorkModeid() {
        return this.workModeid;
    }

    public void setWorkModeid(int workModeid) {
        this.workModeid = workModeid;
    }

    public String getPreachWord() {
        return this.preachWord;
    }

    public void setPreachWord(String preachWord) {
        this.preachWord = preachWord;
    }

    public String getBroadcastImg() {
        return this.broadcastImg == null ? "" : this.broadcastImg;
    }

    public void setBroadcastImg(String broadcastImg) {
        this.broadcastImg = broadcastImg;
    }

    public int getCarouselGroupId() {
        return this.carouselGroupId;
    }

    public void setCarouselGroupId(int carouselGroupId) {
        this.carouselGroupId = carouselGroupId;
    }

    public int getRs() {
        return this.rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public DataBean getData() {
        if (this.data == null) {
            this.data = new DataBean();
        }

        return this.data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public SetBean getSet() {
        if (this.set == null) {
            this.set = new SetBean();
        }

        return this.set;
    }

    public void setSet(SetBean set) {
        this.set = set;
    }

    public CurrentMapBean getCurrentMap() {
        if (this.currentMap == null) {
            this.currentMap = new CurrentMapBean();
        }

        return this.currentMap;
    }

    public void setCurrentMap(CurrentMapBean currentMap) {
        this.currentMap = currentMap;
    }

    public ExpressionMapBean getExpressionMap() {
        if (this.expressionMap == null) {
            this.expressionMap = new ExpressionMapBean();
        }

        return this.expressionMap;
    }

    public void setExpressionMap(ExpressionMapBean expressionMap) {
        this.expressionMap = expressionMap;
    }

    public String getRobotName() {
        return this.robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public int getRobotMod() {
        return this.robotMod;
    }

    public void setRobotMod(int robotMod) {
        this.robotMod = robotMod;
    }

    public MeetingBean getMeeting() {
        if (this.meeting == null) {
            this.meeting = new MeetingBean();
        }

        return this.meeting;
    }

    public void setMeeting(MeetingBean meeting) {
        this.meeting = meeting;
    }

    public PreachGroupBean getPreachGroup() {
        if (this.preachGroup == null) {
            this.preachGroup = new PreachGroupBean();
        }

        return this.preachGroup;
    }

    public void setPreachGroup(PreachGroupBean preachGroup) {
        this.preachGroup = preachGroup;
    }

    public PrintGroupBean getPrintGroup() {
        if (this.printGroup == null) {
            this.printGroup = new PrintGroupBean();
        }

        return this.printGroup;
    }

    public void setPrintGroup(PrintGroupBean printGroup) {
        this.printGroup = printGroup;
    }

    public WorkAttendanceBean getWorkAttendance() {
        if (this.workAttendance == null) {
            this.workAttendance = new WorkAttendanceBean();
        }

        return this.workAttendance;
    }

    public void setWorkAttendance(WorkAttendanceBean workAttendance) {
        this.workAttendance = workAttendance;
    }

    public String getVoiceTag() {
        return this.voiceTag;
    }

    public void setVoiceTag(String voiceTag) {
        this.voiceTag = voiceTag;
    }

    public CleverPreachBean getCleverPreach() {
        if (this.cleverPreach == null) {
            this.cleverPreach = new CleverPreachBean();
        }

        return this.cleverPreach;
    }

    public void setCleverPreach(CleverPreachBean cleverPreach) {
        this.cleverPreach = cleverPreach;
    }

    public List<String> getNoContent() {
        if (this.noContent == null) {
            this.noContent = new ArrayList();
        }

        return this.noContent;
    }

    public void setNoContent(List<String> noContent) {
        this.noContent = noContent;
    }

    public List<String> getIsContent() {
        if (this.isContent == null) {
            this.isContent = new ArrayList();
        }

        return this.isContent;
    }

    public void setIsContent(List<String> isContent) {
        this.isContent = isContent;
    }

    public List<String> getWholeContent() {
        if (this.wholeContent == null) {
            this.wholeContent = new ArrayList();
        }

        return this.wholeContent;
    }

    public void setWholeContent(List<String> wholeContent) {
        this.wholeContent = wholeContent;
    }

    public int getExpressionGroupId() {
        return this.expressionGroupId;
    }

    public void setExpressionGroupId(int expressionGroupId) {
        this.expressionGroupId = expressionGroupId;
    }

    public List<String> getSounds() {
        if (this.sounds == null) {
            this.sounds = new ArrayList();
        }

        return this.sounds;
    }

    public void setSounds(List<String> sounds) {
        this.sounds = sounds;
    }

    public List<CarouselItemsBean> getCarouselItems() {
        if (this.carouselItems == null) {
            this.carouselItems = new ArrayList();
        }

        return this.carouselItems;
    }

    public void setCarouselItems(List<CarouselItemsBean> carouselItems) {
        this.carouselItems = carouselItems;
    }

    public List<String> getFunctionManages() {
        if (this.functionManages == null) {
            this.functionManages = new ArrayList();
        }

        return this.functionManages;
    }

    public void setFunctionManages(List<String> functionManages) {
        this.functionManages = functionManages;
    }

    public List<String> getStatusBars() {
        if (this.statusBars == null) {
            this.statusBars = new ArrayList();
        }

        return this.statusBars;
    }

    public void setStatusBars(List<String> statusBars) {
        this.statusBars = statusBars;
    }

    public RobotInfoBean getRobotInfo() {
        if (this.robotInfo == null) {
            this.robotInfo = new RobotInfoBean();
        }

        return this.robotInfo;
    }

    public void setRobotInfo(RobotInfoBean robotInfo) {
        this.robotInfo = robotInfo;
    }

    public boolean isSpeakPower30() {
        return this.isSpeakPower30;
    }

    public void setSpeakPower30(boolean speakPower30) {
        this.isSpeakPower30 = speakPower30;
    }

    public boolean isSpeakPower15() {
        return this.isSpeakPower15;
    }

    public void setSpeakPower15(boolean speakPower15) {
        this.isSpeakPower15 = speakPower15;
    }

    public int getLanType() {
        return this.lanType;
    }

    public void setLanType(int lanType) {
        this.lanType = lanType;
    }

    public static class RobotInfoBean {
        private String robName;
        private int timbreId;
        private int preachTimbreId;
        private int wakeFlag;
        private String moveMsg;
        private String thirtyDownMsg;
        private String fifteenDownMsg;
        private int spotVip;
        private int welcomeStatus;
        private String vipWelcomeContent;
        private String vipContent;
        private String strangerContent;
        private String moreVipContent;
        private String moreStrangerContent;
        private int lastPower;
        private int warnPower;
        private String nowakeContent;
        private String arousalWords;
        private int version;
        private String moveSpeed;
        private String speechSpeed;
        private float warnTemp;
        private String warnSpeech;
        private String homeVideo;

        public RobotInfoBean() {
        }

        public String getRobName() {
            return this.robName;
        }

        public void setRobName(String robName) {
            this.robName = robName;
        }

        public int getTimbreId() {
            return this.timbreId;
        }

        public void setTimbreId(int timbreId) {
            this.timbreId = timbreId;
        }

        public int getPreachTimbreId() {
            return this.preachTimbreId;
        }

        public void setPreachTimbreId(int preachTimbreId) {
            this.preachTimbreId = preachTimbreId;
        }

        public int getWakeFlag() {
            return this.wakeFlag;
        }

        public void setWakeFlag(int wakeFlag) {
            this.wakeFlag = wakeFlag;
        }

        public String getMoveMsg() {
            return this.moveMsg;
        }

        public void setMoveMsg(String moveMsg) {
            this.moveMsg = moveMsg;
        }

        public String getThirtyDownMsg() {
            return this.thirtyDownMsg;
        }

        public void setThirtyDownMsg(String thirtyDownMsg) {
            this.thirtyDownMsg = thirtyDownMsg;
        }

        public String getFifteenDownMsg() {
            return this.fifteenDownMsg;
        }

        public void setFifteenDownMsg(String fifteenDownMsg) {
            this.fifteenDownMsg = fifteenDownMsg;
        }

        public int getSpotVip() {
            return this.spotVip;
        }

        public void setSpotVip(int spotVip) {
            this.spotVip = spotVip;
        }

        public int getWelcomeStatus() {
            return this.welcomeStatus;
        }

        public void setWelcomeStatus(int welcomeStatus) {
            this.welcomeStatus = welcomeStatus;
        }

        public String getVipWelcomeContent() {
            return this.vipWelcomeContent;
        }

        public void setVipWelcomeContent(String vipWelcomeContent) {
            this.vipWelcomeContent = vipWelcomeContent;
        }

        public String getVipContent() {
            return this.vipContent;
        }

        public void setVipContent(String vipContent) {
            this.vipContent = vipContent;
        }

        public String getStrangerContent() {
            return this.strangerContent;
        }

        public void setStrangerContent(String strangerContent) {
            this.strangerContent = strangerContent;
        }

        public String getMoreVipContent() {
            return this.moreVipContent;
        }

        public void setMoreVipContent(String moreVipContent) {
            this.moreVipContent = moreVipContent;
        }

        public String getMoreStrangerContent() {
            return this.moreStrangerContent;
        }

        public void setMoreStrangerContent(String moreStrangerContent) {
            this.moreStrangerContent = moreStrangerContent;
        }

        public int getLastPower() {
            return this.lastPower;
        }

        public void setLastPower(int lastPower) {
            this.lastPower = lastPower;
        }

        public int getWarnPower() {
            return this.warnPower;
        }

        public void setWarnPower(int warnPower) {
            this.warnPower = warnPower;
        }

        public String getNowakeContent() {
            return this.nowakeContent;
        }

        public void setNowakeContent(String nowakeContent) {
            this.nowakeContent = nowakeContent;
        }

        public String getArousalWords() {
            return this.arousalWords;
        }

        public void setArousalWords(String arousalWords) {
            this.arousalWords = arousalWords;
        }

        public int getVersion() {
            return this.version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getMoveSpeed() {
            return this.moveSpeed;
        }

        public void setMoveSpeed(String moveSpeed) {
            this.moveSpeed = moveSpeed;
        }

        public String getSpeechSpeed() {
            return this.speechSpeed;
        }

        public void setSpeechSpeed(String speechSpeed) {
            this.speechSpeed = speechSpeed;
        }

        public float getWarnTemp() {
            return this.warnTemp;
        }

        public void setWarnTemp(float warnTemp) {
            this.warnTemp = warnTemp;
        }

        public String getWarnSpeech() {
            return this.warnSpeech;
        }

        public void setWarnSpeech(String warnSpeech) {
            this.warnSpeech = warnSpeech;
        }

        public String getHomeVideo() {
            return this.homeVideo;
        }

        public void setHomeVideo(String homeVideo) {
            this.homeVideo = homeVideo;
        }
    }

    public static class CarouselItemsBean {
        private String url;

        public CarouselItemsBean() {
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public class DataBean {
        private String errorCode;
        private String errorMsg;

        public DataBean() {
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

    public static class CleverPreachBean {
        private int id;
        private int version;
        private String robUuid;
        private String preachEndMsg;
        private String stopPreachPwd;
        private int halfwayQuizFlag;
        private String switchMsg;
        private String advisoryMsg;
        private String noAdvisoryMsg;
        private String beforeMsg;
        private String noPreachMsg;
        private String otherMsg;
        @SerializedName("preachImg")
        private String preachImgX;
        private String callMsg;
        private int callMsgTime;
        private String isleadVip;
        private String isleadNotVip;
        private int noPreachTime;
        private int repeatPointFlag;
        private String notPointMsg;
        private int halfwayTime;
        private String halfwayOtherMsg;
        private int nobodyPreach;
        private String centralControlIp;
        private String centralControlPort;

        public CleverPreachBean() {
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getVersion() {
            return this.version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getRobUuid() {
            return this.robUuid;
        }

        public void setRobUuid(String robUuid) {
            this.robUuid = robUuid;
        }

        public String getPreachEndMsg() {
            return this.preachEndMsg;
        }

        public void setPreachEndMsg(String preachEndMsg) {
            this.preachEndMsg = preachEndMsg;
        }

        public String getStopPreachPwd() {
            return this.stopPreachPwd;
        }

        public void setStopPreachPwd(String stopPreachPwd) {
            this.stopPreachPwd = stopPreachPwd;
        }

        public int getHalfwayQuizFlag() {
            return this.halfwayQuizFlag;
        }

        public void setHalfwayQuizFlag(int halfwayQuizFlag) {
            this.halfwayQuizFlag = halfwayQuizFlag;
        }

        public String getSwitchMsg() {
            return this.switchMsg;
        }

        public void setSwitchMsg(String switchMsg) {
            this.switchMsg = switchMsg;
        }

        public String getAdvisoryMsg() {
            return this.advisoryMsg;
        }

        public void setAdvisoryMsg(String advisoryMsg) {
            this.advisoryMsg = advisoryMsg;
        }

        public String getNoAdvisoryMsg() {
            return this.noAdvisoryMsg;
        }

        public void setNoAdvisoryMsg(String noAdvisoryMsg) {
            this.noAdvisoryMsg = noAdvisoryMsg;
        }

        public String getBeforeMsg() {
            return this.beforeMsg;
        }

        public void setBeforeMsg(String beforeMsg) {
            this.beforeMsg = beforeMsg;
        }

        public String getNoPreachMsg() {
            return this.noPreachMsg;
        }

        public void setNoPreachMsg(String noPreachMsg) {
            this.noPreachMsg = noPreachMsg;
        }

        public String getOtherMsg() {
            return this.otherMsg;
        }

        public void setOtherMsg(String otherMsg) {
            this.otherMsg = otherMsg;
        }

        public String getPreachImgX() {
            return this.preachImgX;
        }

        public void setPreachImgX(String preachImgX) {
            this.preachImgX = preachImgX;
        }

        public String getCallMsg() {
            return this.callMsg;
        }

        public void setCallMsg(String callMsg) {
            this.callMsg = callMsg;
        }

        public int getCallMsgTime() {
            return this.callMsgTime;
        }

        public void setCallMsgTime(int callMsgTime) {
            this.callMsgTime = callMsgTime;
        }

        public String getIsleadVip() {
            return this.isleadVip;
        }

        public void setIsleadVip(String isleadVip) {
            this.isleadVip = isleadVip;
        }

        public String getIsleadNotVip() {
            return this.isleadNotVip;
        }

        public void setIsleadNotVip(String isleadNotVip) {
            this.isleadNotVip = isleadNotVip;
        }

        public int getNoPreachTime() {
            return this.noPreachTime;
        }

        public void setNoPreachTime(int noPreachTime) {
            this.noPreachTime = noPreachTime;
        }

        public int getRepeatPointFlag() {
            return this.repeatPointFlag;
        }

        public void setRepeatPointFlag(int repeatPointFlag) {
            this.repeatPointFlag = repeatPointFlag;
        }

        public String getNotPointMsg() {
            return this.notPointMsg;
        }

        public void setNotPointMsg(String notPointMsg) {
            this.notPointMsg = notPointMsg;
        }

        public int getHalfwayTime() {
            return this.halfwayTime;
        }

        public void setHalfwayTime(int halfwayTime) {
            this.halfwayTime = halfwayTime;
        }

        public String getHalfwayOtherMsg() {
            return this.halfwayOtherMsg;
        }

        public void setHalfwayOtherMsg(String halfwayOtherMsg) {
            this.halfwayOtherMsg = halfwayOtherMsg;
        }

        public int getNobodyPreach() {
            return this.nobodyPreach;
        }

        public void setNobodyPreach(int nobodyPreach) {
            this.nobodyPreach = nobodyPreach;
        }

        public String getCentralControlIp() {
            return this.centralControlIp;
        }

        public void setCentralControlIp(String centralControlIp) {
            this.centralControlIp = centralControlIp;
        }

        public int getCentralControlPort() {
            try {
                return Integer.valueOf(this.centralControlPort);
            } catch (Exception var2) {
                return 0;
            }
        }

        public void setCentralControlPort(String centralControlPort) {
            this.centralControlPort = centralControlPort;
        }
    }

    public static class WorkAttendanceBean {
        private int workAttendanceId;
        private int startTime;
        private int endTime;
        private int faceCount;
        private int startWarnTime;
        private String inworkContent;
        private String startWarnContent;
        private String offworkContent;
        private int photoGroupId;
        private String notEmployeeContent;
        private String specialContent;
        private int bufferTime;
        private String companyName;
        private int workFaceCount;

        public WorkAttendanceBean() {
        }

        public String getCompanyName() {
            return this.companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public int getWorkFaceCount() {
            return this.workFaceCount;
        }

        public void setWorkFaceCount(int workFaceCount) {
            this.workFaceCount = workFaceCount;
        }

        public int getWorkAttendanceId() {
            return this.workAttendanceId;
        }

        public void setWorkAttendanceId(int workAttendanceId) {
            this.workAttendanceId = workAttendanceId;
        }

        public int getStartTime() {
            return this.startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return this.endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getFaceCount() {
            return this.faceCount;
        }

        public void setFaceCount(int faceCount) {
            this.faceCount = faceCount;
        }

        public int getStartWarnTime() {
            return this.startWarnTime;
        }

        public void setStartWarnTime(int startWarnTime) {
            this.startWarnTime = startWarnTime;
        }

        public String getInworkContent() {
            return this.inworkContent;
        }

        public void setInworkContent(String inworkContent) {
            this.inworkContent = inworkContent;
        }

        public String getStartWarnContent() {
            return this.startWarnContent;
        }

        public void setStartWarnContent(String startWarnContent) {
            this.startWarnContent = startWarnContent;
        }

        public String getOffworkContent() {
            return this.offworkContent;
        }

        public void setOffworkContent(String offworkContent) {
            this.offworkContent = offworkContent;
        }

        public int getPhotoGroupId() {
            return this.photoGroupId;
        }

        public void setPhotoGroupId(int photoGroupId) {
            this.photoGroupId = photoGroupId;
        }

        public String getNotEmployeeContent() {
            return this.notEmployeeContent;
        }

        public void setNotEmployeeContent(String notEmployeeContent) {
            this.notEmployeeContent = notEmployeeContent;
        }

        public String getSpecialContent() {
            return this.specialContent;
        }

        public void setSpecialContent(String specialContent) {
            this.specialContent = specialContent;
        }

        public int getBufferTime() {
            return this.bufferTime;
        }

        public void setBufferTime(int bufferTime) {
            this.bufferTime = bufferTime;
        }
    }

    public static class PrintGroupBean {
        private int groupId;
        private String name;
        private int state;
        private int version;
        private List<PrintsBean> prints;

        public PrintGroupBean() {
        }

        public int getGroupId() {
            return this.groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getState() {
            return this.state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getVersion() {
            return this.version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public List<PrintsBean> getPrints() {
            if (this.prints == null) {
                this.prints = new ArrayList();
            }

            return this.prints;
        }

        public void setPrints(List<PrintsBean> prints) {
            this.prints = prints;
        }

        public static class PrintsBean {
            private int printId;
            private String name;
            private String describe;
            private int state;
            private List<PrintItemsBean> printItems;

            public PrintsBean() {
            }

            public int getPrintId() {
                return this.printId;
            }

            public void setPrintId(int printId) {
                this.printId = printId;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescribe() {
                return this.describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getState() {
                return this.state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public List<PrintItemsBean> getPrintItems() {
                if (this.printItems == null) {
                    this.printItems = new ArrayList();
                }

                return this.printItems;
            }

            public void setPrintItems(List<PrintItemsBean> printItems) {
                this.printItems = printItems;
            }

            public static class PrintItemsBean {
                private int printItemId;
                private String content;
                private StyleBean style;
                private int printId;
                private int orderNum;
                private int state;
                private int printType;
                private int dynamicType;
                private int startNum;
                private int endNum;

                public PrintItemsBean() {
                }

                public int getPrintType() {
                    return this.printType;
                }

                public void setPrintType(int printType) {
                    this.printType = printType;
                }

                public int getDynamicType() {
                    return this.dynamicType;
                }

                public void setDynamicType(int dynamicType) {
                    this.dynamicType = dynamicType;
                }

                public int getStartNum() {
                    return this.startNum;
                }

                public void setStartNum(int startNum) {
                    this.startNum = startNum;
                }

                public int getEndNum() {
                    return this.endNum;
                }

                public void setEndNum(int endNum) {
                    this.endNum = endNum;
                }

                public int getPrintItemId() {
                    return this.printItemId;
                }

                public void setPrintItemId(int printItemId) {
                    this.printItemId = printItemId;
                }

                public String getContent() {
                    return this.content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public StyleBean getStyle() {
                    if (this.style == null) {
                        this.style = new StyleBean();
                    }

                    return this.style;
                }

                public void setStyle(StyleBean style) {
                    this.style = style;
                }

                public int getPrintId() {
                    return this.printId;
                }

                public void setPrintId(int printId) {
                    this.printId = printId;
                }

                public int getOrderNum() {
                    return this.orderNum;
                }

                public void setOrderNum(int orderNum) {
                    this.orderNum = orderNum;
                }

                public int getState() {
                    return this.state;
                }

                public void setState(int state) {
                    this.state = state;
                }

                public static class StyleBean {
                    private String type;
                    private String value;

                    public StyleBean() {
                    }

                    public String getType() {
                        return this.type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getValue() {
                        return this.value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }
            }
        }
    }

    public static class PreachGroupBean {
        private int groupId;
        private String name;
        private String describe;
        private int sceneId;
        private int state;
        private String sceneName;
        private int robModelNum;
        private int updateFlag;
        private int version;
        private List<PreachItemListBean> preachItemList;

        public PreachGroupBean() {
        }

        public int getGroupId() {
            return this.groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescribe() {
            return this.describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public int getSceneId() {
            return this.sceneId;
        }

        public void setSceneId(int sceneId) {
            this.sceneId = sceneId;
        }

        public int getState() {
            return this.state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getSceneName() {
            return this.sceneName;
        }

        public void setSceneName(String sceneName) {
            this.sceneName = sceneName;
        }

        public int getRobModelNum() {
            return this.robModelNum;
        }

        public void setRobModelNum(int robModelNum) {
            this.robModelNum = robModelNum;
        }

        public int getUpdateFlag() {
            return this.updateFlag;
        }

        public void setUpdateFlag(int updateFlag) {
            this.updateFlag = updateFlag;
        }

        public List<PreachItemListBean> getPreachItemList() {
            if (this.preachItemList == null) {
                this.preachItemList = new ArrayList();
            }

            return this.preachItemList;
        }

        public void setPreachItemList(List<PreachItemListBean> preachItemList) {
            this.preachItemList = preachItemList;
        }

        public int getVersion() {
            return this.version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public static class PreachItemListBean {
            private int itemId;
            private int groupId;
            private int slocId;
            private int preachType;
            private String videoUrl;
            private String contentOnTheWay;
            private int showType;
            private int orderNum;
            private int state;
            private String videoOldname;
            private String slocName;
            private String location;
            private int updateFlag;
            private String imgUrl;
            private String content;
            private String imgOldname;
            private String voiceUrl;
            private String voiceOldname;
            private String actionIds;

            public PreachItemListBean() {
            }

            public String getActionIds() {
                return this.actionIds;
            }

            public void setActionIds(String actionIds) {
                this.actionIds = actionIds;
            }

            public int getItemId() {
                return this.itemId;
            }

            public void setItemId(int itemId) {
                this.itemId = itemId;
            }

            public int getGroupId() {
                return this.groupId;
            }

            public void setGroupId(int groupId) {
                this.groupId = groupId;
            }

            public int getSlocId() {
                return this.slocId;
            }

            public void setSlocId(int slocId) {
                this.slocId = slocId;
            }

            public int getPreachType() {
                return this.preachType;
            }

            public void setPreachType(int preachType) {
                this.preachType = preachType;
            }

            public String getVideoUrl() {
                return this.videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }

            public String getContentOnTheWay() {
                return this.contentOnTheWay;
            }

            public void setContentOnTheWay(String contentOnTheWay) {
                this.contentOnTheWay = contentOnTheWay;
            }

            public int getShowType() {
                return this.showType;
            }

            public void setShowType(int showType) {
                this.showType = showType;
            }

            public int getOrderNum() {
                return this.orderNum;
            }

            public void setOrderNum(int orderNum) {
                this.orderNum = orderNum;
            }

            public int getState() {
                return this.state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getVideoOldname() {
                return this.videoOldname;
            }

            public void setVideoOldname(String videoOldname) {
                this.videoOldname = videoOldname;
            }

            public String getSlocName() {
                return this.slocName;
            }

            public void setSlocName(String slocName) {
                this.slocName = slocName;
            }

            public String getLocation() {
                return this.location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public int getUpdateFlag() {
                return this.updateFlag;
            }

            public void setUpdateFlag(int updateFlag) {
                this.updateFlag = updateFlag;
            }

            public String getImgUrl() {
                return this.imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getContent() {
                return this.content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImgOldname() {
                return this.imgOldname;
            }

            public void setImgOldname(String imgOldname) {
                this.imgOldname = imgOldname;
            }

            public String getVoiceUrl() {
                return this.voiceUrl;
            }

            public void setVoiceUrl(String voiceUrl) {
                this.voiceUrl = voiceUrl;
            }

            public String getVoiceOldname() {
                return this.voiceOldname;
            }

            public void setVoiceOldname(String voiceOldname) {
                this.voiceOldname = voiceOldname;
            }
        }
    }

    public static class MeetingBean {
        private int meetingId;
        private String name;
        private long meetingStartTime;
        private long meetingEndTime;
        private String newVisitorWords;
        private String repeatVisitorWords;
        private String vipVisitorWords;
        private int photoGroupId;
        private String guideWords;
        private int guideWordsTime;
        private int checkInType;

        public MeetingBean() {
        }

        public int getMeetingId() {
            return this.meetingId;
        }

        public void setMeetingId(int meetingId) {
            this.meetingId = meetingId;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getMeetingStartTime() {
            return this.meetingStartTime;
        }

        public void setMeetingStartTime(long meetingStartTime) {
            this.meetingStartTime = meetingStartTime;
        }

        public long getMeetingEndTime() {
            return this.meetingEndTime;
        }

        public void setMeetingEndTime(long meetingEndTime) {
            this.meetingEndTime = meetingEndTime;
        }

        public String getNewVisitorWords() {
            return this.newVisitorWords;
        }

        public void setNewVisitorWords(String newVisitorWords) {
            this.newVisitorWords = newVisitorWords;
        }

        public String getRepeatVisitorWords() {
            return this.repeatVisitorWords;
        }

        public void setRepeatVisitorWords(String repeatVisitorWords) {
            this.repeatVisitorWords = repeatVisitorWords;
        }

        public String getVipVisitorWords() {
            return this.vipVisitorWords;
        }

        public void setVipVisitorWords(String vipVisitorWords) {
            this.vipVisitorWords = vipVisitorWords;
        }

        public int getPhotoGroupId() {
            return this.photoGroupId;
        }

        public void setPhotoGroupId(int photoGroupId) {
            this.photoGroupId = photoGroupId;
        }

        public String getGuideWords() {
            return this.guideWords;
        }

        public void setGuideWords(String guideWords) {
            this.guideWords = guideWords;
        }

        public int getGuideWordsTime() {
            return this.guideWordsTime;
        }

        public void setGuideWordsTime(int guideWordsTime) {
            this.guideWordsTime = guideWordsTime;
        }

        public int getCheckInType() {
            return this.checkInType;
        }

        public void setCheckInType(int checkInType) {
            this.checkInType = checkInType;
        }
    }

    public static class ExpressionMapBean {
        private int groupId;
        private int version;
        private String awaken;
        private String anthomaniac;
        private String unawaken;
        private String happy;
        private String speak;
        private String sorry;

        public ExpressionMapBean() {
        }

        public int getGroupId() {
            return this.groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public int getVersion() {
            return this.version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getAwaken() {
            return this.awaken;
        }

        public void setAwaken(String awaken) {
            this.awaken = awaken;
        }

        public String getAnthomaniac() {
            return this.anthomaniac;
        }

        public void setAnthomaniac(String anthomaniac) {
            this.anthomaniac = anthomaniac;
        }

        public String getHappy() {
            return this.happy;
        }

        public void setHappy(String happy) {
            this.happy = happy;
        }

        public String getSpeak() {
            return this.speak;
        }

        public void setSpeak(String speak) {
            this.speak = speak;
        }

        public String getUnawaken() {
            return this.unawaken;
        }

        public void setUnawaken(String unawaken) {
            this.unawaken = unawaken;
        }

        public String getSorry() {
            return this.sorry;
        }

        public void setSorry(String sorry) {
            this.sorry = sorry;
        }
    }

    public static class CurrentMapBean {
        private String robuuid;
        private int mapId;
        private int version;
        private String mapName;
        private String imgUrl;
        private String file;
        private String homeLocation;
        private Pose pose;
        private List<PositionPointsBean> positionPoints;
        private String scenePlaneImg;

        public CurrentMapBean() {
        }

        public String getRobuuid() {
            return this.robuuid;
        }

        public void setRobuuid(String robuuid) {
            this.robuuid = robuuid;
        }

        public int getMapId() {
            return this.mapId;
        }

        public void setMapId(int mapId) {
            this.mapId = mapId;
        }

        public int getVersion() {
            return this.version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getMapName() {
            return this.mapName;
        }

        public void setMapName(String mapName) {
            this.mapName = mapName;
        }

        public String getImgUrl() {
            return this.imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getFile() {
            return this.file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getHomeLocation() {
            return this.homeLocation;
        }

        public void setHomeLocation(String homeLocation) {
            this.homeLocation = homeLocation;
        }

        public Pose getPose() {
            if (this.pose == null) {
                this.pose = new Pose();
            }

            return this.pose;
        }

        public void setPose(Pose pose) {
            this.pose = pose;
        }

        public List<PositionPointsBean> getPositionPoints() {
            if (this.positionPoints == null) {
                this.positionPoints = new ArrayList();
            }

            return this.positionPoints;
        }

        public void setPositionPoints(List<PositionPointsBean> positionPoints) {
            this.positionPoints = positionPoints;
        }

        public String getScenePlaneImg() {
            return this.scenePlaneImg;
        }

        public void setScenePlaneImg(String scenePlaneImg) {
            this.scenePlaneImg = scenePlaneImg;
        }

        public static class PositionPointsBean {
            private String name;
            private String location;
            private String broadcast;
            private List<String> otherNames;
            private String position;

            public PositionPointsBean() {
            }

            public List<String> getOtherNames() {
                if (this.otherNames == null) {
                    this.otherNames = new ArrayList();
                }

                return this.otherNames;
            }

            public void setOtherNames(List<String> otherNames) {
                this.otherNames = otherNames;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLocation() {
                return this.location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getBroadcast() {
                return this.broadcast;
            }

            public void setBroadcast(String broadcast) {
                this.broadcast = broadcast;
            }

            public String getPosition() {
                return this.position;
            }

            public void setPosition(String position) {
                this.position = position;
            }
        }
    }

    public static class SetBean {
        private int version;
        private String leftHeadImg;
        private String rightHeadImg;
        private String logoImg;
        private List<String> questionTip;
        private String fristMsg;
        private String repeatMsg;
        private String contentReply;
        private int subject;

        public SetBean() {
        }

        public String getRepeatMsg() {
            return this.repeatMsg;
        }

        public void setRepeatMsg(String repeatMsg) {
            this.repeatMsg = repeatMsg;
        }

        public String getLeftHeadImg() {
            return this.leftHeadImg;
        }

        public void setLeftHeadImg(String leftHeadImg) {
            this.leftHeadImg = leftHeadImg;
        }

        public String getRightHeadImg() {
            return this.rightHeadImg;
        }

        public void setRightHeadImg(String rightHeadImg) {
            this.rightHeadImg = rightHeadImg;
        }

        public String getLogoImg() {
            return this.logoImg;
        }

        public void setLogoImg(String logoImg) {
            this.logoImg = logoImg;
        }

        public List<String> getQuestionTip() {
            if (this.questionTip == null) {
                this.questionTip = new ArrayList();
            }

            return this.questionTip;
        }

        public void setQuestionTip(List<String> questionTip) {
            this.questionTip = questionTip;
        }

        public String getFristMsg() {
            return this.fristMsg;
        }

        public void setFristMsg(String fristMsg) {
            this.fristMsg = fristMsg;
        }

        public String getContentReply() {
            return this.contentReply;
        }

        public void setContentReply(String contentReply) {
            this.contentReply = contentReply;
        }

        public int getSubject() {
            return this.subject;
        }

        public void setSubject(int subject) {
            this.subject = subject;
        }

        public int getVersion() {
            return this.version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }
}
