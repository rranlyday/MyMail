package service;

import model.Mail;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public interface MailService{

     int  publishMail(Integer userId,String aimLinkman,String aimPhone,String aimAddress,
                      Integer goodsTypeId,String goodsSize, String goodsWeight,
                      Integer goodsNum,Date aimTime, Date pickUpTime,String pickUpLinkman,
                      String pickUpPhone);

    List<Mail> searchNotTakedMailByTime(int curPage, int pageSize);

    List<Mail> searchMailByCondition(int curPage, int pageSize, String searchCondition);
}
