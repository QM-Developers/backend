package com.qm.backend.pojo;

public class SysBreedTypeSelect {
    private String selectId;

    private String selectName;

    private String typeId;

    public String getSelectId() {
        return selectId;
    }

    public void setSelectId(String selectId) {
        this.selectId = selectId == null ? null : selectId.trim();
    }

    public String getSelectName() {
        return selectName;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName == null ? null : selectName.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }
}