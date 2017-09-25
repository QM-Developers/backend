package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.mapper.PermissionMapper;
import com.qm.backend.pojo.GoodsTypeinfo;
import com.qm.backend.pojo.GoodsTypeinfoExample;
import com.qm.backend.pojo.Permission;
import com.qm.backend.pojo.PermissionExample;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.util.ParameterUtil;
import com.qm.backend.util.TreeUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import com.qm.backend.vo.TreeVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService
{
    private final PermissionMapper mapper;

    public PermissionServiceImpl(PermissionMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String save(SessionVO sessionVO, Permission permission)
    {
        permission.setPermissionId(IDGeneratorUtil.generator());

        if (ParameterUtil.objectIsNull(permission))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        int result = mapper.insert(permission);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), permission.getPermissionId()));
    }

    @Override
    public String remove(SessionVO sessionVO, Permission permission)
    {
        if (mapper.countPermissionRE(permission.getPermissionId()) > 0)
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102,sessionVO.getToken()));

        int result = mapper.deleteByPrimaryKey(permission.getPermissionId());

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String update(SessionVO sessionVO, Permission permission)
    {
        int result = mapper.updateByPrimaryKeySelective(permission);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String list(SessionVO sessionVO, PageVO pageVO)
    {
        PermissionExample example = new PermissionExample();

        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());
        List<Permission> result = mapper.selectByExample(example);
        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, Permission permission)
    {
        permission = mapper.selectByPrimaryKey(permission.getPermissionId());

        int result = permission == null ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), permission));
    }

    @Override
    public String tree(SessionVO sessionVO)
    {
        PermissionExample example = new PermissionExample();

        example.setOrderByClause("permission_name");
        List<Permission> types = mapper.selectByExample(example);
        List<TreeVO> result = new ArrayList<>();

        for (Permission p: types)
        {
            TreeVO leaf = new TreeVO();
            leaf.setId(p.getPermissionId());
            leaf.setName(p.getPermissionName());
            leaf.setpId(p.getPermissionPid());
            leaf.setUrl(p.getPermissionUrl());
            result.add(leaf);
        }

        result = TreeUtil.addChild(result,"0");

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
    }
}
