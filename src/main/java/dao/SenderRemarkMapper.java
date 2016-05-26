package dao;

import java.util.List;
import model.SenderRemark;
import model.SenderRemarkExample;
import org.apache.ibatis.annotations.Param;

public interface SenderRemarkMapper {
    int countByExample(SenderRemarkExample example);

    int deleteByExample(SenderRemarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SenderRemark record);

    int insertSelective(SenderRemark record);

    List<SenderRemark> selectByExample(SenderRemarkExample example);

    SenderRemark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SenderRemark record, @Param("example") SenderRemarkExample example);

    int updateByExample(@Param("record") SenderRemark record, @Param("example") SenderRemarkExample example);

    int updateByPrimaryKeySelective(SenderRemark record);

    int updateByPrimaryKey(SenderRemark record);

    List<SenderRemark> searchSenderRemarkOrderByTime(@Param("beginPos")int beginPos, @Param("pageSie")int pageSie);
}