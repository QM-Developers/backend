package com.qm.backend.pojo;

import java.util.List;

public class SysRole {
    private String roleId;

    private String roleName;

    private String roleText;

    private String permission;

    private String memberId;

    private List<SysPermission> permissionList;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleText() {
        return roleText;
    }

    public void setRoleText(String roleText) {
        this.roleText = roleText == null ? null : roleText.trim();
    }

    public String getPermission()
    {
        return permission;
    }

    public void setPermission(String permission)
    {
        this.permission = permission;
    }

    public String getMemberId()
    {
        return memberId;
    }

    public void setMemberId(String memberId)
    {
        this.memberId = memberId;
    }

    public List<SysPermission> getPermissionList()
    {
        return permissionList;
    }

    public void setPermissionList(List<SysPermission> permissionList)
    {
        this.permissionList = permissionList;
    }
}