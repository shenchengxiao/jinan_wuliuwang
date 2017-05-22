package com.ontime.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QLoginLimitExample {
    /**
     * Table: q_login_limit
    @mbggenerated 2017-05-18 15:32:38
     */
    protected String orderByClause;

    /**
     * Table: q_login_limit
    @mbggenerated 2017-05-18 15:32:38
     */
    protected boolean distinct;

    /**
     * Table: q_login_limit
    @mbggenerated 2017-05-18 15:32:38
     */
    protected List<Criteria> oredCriteria;

    public QLoginLimitExample() {
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

    /**
     * [STRATO MyBatis Generator]
     * Table: q_login_limit
    @mbggenerated 2017-05-18 15:32:38
     */
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

        public Criteria andLimitIdIsNull() {
            addCriterion("limit_id is null");
            return (Criteria) this;
        }

        public Criteria andLimitIdIsNotNull() {
            addCriterion("limit_id is not null");
            return (Criteria) this;
        }

        public Criteria andLimitIdEqualTo(Integer value) {
            addCriterion("limit_id =", value, "limitId");
            return (Criteria) this;
        }

        public Criteria andLimitIdNotEqualTo(Integer value) {
            addCriterion("limit_id <>", value, "limitId");
            return (Criteria) this;
        }

        public Criteria andLimitIdGreaterThan(Integer value) {
            addCriterion("limit_id >", value, "limitId");
            return (Criteria) this;
        }

        public Criteria andLimitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_id >=", value, "limitId");
            return (Criteria) this;
        }

        public Criteria andLimitIdLessThan(Integer value) {
            addCriterion("limit_id <", value, "limitId");
            return (Criteria) this;
        }

        public Criteria andLimitIdLessThanOrEqualTo(Integer value) {
            addCriterion("limit_id <=", value, "limitId");
            return (Criteria) this;
        }

        public Criteria andLimitIdIn(List<Integer> values) {
            addCriterion("limit_id in", values, "limitId");
            return (Criteria) this;
        }

        public Criteria andLimitIdNotIn(List<Integer> values) {
            addCriterion("limit_id not in", values, "limitId");
            return (Criteria) this;
        }

        public Criteria andLimitIdBetween(Integer value1, Integer value2) {
            addCriterion("limit_id between", value1, value2, "limitId");
            return (Criteria) this;
        }

        public Criteria andLimitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_id not between", value1, value2, "limitId");
            return (Criteria) this;
        }

        public Criteria andQuserIdIsNull() {
            addCriterion("quser_id is null");
            return (Criteria) this;
        }

        public Criteria andQuserIdIsNotNull() {
            addCriterion("quser_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuserIdEqualTo(Integer value) {
            addCriterion("quser_id =", value, "quserId");
            return (Criteria) this;
        }

        public Criteria andQuserIdNotEqualTo(Integer value) {
            addCriterion("quser_id <>", value, "quserId");
            return (Criteria) this;
        }

        public Criteria andQuserIdGreaterThan(Integer value) {
            addCriterion("quser_id >", value, "quserId");
            return (Criteria) this;
        }

        public Criteria andQuserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("quser_id >=", value, "quserId");
            return (Criteria) this;
        }

        public Criteria andQuserIdLessThan(Integer value) {
            addCriterion("quser_id <", value, "quserId");
            return (Criteria) this;
        }

        public Criteria andQuserIdLessThanOrEqualTo(Integer value) {
            addCriterion("quser_id <=", value, "quserId");
            return (Criteria) this;
        }

        public Criteria andQuserIdIn(List<Integer> values) {
            addCriterion("quser_id in", values, "quserId");
            return (Criteria) this;
        }

        public Criteria andQuserIdNotIn(List<Integer> values) {
            addCriterion("quser_id not in", values, "quserId");
            return (Criteria) this;
        }

        public Criteria andQuserIdBetween(Integer value1, Integer value2) {
            addCriterion("quser_id between", value1, value2, "quserId");
            return (Criteria) this;
        }

        public Criteria andQuserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("quser_id not between", value1, value2, "quserId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdIsNull() {
            addCriterion("login_type_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdIsNotNull() {
            addCriterion("login_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdEqualTo(Integer value) {
            addCriterion("login_type_id =", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdNotEqualTo(Integer value) {
            addCriterion("login_type_id <>", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdGreaterThan(Integer value) {
            addCriterion("login_type_id >", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_type_id >=", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdLessThan(Integer value) {
            addCriterion("login_type_id <", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("login_type_id <=", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdIn(List<Integer> values) {
            addCriterion("login_type_id in", values, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdNotIn(List<Integer> values) {
            addCriterion("login_type_id not in", values, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("login_type_id between", value1, value2, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("login_type_id not between", value1, value2, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Integer value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Integer value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Integer value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Integer value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Integer> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Integer> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Integer value1, Integer value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNull() {
            addCriterion("stop_time is null");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNotNull() {
            addCriterion("stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andStopTimeEqualTo(Date value) {
            addCriterion("stop_time =", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotEqualTo(Date value) {
            addCriterion("stop_time <>", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThan(Date value) {
            addCriterion("stop_time >", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stop_time >=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThan(Date value) {
            addCriterion("stop_time <", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("stop_time <=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIn(List<Date> values) {
            addCriterion("stop_time in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotIn(List<Date> values) {
            addCriterion("stop_time not in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeBetween(Date value1, Date value2) {
            addCriterion("stop_time between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("stop_time not between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andHardwareIsNull() {
            addCriterion("hardware is null");
            return (Criteria) this;
        }

        public Criteria andHardwareIsNotNull() {
            addCriterion("hardware is not null");
            return (Criteria) this;
        }

        public Criteria andHardwareEqualTo(String value) {
            addCriterion("hardware =", value, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareNotEqualTo(String value) {
            addCriterion("hardware <>", value, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareGreaterThan(String value) {
            addCriterion("hardware >", value, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareGreaterThanOrEqualTo(String value) {
            addCriterion("hardware >=", value, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareLessThan(String value) {
            addCriterion("hardware <", value, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareLessThanOrEqualTo(String value) {
            addCriterion("hardware <=", value, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareLike(String value) {
            addCriterion("hardware like", value, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareNotLike(String value) {
            addCriterion("hardware not like", value, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareIn(List<String> values) {
            addCriterion("hardware in", values, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareNotIn(List<String> values) {
            addCriterion("hardware not in", values, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareBetween(String value1, String value2) {
            addCriterion("hardware between", value1, value2, "hardware");
            return (Criteria) this;
        }

        public Criteria andHardwareNotBetween(String value1, String value2) {
            addCriterion("hardware not between", value1, value2, "hardware");
            return (Criteria) this;
        }
    }

    /**
     * This class corresponds to the database table q_login_limit
    @mbggenerated do_not_delete_during_merge 2017-05-18 15:32:38
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * [STRATO MyBatis Generator]
     * Table: q_login_limit
    @mbggenerated 2017-05-18 15:32:38
     */
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