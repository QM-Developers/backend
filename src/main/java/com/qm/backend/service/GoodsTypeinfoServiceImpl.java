package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.mapper.GoodsTypeinfoMapper;
import com.qm.backend.pojo.GoodsTypeinfo;
import com.qm.backend.pojo.GoodsTypeinfoExample;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.util.TreeUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import com.qm.backend.vo.TreeVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsTypeinfoServiceImpl implements GoodsTypeinfoService
{
    private final GoodsTypeinfoMapper mapper;

    public GoodsTypeinfoServiceImpl(GoodsTypeinfoMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String save(SessionVO sessionVO, GoodsTypeinfo info)
    {
        info.setGoodsTypeId(IDGeneratorUtil.generator());
        info.setIsDeleted((byte) 0);

        int result = mapper.insert(info);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), info.getGoodsTypeId()));
    }

    @Override
    public String remove(SessionVO sessionVO, GoodsTypeinfo info)
    {
        if (mapper.countGoods(info.getGoodsTypeId()) > 0)
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102,sessionVO.getToken()));

        int result = mapper.deleteByPrimaryKey(info.getGoodsTypeId());

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String update(SessionVO sessionVO, GoodsTypeinfo info)
    {
        int result = mapper.updateByPrimaryKeySelective(info);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String list(SessionVO sessionVO, PageVO pageVO)
    {
        GoodsTypeinfoExample example = new GoodsTypeinfoExample();

        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());
        List<GoodsTypeinfo> result = mapper.selectByExample(example);
        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, GoodsTypeinfo info)
    {
        GoodsTypeinfo result = mapper.selectByPrimaryKey(info.getGoodsTypeId());

        int flag = result == null ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(flag, sessionVO.getToken(), result));
    }

    @Override
    public String tree(SessionVO sessionVO)
    {
        GoodsTypeinfoExample example = new GoodsTypeinfoExample();

        List<GoodsTypeinfo> types = mapper.selectByExample(example);
        List<TreeVO> result = new ArrayList<>();

        for (GoodsTypeinfo info : types)
        {
            TreeVO leaf = new TreeVO();
            leaf.setId(info.getGoodsTypeId());
            leaf.setName(info.getGoodsTypeName());
            leaf.setpId(info.getGoodsTypePid());
            result.add(leaf);
        }

        result = TreeUtil.addChild(result,"0");

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
    }
}
