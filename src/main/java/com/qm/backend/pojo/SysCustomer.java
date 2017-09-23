package com.qm.backend.pojo;

import java.util.Date;

public class SysCustomer {
    private String customerId;

    private String customerSex;

    private String customerName;

    private String customerPhone;

    private String customerIdentity;

    private String teamId;

    private String teamName;

    private Date teamCreateDate;

    private String teamArea;

    private String teamAddress;

    private String departmentId;

    private String departmentName;

    private String departmentType;

    private String positionId;

    private String positionName;

    private String userId;

    private Byte hadAccount;

    private Integer roleId;

    private String latLng;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex == null ? null : customerSex.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public String getCustomerIdentity() {
        return customerIdentity;
    }

    public void setCustomerIdentity(String customerIdentity) {
        this.customerIdentity = customerIdentity == null ? null : customerIdentity.trim();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public Date getTeamCreateDate() {
        return teamCreateDate;
    }

    public void setTeamCreateDate(Date teamCreateDate) {
        this.teamCreateDate = teamCreateDate;
    }

    public String getTeamArea() {
        return teamArea;
    }

    public void setTeamArea(String teamArea) {
        this.teamArea = teamArea == null ? null : teamArea.trim();
    }

    public String getTeamAddress() {
        return teamAddress;
    }

    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress == null ? null : teamAddress.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType == null ? null : departmentType.trim();
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Byte getHadAccount() {
        return hadAccount;
    }

    public void setHadAccount(Byte hadAccount) {
        this.hadAccount = hadAccount;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getLatLng()
    {
        return latLng;
    }

    public void setLatLng(String latLng)
    {
        this.latLng = latLng;
    }
}