package com.ontime.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QUsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QUsersExample() {
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

        public Criteria andQuIdIsNull() {
            addCriterion("qu_id is null");
            return (Criteria) this;
        }

        public Criteria andQuIdIsNotNull() {
            addCriterion("qu_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuIdEqualTo(Integer value) {
            addCriterion("qu_id =", value, "quId");
            return (Criteria) this;
        }

        public Criteria andQuIdNotEqualTo(Integer value) {
            addCriterion("qu_id <>", value, "quId");
            return (Criteria) this;
        }

        public Criteria andQuIdGreaterThan(Integer value) {
            addCriterion("qu_id >", value, "quId");
            return (Criteria) this;
        }

        public Criteria andQuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("qu_id >=", value, "quId");
            return (Criteria) this;
        }

        public Criteria andQuIdLessThan(Integer value) {
            addCriterion("qu_id <", value, "quId");
            return (Criteria) this;
        }

        public Criteria andQuIdLessThanOrEqualTo(Integer value) {
            addCriterion("qu_id <=", value, "quId");
            return (Criteria) this;
        }

        public Criteria andQuIdIn(List<Integer> values) {
            addCriterion("qu_id in", values, "quId");
            return (Criteria) this;
        }

        public Criteria andQuIdNotIn(List<Integer> values) {
            addCriterion("qu_id not in", values, "quId");
            return (Criteria) this;
        }

        public Criteria andQuIdBetween(Integer value1, Integer value2) {
            addCriterion("qu_id between", value1, value2, "quId");
            return (Criteria) this;
        }

        public Criteria andQuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("qu_id not between", value1, value2, "quId");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andCertNumberIsNull() {
            addCriterion("cert_number is null");
            return (Criteria) this;
        }

        public Criteria andCertNumberIsNotNull() {
            addCriterion("cert_number is not null");
            return (Criteria) this;
        }

        public Criteria andCertNumberEqualTo(String value) {
            addCriterion("cert_number =", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberNotEqualTo(String value) {
            addCriterion("cert_number <>", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberGreaterThan(String value) {
            addCriterion("cert_number >", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberGreaterThanOrEqualTo(String value) {
            addCriterion("cert_number >=", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberLessThan(String value) {
            addCriterion("cert_number <", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberLessThanOrEqualTo(String value) {
            addCriterion("cert_number <=", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberLike(String value) {
            addCriterion("cert_number like", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberNotLike(String value) {
            addCriterion("cert_number not like", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberIn(List<String> values) {
            addCriterion("cert_number in", values, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberNotIn(List<String> values) {
            addCriterion("cert_number not in", values, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberBetween(String value1, String value2) {
            addCriterion("cert_number between", value1, value2, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberNotBetween(String value1, String value2) {
            addCriterion("cert_number not between", value1, value2, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertAddressIsNull() {
            addCriterion("cert_address is null");
            return (Criteria) this;
        }

        public Criteria andCertAddressIsNotNull() {
            addCriterion("cert_address is not null");
            return (Criteria) this;
        }

        public Criteria andCertAddressEqualTo(String value) {
            addCriterion("cert_address =", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressNotEqualTo(String value) {
            addCriterion("cert_address <>", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressGreaterThan(String value) {
            addCriterion("cert_address >", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressGreaterThanOrEqualTo(String value) {
            addCriterion("cert_address >=", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressLessThan(String value) {
            addCriterion("cert_address <", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressLessThanOrEqualTo(String value) {
            addCriterion("cert_address <=", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressLike(String value) {
            addCriterion("cert_address like", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressNotLike(String value) {
            addCriterion("cert_address not like", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressIn(List<String> values) {
            addCriterion("cert_address in", values, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressNotIn(List<String> values) {
            addCriterion("cert_address not in", values, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressBetween(String value1, String value2) {
            addCriterion("cert_address between", value1, value2, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressNotBetween(String value1, String value2) {
            addCriterion("cert_address not between", value1, value2, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCompNameIsNull() {
            addCriterion("comp_name is null");
            return (Criteria) this;
        }

        public Criteria andCompNameIsNotNull() {
            addCriterion("comp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompNameEqualTo(String value) {
            addCriterion("comp_name =", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotEqualTo(String value) {
            addCriterion("comp_name <>", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThan(String value) {
            addCriterion("comp_name >", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThanOrEqualTo(String value) {
            addCriterion("comp_name >=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThan(String value) {
            addCriterion("comp_name <", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThanOrEqualTo(String value) {
            addCriterion("comp_name <=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLike(String value) {
            addCriterion("comp_name like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotLike(String value) {
            addCriterion("comp_name not like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameIn(List<String> values) {
            addCriterion("comp_name in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotIn(List<String> values) {
            addCriterion("comp_name not in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameBetween(String value1, String value2) {
            addCriterion("comp_name between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotBetween(String value1, String value2) {
            addCriterion("comp_name not between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andCompAddressIsNull() {
            addCriterion("comp_address is null");
            return (Criteria) this;
        }

        public Criteria andCompAddressIsNotNull() {
            addCriterion("comp_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompAddressEqualTo(String value) {
            addCriterion("comp_address =", value, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressNotEqualTo(String value) {
            addCriterion("comp_address <>", value, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressGreaterThan(String value) {
            addCriterion("comp_address >", value, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressGreaterThanOrEqualTo(String value) {
            addCriterion("comp_address >=", value, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressLessThan(String value) {
            addCriterion("comp_address <", value, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressLessThanOrEqualTo(String value) {
            addCriterion("comp_address <=", value, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressLike(String value) {
            addCriterion("comp_address like", value, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressNotLike(String value) {
            addCriterion("comp_address not like", value, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressIn(List<String> values) {
            addCriterion("comp_address in", values, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressNotIn(List<String> values) {
            addCriterion("comp_address not in", values, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressBetween(String value1, String value2) {
            addCriterion("comp_address between", value1, value2, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompAddressNotBetween(String value1, String value2) {
            addCriterion("comp_address not between", value1, value2, "compAddress");
            return (Criteria) this;
        }

        public Criteria andCompPhoneIsNull() {
            addCriterion("comp_phone is null");
            return (Criteria) this;
        }

        public Criteria andCompPhoneIsNotNull() {
            addCriterion("comp_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCompPhoneEqualTo(String value) {
            addCriterion("comp_phone =", value, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneNotEqualTo(String value) {
            addCriterion("comp_phone <>", value, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneGreaterThan(String value) {
            addCriterion("comp_phone >", value, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("comp_phone >=", value, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneLessThan(String value) {
            addCriterion("comp_phone <", value, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneLessThanOrEqualTo(String value) {
            addCriterion("comp_phone <=", value, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneLike(String value) {
            addCriterion("comp_phone like", value, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneNotLike(String value) {
            addCriterion("comp_phone not like", value, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneIn(List<String> values) {
            addCriterion("comp_phone in", values, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneNotIn(List<String> values) {
            addCriterion("comp_phone not in", values, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneBetween(String value1, String value2) {
            addCriterion("comp_phone between", value1, value2, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompPhoneNotBetween(String value1, String value2) {
            addCriterion("comp_phone not between", value1, value2, "compPhone");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionIsNull() {
            addCriterion("comp_introduction is null");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionIsNotNull() {
            addCriterion("comp_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionEqualTo(String value) {
            addCriterion("comp_introduction =", value, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionNotEqualTo(String value) {
            addCriterion("comp_introduction <>", value, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionGreaterThan(String value) {
            addCriterion("comp_introduction >", value, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("comp_introduction >=", value, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionLessThan(String value) {
            addCriterion("comp_introduction <", value, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionLessThanOrEqualTo(String value) {
            addCriterion("comp_introduction <=", value, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionLike(String value) {
            addCriterion("comp_introduction like", value, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionNotLike(String value) {
            addCriterion("comp_introduction not like", value, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionIn(List<String> values) {
            addCriterion("comp_introduction in", values, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionNotIn(List<String> values) {
            addCriterion("comp_introduction not in", values, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionBetween(String value1, String value2) {
            addCriterion("comp_introduction between", value1, value2, "compIntroduction");
            return (Criteria) this;
        }

        public Criteria andCompIntroductionNotBetween(String value1, String value2) {
            addCriterion("comp_introduction not between", value1, value2, "compIntroduction");
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

        public Criteria andUserTypeIdIsNull() {
            addCriterion("user_type_id is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdIsNotNull() {
            addCriterion("user_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdEqualTo(Integer value) {
            addCriterion("user_type_id =", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdNotEqualTo(Integer value) {
            addCriterion("user_type_id <>", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdGreaterThan(Integer value) {
            addCriterion("user_type_id >", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type_id >=", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdLessThan(Integer value) {
            addCriterion("user_type_id <", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_type_id <=", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdIn(List<Integer> values) {
            addCriterion("user_type_id in", values, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdNotIn(List<Integer> values) {
            addCriterion("user_type_id not in", values, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("user_type_id between", value1, value2, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type_id not between", value1, value2, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andZlineCityIsNull() {
            addCriterion("zline_city is null");
            return (Criteria) this;
        }

        public Criteria andZlineCityIsNotNull() {
            addCriterion("zline_city is not null");
            return (Criteria) this;
        }

        public Criteria andZlineCityEqualTo(String value) {
            addCriterion("zline_city =", value, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityNotEqualTo(String value) {
            addCriterion("zline_city <>", value, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityGreaterThan(String value) {
            addCriterion("zline_city >", value, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityGreaterThanOrEqualTo(String value) {
            addCriterion("zline_city >=", value, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityLessThan(String value) {
            addCriterion("zline_city <", value, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityLessThanOrEqualTo(String value) {
            addCriterion("zline_city <=", value, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityLike(String value) {
            addCriterion("zline_city like", value, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityNotLike(String value) {
            addCriterion("zline_city not like", value, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityIn(List<String> values) {
            addCriterion("zline_city in", values, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityNotIn(List<String> values) {
            addCriterion("zline_city not in", values, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityBetween(String value1, String value2) {
            addCriterion("zline_city between", value1, value2, "zlineCity");
            return (Criteria) this;
        }

        public Criteria andZlineCityNotBetween(String value1, String value2) {
            addCriterion("zline_city not between", value1, value2, "zlineCity");
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