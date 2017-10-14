package com.qm.backend.pojo;

import java.util.ArrayList;
import java.util.List;

public class InterfaceRequestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InterfaceRequestExample() {
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

        public Criteria andRequestIdIsNull() {
            addCriterion("request_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNotNull() {
            addCriterion("request_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIdEqualTo(String value) {
            addCriterion("request_id =", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotEqualTo(String value) {
            addCriterion("request_id <>", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThan(String value) {
            addCriterion("request_id >", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThanOrEqualTo(String value) {
            addCriterion("request_id >=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThan(String value) {
            addCriterion("request_id <", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThanOrEqualTo(String value) {
            addCriterion("request_id <=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLike(String value) {
            addCriterion("request_id like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotLike(String value) {
            addCriterion("request_id not like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdIn(List<String> values) {
            addCriterion("request_id in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotIn(List<String> values) {
            addCriterion("request_id not in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdBetween(String value1, String value2) {
            addCriterion("request_id between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotBetween(String value1, String value2) {
            addCriterion("request_id not between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestNameIsNull() {
            addCriterion("request_name is null");
            return (Criteria) this;
        }

        public Criteria andRequestNameIsNotNull() {
            addCriterion("request_name is not null");
            return (Criteria) this;
        }

        public Criteria andRequestNameEqualTo(String value) {
            addCriterion("request_name =", value, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameNotEqualTo(String value) {
            addCriterion("request_name <>", value, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameGreaterThan(String value) {
            addCriterion("request_name >", value, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameGreaterThanOrEqualTo(String value) {
            addCriterion("request_name >=", value, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameLessThan(String value) {
            addCriterion("request_name <", value, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameLessThanOrEqualTo(String value) {
            addCriterion("request_name <=", value, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameLike(String value) {
            addCriterion("request_name like", value, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameNotLike(String value) {
            addCriterion("request_name not like", value, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameIn(List<String> values) {
            addCriterion("request_name in", values, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameNotIn(List<String> values) {
            addCriterion("request_name not in", values, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameBetween(String value1, String value2) {
            addCriterion("request_name between", value1, value2, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestNameNotBetween(String value1, String value2) {
            addCriterion("request_name not between", value1, value2, "requestName");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNull() {
            addCriterion("request_type is null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNotNull() {
            addCriterion("request_type is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeEqualTo(String value) {
            addCriterion("request_type =", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotEqualTo(String value) {
            addCriterion("request_type <>", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThan(String value) {
            addCriterion("request_type >", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThanOrEqualTo(String value) {
            addCriterion("request_type >=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThan(String value) {
            addCriterion("request_type <", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThanOrEqualTo(String value) {
            addCriterion("request_type <=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLike(String value) {
            addCriterion("request_type like", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotLike(String value) {
            addCriterion("request_type not like", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIn(List<String> values) {
            addCriterion("request_type in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotIn(List<String> values) {
            addCriterion("request_type not in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeBetween(String value1, String value2) {
            addCriterion("request_type between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotBetween(String value1, String value2) {
            addCriterion("request_type not between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestMustIsNull() {
            addCriterion("request_must is null");
            return (Criteria) this;
        }

        public Criteria andRequestMustIsNotNull() {
            addCriterion("request_must is not null");
            return (Criteria) this;
        }

        public Criteria andRequestMustEqualTo(String value) {
            addCriterion("request_must =", value, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustNotEqualTo(String value) {
            addCriterion("request_must <>", value, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustGreaterThan(String value) {
            addCriterion("request_must >", value, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustGreaterThanOrEqualTo(String value) {
            addCriterion("request_must >=", value, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustLessThan(String value) {
            addCriterion("request_must <", value, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustLessThanOrEqualTo(String value) {
            addCriterion("request_must <=", value, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustLike(String value) {
            addCriterion("request_must like", value, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustNotLike(String value) {
            addCriterion("request_must not like", value, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustIn(List<String> values) {
            addCriterion("request_must in", values, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustNotIn(List<String> values) {
            addCriterion("request_must not in", values, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustBetween(String value1, String value2) {
            addCriterion("request_must between", value1, value2, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestMustNotBetween(String value1, String value2) {
            addCriterion("request_must not between", value1, value2, "requestMust");
            return (Criteria) this;
        }

        public Criteria andRequestTextIsNull() {
            addCriterion("request_text is null");
            return (Criteria) this;
        }

        public Criteria andRequestTextIsNotNull() {
            addCriterion("request_text is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTextEqualTo(String value) {
            addCriterion("request_text =", value, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextNotEqualTo(String value) {
            addCriterion("request_text <>", value, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextGreaterThan(String value) {
            addCriterion("request_text >", value, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextGreaterThanOrEqualTo(String value) {
            addCriterion("request_text >=", value, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextLessThan(String value) {
            addCriterion("request_text <", value, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextLessThanOrEqualTo(String value) {
            addCriterion("request_text <=", value, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextLike(String value) {
            addCriterion("request_text like", value, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextNotLike(String value) {
            addCriterion("request_text not like", value, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextIn(List<String> values) {
            addCriterion("request_text in", values, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextNotIn(List<String> values) {
            addCriterion("request_text not in", values, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextBetween(String value1, String value2) {
            addCriterion("request_text between", value1, value2, "requestText");
            return (Criteria) this;
        }

        public Criteria andRequestTextNotBetween(String value1, String value2) {
            addCriterion("request_text not between", value1, value2, "requestText");
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

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNull() {
            addCriterion("info_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("info_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(String value) {
            addCriterion("info_id =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(String value) {
            addCriterion("info_id <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(String value) {
            addCriterion("info_id >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("info_id >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(String value) {
            addCriterion("info_id <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(String value) {
            addCriterion("info_id <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLike(String value) {
            addCriterion("info_id like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotLike(String value) {
            addCriterion("info_id not like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<String> values) {
            addCriterion("info_id in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<String> values) {
            addCriterion("info_id not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(String value1, String value2) {
            addCriterion("info_id between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(String value1, String value2) {
            addCriterion("info_id not between", value1, value2, "infoId");
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
}