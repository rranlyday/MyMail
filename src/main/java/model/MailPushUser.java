package model;

public class MailPushUser {
    private Integer id;

    private Integer mailPushId;

    private Integer userId;

    private Integer arrive;   // 0代表没有到达，1代表已经到达

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMailPushId() {
        return mailPushId;
    }

    public void setMailPushId(Integer mailPushId) {
        this.mailPushId = mailPushId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArrive() {
        return arrive;
    }

    public void setArrive(Integer arrive) {
        this.arrive = arrive;
    }
}