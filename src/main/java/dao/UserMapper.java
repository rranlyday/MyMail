package dao;

import java.util.List;
import model.User;
import model.UserExample;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(User u);

    List<User> selectUserList();  //获取所有用户,数据少的时候用

    List<User> selectUserListPaging(@Param("beginePosition") int beginePosition,@Param("perPageSize") int perPageSize);  //获取所有用户，数据大的时候用
}