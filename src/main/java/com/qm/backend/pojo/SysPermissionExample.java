package com.qm.backend.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysPermissionExample {
    private int pageNum;

    private int pageSize;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPermissionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPermissionIdIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(String value) {
            addCriterion("permission_id =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(String value) {
            addCriterion("permission_id <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(String value) {
            addCriterion("permission_id >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(String value) {
            addCriterion("permission_id >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(String value) {
            addCriterion("permission_id <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(String value) {
            addCriterion("permission_id <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLike(String value) {
            addCriterion("permission_id like", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotLike(String value) {
            addCriterion("permission_id not like", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<String> values) {
            addCriterion("permission_id in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<String> values) {
            addCriterion("permission_id not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(String value1, String value2) {
            addCriterion("permission_id between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(String value1, String value2) {
            addCriterion("permission_id not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNull() {
            addCriterion("permission_name is null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNotNull() {
            addCriterion("permission_name is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameEqualTo(String value) {
            addCriterion("permission_name =", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotEqualTo(String value) {
            addCriterion("permission_name <>", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThan(String value) {
            addCriterion("permission_name >", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("permission_name >=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThan(String value) {
            addCriterion("permission_name <", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThanOrEqualTo(String value) {
            addCriterion("permission_name <=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLike(String value) {
            addCriterion("permission_name like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotLike(String value) {
            addCriterion("permission_name not like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIn(List<String> values) {
            addCriterion("permission_name in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotIn(List<String> values) {
            addCriterion("permission_name not in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameBetween(String value1, String value2) {
            addCriterion("permission_name between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotBetween(String value1, String value2) {
            addCriterion("permission_name not between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlIsNull() {
            addCriterion("permission_url is null");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlIsNotNull() {
            addCriterion("permission_url is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlEqualTo(String value) {
            addCriterion("permission_url =", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlNotEqualTo(String value) {
            addCriterion("permission_url <>", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlGreaterThan(String value) {
            addCriterion("permission_url >", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("permission_url >=", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlLessThan(String value) {
            addCriterion("permission_url <", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlLessThanOrEqualTo(String value) {
            addCriterion("permission_url <=", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlLike(String value) {
            addCriterion("permission_url like", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlNotLike(String value) {
            addCriterion("permission_url not like", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlIn(List<String> values) {
            addCriterion("permission_url in", values, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlNotIn(List<String> values) {
            addCriterion("permission_url not in", values, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlBetween(String value1, String value2) {
            addCriterion("permission_url between", value1, value2, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlNotBetween(String value1, String value2) {
            addCriterion("permission_url not between", value1, value2, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionTextIsNull() {
            addCriterion("permission_text is null");
            return (Criteria) this;
        }

        public Criteria andPermissionTextIsNotNull() {
            addCriterion("permission_text is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionTextEqualTo(String value) {
            addCriterion("permission_text =", value, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextNotEqualTo(String value) {
            addCriterion("permission_text <>", value, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextGreaterThan(String value) {
            addCriterion("permission_text >", value, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextGreaterThanOrEqualTo(String value) {
            addCriterion("permission_text >=", value, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextLessThan(String value) {
            addCriterion("permission_text <", value, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextLessThanOrEqualTo(String value) {
            addCriterion("permission_text <=", value, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextLike(String value) {
            addCriterion("permission_text like", value, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextNotLike(String value) {
            addCriterion("permission_text not like", value, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextIn(List<String> values) {
            addCriterion("permission_text in", values, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextNotIn(List<String> values) {
            addCriterion("permission_text not in", values, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextBetween(String value1, String value2) {
            addCriterion("permission_text between", value1, value2, "permissionText");
            return (Criteria) this;
        }

        public Criteria andPermissionTextNotBetween(String value1, String value2) {
            addCriterion("permission_text not between", value1, value2, "permissionText");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public int getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
}