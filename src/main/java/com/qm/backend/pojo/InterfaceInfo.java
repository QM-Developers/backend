package com.qm.backend.pojo;

public class InterfaceInfo {
    private String infoId;

    private String infoName;

    private String infoPath;

    private String infoMethod;

    private String intoFormat;

    private String infoRemark;

    private String requestExample;

    private String responseExample;

    private String typeId;
    private String request;
    private String response;
    private String update;

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName == null ? null : infoName.trim();
    }

    public String getInfoPath() {
        return infoPath;
    }

    public void setInfoPath(String infoPath) {
        this.infoPath = infoPath == null ? null : infoPath.trim();
    }

    public String getInfoMethod() {
        return infoMethod;
    }

    public void setInfoMethod(String infoMethod) {
        this.infoMethod = infoMethod == null ? null : infoMethod.trim();
    }

    public String getIntoFormat() {
        return intoFormat;
    }

    public void setIntoFormat(String intoFormat) {
        this.intoFormat = intoFormat == null ? null : intoFormat.trim();
    }

    public String getInfoRemark() {
        return infoRemark;
    }

    public void setInfoRemark(String infoRemark) {
        this.infoRemark = infoRemark == null ? null : infoRemark.trim();
    }

    public String getRequestExample() {
        return requestExample;
    }

    public void setRequestExample(String requestExample) {
        this.requestExample = requestExample == null ? null : requestExample.trim();
    }

    public String getResponseExample() {
        return responseExample;
    }

    public void setResponseExample(String responseExample) {
        this.responseExample = responseExample == null ? null : responseExample.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getRequest()
    {
        return request;
    }

    public void setRequest(String request)
    {
        this.request = request;
    }

    public String getResponse()
    {
        return response;
    }

    public void setResponse(String response)
    {
        this.response = response;
    }

    public String getUpdate()
    {
        return update;
    }

    public void setUpdate(String update)
    {
        this.update = update;
    }
}