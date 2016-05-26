package service;

import model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/5/16 0016.
 */
public interface UserService {

    User login(String loginName,String password);

    int  register(String cellPhone, String password, String idcard,String fullName);

    List<User> getPushUserIdList(); //获取所有用户

    List<User> getPushUserIdList(String pushCondition); //根据条件获取所有用户

    List<User> getPushUserIdList(int beginPosition,int perPageSize);  //分页获取所有用户

    List<User> getPushUserIdList(int beginPosition,int perPageSize,String pushCondition); //根据条件分页获取所有用户


}
