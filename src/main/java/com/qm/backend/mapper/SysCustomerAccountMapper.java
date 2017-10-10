package com.qm.backend.mapper;

import com.qm.backend.pojo.QmBranch;
import com.qm.backend.pojo.SysCustomerAccount;
import com.qm.backend.pojo.SysCustomerAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysCustomerAccountMapper {
    long countByExample(SysCustomerAccountExample example);

    int deleteByExample(SysCustomerAccountExample example);

    int deleteByPrimaryKey(String accountId);

    int insert(SysCustomerAccount record);

    int insertSelective(SysCustomerAccount record);

    List<SysCustomerAccount> selectByExample(SysCustomerAccountExample example);

    SysCustomerAccount selectByPrimaryKey(String accountId);

    int updateByExampleSelective(@Param("record") SysCustomerAccount record, @Param("example") SysCustomerAccountExample example);

    int updateByExample(@Param("record") SysCustomerAccount record, @Param("example") SysCustomerAccountExample example);

    int updateByPrimaryKeySelective(SysCustomerAccount record);

    int updateByPrimaryKey(SysCustomerAccount record);

    String getUserName(@Param("userId") String userId);

    int insertTeam(String customerId);

    int insertDepartment(String customerId);

    int insertUser(String customerId);

    int insertPosition(String customerId);

    int insertBranch(String customerId);
}