package com.qm.backend.service;

import com.qm.backend.pojo.SysCustomer;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface SysCustomerService
{
    String save(SessionVO sessionVO, SysCustomer customer);

    String remove(SessionVO sessionVO, SysCustomer customer);

    String update(SessionVO sessionVO, SysCustomer customer);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, SysCustomer customer);
}
