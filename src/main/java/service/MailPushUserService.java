package service;


import model.MailPushUser;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public interface MailPushUserService{

    //����������Ϣ
    int buildMailPushUser(MailPushUser mailPushUser);

    List<MailPushUser> selectNotArriveMailPushUserByUserId(int userId);


}

