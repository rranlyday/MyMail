package dao;

import java.util.List;
import model.MailPushUser;
import model.MailPushUserExample;
import org.apache.ibatis.annotations.Param;

public interface MailPushUserMapper {
    int countByExample(MailPushUserExample example);

    int deleteByExample(MailPushUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MailPushUser record);

    int insertSelective(MailPushUser record);

    List<MailPushUser> selectByExample(MailPushUserExample example);

    MailPushUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MailPushUser record, @Param("example") MailPushUserExample example);

    int updateByExample(@Param("record") MailPushUser record, @Param("example") MailPushUserExample example);

    int updateByPrimaryKeySelective(MailPushUser record);

    int updateByPrimaryKey(MailPushUser record);

    List<MailPushUser> selectNotArriveMailPushUserByUserId(int userId);
}