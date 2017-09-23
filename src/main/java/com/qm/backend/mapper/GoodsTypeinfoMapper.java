package com.qm.backend.mapper;

import com.qm.backend.pojo.GoodsTypeinfo;
import com.qm.backend.pojo.GoodsTypeinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsTypeinfoMapper {
    long countByExample(GoodsTypeinfoExample example);

    int deleteByExample(GoodsTypeinfoExample example);

    int deleteByPrimaryKey(String goodsTypeId);

    int insert(GoodsTypeinfo record);

    int insertSelective(GoodsTypeinfo record);

    List<GoodsTypeinfo> selectByExample(GoodsTypeinfoExample example);

    GoodsTypeinfo selectByPrimaryKey(String goodsTypeId);

    int updateByExampleSelective(@Param("record") GoodsTypeinfo record, @Param("example") GoodsTypeinfoExample example);

    int updateByExample(@Param("record") GoodsTypeinfo record, @Param("example") GoodsTypeinfoExample example);

    int updateByPrimaryKeySelective(GoodsTypeinfo record);

    int updateByPrimaryKey(GoodsTypeinfo record);

    int countGoods(@Param("typeId") String goodsTypeId);
}