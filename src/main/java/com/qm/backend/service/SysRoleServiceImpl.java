package com.qm.backend.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.Constant;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.constant.StringConstant;
import com.qm.backend.mapper.SysRoleMapper;
import com.qm.backend.mapper.SysRolePermissionReMapper;
import com.qm.backend.pojo.SysRole;
import com.qm.backend.pojo.SysRoleExample;
import com.qm.backend.pojo.SysRolePermissionRe;
import com.qm.backend.pojo.SysRolePermissionReExample;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.util.ParameterUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService
{
    private final SysRoleMapper mapper;
    private final SysRolePermissionReMapper permissionReMapper;

    @Autowired
    public SysRoleServiceImpl(SysRoleMapper mapper, SysRolePermissionReMapper permissionReMapper)
    {
        this.mapper = mapper;
        this.permissionReMapper = permissionReMapper;
    }

    @Override
    public String save(SessionVO sessionVO, SysRole role)
    {
        role.setRoleId(IDGeneratorUtil.generator());
        role.setPermission(role.getPermission() == null ? StringConstant.EMPTY : role.getPermission());
        role.setMemberId(StringConstant.EMPTY);
        role.setPermissionList(new ArrayList<>());

        if (ParameterUtil.objectIsNull(role))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED, sessionVO.getToken()));

        int result = mapper.insert(role);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), role.getRoleId()));
    }

    @Override
    public String remove(SessionVO sessionVO, SysRole role)
    {
        int result = mapper.deleteByPrimaryKey(role.getRoleId());

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String update(SessionVO sessionVO, SysRole role)
    {
        int result = mapper.updateByPrimaryKeySelective(role);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String list(SessionVO sessionVO, PageVO pageVO)
    {
        if (ParameterUtil.objectIsNull(pageVO))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        SysRoleExample example = new SysRoleExample();
        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());

        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());
        List<SysRole> result = mapper.selectByExample(example);

        for (SysRole role : result)
            role.setPermissionList(mapper.listPermission(role.getRoleId()));

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, SysRole role)
    {
        SysRole result = mapper.selectByPrimaryKey(role.getRoleId());

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
    }

    @Override
    public String updatePermission(SessionVO sessionVO, SysRole role)
    {
        SysRolePermissionReExample example = new SysRolePermissionReExample();
        SysRolePermissionReExample.Criteria criteria = example.createCriteria();

        criteria.andRoleIdEqualTo(role.getRoleId());

        permissionReMapper.deleteByExample(example);

        JSONArray jArr = JSONArray.parseArray(role.getPermission());
        SysRolePermissionRe permissionRe;

        for (Object obj : jArr)
        {
            permissionRe = JSONObject.parseObject(obj.toString(), SysRolePermissionRe.class);
            permissionRe.setRoleId(role.getRoleId());
            if (permissionReMapper.insert(permissionRe) < 1)
                throw new RuntimeException(Constant.SAVE_FAILED);
        }

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken()));
    }
}
