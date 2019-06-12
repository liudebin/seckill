package qian.ling.yi.seckill.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qian.ling.yi.seckill.model.TrdOrder;
import qian.ling.yi.seckill.model.TrdOrderExample;

public interface TrdOrderMapper {
    int countByExample(TrdOrderExample example);

    int deleteByExample(TrdOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrdOrder record);

    int insertSelective(TrdOrder record);

    List<TrdOrder> selectByExample(TrdOrderExample example);

    TrdOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrdOrder record, @Param("example") TrdOrderExample example);

    int updateByExample(@Param("record") TrdOrder record, @Param("example") TrdOrderExample example);

    int updateByPrimaryKeySelective(TrdOrder record);

    int updateByPrimaryKey(TrdOrder record);
}