package com.qm.backend.pojo;

public class SysPermission {
    private String permissionId;

    private String permissionName;

    private String permissionUrl;

    private String permissionText;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
    }

    public String getPermissionText() {
        return permissionText;
    }

    public void setPermissionText(String permissionText) {
        this.permissionText = permissionText == null ? null : permissionText.trim();
    }
}