package com.qm.backend.service;

import com.qm.backend.pojo.InterfaceInfo;
import com.qm.backend.vo.SessionVO;

public interface InterfaceInfoService
{
    String save(SessionVO sessionVO, InterfaceInfo info);

    String tree(SessionVO sessionVO);
}
