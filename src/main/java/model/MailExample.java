package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MailExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReciveIsNull() {
            addCriterion("order_recive is null");
            return (Criteria) this;
        }

        public Criteria andOrderReciveIsNotNull() {
            addCriterion("order_recive is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReciveEqualTo(Integer value) {
            addCriterion("order_recive =", value, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andOrderReciveNotEqualTo(Integer value) {
            addCriterion("order_recive <>", value, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andOrderReciveGreaterThan(Integer value) {
            addCriterion("order_recive >", value, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andOrderReciveGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_recive >=", value, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andOrderReciveLessThan(Integer value) {
            addCriterion("order_recive <", value, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andOrderReciveLessThanOrEqualTo(Integer value) {
            addCriterion("order_recive <=", value, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andOrderReciveIn(List<Integer> values) {
            addCriterion("order_recive in", values, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andOrderReciveNotIn(List<Integer> values) {
            addCriterion("order_recive not in", values, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andOrderReciveBetween(Integer value1, Integer value2) {
            addCriterion("order_recive between", value1, value2, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andOrderReciveNotBetween(Integer value1, Integer value2) {
            addCriterion("order_recive not between", value1, value2, "orderRecive");
            return (Criteria) this;
        }

        public Criteria andServiceIsNull() {
            addCriterion("service is null");
            return (Criteria) this;
        }

        public Criteria andServiceIsNotNull() {
            addCriterion("service is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEqualTo(Integer value) {
            addCriterion("service =", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotEqualTo(Integer value) {
            addCriterion("service <>", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThan(Integer value) {
            addCriterion("service >", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThanOrEqualTo(Integer value) {
            addCriterion("service >=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThan(Integer value) {
            addCriterion("service <", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThanOrEqualTo(Integer value) {
            addCriterion("service <=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceIn(List<Integer> values) {
            addCriterion("service in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotIn(List<Integer> values) {
            addCriterion("service not in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceBetween(Integer value1, Integer value2) {
            addCriterion("service between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotBetween(Integer value1, Integer value2) {
            addCriterion("service not between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andPayIsNull() {
            addCriterion("pay is null");
            return (Criteria) this;
        }

        public Criteria andPayIsNotNull() {
            addCriterion("pay is not null");
            return (Criteria) this;
        }

        public Criteria andPayEqualTo(Integer value) {
            addCriterion("pay =", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotEqualTo(Integer value) {
            addCriterion("pay <>", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayGreaterThan(Integer value) {
            addCriterion("pay >", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay >=", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayLessThan(Integer value) {
            addCriterion("pay <", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayLessThanOrEqualTo(Integer value) {
            addCriterion("pay <=", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayIn(List<Integer> values) {
            addCriterion("pay in", values, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotIn(List<Integer> values) {
            addCriterion("pay not in", values, "pay");
            return (Criteria) this;
        }

        public Criteria andPayBetween(Integer value1, Integer value2) {
            addCriterion("pay between", value1, value2, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotBetween(Integer value1, Integer value2) {
            addCriterion("pay not between", value1, value2, "pay");
            return (Criteria) this;
        }

        public Criteria andRewardIsNull() {
            addCriterion("reward is null");
            return (Criteria) this;
        }

        public Criteria andRewardIsNotNull() {
            addCriterion("reward is not null");
            return (Criteria) this;
        }

        public Criteria andRewardEqualTo(Long value) {
            addCriterion("reward =", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotEqualTo(Long value) {
            addCriterion("reward <>", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThan(Long value) {
            addCriterion("reward >", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThanOrEqualTo(Long value) {
            addCriterion("reward >=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThan(Long value) {
            addCriterion("reward <", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThanOrEqualTo(Long value) {
            addCriterion("reward <=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardIn(List<Long> values) {
            addCriterion("reward in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotIn(List<Long> values) {
            addCriterion("reward not in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardBetween(Long value1, Long value2) {
            addCriterion("reward between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotBetween(Long value1, Long value2) {
            addCriterion("reward not between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressIsNull() {
            addCriterion("pick_up_address is null");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressIsNotNull() {
            addCriterion("pick_up_address is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressEqualTo(String value) {
            addCriterion("pick_up_address =", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressNotEqualTo(String value) {
            addCriterion("pick_up_address <>", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressGreaterThan(String value) {
            addCriterion("pick_up_address >", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("pick_up_address >=", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressLessThan(String value) {
            addCriterion("pick_up_address <", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressLessThanOrEqualTo(String value) {
            addCriterion("pick_up_address <=", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressLike(String value) {
            addCriterion("pick_up_address like", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressNotLike(String value) {
            addCriterion("pick_up_address not like", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressIn(List<String> values) {
            addCriterion("pick_up_address in", values, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressNotIn(List<String> values) {
            addCriterion("pick_up_address not in", values, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressBetween(String value1, String value2) {
            addCriterion("pick_up_address between", value1, value2, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressNotBetween(String value1, String value2) {
            addCriterion("pick_up_address not between", value1, value2, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeIsNull() {
            addCriterion("pick_up_time is null");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeIsNotNull() {
            addCriterion("pick_up_time is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeEqualTo(Date value) {
            addCriterion("pick_up_time =", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeNotEqualTo(Date value) {
            addCriterion("pick_up_time <>", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeGreaterThan(Date value) {
            addCriterion("pick_up_time >", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pick_up_time >=", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeLessThan(Date value) {
            addCriterion("pick_up_time <", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeLessThanOrEqualTo(Date value) {
            addCriterion("pick_up_time <=", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeIn(List<Date> values) {
            addCriterion("pick_up_time in", values, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeNotIn(List<Date> values) {
            addCriterion("pick_up_time not in", values, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeBetween(Date value1, Date value2) {
            addCriterion("pick_up_time between", value1, value2, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeNotBetween(Date value1, Date value2) {
            addCriterion("pick_up_time not between", value1, value2, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanIsNull() {
            addCriterion("pick_up_linkman is null");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanIsNotNull() {
            addCriterion("pick_up_linkman is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanEqualTo(String value) {
            addCriterion("pick_up_linkman =", value, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanNotEqualTo(String value) {
            addCriterion("pick_up_linkman <>", value, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanGreaterThan(String value) {
            addCriterion("pick_up_linkman >", value, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("pick_up_linkman >=", value, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanLessThan(String value) {
            addCriterion("pick_up_linkman <", value, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanLessThanOrEqualTo(String value) {
            addCriterion("pick_up_linkman <=", value, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanLike(String value) {
            addCriterion("pick_up_linkman like", value, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanNotLike(String value) {
            addCriterion("pick_up_linkman not like", value, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanIn(List<String> values) {
            addCriterion("pick_up_linkman in", values, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanNotIn(List<String> values) {
            addCriterion("pick_up_linkman not in", values, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanBetween(String value1, String value2) {
            addCriterion("pick_up_linkman between", value1, value2, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpLinkmanNotBetween(String value1, String value2) {
            addCriterion("pick_up_linkman not between", value1, value2, "pickUpLinkman");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneIsNull() {
            addCriterion("pick_up_phone is null");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneIsNotNull() {
            addCriterion("pick_up_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneEqualTo(String value) {
            addCriterion("pick_up_phone =", value, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneNotEqualTo(String value) {
            addCriterion("pick_up_phone <>", value, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneGreaterThan(String value) {
            addCriterion("pick_up_phone >", value, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("pick_up_phone >=", value, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneLessThan(String value) {
            addCriterion("pick_up_phone <", value, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneLessThanOrEqualTo(String value) {
            addCriterion("pick_up_phone <=", value, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneLike(String value) {
            addCriterion("pick_up_phone like", value, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneNotLike(String value) {
            addCriterion("pick_up_phone not like", value, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneIn(List<String> values) {
            addCriterion("pick_up_phone in", values, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneNotIn(List<String> values) {
            addCriterion("pick_up_phone not in", values, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneBetween(String value1, String value2) {
            addCriterion("pick_up_phone between", value1, value2, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andPickUpPhoneNotBetween(String value1, String value2) {
            addCriterion("pick_up_phone not between", value1, value2, "pickUpPhone");
            return (Criteria) this;
        }

        public Criteria andAimAddressIsNull() {
            addCriterion("aim_address is null");
            return (Criteria) this;
        }

        public Criteria andAimAddressIsNotNull() {
            addCriterion("aim_address is not null");
            return (Criteria) this;
        }

        public Criteria andAimAddressEqualTo(String value) {
            addCriterion("aim_address =", value, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressNotEqualTo(String value) {
            addCriterion("aim_address <>", value, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressGreaterThan(String value) {
            addCriterion("aim_address >", value, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressGreaterThanOrEqualTo(String value) {
            addCriterion("aim_address >=", value, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressLessThan(String value) {
            addCriterion("aim_address <", value, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressLessThanOrEqualTo(String value) {
            addCriterion("aim_address <=", value, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressLike(String value) {
            addCriterion("aim_address like", value, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressNotLike(String value) {
            addCriterion("aim_address not like", value, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressIn(List<String> values) {
            addCriterion("aim_address in", values, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressNotIn(List<String> values) {
            addCriterion("aim_address not in", values, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressBetween(String value1, String value2) {
            addCriterion("aim_address between", value1, value2, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimAddressNotBetween(String value1, String value2) {
            addCriterion("aim_address not between", value1, value2, "aimAddress");
            return (Criteria) this;
        }

        public Criteria andAimTimeIsNull() {
            addCriterion("aim_time is null");
            return (Criteria) this;
        }

        public Criteria andAimTimeIsNotNull() {
            addCriterion("aim_time is not null");
            return (Criteria) this;
        }

        public Criteria andAimTimeEqualTo(Date value) {
            addCriterion("aim_time =", value, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimTimeNotEqualTo(Date value) {
            addCriterion("aim_time <>", value, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimTimeGreaterThan(Date value) {
            addCriterion("aim_time >", value, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("aim_time >=", value, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimTimeLessThan(Date value) {
            addCriterion("aim_time <", value, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimTimeLessThanOrEqualTo(Date value) {
            addCriterion("aim_time <=", value, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimTimeIn(List<Date> values) {
            addCriterion("aim_time in", values, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimTimeNotIn(List<Date> values) {
            addCriterion("aim_time not in", values, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimTimeBetween(Date value1, Date value2) {
            addCriterion("aim_time between", value1, value2, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimTimeNotBetween(Date value1, Date value2) {
            addCriterion("aim_time not between", value1, value2, "aimTime");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanIsNull() {
            addCriterion("aim_linkman is null");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanIsNotNull() {
            addCriterion("aim_linkman is not null");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanEqualTo(String value) {
            addCriterion("aim_linkman =", value, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanNotEqualTo(String value) {
            addCriterion("aim_linkman <>", value, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanGreaterThan(String value) {
            addCriterion("aim_linkman >", value, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("aim_linkman >=", value, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanLessThan(String value) {
            addCriterion("aim_linkman <", value, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanLessThanOrEqualTo(String value) {
            addCriterion("aim_linkman <=", value, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanLike(String value) {
            addCriterion("aim_linkman like", value, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanNotLike(String value) {
            addCriterion("aim_linkman not like", value, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanIn(List<String> values) {
            addCriterion("aim_linkman in", values, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanNotIn(List<String> values) {
            addCriterion("aim_linkman not in", values, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanBetween(String value1, String value2) {
            addCriterion("aim_linkman between", value1, value2, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimLinkmanNotBetween(String value1, String value2) {
            addCriterion("aim_linkman not between", value1, value2, "aimLinkman");
            return (Criteria) this;
        }

        public Criteria andAimPhoneIsNull() {
            addCriterion("aim_phone is null");
            return (Criteria) this;
        }

        public Criteria andAimPhoneIsNotNull() {
            addCriterion("aim_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAimPhoneEqualTo(String value) {
            addCriterion("aim_phone =", value, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneNotEqualTo(String value) {
            addCriterion("aim_phone <>", value, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneGreaterThan(String value) {
            addCriterion("aim_phone >", value, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("aim_phone >=", value, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneLessThan(String value) {
            addCriterion("aim_phone <", value, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneLessThanOrEqualTo(String value) {
            addCriterion("aim_phone <=", value, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneLike(String value) {
            addCriterion("aim_phone like", value, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneNotLike(String value) {
            addCriterion("aim_phone not like", value, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneIn(List<String> values) {
            addCriterion("aim_phone in", values, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneNotIn(List<String> values) {
            addCriterion("aim_phone not in", values, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneBetween(String value1, String value2) {
            addCriterion("aim_phone between", value1, value2, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andAimPhoneNotBetween(String value1, String value2) {
            addCriterion("aim_phone not between", value1, value2, "aimPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdIsNull() {
            addCriterion("goods_type_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdIsNotNull() {
            addCriterion("goods_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdEqualTo(Integer value) {
            addCriterion("goods_type_id =", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdNotEqualTo(Integer value) {
            addCriterion("goods_type_id <>", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdGreaterThan(Integer value) {
            addCriterion("goods_type_id >", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_type_id >=", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdLessThan(Integer value) {
            addCriterion("goods_type_id <", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_type_id <=", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdIn(List<Integer> values) {
            addCriterion("goods_type_id in", values, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdNotIn(List<Integer> values) {
            addCriterion("goods_type_id not in", values, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_type_id between", value1, value2, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_type_id not between", value1, value2, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeIsNull() {
            addCriterion("goods_size is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeIsNotNull() {
            addCriterion("goods_size is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeEqualTo(String value) {
            addCriterion("goods_size =", value, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeNotEqualTo(String value) {
            addCriterion("goods_size <>", value, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeGreaterThan(String value) {
            addCriterion("goods_size >", value, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_size >=", value, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeLessThan(String value) {
            addCriterion("goods_size <", value, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeLessThanOrEqualTo(String value) {
            addCriterion("goods_size <=", value, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeLike(String value) {
            addCriterion("goods_size like", value, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeNotLike(String value) {
            addCriterion("goods_size not like", value, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeIn(List<String> values) {
            addCriterion("goods_size in", values, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeNotIn(List<String> values) {
            addCriterion("goods_size not in", values, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeBetween(String value1, String value2) {
            addCriterion("goods_size between", value1, value2, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsSizeNotBetween(String value1, String value2) {
            addCriterion("goods_size not between", value1, value2, "goodsSize");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoIsNull() {
            addCriterion("goods_photo is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoIsNotNull() {
            addCriterion("goods_photo is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoEqualTo(String value) {
            addCriterion("goods_photo =", value, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoNotEqualTo(String value) {
            addCriterion("goods_photo <>", value, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoGreaterThan(String value) {
            addCriterion("goods_photo >", value, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("goods_photo >=", value, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoLessThan(String value) {
            addCriterion("goods_photo <", value, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoLessThanOrEqualTo(String value) {
            addCriterion("goods_photo <=", value, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoLike(String value) {
            addCriterion("goods_photo like", value, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoNotLike(String value) {
            addCriterion("goods_photo not like", value, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoIn(List<String> values) {
            addCriterion("goods_photo in", values, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoNotIn(List<String> values) {
            addCriterion("goods_photo not in", values, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoBetween(String value1, String value2) {
            addCriterion("goods_photo between", value1, value2, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsPhotoNotBetween(String value1, String value2) {
            addCriterion("goods_photo not between", value1, value2, "goodsPhoto");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIsNull() {
            addCriterion("goods_weight is null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIsNotNull() {
            addCriterion("goods_weight is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightEqualTo(String value) {
            addCriterion("goods_weight =", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotEqualTo(String value) {
            addCriterion("goods_weight <>", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightGreaterThan(String value) {
            addCriterion("goods_weight >", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightGreaterThanOrEqualTo(String value) {
            addCriterion("goods_weight >=", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightLessThan(String value) {
            addCriterion("goods_weight <", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightLessThanOrEqualTo(String value) {
            addCriterion("goods_weight <=", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightLike(String value) {
            addCriterion("goods_weight like", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotLike(String value) {
            addCriterion("goods_weight not like", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIn(List<String> values) {
            addCriterion("goods_weight in", values, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotIn(List<String> values) {
            addCriterion("goods_weight not in", values, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightBetween(String value1, String value2) {
            addCriterion("goods_weight between", value1, value2, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotBetween(String value1, String value2) {
            addCriterion("goods_weight not between", value1, value2, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNull() {
            addCriterion("goods_num is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNotNull() {
            addCriterion("goods_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumEqualTo(Integer value) {
            addCriterion("goods_num =", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotEqualTo(Integer value) {
            addCriterion("goods_num <>", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThan(Integer value) {
            addCriterion("goods_num >", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_num >=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThan(Integer value) {
            addCriterion("goods_num <", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            addCriterion("goods_num <=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIn(List<Integer> values) {
            addCriterion("goods_num in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotIn(List<Integer> values) {
            addCriterion("goods_num not in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            addCriterion("goods_num between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_num not between", value1, value2, "goodsNum");
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