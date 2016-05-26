package dao;

import java.util.List;
import model.MailPush;
import model.MailPushExample;
import org.apache.ibatis.annotations.Param;

public interface MailPushMapper {
    int countByExample(MailPushExample example);

    int deleteByExample(MailPushExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MailPush record);

    int insertSelective(MailPush record);

    List<MailPush> selectByExample(MailPushExample example);

    MailPush selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MailPush record, @Param("example") MailPushExample example);

    int updateByExample(@Param("record") MailPush record, @Param("example") MailPushExample example);

    int updateByPrimaryKeySelective(MailPush record);

    int updateByPrimaryKey(MailPush record);
}