package service;

import model.Mail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public interface MailService{

     int  publishMail(Integer userId,String aimLinkman,String aimPhone,String aimAddress,
                      Integer goodsTypeId,String goodsSize, String goodsWeight,
                      Integer goodsNum,Date aimTime, Date pickUpTime,String pickUpLinkman,
                      String pickUpPhone,Long reward,String pickUpAddress);

    List<Mail> searchNotTakedMailByTime(int curPage, int pageSize);

    List<Mail> searchMailByCondition(int curPage, int pageSize, String searchCondition);

    List<Mail>  searchMyPushMailNotPickUpByUserId(int userId,int curPage,int pageSize);

    List<Mail> searchMyPushMailPickdeByUserId(int userId,int curPage,int pageSize);

    List<Mail> searchAllMyPushMailUserId(int userId,int curPage,int pageSize);

    int searchhMyPushMailNotPickUpPageNumByUserId(int userId,int pageSize);

    int searchhMyPushMailNotPickUpPageNum(int pageSize);

    int updateSelectiveById(Mail mail);

    Mail searchMailById(Integer mailId);

    int recivedeMailById(Integer mailId);

    int completeMailById(Integer mailId);
}
