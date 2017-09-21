package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.constant.StringConstant;
import com.qm.backend.mapper.SysPermissionMapper;
import com.qm.backend.pojo.SysPermission;
import com.qm.backend.pojo.SysPermissionExample;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.util.ParameterUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService
{
    private final SysPermissionMapper mapper;

    @Autowired
    public SysPermissionServiceImpl(SysPermissionMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String save(SessionVO sessionVO, SysPermission permission)
    {
        permission.setPermissionId(IDGeneratorUtil.generator());
        permission.setPermissionText(permission.getPermissionText() == null ? StringConstant.EMPTY : permission.getPermissionText());

        if (ParameterUtil.objectIsNull(permission))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        int result = mapper.insert(permission);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), permission.getPermissionId()));
    }

    @Override
    public String remove(SessionVO sessionVO, SysPermission permission)
    {
        int result = mapper.deleteByPrimaryKey(permission.getPermissionId());

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), permission.getPermissionId()));
    }

    @Override
    public String update(SessionVO sessionVO, SysPermission permission)
    {
        int result = mapper.updateByPrimaryKeySelective(permission);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), permission.getPermissionId()));
    }

    @Override
    public String list(SessionVO sessionVO, PageVO pageVO)
    {
        if (ParameterUtil.objectIsNull(pageVO))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        SysPermissionExample example = new SysPermissionExample();

        example.setOrderByClause("permission_url");
        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());

        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());
        List<SysPermission> result = mapper.selectByExample(example);

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, SysPermission permission)
    {
        SysPermission result = mapper.selectByPrimaryKey(permission.getPermissionId());

        int flag = result == null ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(flag, sessionVO.getToken(), result));
    }
}
