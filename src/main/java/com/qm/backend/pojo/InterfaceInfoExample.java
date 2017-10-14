package com.qm.backend.pojo;

import java.util.ArrayList;
import java.util.List;

public class InterfaceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InterfaceInfoExample() {
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

        public Criteria andInfoNameIsNull() {
            addCriterion("info_name is null");
            return (Criteria) this;
        }

        public Criteria andInfoNameIsNotNull() {
            addCriterion("info_name is not null");
            return (Criteria) this;
        }

        public Criteria andInfoNameEqualTo(String value) {
            addCriterion("info_name =", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotEqualTo(String value) {
            addCriterion("info_name <>", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameGreaterThan(String value) {
            addCriterion("info_name >", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("info_name >=", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameLessThan(String value) {
            addCriterion("info_name <", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameLessThanOrEqualTo(String value) {
            addCriterion("info_name <=", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameLike(String value) {
            addCriterion("info_name like", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotLike(String value) {
            addCriterion("info_name not like", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameIn(List<String> values) {
            addCriterion("info_name in", values, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotIn(List<String> values) {
            addCriterion("info_name not in", values, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameBetween(String value1, String value2) {
            addCriterion("info_name between", value1, value2, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotBetween(String value1, String value2) {
            addCriterion("info_name not between", value1, value2, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoPathIsNull() {
            addCriterion("info_path is null");
            return (Criteria) this;
        }

        public Criteria andInfoPathIsNotNull() {
            addCriterion("info_path is not null");
            return (Criteria) this;
        }

        public Criteria andInfoPathEqualTo(String value) {
            addCriterion("info_path =", value, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathNotEqualTo(String value) {
            addCriterion("info_path <>", value, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathGreaterThan(String value) {
            addCriterion("info_path >", value, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathGreaterThanOrEqualTo(String value) {
            addCriterion("info_path >=", value, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathLessThan(String value) {
            addCriterion("info_path <", value, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathLessThanOrEqualTo(String value) {
            addCriterion("info_path <=", value, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathLike(String value) {
            addCriterion("info_path like", value, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathNotLike(String value) {
            addCriterion("info_path not like", value, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathIn(List<String> values) {
            addCriterion("info_path in", values, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathNotIn(List<String> values) {
            addCriterion("info_path not in", values, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathBetween(String value1, String value2) {
            addCriterion("info_path between", value1, value2, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoPathNotBetween(String value1, String value2) {
            addCriterion("info_path not between", value1, value2, "infoPath");
            return (Criteria) this;
        }

        public Criteria andInfoMethodIsNull() {
            addCriterion("info_method is null");
            return (Criteria) this;
        }

        public Criteria andInfoMethodIsNotNull() {
            addCriterion("info_method is not null");
            return (Criteria) this;
        }

        public Criteria andInfoMethodEqualTo(String value) {
            addCriterion("info_method =", value, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodNotEqualTo(String value) {
            addCriterion("info_method <>", value, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodGreaterThan(String value) {
            addCriterion("info_method >", value, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodGreaterThanOrEqualTo(String value) {
            addCriterion("info_method >=", value, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodLessThan(String value) {
            addCriterion("info_method <", value, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodLessThanOrEqualTo(String value) {
            addCriterion("info_method <=", value, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodLike(String value) {
            addCriterion("info_method like", value, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodNotLike(String value) {
            addCriterion("info_method not like", value, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodIn(List<String> values) {
            addCriterion("info_method in", values, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodNotIn(List<String> values) {
            addCriterion("info_method not in", values, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodBetween(String value1, String value2) {
            addCriterion("info_method between", value1, value2, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andInfoMethodNotBetween(String value1, String value2) {
            addCriterion("info_method not between", value1, value2, "infoMethod");
            return (Criteria) this;
        }

        public Criteria andIntoFormatIsNull() {
            addCriterion("into_format is null");
            return (Criteria) this;
        }

        public Criteria andIntoFormatIsNotNull() {
            addCriterion("into_format is not null");
            return (Criteria) this;
        }

        public Criteria andIntoFormatEqualTo(String value) {
            addCriterion("into_format =", value, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatNotEqualTo(String value) {
            addCriterion("into_format <>", value, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatGreaterThan(String value) {
            addCriterion("into_format >", value, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatGreaterThanOrEqualTo(String value) {
            addCriterion("into_format >=", value, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatLessThan(String value) {
            addCriterion("into_format <", value, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatLessThanOrEqualTo(String value) {
            addCriterion("into_format <=", value, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatLike(String value) {
            addCriterion("into_format like", value, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatNotLike(String value) {
            addCriterion("into_format not like", value, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatIn(List<String> values) {
            addCriterion("into_format in", values, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatNotIn(List<String> values) {
            addCriterion("into_format not in", values, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatBetween(String value1, String value2) {
            addCriterion("into_format between", value1, value2, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andIntoFormatNotBetween(String value1, String value2) {
            addCriterion("into_format not between", value1, value2, "intoFormat");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkIsNull() {
            addCriterion("info_remark is null");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkIsNotNull() {
            addCriterion("info_remark is not null");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkEqualTo(String value) {
            addCriterion("info_remark =", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkNotEqualTo(String value) {
            addCriterion("info_remark <>", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkGreaterThan(String value) {
            addCriterion("info_remark >", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("info_remark >=", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkLessThan(String value) {
            addCriterion("info_remark <", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkLessThanOrEqualTo(String value) {
            addCriterion("info_remark <=", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkLike(String value) {
            addCriterion("info_remark like", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkNotLike(String value) {
            addCriterion("info_remark not like", value, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkIn(List<String> values) {
            addCriterion("info_remark in", values, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkNotIn(List<String> values) {
            addCriterion("info_remark not in", values, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkBetween(String value1, String value2) {
            addCriterion("info_remark between", value1, value2, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andInfoRemarkNotBetween(String value1, String value2) {
            addCriterion("info_remark not between", value1, value2, "infoRemark");
            return (Criteria) this;
        }

        public Criteria andRequestExampleIsNull() {
            addCriterion("request_example is null");
            return (Criteria) this;
        }

        public Criteria andRequestExampleIsNotNull() {
            addCriterion("request_example is not null");
            return (Criteria) this;
        }

        public Criteria andRequestExampleEqualTo(String value) {
            addCriterion("request_example =", value, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleNotEqualTo(String value) {
            addCriterion("request_example <>", value, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleGreaterThan(String value) {
            addCriterion("request_example >", value, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleGreaterThanOrEqualTo(String value) {
            addCriterion("request_example >=", value, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleLessThan(String value) {
            addCriterion("request_example <", value, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleLessThanOrEqualTo(String value) {
            addCriterion("request_example <=", value, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleLike(String value) {
            addCriterion("request_example like", value, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleNotLike(String value) {
            addCriterion("request_example not like", value, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleIn(List<String> values) {
            addCriterion("request_example in", values, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleNotIn(List<String> values) {
            addCriterion("request_example not in", values, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleBetween(String value1, String value2) {
            addCriterion("request_example between", value1, value2, "requestExample");
            return (Criteria) this;
        }

        public Criteria andRequestExampleNotBetween(String value1, String value2) {
            addCriterion("request_example not between", value1, value2, "requestExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleIsNull() {
            addCriterion("response_example is null");
            return (Criteria) this;
        }

        public Criteria andResponseExampleIsNotNull() {
            addCriterion("response_example is not null");
            return (Criteria) this;
        }

        public Criteria andResponseExampleEqualTo(String value) {
            addCriterion("response_example =", value, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleNotEqualTo(String value) {
            addCriterion("response_example <>", value, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleGreaterThan(String value) {
            addCriterion("response_example >", value, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleGreaterThanOrEqualTo(String value) {
            addCriterion("response_example >=", value, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleLessThan(String value) {
            addCriterion("response_example <", value, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleLessThanOrEqualTo(String value) {
            addCriterion("response_example <=", value, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleLike(String value) {
            addCriterion("response_example like", value, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleNotLike(String value) {
            addCriterion("response_example not like", value, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleIn(List<String> values) {
            addCriterion("response_example in", values, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleNotIn(List<String> values) {
            addCriterion("response_example not in", values, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleBetween(String value1, String value2) {
            addCriterion("response_example between", value1, value2, "responseExample");
            return (Criteria) this;
        }

        public Criteria andResponseExampleNotBetween(String value1, String value2) {
            addCriterion("response_example not between", value1, value2, "responseExample");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
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