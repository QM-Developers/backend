package com.qm.backend.pojo;

public class Permission {
    private String permissionId;

    private String permissionName;

    private String permissionUrl;

    private String permissionPid;

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

    public String getPermissionPid() {
        return permissionPid;
    }

    public void setPermissionPid(String permissionPid) {
        this.permissionPid = permissionPid == null ? null : permissionPid.trim();
    }
}