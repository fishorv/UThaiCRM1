//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.uthai.message;

public class SendMessge {
    private String touser;
    private String msgtype;
    private String thumb_media_id;
    MediaID mediaID = new MediaID();

    public SendMessge() {
    }

    public String getTouser() {
        return this.touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return this.msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public void setMediaID(String mediaid) {
        this.mediaID.setMedia_id(mediaid);
    }

    public String getThumb_media_id() {
        return this.thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }
}
