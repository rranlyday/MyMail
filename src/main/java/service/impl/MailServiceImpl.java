package service.impl;

import com.alibaba.druid.sql.PagerUtils;
import dao.MailMapper;
import job.MailPushJob;
import job.MailPushTask;
import model.Mail;
import model.MailPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MailPushService;
import service.MailService;
import util.MathUtil;
import util.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
@Service("mailService")
public class MailServiceImpl implements MailService{

    @Autowired
    MailMapper mailMapper ;

    @Autowired
    MailPushService mailPushService;

    @Autowired
    MailPushJob mailPushJob;

    public int publishMail(Integer userId,String aimLinkman, String aimPhone, String aimAddress,Integer goodsTypeId,
                           String goodsSize, String goodsWeight, Integer goodsNum,Date aimTime,
                           Date pickUpTime,String pickUpLinkman,
                           String pickUpPhone){

        Mail  mail = new Mail();

        mail.setAimLinkman(aimLinkman);
        mail.setAimPhone(aimPhone);
        mail.setAimAddress(aimAddress);
        mail.setGoodsTypeId(goodsTypeId);
        mail.setGoodsSize(goodsSize);
        mail.setGoodsWeight(goodsWeight);
        mail.setGoodsNum(goodsNum);
        mail.setAimTime(aimTime);
        mail.setPickUpLinkman(pickUpLinkman);
        mail.setPickUpPhone(pickUpPhone);
        mail.setPickUpTime(pickUpTime);
        mail.setUserId(userId);

        Date publishTime = TimeUtil.getNowSysTime();
        mail.setPublishTime(publishTime);

        int row =  mailMapper.insertSelective(mail);
        int mailId = mail.getId();

        if (mailId > 0 ){  //生成邮单成功,生成推消息

           int mailPushId =  mailPushService.buildMailPush(mailId,bulidMailPushMessage(mail));

            if (mailPushId > 0){  //推送消息建立成功
                mailPushJob.addTask(mailPushId);  //加入邮单推送job
            }
        }
        return  mailId;
    }

    public List<Mail> searchNotTakedMailByTime(int curPage, int pageSize) {
        return mailMapper.selectNotTakedMailByTime(curPage,pageSize);
    }

    public List<Mail> searchMailByCondition(int curPage, int pageSize, String searchCondition) {
        return null;
    }

    private  String bulidMailPushMessage(Mail  mail){
        return  "你有新的邮单，请注意查收哦！";
    }
}
