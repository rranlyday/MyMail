package dao;

import java.util.List;
import model.OrderRecive;
import model.OrderReciveExample;
import org.apache.ibatis.annotations.Param;

public interface OrderReciveMapper {
    int countByExample(OrderReciveExample example);

    int deleteByExample(OrderReciveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderRecive record);

    int insertSelective(OrderRecive record);

    List<OrderRecive> selectByExample(OrderReciveExample example);

    OrderRecive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderRecive record, @Param("example") OrderReciveExample example);

    int updateByExample(@Param("record") OrderRecive record, @Param("example") OrderReciveExample example);

    int updateByPrimaryKeySelective(OrderRecive record);

    int updateByPrimaryKey(OrderRecive record);

    OrderRecive getOrderReciveByMailmanIdAndMailId(@Param("mailId")Integer mailId,@Param("mailmanId") Integer mailmanId);

    List<OrderRecive> getOrderReciveByMailmanId(@Param("mailmanId")Integer mailmanId, @Param("beginPos")int beginPos,
                                                @Param("pageSize")int pageSize);

    int getOrderReciveByMailmanIdPageNum(Integer mailmanId);
}