package DTO;

import model.MailPush;
import model.MailPushUser;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public class MailPushMessageDTO {

    private MailPushUser mailPushUser;

    private MailPush mailPush;

    public MailPush getMailPush() {
        return mailPush;
    }

    public void setMailPush(MailPush mailPush) {
        this.mailPush = mailPush;
    }

    public MailPushUser getMailPushUser() {
        return mailPushUser;
    }

    public void setMailPushUser(MailPushUser mailPushUser) {
        this.mailPushUser = mailPushUser;
    }
}
