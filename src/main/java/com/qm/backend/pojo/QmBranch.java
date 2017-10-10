package com.qm.backend.pojo;

public class QmBranch {
    private String branchId;

    private String branchName;

    private String departmentId;

    private String myTeamId;

    private String departmentName;

    private String userId;

    private String userName;

    private String userPhone;

    private String branchArea;

    private String latLng;

    private Byte branchType;

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getMyTeamId() {
        return myTeamId;
    }

    public void setMyTeamId(String myTeamId) {
        this.myTeamId = myTeamId == null ? null : myTeamId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getBranchArea() {
        return branchArea;
    }

    public void setBranchArea(String branchArea) {
        this.branchArea = branchArea == null ? null : branchArea.trim();
    }

    public String getLatLng() {
        return latLng;
    }

    public void setLatLng(String latLng) {
        this.latLng = latLng == null ? null : latLng.trim();
    }

    public Byte getBranchType() {
        return branchType;
    }

    public void setBranchType(Byte branchType) {
        this.branchType = branchType;
    }
}