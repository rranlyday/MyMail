package service;

import model.MailPush;
import model.MailPushUser;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public interface MailPushService {

    int  buildMailPush(Integer mailId,String content);

    MailPush selectMailPushById(int mailPushId);


}
