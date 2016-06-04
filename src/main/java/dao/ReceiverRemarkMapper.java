package dao;

import java.util.List;

import model.OrderRecive;
import model.ReceiverRemark;
import model.ReceiverRemarkExample;
import org.apache.ibatis.annotations.Param;

public interface ReceiverRemarkMapper {
    int countByExample(ReceiverRemarkExample example);

    int deleteByExample(ReceiverRemarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReceiverRemark record);

    int insertSelective(ReceiverRemark record);

    List<ReceiverRemark> selectByExample(ReceiverRemarkExample example);

    ReceiverRemark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReceiverRemark record, @Param("example") ReceiverRemarkExample example);

    int updateByExample(@Param("record") ReceiverRemark record, @Param("example") ReceiverRemarkExample example);

    int updateByPrimaryKeySelective(ReceiverRemark record);

    int updateByPrimaryKey(ReceiverRemark record);

    List<ReceiverRemark> searchReceiverRemarkOrderByTime(@Param("beginPos")int beginPos, @Param("pageSie")int pageSie);

    ReceiverRemark getReceiverRemarkByMailId(Integer mailId);

}