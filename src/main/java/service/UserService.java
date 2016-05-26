package service;

import model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/5/16 0016.
 */
public interface UserService {

    User login(String loginName,String password);

    int  register(String cellPhone, String password, String idcard,String fullName);

    List<User> getPushUserIdList(); //��ȡ�����û�

    List<User> getPushUserIdList(String pushCondition); //����������ȡ�����û�

    List<User> getPushUserIdList(int beginPosition,int perPageSize);  //��ҳ��ȡ�����û�

    List<User> getPushUserIdList(int beginPosition,int perPageSize,String pushCondition); //����������ҳ��ȡ�����û�


}
