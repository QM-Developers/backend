package com.qm.backend.pojo;

import java.util.List;

public class QmPermission {
    private String qmPermissionId;

    private String qmPermissionName;

    private String qmPermissionDescribe;

    private String qmPermissionPid;

    private Byte sort;

    private Byte qmPermissionType;

    private String permission;

    private List<QmPermissionRe> permissionList;

    public String getQmPermissionId() {
        return qmPermissionId;
    }

    public void setQmPermissionId(String qmPermissionId) {
        this.qmPermissionId = qmPermissionId == null ? null : qmPermissionId.trim();
    }

    public String getQmPermissionName() {
        return qmPermissionName;
    }

    public void setQmPermissionName(String qmPermissionName) {
        this.qmPermissionName = qmPermissionName == null ? null : qmPermissionName.trim();
    }

    public String getQmPermissionDescribe() {
        return qmPermissionDescribe;
    }

    public void setQmPermissionDescribe(String qmPermissionDescribe) {
        this.qmPermissionDescribe = qmPermissionDescribe == null ? null : qmPermissionDescribe.trim();
    }

    public String getQmPermissionPid() {
        return qmPermissionPid;
    }

    public void setQmPermissionPid(String qmPermissionPid) {
        this.qmPermissionPid = qmPermissionPid == null ? null : qmPermissionPid.trim();
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Byte getQmPermissionType() {
        return qmPermissionType;
    }

    public void setQmPermissionType(Byte qmPermissionType) {
        this.qmPermissionType = qmPermissionType;
    }

    public String getPermission()
    {
        return permission;
    }

    public void setPermission(String permission)
    {
        this.permission = permission;
    }

    public List<QmPermissionRe> getPermissionList()
    {
        return permissionList;
    }

    public void setPermissionList(List<QmPermissionRe> permissionList)
    {
        this.permissionList = permissionList;
    }
}