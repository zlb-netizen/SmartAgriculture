package com.cqsx.rgzn.smartagriculture.Untils;

public class Rabat {
    private   int imgID;//头像id
    private  String msg;//消息
    private  boolean isSend;//true表示发送方 。false 服务器
    public Rabat(int imgID, String msg, boolean isSend) {
        this.imgID = imgID;
        this.msg = msg;
        this.isSend = isSend;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
