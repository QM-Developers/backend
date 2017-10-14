package com.qm.backend.pojo;

public class InterfaceRequest {
    private String requestId;

    private String requestName;

    private String requestType;

    private String requestMust;

    private String requestText;

    private Integer sort;

    private String infoId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName == null ? null : requestName.trim();
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    public String getRequestMust() {
        return requestMust;
    }

    public void setRequestMust(String requestMust) {
        this.requestMust = requestMust == null ? null : requestMust.trim();
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText == null ? null : requestText.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }
}