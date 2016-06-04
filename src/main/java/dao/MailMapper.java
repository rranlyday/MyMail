package dao;

import java.util.List;
import model.Mail;
import model.MailExample;
import org.apache.ibatis.annotations.Param;

public interface MailMapper {
    int countByExample(MailExample example);

    int deleteByExample(MailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mail record);

    int insertSelective(Mail record);

    List<Mail> selectByExample(MailExample example);

    Mail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mail record, @Param("example") MailExample example);

    int updateByExample(@Param("record") Mail record, @Param("example") MailExample example);

    int updateByPrimaryKeySelective(Mail record);

    int updateByPrimaryKey(Mail record);

    List<Mail> selectNotTakedMailByTime(@Param("beginPos") Integer beginPos, @Param("pageSize") Integer pageSize);

    List<Mail> searchMyPushMailNotPickUpByUserId(@Param("userId")Integer userId,@Param("beginPos")Integer beginPos,
                                         @Param("pageSize")Integer pageSize);

    List<Mail> searchMyPushMailPickdeByUserId(@Param("userId")Integer userId,@Param("beginPos")Integer beginPos,
                                              @Param("pageSize")Integer pageSize);

    List<Mail> searchAllMyPushMailUserId(@Param("userId")Integer userId,@Param("beginPos")Integer beginPos,
                                         @Param("pageSize")Integer pageSize);

    int searchhMyPushMailNotPickUpCountByUserId(Integer userId);

    int searchhMyPushMailNotPickUpPageNum();

    List<Mail> searchMailByCondition(@Param("beginPos")Integer beginPos, @Param("pageSize")Integer pageSize,
                                     @Param("searchCondition")String searchCondition);

}