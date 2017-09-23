package com.qm.backend.service;

import com.qm.backend.pojo.GoodsTypeinfo;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface GoodsTypeinfoService
{
    String save(SessionVO sessionVO, GoodsTypeinfo info);

    String remove(SessionVO sessionVO, GoodsTypeinfo info);

    String update(SessionVO sessionVO, GoodsTypeinfo info);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, GoodsTypeinfo info);

    String tree(SessionVO sessionVO);
}
