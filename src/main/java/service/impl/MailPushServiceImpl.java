package service.impl;

import dao.MailPushMapper;
import model.MailPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MailPushService;


/**
 * Created by Administrator on 2016/5/24 0024.
 */

@Service("mailPushService")
public class MailPushServiceImpl implements MailPushService{

    @Autowired
    MailPushMapper mailPushMapper;
    public  int  buildMailPush(Integer mailId,String content){

        MailPush mailPush = new MailPush();
        mailPush.setMailId(mailId);
        mailPush.setContent(content);

       int row =   mailPushMapper.insertSelective(mailPush);
        return  mailPush.getId();
    }

    public MailPush selectMailPushById(int mailPushId) {
        return mailPushMapper.selectByPrimaryKey(mailPushId);
    }
}
