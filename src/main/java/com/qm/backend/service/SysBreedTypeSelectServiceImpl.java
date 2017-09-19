package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.mapper.SysBreedTypeSelectMapper;
import com.qm.backend.pojo.SysBreedTypeSelect;
import com.qm.backend.pojo.SysBreedTypeSelectExample;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.util.ParameterUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysBreedTypeSelectServiceImpl implements SysBreedTypeSelectService
{
    private final SysBreedTypeSelectMapper mapper;

    public SysBreedTypeSelectServiceImpl(SysBreedTypeSelectMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String save(SessionVO sessionVO, SysBreedTypeSelect select)
    {
        select.setSelectId(IDGeneratorUtil.generator());

        if (ParameterUtil.objectIsNull(select))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        int result = mapper.insert(select);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), select.getSelectId()));
    }

    @Override
    public String remove(SessionVO sessionVO, SysBreedTypeSelect select)
    {
        int result = mapper.deleteByPrimaryKey(select.getSelectId());
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String update(SessionVO sessionVO, SysBreedTypeSelect select)
    {
        int result = mapper.updateByPrimaryKeySelective(select);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String list(SessionVO sessionVO, SysBreedTypeSelect select, PageVO pageVO)
    {
        if (ParameterUtil.objectIsNull(pageVO))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        SysBreedTypeSelectExample example = new SysBreedTypeSelectExample();
        SysBreedTypeSelectExample.Criteria criteria = example.createCriteria();

        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());
        criteria.andTypeIdEqualTo(select.getTypeId());

        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());
        List<SysBreedTypeSelect> result = mapper.selectByExample(example);

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, SysBreedTypeSelect select)
    {
        SysBreedTypeSelect result = mapper.selectByPrimaryKey(select.getSelectId());

        int flag = result == null ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(flag, sessionVO.getToken(), result));
    }
}
