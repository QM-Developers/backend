package com.qm.backend.pojo;

import java.util.ArrayList;
import java.util.List;

public class InterfaceResponseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InterfaceResponseExample() {
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

        public Criteria andResponseIdIsNull() {
            addCriterion("response_id is null");
            return (Criteria) this;
        }

        public Criteria andResponseIdIsNotNull() {
            addCriterion("response_id is not null");
            return (Criteria) this;
        }

        public Criteria andResponseIdEqualTo(String value) {
            addCriterion("response_id =", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotEqualTo(String value) {
            addCriterion("response_id <>", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdGreaterThan(String value) {
            addCriterion("response_id >", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdGreaterThanOrEqualTo(String value) {
            addCriterion("response_id >=", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdLessThan(String value) {
            addCriterion("response_id <", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdLessThanOrEqualTo(String value) {
            addCriterion("response_id <=", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdLike(String value) {
            addCriterion("response_id like", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotLike(String value) {
            addCriterion("response_id not like", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdIn(List<String> values) {
            addCriterion("response_id in", values, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotIn(List<String> values) {
            addCriterion("response_id not in", values, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdBetween(String value1, String value2) {
            addCriterion("response_id between", value1, value2, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotBetween(String value1, String value2) {
            addCriterion("response_id not between", value1, value2, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseNameIsNull() {
            addCriterion("response_name is null");
            return (Criteria) this;
        }

        public Criteria andResponseNameIsNotNull() {
            addCriterion("response_name is not null");
            return (Criteria) this;
        }

        public Criteria andResponseNameEqualTo(String value) {
            addCriterion("response_name =", value, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameNotEqualTo(String value) {
            addCriterion("response_name <>", value, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameGreaterThan(String value) {
            addCriterion("response_name >", value, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameGreaterThanOrEqualTo(String value) {
            addCriterion("response_name >=", value, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameLessThan(String value) {
            addCriterion("response_name <", value, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameLessThanOrEqualTo(String value) {
            addCriterion("response_name <=", value, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameLike(String value) {
            addCriterion("response_name like", value, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameNotLike(String value) {
            addCriterion("response_name not like", value, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameIn(List<String> values) {
            addCriterion("response_name in", values, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameNotIn(List<String> values) {
            addCriterion("response_name not in", values, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameBetween(String value1, String value2) {
            addCriterion("response_name between", value1, value2, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseNameNotBetween(String value1, String value2) {
            addCriterion("response_name not between", value1, value2, "responseName");
            return (Criteria) this;
        }

        public Criteria andResponseTypeIsNull() {
            addCriterion("response_type is null");
            return (Criteria) this;
        }

        public Criteria andResponseTypeIsNotNull() {
            addCriterion("response_type is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTypeEqualTo(String value) {
            addCriterion("response_type =", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeNotEqualTo(String value) {
            addCriterion("response_type <>", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeGreaterThan(String value) {
            addCriterion("response_type >", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("response_type >=", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeLessThan(String value) {
            addCriterion("response_type <", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeLessThanOrEqualTo(String value) {
            addCriterion("response_type <=", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeLike(String value) {
            addCriterion("response_type like", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeNotLike(String value) {
            addCriterion("response_type not like", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeIn(List<String> values) {
            addCriterion("response_type in", values, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeNotIn(List<String> values) {
            addCriterion("response_type not in", values, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeBetween(String value1, String value2) {
            addCriterion("response_type between", value1, value2, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeNotBetween(String value1, String value2) {
            addCriterion("response_type not between", value1, value2, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTextIsNull() {
            addCriterion("response_text is null");
            return (Criteria) this;
        }

        public Criteria andResponseTextIsNotNull() {
            addCriterion("response_text is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTextEqualTo(String value) {
            addCriterion("response_text =", value, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextNotEqualTo(String value) {
            addCriterion("response_text <>", value, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextGreaterThan(String value) {
            addCriterion("response_text >", value, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextGreaterThanOrEqualTo(String value) {
            addCriterion("response_text >=", value, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextLessThan(String value) {
            addCriterion("response_text <", value, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextLessThanOrEqualTo(String value) {
            addCriterion("response_text <=", value, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextLike(String value) {
            addCriterion("response_text like", value, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextNotLike(String value) {
            addCriterion("response_text not like", value, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextIn(List<String> values) {
            addCriterion("response_text in", values, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextNotIn(List<String> values) {
            addCriterion("response_text not in", values, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextBetween(String value1, String value2) {
            addCriterion("response_text between", value1, value2, "responseText");
            return (Criteria) this;
        }

        public Criteria andResponseTextNotBetween(String value1, String value2) {
            addCriterion("response_text not between", value1, value2, "responseText");
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