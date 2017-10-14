package com.qm.backend.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.Constant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.constant.StringConstant;
import com.qm.backend.mapper.*;
import com.qm.backend.pojo.*;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.StringUtil;
import com.qm.backend.util.TreeUtil;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import com.qm.backend.vo.TreeVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InterfaceInfoServiceImpl implements InterfaceInfoService
{
    private final InterfaceInfoMapper infoMapper;
    private final InterfaceRequestMapper requestMapper;
    private final InterfaceResponseMapper responseMapper;
    private final InterfaceUpdateMapper updateMapper;
    private final InterfaceTypeMapper typeMapper;

    public InterfaceInfoServiceImpl(InterfaceInfoMapper infoMapper, InterfaceRequestMapper requestMapper, InterfaceResponseMapper responseMapper, InterfaceUpdateMapper updateMapper, InterfaceTypeMapper typeMapper)
    {
        this.infoMapper = infoMapper;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
        this.updateMapper = updateMapper;
        this.typeMapper = typeMapper;
    }

    @Override
    public String save(SessionVO sessionVO, InterfaceInfo info)
    {
        info.setInfoId(StringUtil.isEmpty(info.getInfoId()) ? IDGeneratorUtil.generator() : info.getInfoId());

        if (infoMapper.insert(info) < 1)
            throw new RuntimeException(Constant.SAVE_FAILED);

        JSONArray rArr = JSONArray.parseArray(info.getRequest());
        for (Object json : rArr)
        {
            InterfaceRequest request = JSONObject.parseObject(json.toString(), InterfaceRequest.class);
            request.setRequestId(IDGeneratorUtil.generator());
            request.setInfoId(info.getInfoId());
            if (requestMapper.insert(request) < 1)
                throw new RuntimeException(Constant.SAVE_FAILED);
        }

        rArr = JSONArray.parseArray(info.getResponse());
        for (Object json : rArr)
        {
            InterfaceResponse response = JSONObject.parseObject(json.toString(), InterfaceResponse.class);
            response.setResponseId(IDGeneratorUtil.generator());
            response.setInfoId(info.getInfoId());
            if (responseMapper.insert(response) < 1)
                throw new RuntimeException(Constant.SAVE_FAILED);
        }

        InterfaceUpdate update = new InterfaceUpdate();
        update.setInfoId(info.getInfoId());
        update.setInfoName(info.getInfoName());
        update.setUpdateDate(new Date());
        update.setUpdateText(info.getUpdate());
        update.setUpdateId(IDGeneratorUtil.generator());

        if (updateMapper.insert(update) < 1)
            throw new RuntimeException(Constant.SAVE_FAILED);

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), info.getInfoId()));
    }

    @Override
    public String tree(SessionVO sessionVO)
    {
        InterfaceTypeExample example = new InterfaceTypeExample();
        List<InterfaceType> types = typeMapper.selectByExample(example);
        List<TreeVO> result = new ArrayList<>();
        List<InterfaceInfo> infoList;
        TreeVO leaf;

        for (InterfaceType type : types)
        {
            InterfaceInfoExample infoExample = new InterfaceInfoExample();
            InterfaceInfoExample.Criteria infoCriteria = infoExample.createCriteria();
            infoCriteria.andTypeIdEqualTo(type.getTypeId());

            infoList = infoMapper.selectByExample(infoExample);
            for (InterfaceInfo info : infoList)
            {
                leaf = new TreeVO();
                leaf.setId(info.getInfoId());
                leaf.setName(info.getInfoName());
                leaf.setpId(type.getTypeId());
                result.add(leaf);
            }

            leaf = new TreeVO();
            leaf.setId(type.getTypeId());
            leaf.setpId(type.getTypePid());
            leaf.setName(type.getTypeName());
            result.add(leaf);
        }

        result = TreeUtil.addChild(result, StringConstant.ZERO);

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
    }
}
