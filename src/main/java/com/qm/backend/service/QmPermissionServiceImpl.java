package com.qm.backend.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.Constant;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.mapper.QmPermissionMapper;
import com.qm.backend.mapper.QmPermissionReMapper;
import com.qm.backend.pojo.*;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QmPermissionServiceImpl implements QmPermissionService
{
    private final QmPermissionMapper mapper;
    private final QmPermissionReMapper permissionReMapper;

    public QmPermissionServiceImpl(QmPermissionMapper mapper, QmPermissionReMapper permissionReMapper)
    {
        this.mapper = mapper;
        this.permissionReMapper = permissionReMapper;
    }

    @Override
    public String save(SessionVO sessionVO, QmPermission permission)
    {
        permission.setQmPermissionId(IDGeneratorUtil.generator());
        permission.setQmPermissionPid("0");
        permission.setSort((byte) 0);

        int result = mapper.insert(permission);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), permission.getQmPermissionId()));
    }

    @Override
    public String remove(SessionVO sessionVO, QmPermission permission)
    {
        if (mapper.countPermission(permission.getQmPermissionId()) > 0)
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        mapper.deletePermissionRe(permission.getQmPermissionId());
        int result = mapper.deleteByPrimaryKey(permission.getQmPermissionId());

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), permission.getQmPermissionId()));
    }

    @Override
    public String update(SessionVO sessionVO, QmPermission permission)
    {
        int result = mapper.updateByPrimaryKeySelective(permission);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), permission.getQmPermissionId()));
    }

    @Override
    public String list(SessionVO sessionVO, PageVO pageVO)
    {
        QmPermissionExample example = new QmPermissionExample();

        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());
        List<QmPermission> result = mapper.selectByExample(example);

        for (QmPermission p : result)
            p.setPermissionList(mapper.listPermission(p.getQmPermissionId()));

        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, QmPermission permission)
    {
        permission = mapper.selectByPrimaryKey(permission.getQmPermissionId());

        int result = permission == null ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), permission));
    }

    @Override
    public String updatePermission(SessionVO sessionVO, QmPermission permission)
    {
        QmPermissionReExample example = new QmPermissionReExample();
        QmPermissionReExample.Criteria criteria = example.createCriteria();

        criteria.andQmPermissionIdEqualTo(permission.getQmPermissionId());

        permissionReMapper.deleteByExample(example);

        JSONArray jArr = JSONArray.parseArray(permission.getPermission());
        QmPermissionRe permissionRe;

        for (Object obj : jArr)
        {
            permissionRe = JSONObject.parseObject(obj.toString(), QmPermissionRe.class);
            permissionRe.setQmPermissionId(permission.getQmPermissionId());
            if (permissionReMapper.insert(permissionRe) < 1)
                throw new RuntimeException(Constant.SAVE_FAILED);
        }

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken()));
    }
}
