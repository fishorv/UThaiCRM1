package com.uthai.po;

import java.util.Date;

public class TbSerEmp {
    private String serEmpId;

    private Date createDate;

    private String serStatus;

    private String serEmpName;

    private String telNumber;

    private String address;

    private String weChat;

    private String openId;

    public String getSerEmpId() {
        return serEmpId;
    }

    public void setSerEmpId(String serEmpId) {
        this.serEmpId = serEmpId == null ? null : serEmpId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSerStatus() {
        return serStatus;
    }

    public void setSerStatus(String serStatus) {
        this.serStatus = serStatus == null ? null : serStatus.trim();
    }

    public String getSerEmpName() {
        return serEmpName;
    }

    public void setSerEmpName(String serEmpName) {
        this.serEmpName = serEmpName == null ? null : serEmpName.trim();
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber == null ? null : telNumber.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat == null ? null : weChat.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }
}