package com.qm.backend.mapper;

import com.qm.backend.pojo.SysCustomer;
import com.qm.backend.pojo.SysCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysCustomerMapper {
    long countByExample(SysCustomerExample example);

    int deleteByExample(SysCustomerExample example);

    int deleteByPrimaryKey(String customerId);

    int insert(SysCustomer record);

    int insertSelective(SysCustomer record);

    List<SysCustomer> selectByExample(SysCustomerExample example);

    SysCustomer selectByPrimaryKey(String customerId);

    int updateByExampleSelective(@Param("record") SysCustomer record, @Param("example") SysCustomerExample example);

    int updateByExample(@Param("record") SysCustomer record, @Param("example") SysCustomerExample example);

    int updateByPrimaryKeySelective(SysCustomer record);

    int updateByPrimaryKey(SysCustomer record);
}