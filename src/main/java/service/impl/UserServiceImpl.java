package service.impl;

import dao.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/16 0016.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    public User login(String loginName, String password) {
        User user = null;
        if (loginName !=null && password != null){
            user = new User();
            user.setCellphone(loginName);
            user.setPwd(password);

            try{
                user =  userMapper.login(user);
            }
            catch (Exception e){
                e.printStackTrace();
                new Exception(e);
            }
        }
        return user;
    }

   public int register(String cellPhone, String password, String idcard,String fullName){
        User user = new User();
        user.setCellphone(cellPhone);
        user.setPwd(password);
        user.setIdcard(idcard);
        user.setFullName(fullName);

       int row =  userMapper.insertSelective(user);
       return  user.getId();
    }

    //获取所有用户
    public List<User> getPushUserIdList() {
        return userMapper.selectUserList();
    }

    //根据条件获取所有用户
    public List<User> getPushUserIdList(String pushCondition) {
        if (pushCondition == null){
            return getPushUserIdList();
        }
        else {   //处理条件

        }
        return null;
    }

    //分页获取所有用户
    public List<User> getPushUserIdList(int beginPosition, int perPageSize) {
        return userMapper.selectUserListPaging(beginPosition,perPageSize);
    }

    //根据条件分页获取所有用户
    public List<User> getPushUserIdList(int beginPosition, int perPageSize, String pushCondition) {
        if (pushCondition == null){
            return getPushUserIdList(beginPosition,perPageSize);
        }
        else{    //处理条件

        }
        return null;
    }

}
