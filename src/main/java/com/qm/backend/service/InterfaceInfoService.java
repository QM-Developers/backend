package com.qm.backend.service;

import com.qm.backend.pojo.InterfaceInfo;
import com.qm.backend.vo.SessionVO;

public interface InterfaceInfoService
{
    String save(SessionVO sessionVO, InterfaceInfo info);

    String tree(SessionVO sessionVO);

    String get(SessionVO sessionVO, InterfaceInfo info);

    String update(SessionVO sessionVO, InterfaceInfo info);

    String remove(SessionVO sessionVO, InterfaceInfo info);

    String logList(SessionVO sessionVO);
}
