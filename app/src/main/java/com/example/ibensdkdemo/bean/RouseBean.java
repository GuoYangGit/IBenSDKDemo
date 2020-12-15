package com.example.ibensdkdemo.bean;
/***
 * You may think you know what the following code does.
 * But you dont. Trust me.
 * Fiddle with it, and youll spend many a sleepless
 * night cursing the moment you thought youd be clever
 * enough to "optimize" the code below.
 * Now close this file and go play with something else.
 */

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
 * Created by guoyang on 2020/11/23.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */
public class RouseBean {
    /**
     * rs : 1
     * _token_iben : null
     * faceRectangle : {"width":163,"top":108,"left":47,"height":163}
     * speach : 先生您好小笨很高兴为您服务
     * isExist : false
     */

    private String rs;
    private Object _token_iben;
    private FaceRectangleBean faceRectangle;
    private String speach;
    private boolean isExist;

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public Object get_token_iben() {
        return _token_iben;
    }

    public void set_token_iben(Object _token_iben) {
        this._token_iben = _token_iben;
    }

    public FaceRectangleBean getFaceRectangle() {
        return faceRectangle;
    }

    public void setFaceRectangle(FaceRectangleBean faceRectangle) {
        this.faceRectangle = faceRectangle;
    }

    public String getSpeach() {
        return speach;
    }

    public void setSpeach(String speach) {
        this.speach = speach;
    }

    public boolean isIsExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    public static class FaceRectangleBean {
        /**
         * width : 163
         * top : 108
         * left : 47
         * height : 163
         */

        private int width;
        private int top;
        private int left;
        private int height;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}