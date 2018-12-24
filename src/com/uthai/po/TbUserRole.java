package com.uthai.po;

public class TbUserRole {
    private String openId;

    private String userRole;

    private String userId;

    private String branchGroup;

    private String pass;

    private String promission;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBranchGroup() {
        return branchGroup;
    }

    public void setBranchGroup(String branchGroup) {
        this.branchGroup = branchGroup == null ? null : branchGroup.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getPromission() {
        return promission;
    }

    public void setPromission(String promission) {
        this.promission = promission == null ? null : promission.trim();
    }
}