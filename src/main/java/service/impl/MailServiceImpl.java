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

import java.math.BigDecimal;
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
                           Date pickUpTime,String pickUpLinkman,String pickUpPhone,Long reward,String pickUpAddress){

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
        mail.setReward(reward);
        mail.setOrderRecive(0);
        mail.setPickUpAddress(pickUpAddress);

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
        int beginPos = curPage * pageSize;
        return mailMapper.selectNotTakedMailByTime(beginPos,pageSize);
    }

    public List<Mail> searchMailByCondition(int curPage, int pageSize, String searchCondition) {
        if (searchCondition == null)
          return searchNotTakedMailByTime(curPage,pageSize);
        else {
            int biginPos =  curPage * pageSize;
            searchCondition = "%"+searchCondition+"%";
            return mailMapper.searchMailByCondition(biginPos,pageSize,searchCondition);
        }
    }

    private  String bulidMailPushMessage(Mail  mail){
        return "你有新的邮单，请注意查收哦！";
    }

    public List<Mail> searchMyPushMailNotPickUpByUserId(int userId,int curPage,int pageSize) {
        int beginPos = curPage  * pageSize;
        return mailMapper.searchMyPushMailNotPickUpByUserId(userId, beginPos, pageSize);
    }

    public List<Mail> searchMyPushMailPickdeByUserId(int userId, int curPage, int pageSize) {
        int beginPos = curPage  * pageSize;
        return mailMapper.searchMyPushMailPickdeByUserId(userId,beginPos,pageSize);
    }

    public List<Mail> searchAllMyPushMailUserId(int userId, int curPage, int pageSize) {
        int beginPos = curPage  * pageSize;
        return mailMapper.searchAllMyPushMailUserId(userId,beginPos,pageSize);
    }

    public int searchhMyPushMailNotPickUpPageNumByUserId(int userId, int pageSize) {
        int count = mailMapper.searchhMyPushMailNotPickUpCountByUserId(userId);
        int pageNum = MathUtil.numToPageTotal(count,pageSize);
        return pageNum;
    }

    public int searchhMyPushMailNotPickUpPageNum(int pageSize) {
        int count = mailMapper.searchhMyPushMailNotPickUpPageNum();
        int pageNum = MathUtil.numToPageTotal(count,pageSize);
        return pageNum;
    }

    public int updateSelectiveById(Mail mail) {
        return mailMapper.updateByPrimaryKeySelective(mail);
    }

    public Mail searchMailById(Integer mailId) {
        return mailMapper.selectByPrimaryKey(mailId);
    }

    public int recivedeMailById(Integer mailId) {
        Mail mail = new Mail();
        mail.setId(mailId);
        mail.setOrderRecive(1);
        return mailMapper.updateByPrimaryKeySelective(mail);
        }

    public int completeMailById(Integer mailId) {
        Mail mail = new Mail();
        mail.setId(mailId);
        mail.setService(1);
        return mailMapper.updateByPrimaryKeySelective(mail);
    }
}
