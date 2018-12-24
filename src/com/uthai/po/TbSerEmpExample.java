package com.uthai.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSerEmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSerEmpExample() {
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

        public Criteria andSerEmpIdIsNull() {
            addCriterion("ser_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdIsNotNull() {
            addCriterion("ser_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdEqualTo(String value) {
            addCriterion("ser_emp_id =", value, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdNotEqualTo(String value) {
            addCriterion("ser_emp_id <>", value, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdGreaterThan(String value) {
            addCriterion("ser_emp_id >", value, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("ser_emp_id >=", value, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdLessThan(String value) {
            addCriterion("ser_emp_id <", value, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdLessThanOrEqualTo(String value) {
            addCriterion("ser_emp_id <=", value, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdLike(String value) {
            addCriterion("ser_emp_id like", value, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdNotLike(String value) {
            addCriterion("ser_emp_id not like", value, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdIn(List<String> values) {
            addCriterion("ser_emp_id in", values, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdNotIn(List<String> values) {
            addCriterion("ser_emp_id not in", values, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdBetween(String value1, String value2) {
            addCriterion("ser_emp_id between", value1, value2, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andSerEmpIdNotBetween(String value1, String value2) {
            addCriterion("ser_emp_id not between", value1, value2, "serEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andSerStatusIsNull() {
            addCriterion("ser_status is null");
            return (Criteria) this;
        }

        public Criteria andSerStatusIsNotNull() {
            addCriterion("ser_status is not null");
            return (Criteria) this;
        }

        public Criteria andSerStatusEqualTo(String value) {
            addCriterion("ser_status =", value, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusNotEqualTo(String value) {
            addCriterion("ser_status <>", value, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusGreaterThan(String value) {
            addCriterion("ser_status >", value, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ser_status >=", value, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusLessThan(String value) {
            addCriterion("ser_status <", value, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusLessThanOrEqualTo(String value) {
            addCriterion("ser_status <=", value, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusLike(String value) {
            addCriterion("ser_status like", value, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusNotLike(String value) {
            addCriterion("ser_status not like", value, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusIn(List<String> values) {
            addCriterion("ser_status in", values, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusNotIn(List<String> values) {
            addCriterion("ser_status not in", values, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusBetween(String value1, String value2) {
            addCriterion("ser_status between", value1, value2, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerStatusNotBetween(String value1, String value2) {
            addCriterion("ser_status not between", value1, value2, "serStatus");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameIsNull() {
            addCriterion("ser_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameIsNotNull() {
            addCriterion("ser_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameEqualTo(String value) {
            addCriterion("ser_emp_name =", value, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameNotEqualTo(String value) {
            addCriterion("ser_emp_name <>", value, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameGreaterThan(String value) {
            addCriterion("ser_emp_name >", value, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("ser_emp_name >=", value, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameLessThan(String value) {
            addCriterion("ser_emp_name <", value, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameLessThanOrEqualTo(String value) {
            addCriterion("ser_emp_name <=", value, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameLike(String value) {
            addCriterion("ser_emp_name like", value, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameNotLike(String value) {
            addCriterion("ser_emp_name not like", value, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameIn(List<String> values) {
            addCriterion("ser_emp_name in", values, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameNotIn(List<String> values) {
            addCriterion("ser_emp_name not in", values, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameBetween(String value1, String value2) {
            addCriterion("ser_emp_name between", value1, value2, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andSerEmpNameNotBetween(String value1, String value2) {
            addCriterion("ser_emp_name not between", value1, value2, "serEmpName");
            return (Criteria) this;
        }

        public Criteria andTelNumberIsNull() {
            addCriterion("tel_number is null");
            return (Criteria) this;
        }

        public Criteria andTelNumberIsNotNull() {
            addCriterion("tel_number is not null");
            return (Criteria) this;
        }

        public Criteria andTelNumberEqualTo(String value) {
            addCriterion("tel_number =", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotEqualTo(String value) {
            addCriterion("tel_number <>", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberGreaterThan(String value) {
            addCriterion("tel_number >", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberGreaterThanOrEqualTo(String value) {
            addCriterion("tel_number >=", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberLessThan(String value) {
            addCriterion("tel_number <", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberLessThanOrEqualTo(String value) {
            addCriterion("tel_number <=", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberLike(String value) {
            addCriterion("tel_number like", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotLike(String value) {
            addCriterion("tel_number not like", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberIn(List<String> values) {
            addCriterion("tel_number in", values, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotIn(List<String> values) {
            addCriterion("tel_number not in", values, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberBetween(String value1, String value2) {
            addCriterion("tel_number between", value1, value2, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotBetween(String value1, String value2) {
            addCriterion("tel_number not between", value1, value2, "telNumber");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andWeChatIsNull() {
            addCriterion("we_chat is null");
            return (Criteria) this;
        }

        public Criteria andWeChatIsNotNull() {
            addCriterion("we_chat is not null");
            return (Criteria) this;
        }

        public Criteria andWeChatEqualTo(String value) {
            addCriterion("we_chat =", value, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatNotEqualTo(String value) {
            addCriterion("we_chat <>", value, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatGreaterThan(String value) {
            addCriterion("we_chat >", value, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatGreaterThanOrEqualTo(String value) {
            addCriterion("we_chat >=", value, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatLessThan(String value) {
            addCriterion("we_chat <", value, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatLessThanOrEqualTo(String value) {
            addCriterion("we_chat <=", value, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatLike(String value) {
            addCriterion("we_chat like", value, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatNotLike(String value) {
            addCriterion("we_chat not like", value, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatIn(List<String> values) {
            addCriterion("we_chat in", values, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatNotIn(List<String> values) {
            addCriterion("we_chat not in", values, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatBetween(String value1, String value2) {
            addCriterion("we_chat between", value1, value2, "weChat");
            return (Criteria) this;
        }

        public Criteria andWeChatNotBetween(String value1, String value2) {
            addCriterion("we_chat not between", value1, value2, "weChat");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
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