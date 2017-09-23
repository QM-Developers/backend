package com.qm.backend.pojo;

public class QmPermissionRe {
    private String permissionId;

    private String qmPermissionId;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getQmPermissionId() {
        return qmPermissionId;
    }

    public void setQmPermissionId(String qmPermissionId) {
        this.qmPermissionId = qmPermissionId == null ? null : qmPermissionId.trim();
    }
}