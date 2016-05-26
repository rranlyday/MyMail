package model;

import java.util.Date;

public class Message {
    private Integer id;

    private Integer lookUp; //0表示未查看,1表示已经查看

    private Integer senderId;

    private Integer receiverId;

    private String content;

    private Date sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLookUp() {
        return lookUp;
    }

    public void setLookUp(Integer lookUp) {
        this.lookUp = lookUp;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}