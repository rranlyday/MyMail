package service.impl;

import dao.MailPushUserMapper;
import model.MailPushUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MailPushUserService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
@Service("mailPushUserService")
public class MailPushUserServiceImpl implements MailPushUserService {

    @Autowired
    MailPushUserMapper mailPushUserMapper;

    //生成推送消息
    public int buildMailPushUser(MailPushUser mailPushUser) {
        int row =  mailPushUserMapper.insertSelective(mailPushUser);
        return mailPushUser.getId();
    }

    public List<MailPushUser> selectNotArriveMailPushUserByUserId(int userId) {
        return mailPushUserMapper.selectNotArriveMailPushUserByUserId(userId);
    }
}
