package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.Constant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.constant.StringConstant;
import com.qm.backend.mapper.InterfaceTypeMapper;
import com.qm.backend.pojo.InterfaceType;
import com.qm.backend.pojo.InterfaceTypeExample;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.ParameterUtil;
import com.qm.backend.util.StringUtil;
import com.qm.backend.util.TreeUtil;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import com.qm.backend.vo.TreeVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterfaceTypeServiceImpl implements InterfaceTypeService
{
    private final InterfaceTypeMapper mapper;

    public InterfaceTypeServiceImpl(InterfaceTypeMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String save(SessionVO sessionVO, InterfaceType type)
    {
        type.setTypeId(IDGeneratorUtil.generator());
        type.setTypePid(StringUtil.isEmpty(type.getTypePid()) ? StringConstant.ZERO : type.getTypePid());

        if (ParameterUtil.objectIsNull(type))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        int result = mapper.insert(type) < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String remove(SessionVO sessionVO, InterfaceType type)
    {
        int result = mapper.deleteByPrimaryKey(type.getTypeId()) < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String update(SessionVO sessionVO, InterfaceType type)
    {
        int result = mapper.updateByPrimaryKeySelective(type) < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String tree(SessionVO sessionVO)
    {
        InterfaceTypeExample example = new InterfaceTypeExample();
        List<InterfaceType> types = mapper.selectByExample(example);
        List<TreeVO> result = new ArrayList<>();

        for (InterfaceType type : types)
        {
            TreeVO leaf = new TreeVO();
            leaf.setId(type.getTypeId());
            leaf.setName(type.getTypeName());
            leaf.setpId(type.getTypePid());
            result.add(leaf);
        }

        result = TreeUtil.addChild(result, StringConstant.ZERO);

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
    }
}
