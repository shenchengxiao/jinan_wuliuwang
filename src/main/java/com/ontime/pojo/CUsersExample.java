package com.ontime.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CUsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CUsersExample() {
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

        public Criteria andCuIdIsNull() {
            addCriterion("cu_id is null");
            return (Criteria) this;
        }

        public Criteria andCuIdIsNotNull() {
            addCriterion("cu_id is not null");
            return (Criteria) this;
        }

        public Criteria andCuIdEqualTo(Integer value) {
            addCriterion("cu_id =", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdNotEqualTo(Integer value) {
            addCriterion("cu_id <>", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdGreaterThan(Integer value) {
            addCriterion("cu_id >", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cu_id >=", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdLessThan(Integer value) {
            addCriterion("cu_id <", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdLessThanOrEqualTo(Integer value) {
            addCriterion("cu_id <=", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdIn(List<Integer> values) {
            addCriterion("cu_id in", values, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdNotIn(List<Integer> values) {
            addCriterion("cu_id not in", values, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdBetween(Integer value1, Integer value2) {
            addCriterion("cu_id between", value1, value2, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cu_id not between", value1, value2, "cuId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
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

        public Criteria andCertNameIsNull() {
            addCriterion("cert_name is null");
            return (Criteria) this;
        }

        public Criteria andCertNameIsNotNull() {
            addCriterion("cert_name is not null");
            return (Criteria) this;
        }

        public Criteria andCertNameEqualTo(String value) {
            addCriterion("cert_name =", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameNotEqualTo(String value) {
            addCriterion("cert_name <>", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameGreaterThan(String value) {
            addCriterion("cert_name >", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameGreaterThanOrEqualTo(String value) {
            addCriterion("cert_name >=", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameLessThan(String value) {
            addCriterion("cert_name <", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameLessThanOrEqualTo(String value) {
            addCriterion("cert_name <=", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameLike(String value) {
            addCriterion("cert_name like", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameNotLike(String value) {
            addCriterion("cert_name not like", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameIn(List<String> values) {
            addCriterion("cert_name in", values, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameNotIn(List<String> values) {
            addCriterion("cert_name not in", values, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameBetween(String value1, String value2) {
            addCriterion("cert_name between", value1, value2, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameNotBetween(String value1, String value2) {
            addCriterion("cert_name not between", value1, value2, "certName");
            return (Criteria) this;
        }

        public Criteria andCarPhoneIsNull() {
            addCriterion("car_phone is null");
            return (Criteria) this;
        }

        public Criteria andCarPhoneIsNotNull() {
            addCriterion("car_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCarPhoneEqualTo(String value) {
            addCriterion("car_phone =", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotEqualTo(String value) {
            addCriterion("car_phone <>", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneGreaterThan(String value) {
            addCriterion("car_phone >", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("car_phone >=", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneLessThan(String value) {
            addCriterion("car_phone <", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneLessThanOrEqualTo(String value) {
            addCriterion("car_phone <=", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneLike(String value) {
            addCriterion("car_phone like", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotLike(String value) {
            addCriterion("car_phone not like", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneIn(List<String> values) {
            addCriterion("car_phone in", values, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotIn(List<String> values) {
            addCriterion("car_phone not in", values, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneBetween(String value1, String value2) {
            addCriterion("car_phone between", value1, value2, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotBetween(String value1, String value2) {
            addCriterion("car_phone not between", value1, value2, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(String value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(String value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(String value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(String value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(String value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLike(String value) {
            addCriterion("car_type like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotLike(String value) {
            addCriterion("car_type not like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<String> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<String> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(String value1, String value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(String value1, String value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarLengthIsNull() {
            addCriterion("car_length is null");
            return (Criteria) this;
        }

        public Criteria andCarLengthIsNotNull() {
            addCriterion("car_length is not null");
            return (Criteria) this;
        }

        public Criteria andCarLengthEqualTo(Double value) {
            addCriterion("car_length =", value, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarLengthNotEqualTo(Double value) {
            addCriterion("car_length <>", value, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarLengthGreaterThan(Double value) {
            addCriterion("car_length >", value, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarLengthGreaterThanOrEqualTo(Double value) {
            addCriterion("car_length >=", value, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarLengthLessThan(Double value) {
            addCriterion("car_length <", value, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarLengthLessThanOrEqualTo(Double value) {
            addCriterion("car_length <=", value, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarLengthIn(List<Double> values) {
            addCriterion("car_length in", values, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarLengthNotIn(List<Double> values) {
            addCriterion("car_length not in", values, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarLengthBetween(Double value1, Double value2) {
            addCriterion("car_length between", value1, value2, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarLengthNotBetween(Double value1, Double value2) {
            addCriterion("car_length not between", value1, value2, "carLength");
            return (Criteria) this;
        }

        public Criteria andCarWeightIsNull() {
            addCriterion("car_weight is null");
            return (Criteria) this;
        }

        public Criteria andCarWeightIsNotNull() {
            addCriterion("car_weight is not null");
            return (Criteria) this;
        }

        public Criteria andCarWeightEqualTo(Double value) {
            addCriterion("car_weight =", value, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarWeightNotEqualTo(Double value) {
            addCriterion("car_weight <>", value, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarWeightGreaterThan(Double value) {
            addCriterion("car_weight >", value, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("car_weight >=", value, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarWeightLessThan(Double value) {
            addCriterion("car_weight <", value, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarWeightLessThanOrEqualTo(Double value) {
            addCriterion("car_weight <=", value, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarWeightIn(List<Double> values) {
            addCriterion("car_weight in", values, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarWeightNotIn(List<Double> values) {
            addCriterion("car_weight not in", values, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarWeightBetween(Double value1, Double value2) {
            addCriterion("car_weight between", value1, value2, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarWeightNotBetween(Double value1, Double value2) {
            addCriterion("car_weight not between", value1, value2, "carWeight");
            return (Criteria) this;
        }

        public Criteria andCarNumber1IsNull() {
            addCriterion("car_number1 is null");
            return (Criteria) this;
        }

        public Criteria andCarNumber1IsNotNull() {
            addCriterion("car_number1 is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumber1EqualTo(String value) {
            addCriterion("car_number1 =", value, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1NotEqualTo(String value) {
            addCriterion("car_number1 <>", value, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1GreaterThan(String value) {
            addCriterion("car_number1 >", value, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1GreaterThanOrEqualTo(String value) {
            addCriterion("car_number1 >=", value, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1LessThan(String value) {
            addCriterion("car_number1 <", value, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1LessThanOrEqualTo(String value) {
            addCriterion("car_number1 <=", value, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1Like(String value) {
            addCriterion("car_number1 like", value, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1NotLike(String value) {
            addCriterion("car_number1 not like", value, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1In(List<String> values) {
            addCriterion("car_number1 in", values, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1NotIn(List<String> values) {
            addCriterion("car_number1 not in", values, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1Between(String value1, String value2) {
            addCriterion("car_number1 between", value1, value2, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber1NotBetween(String value1, String value2) {
            addCriterion("car_number1 not between", value1, value2, "carNumber1");
            return (Criteria) this;
        }

        public Criteria andCarNumber2IsNull() {
            addCriterion("car_number2 is null");
            return (Criteria) this;
        }

        public Criteria andCarNumber2IsNotNull() {
            addCriterion("car_number2 is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumber2EqualTo(String value) {
            addCriterion("car_number2 =", value, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2NotEqualTo(String value) {
            addCriterion("car_number2 <>", value, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2GreaterThan(String value) {
            addCriterion("car_number2 >", value, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2GreaterThanOrEqualTo(String value) {
            addCriterion("car_number2 >=", value, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2LessThan(String value) {
            addCriterion("car_number2 <", value, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2LessThanOrEqualTo(String value) {
            addCriterion("car_number2 <=", value, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2Like(String value) {
            addCriterion("car_number2 like", value, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2NotLike(String value) {
            addCriterion("car_number2 not like", value, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2In(List<String> values) {
            addCriterion("car_number2 in", values, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2NotIn(List<String> values) {
            addCriterion("car_number2 not in", values, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2Between(String value1, String value2) {
            addCriterion("car_number2 between", value1, value2, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andCarNumber2NotBetween(String value1, String value2) {
            addCriterion("car_number2 not between", value1, value2, "carNumber2");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNull() {
            addCriterion("admin_name is null");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNotNull() {
            addCriterion("admin_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdminNameEqualTo(String value) {
            addCriterion("admin_name =", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotEqualTo(String value) {
            addCriterion("admin_name <>", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThan(String value) {
            addCriterion("admin_name >", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_name >=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThan(String value) {
            addCriterion("admin_name <", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThanOrEqualTo(String value) {
            addCriterion("admin_name <=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLike(String value) {
            addCriterion("admin_name like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotLike(String value) {
            addCriterion("admin_name not like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameIn(List<String> values) {
            addCriterion("admin_name in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotIn(List<String> values) {
            addCriterion("admin_name not in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameBetween(String value1, String value2) {
            addCriterion("admin_name between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotBetween(String value1, String value2) {
            addCriterion("admin_name not between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andCarStatuesIsNull() {
            addCriterion("car_statues is null");
            return (Criteria) this;
        }

        public Criteria andCarStatuesIsNotNull() {
            addCriterion("car_statues is not null");
            return (Criteria) this;
        }

        public Criteria andCarStatuesEqualTo(Integer value) {
            addCriterion("car_statues =", value, "carStatues");
            return (Criteria) this;
        }

        public Criteria andCarStatuesNotEqualTo(Integer value) {
            addCriterion("car_statues <>", value, "carStatues");
            return (Criteria) this;
        }

        public Criteria andCarStatuesGreaterThan(Integer value) {
            addCriterion("car_statues >", value, "carStatues");
            return (Criteria) this;
        }

        public Criteria andCarStatuesGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_statues >=", value, "carStatues");
            return (Criteria) this;
        }

        public Criteria andCarStatuesLessThan(Integer value) {
            addCriterion("car_statues <", value, "carStatues");
            return (Criteria) this;
        }

        public Criteria andCarStatuesLessThanOrEqualTo(Integer value) {
            addCriterion("car_statues <=", value, "carStatues");
            return (Criteria) this;
        }

        public Criteria andCarStatuesIn(List<Integer> values) {
            addCriterion("car_statues in", values, "carStatues");
            return (Criteria) this;
        }

        public Criteria andCarStatuesNotIn(List<Integer> values) {
            addCriterion("car_statues not in", values, "carStatues");
            return (Criteria) this;
        }

        public Criteria andCarStatuesBetween(Integer value1, Integer value2) {
            addCriterion("car_statues between", value1, value2, "carStatues");
            return (Criteria) this;
        }

        public Criteria andCarStatuesNotBetween(Integer value1, Integer value2) {
            addCriterion("car_statues not between", value1, value2, "carStatues");
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