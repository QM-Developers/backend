package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.mapper.SysBreedTypeInfoMapper;
import com.qm.backend.pojo.SysBreedTypeInfo;
import com.qm.backend.pojo.SysBreedTypeInfoExample;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.util.ParameterUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysBreedTypeInfoServiceImpl implements SysBreedTypeInfoService
{
    private final SysBreedTypeInfoMapper mapper;

    public SysBreedTypeInfoServiceImpl(SysBreedTypeInfoMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String save(SessionVO sessionVO, SysBreedTypeInfo info)
    {
        info.setInfoId(IDGeneratorUtil.generator());

        if (ParameterUtil.objectIsNull(info))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        int result = mapper.insert(info);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), info.getInfoId()));
    }

    @Override
    public String remove(SessionVO sessionVO, SysBreedTypeInfo info)
    {
        int result = mapper.deleteByPrimaryKey(info.getInfoId());
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), info.getInfoId()));
    }

    @Override
    public String update(SessionVO sessionVO, SysBreedTypeInfo info)
    {
        int result = mapper.updateByPrimaryKeySelective(info);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), info.getInfoId()));
    }

    @Override
    public String list(SessionVO sessionVO, PageVO pageVO)
    {
        SysBreedTypeInfoExample example = new SysBreedTypeInfoExample();
        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());

        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());
        List<SysBreedTypeInfo> result = mapper.selectByExample(example);

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, SysBreedTypeInfo info)
    {
        SysBreedTypeInfo result = mapper.selectByPrimaryKey(info.getInfoId());
        int flag = result == null ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(flag, sessionVO.getToken(), result));
    }
}
