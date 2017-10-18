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
        saveRequest(rArr, info.getInfoId());

        rArr = JSONArray.parseArray(info.getResponse());
        saveResponse(rArr, info.getInfoId());

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

    @Override
    public String get(SessionVO sessionVO, InterfaceInfo info)
    {
        InterfaceInfo result = infoMapper.selectByPrimaryKey(info.getInfoId());
        if (result == null)
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED, sessionVO.getToken()));

        InterfaceRequestExample requestExample = new InterfaceRequestExample();
        requestExample.setOrderByClause("sort");
        InterfaceRequestExample.Criteria requestCriteria = requestExample.createCriteria();
        requestCriteria.andInfoIdEqualTo(result.getInfoId());

        InterfaceResponseExample responseExample = new InterfaceResponseExample();
        responseExample.setOrderByClause("sort");
        InterfaceResponseExample.Criteria responseCriteria = responseExample.createCriteria();
        responseCriteria.andInfoIdEqualTo(result.getInfoId());

        result.setRequestList(requestMapper.selectByExample(requestExample));
        result.setResponseList(responseMapper.selectByExample(responseExample));

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
    }

    @Override
    public String update(SessionVO sessionVO, InterfaceInfo info)
    {
        if (infoMapper.updateByPrimaryKeySelective(info) < 1)
            throw new RuntimeException(Constant.SAVE_FAILED);

        InterfaceRequestExample requestExample = new InterfaceRequestExample();
        InterfaceRequestExample.Criteria requestCriteria = requestExample.createCriteria();
        requestCriteria.andInfoIdEqualTo(info.getInfoId());
        requestMapper.deleteByExample(requestExample);

        InterfaceResponseExample responseExample = new InterfaceResponseExample();
        InterfaceResponseExample.Criteria responseCriteria = responseExample.createCriteria();
        responseCriteria.andInfoIdEqualTo(info.getInfoId());
        responseMapper.deleteByExample(responseExample);

        JSONArray rArr = JSONArray.parseArray(info.getRequest());
        saveRequest(rArr, info.getInfoId());

        rArr = JSONArray.parseArray(info.getResponse());
        saveResponse(rArr, info.getInfoId());

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
    public String remove(SessionVO sessionVO, InterfaceInfo info)
    {
        info = infoMapper.selectByPrimaryKey(info.getInfoId());
        if (info == null)
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED, sessionVO.getToken()));

        InterfaceRequestExample requestExample = new InterfaceRequestExample();
        InterfaceRequestExample.Criteria requestCriteria = requestExample.createCriteria();
        requestCriteria.andInfoIdEqualTo(info.getInfoId());
        requestMapper.deleteByExample(requestExample);

        InterfaceResponseExample responseExample = new InterfaceResponseExample();
        InterfaceResponseExample.Criteria responseCriteria = responseExample.createCriteria();
        responseCriteria.andInfoIdEqualTo(info.getInfoId());
        responseMapper.deleteByExample(responseExample);

        InterfaceUpdate update = new InterfaceUpdate();
        update.setInfoId(info.getInfoId());
        update.setInfoName(info.getInfoName());
        update.setUpdateDate(new Date());
        update.setUpdateText("删除接口");
        update.setUpdateId(IDGeneratorUtil.generator());

        if (infoMapper.deleteByPrimaryKey(info.getInfoId()) < 1)
            throw new RuntimeException(Constant.SAVE_FAILED);

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken()));
    }

    @Override
    public String logList(SessionVO sessionVO)
    {
        InterfaceUpdateExample example = new InterfaceUpdateExample();
        example.setOrderByClause("update_date desc");
        List<InterfaceUpdate> result = updateMapper.selectByExample(example);

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
    }

    private void saveResponse(JSONArray rArr, String infoId)
    {
        for (Object json : rArr)
        {
            InterfaceResponse response = JSONObject.parseObject(json.toString(), InterfaceResponse.class);
            response.setResponseId(IDGeneratorUtil.generator());
            response.setInfoId(infoId);
            if (responseMapper.insert(response) < 1)
                throw new RuntimeException(Constant.SAVE_FAILED);
        }
    }

    private void saveRequest(JSONArray rArr, String infoId)
    {
        for (Object json : rArr)
        {
            InterfaceRequest request = JSONObject.parseObject(json.toString(), InterfaceRequest.class);
            request.setRequestId(IDGeneratorUtil.generator());
            request.setInfoId(infoId);
            if (requestMapper.insert(request) < 1)
                throw new RuntimeException(Constant.SAVE_FAILED);
        }
    }
}
