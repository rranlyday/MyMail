package dao;

import java.util.List;
import model.GoodStype;
import model.GoodStypeExample;
import org.apache.ibatis.annotations.Param;

public interface GoodStypeMapper {
    int countByExample(GoodStypeExample example);

    int deleteByExample(GoodStypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodStype record);

    int insertSelective(GoodStype record);

    List<GoodStype> selectByExample(GoodStypeExample example);

    GoodStype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodStype record, @Param("example") GoodStypeExample example);

    int updateByExample(@Param("record") GoodStype record, @Param("example") GoodStypeExample example);

    int updateByPrimaryKeySelective(GoodStype record);

    int updateByPrimaryKey(GoodStype record);
}