package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.mapper.SysBreedTypeMapper;
import com.qm.backend.pojo.SysBreedType;
import com.qm.backend.pojo.SysBreedTypeExample;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.util.ParameterUtil;
import com.qm.backend.util.StringUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysBreedTypeServiceImpl implements SysBreedTypeService
{
    private final SysBreedTypeMapper mapper;

    public SysBreedTypeServiceImpl(SysBreedTypeMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String save(SessionVO sessionVO, SysBreedType breedType)
    {
        breedType.setTypeId(IDGeneratorUtil.generator());
        breedType.setSelectId(breedType.getSelectId() == null ? "0" : breedType.getSelectId());

        if (ParameterUtil.objectIsNull(breedType))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        int result = mapper.insert(breedType);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), breedType.getTypeId()));
    }

    @Override
    public String remove(SessionVO sessionVO, SysBreedType breedType)
    {
        int result = mapper.deleteByPrimaryKey(breedType.getTypeId());

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), breedType.getTypeId()));
    }

    @Override
    public String update(SessionVO sessionVO, SysBreedType breedType)
    {
        int result = mapper.updateByPrimaryKeySelective(breedType);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), breedType.getTypeId()));
    }

    @Override
    public String list(SessionVO sessionVO, SysBreedType type, PageVO pageVO)
    {
        if (ParameterUtil.objectIsNull(pageVO))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        SysBreedTypeExample example = new SysBreedTypeExample();
        SysBreedTypeExample.Criteria criteria = example.createCriteria();

        criteria.andSelectIdEqualTo(type.getSelectId());
        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());

        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());
        List<SysBreedType> result = mapper.selectByExample(example);

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, SysBreedType breedType)
    {
        SysBreedType result = mapper.selectByPrimaryKey(breedType.getTypeId());

        int flag = result == null ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(flag, sessionVO.getToken(), result));
    }
}
