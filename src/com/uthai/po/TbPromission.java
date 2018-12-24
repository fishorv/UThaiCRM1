package com.uthai.po;

public class TbPromission {
    private String role;

    private String promisson;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getPromisson() {
        return promisson;
    }

    public void setPromisson(String promisson) {
        this.promisson = promisson == null ? null : promisson.trim();
    }
}