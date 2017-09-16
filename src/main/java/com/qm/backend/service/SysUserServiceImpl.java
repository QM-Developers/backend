package com.qm.backend.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.*;
import com.qm.backend.mapper.SysUserMapper;
import com.qm.backend.mapper.SysUserRoleReMapper;
import com.qm.backend.pojo.SysUser;
import com.qm.backend.pojo.SysUserExample;
import com.qm.backend.pojo.SysUserRoleRe;
import com.qm.backend.pojo.SysUserRoleReExample;
import com.qm.backend.util.CryptographyUtil;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.util.TokenUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService
{
    private final SysUserMapper mapper;
    private final SysUserRoleReMapper roleReMapper;

    @Autowired
    public SysUserServiceImpl(SysUserMapper mapper, SysUserRoleReMapper roleReMapper)
    {
        this.mapper = mapper;
        this.roleReMapper = roleReMapper;
    }

    @Override
    public String save(SessionVO sessionVO, SysUser user)
    {
        user.setUserId(IDGeneratorUtil.generator());
        user.setToken(TokenUtil.getToken());
        user.setUserPassword(user.getUserPassword() == null ? StringConstant.EMPTY : CryptographyUtil.md5(user.getUserPassword(), Constant.SALT));

        int result = mapper.insert(user);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), user.getUserId()));
    }

    @Override
    public String update(SessionVO sessionVO, SysUser user)
    {
        user.setUserId(sessionVO.getUserId());
        int result = mapper.updateByPrimaryKeySelective(user);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), user.getUserId()));
    }

    @Override
    public String list(SessionVO sessionVO, PageVO pageVO)
    {
        SysUserExample example = new SysUserExample();
        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());

        List<SysUser> result = mapper.selectByExample(example);
        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, SysUser user)
    {
        SysUser result = mapper.selectByPrimaryKey(user.getUserId());
        int flag = result == null ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(flag, sessionVO.getToken(), result));
    }

    @Override
    public String updateRole(SessionVO sessionVO, SysUser user)
    {
        SysUserRoleReExample example = new SysUserRoleReExample();
        SysUserRoleReExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(user.getUserId());

        roleReMapper.deleteByExample(example);

        JSONArray jArr = JSONArray.parseArray(user.getRole());
        List<SysUserRoleRe> roleReList = new ArrayList<>();
        SysUserRoleRe roleRe;

        for (Object role : jArr)
        {
            roleRe = JSONObject.parseObject(role.toString(),SysUserRoleRe.class);

            if (RoleConstant.ADMINISTRATOR.equals(roleRe.getRoleId()))
                return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102,sessionVO.getToken()));

            roleRe.setUserId(user.getUserId());
            roleReList.add(roleRe);
        }

        for (SysUserRoleRe role : roleReList)
            if (roleReMapper.insert(role) < 1)
                throw new RuntimeException(Constant.SAVE_FAILED);

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED,sessionVO.getToken()));
    }


}
