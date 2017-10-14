package com.qm.backend.pojo;

import java.util.List;

public class InterfaceType {
    private String typeId;

    private String typeName;

    private String typePid;

    private List<InterfaceInfo> infoList;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypePid() {
        return typePid;
    }

    public void setTypePid(String typePid) {
        this.typePid = typePid == null ? null : typePid.trim();
    }

    public List<InterfaceInfo> getInfoList()
    {
        return infoList;
    }

    public void setInfoList(List<InterfaceInfo> infoList)
    {
        this.infoList = infoList;
    }
}