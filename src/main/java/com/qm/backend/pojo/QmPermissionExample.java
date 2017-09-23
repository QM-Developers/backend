package com.qm.backend.pojo;

import java.util.ArrayList;
import java.util.List;

public class QmPermissionExample {
    private Integer pageNum;

    private Integer pageSize;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QmPermissionExample() {
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

        public Criteria andQmPermissionIdIsNull() {
            addCriterion("qm_permission_id is null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdIsNotNull() {
            addCriterion("qm_permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdEqualTo(String value) {
            addCriterion("qm_permission_id =", value, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdNotEqualTo(String value) {
            addCriterion("qm_permission_id <>", value, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdGreaterThan(String value) {
            addCriterion("qm_permission_id >", value, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdGreaterThanOrEqualTo(String value) {
            addCriterion("qm_permission_id >=", value, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdLessThan(String value) {
            addCriterion("qm_permission_id <", value, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdLessThanOrEqualTo(String value) {
            addCriterion("qm_permission_id <=", value, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdLike(String value) {
            addCriterion("qm_permission_id like", value, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdNotLike(String value) {
            addCriterion("qm_permission_id not like", value, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdIn(List<String> values) {
            addCriterion("qm_permission_id in", values, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdNotIn(List<String> values) {
            addCriterion("qm_permission_id not in", values, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdBetween(String value1, String value2) {
            addCriterion("qm_permission_id between", value1, value2, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionIdNotBetween(String value1, String value2) {
            addCriterion("qm_permission_id not between", value1, value2, "qmPermissionId");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameIsNull() {
            addCriterion("qm_permission_name is null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameIsNotNull() {
            addCriterion("qm_permission_name is not null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameEqualTo(String value) {
            addCriterion("qm_permission_name =", value, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameNotEqualTo(String value) {
            addCriterion("qm_permission_name <>", value, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameGreaterThan(String value) {
            addCriterion("qm_permission_name >", value, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("qm_permission_name >=", value, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameLessThan(String value) {
            addCriterion("qm_permission_name <", value, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameLessThanOrEqualTo(String value) {
            addCriterion("qm_permission_name <=", value, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameLike(String value) {
            addCriterion("qm_permission_name like", value, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameNotLike(String value) {
            addCriterion("qm_permission_name not like", value, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameIn(List<String> values) {
            addCriterion("qm_permission_name in", values, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameNotIn(List<String> values) {
            addCriterion("qm_permission_name not in", values, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameBetween(String value1, String value2) {
            addCriterion("qm_permission_name between", value1, value2, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionNameNotBetween(String value1, String value2) {
            addCriterion("qm_permission_name not between", value1, value2, "qmPermissionName");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeIsNull() {
            addCriterion("qm_permission_describe is null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeIsNotNull() {
            addCriterion("qm_permission_describe is not null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeEqualTo(String value) {
            addCriterion("qm_permission_describe =", value, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeNotEqualTo(String value) {
            addCriterion("qm_permission_describe <>", value, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeGreaterThan(String value) {
            addCriterion("qm_permission_describe >", value, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("qm_permission_describe >=", value, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeLessThan(String value) {
            addCriterion("qm_permission_describe <", value, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeLessThanOrEqualTo(String value) {
            addCriterion("qm_permission_describe <=", value, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeLike(String value) {
            addCriterion("qm_permission_describe like", value, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeNotLike(String value) {
            addCriterion("qm_permission_describe not like", value, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeIn(List<String> values) {
            addCriterion("qm_permission_describe in", values, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeNotIn(List<String> values) {
            addCriterion("qm_permission_describe not in", values, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeBetween(String value1, String value2) {
            addCriterion("qm_permission_describe between", value1, value2, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionDescribeNotBetween(String value1, String value2) {
            addCriterion("qm_permission_describe not between", value1, value2, "qmPermissionDescribe");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidIsNull() {
            addCriterion("qm_permission_pid is null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidIsNotNull() {
            addCriterion("qm_permission_pid is not null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidEqualTo(String value) {
            addCriterion("qm_permission_pid =", value, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidNotEqualTo(String value) {
            addCriterion("qm_permission_pid <>", value, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidGreaterThan(String value) {
            addCriterion("qm_permission_pid >", value, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidGreaterThanOrEqualTo(String value) {
            addCriterion("qm_permission_pid >=", value, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidLessThan(String value) {
            addCriterion("qm_permission_pid <", value, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidLessThanOrEqualTo(String value) {
            addCriterion("qm_permission_pid <=", value, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidLike(String value) {
            addCriterion("qm_permission_pid like", value, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidNotLike(String value) {
            addCriterion("qm_permission_pid not like", value, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidIn(List<String> values) {
            addCriterion("qm_permission_pid in", values, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidNotIn(List<String> values) {
            addCriterion("qm_permission_pid not in", values, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidBetween(String value1, String value2) {
            addCriterion("qm_permission_pid between", value1, value2, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andQmPermissionPidNotBetween(String value1, String value2) {
            addCriterion("qm_permission_pid not between", value1, value2, "qmPermissionPid");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Byte value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Byte value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Byte value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Byte value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Byte value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Byte value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Byte> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Byte> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Byte value1, Byte value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Byte value1, Byte value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeIsNull() {
            addCriterion("qm_permission_type is null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeIsNotNull() {
            addCriterion("qm_permission_type is not null");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeEqualTo(Byte value) {
            addCriterion("qm_permission_type =", value, "qmPermissionType");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeNotEqualTo(Byte value) {
            addCriterion("qm_permission_type <>", value, "qmPermissionType");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeGreaterThan(Byte value) {
            addCriterion("qm_permission_type >", value, "qmPermissionType");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("qm_permission_type >=", value, "qmPermissionType");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeLessThan(Byte value) {
            addCriterion("qm_permission_type <", value, "qmPermissionType");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeLessThanOrEqualTo(Byte value) {
            addCriterion("qm_permission_type <=", value, "qmPermissionType");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeIn(List<Byte> values) {
            addCriterion("qm_permission_type in", values, "qmPermissionType");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeNotIn(List<Byte> values) {
            addCriterion("qm_permission_type not in", values, "qmPermissionType");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeBetween(Byte value1, Byte value2) {
            addCriterion("qm_permission_type between", value1, value2, "qmPermissionType");
            return (Criteria) this;
        }

        public Criteria andQmPermissionTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("qm_permission_type not between", value1, value2, "qmPermissionType");
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

    public Integer getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(Integer pageNum)
    {
        this.pageNum = pageNum;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }
}