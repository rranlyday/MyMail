package job;

import model.MailPushUser;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.MailPushUserService;
import service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public class MailPushTask{

    @Autowired
    MailPushUserService mailPushUserService;

    List<User> userList;

    private int mailPushId;

    public void setMailPushId(int mailPushId) {
        this.mailPushId = mailPushId;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void run(){

        for (User user:userList){

            MailPushUser mailPushUser = new MailPushUser();
            mailPushUser.setMailPushId(mailPushId);  //��Ϣ����ID
            mailPushUser.setUserId(user.getId());  //�����û�ID
            mailPushUser.setArrive(0);             //����״̬Ϊδ����

            mailPushUserService.buildMailPushUser(mailPushUser);
        }
    }

}
