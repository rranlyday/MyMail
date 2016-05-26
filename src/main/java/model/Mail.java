package model;

import java.util.Date;

public class Mail {
    private Integer id;

    private Integer userId;

    private Date publishTime;

    private Integer orderRecive;

    private Integer service;

    private Integer pay;

    private Long reward;

    private String pickUpAddress;

    private Date pickUpTime;

    private String pickUpLinkman;

    private String pickUpPhone;

    private String aimAddress;

    private Date aimTime;

    private String aimLinkman;

    private String aimPhone;

    private Integer goodsTypeId;

    private String goodsSize;

    private String goodsPhoto;

    private String goodsWeight;

    private Integer goodsNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getOrderRecive() {
        return orderRecive;
    }

    public void setOrderRecive(Integer orderRecive) {
        this.orderRecive = orderRecive;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Long getReward() {
        return reward;
    }

    public void setReward(Long reward) {
        this.reward = reward;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress == null ? null : pickUpAddress.trim();
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpLinkman() {
        return pickUpLinkman;
    }

    public void setPickUpLinkman(String pickUpLinkman) {
        this.pickUpLinkman = pickUpLinkman == null ? null : pickUpLinkman.trim();
    }

    public String getPickUpPhone() {
        return pickUpPhone;
    }

    public void setPickUpPhone(String pickUpPhone) {
        this.pickUpPhone = pickUpPhone == null ? null : pickUpPhone.trim();
    }

    public String getAimAddress() {
        return aimAddress;
    }

    public void setAimAddress(String aimAddress) {
        this.aimAddress = aimAddress == null ? null : aimAddress.trim();
    }

    public Date getAimTime() {
        return aimTime;
    }

    public void setAimTime(Date aimTime) {
        this.aimTime = aimTime;
    }

    public String getAimLinkman() {
        return aimLinkman;
    }

    public void setAimLinkman(String aimLinkman) {
        this.aimLinkman = aimLinkman == null ? null : aimLinkman.trim();
    }

    public String getAimPhone() {
        return aimPhone;
    }

    public void setAimPhone(String aimPhone) {
        this.aimPhone = aimPhone == null ? null : aimPhone.trim();
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize == null ? null : goodsSize.trim();
    }

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto == null ? null : goodsPhoto.trim();
    }

    public String getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight == null ? null : goodsWeight.trim();
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}