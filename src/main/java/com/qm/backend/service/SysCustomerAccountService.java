package com.qm.backend.service;

import com.qm.backend.pojo.SysCustomerAccount;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface SysCustomerAccountService
{
    String save(SessionVO sessionVO, SysCustomerAccount account);

    String listByApprove(SessionVO sessionVO, PageVO pageVO);

    String listByProposer(SessionVO sessionVO, PageVO pageVO);

    String updateAccept(SessionVO sessionVO, SysCustomerAccount account);

    String updateRefuse(SessionVO sessionVO, SysCustomerAccount account);
}
