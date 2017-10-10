package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.*;
import com.qm.backend.mapper.SysCustomerMapper;
import com.qm.backend.pojo.SysCustomer;
import com.qm.backend.pojo.SysCustomerExample;
import com.qm.backend.util.IDGeneratorUtil;
import com.qm.backend.util.PagingUtil;
import com.qm.backend.util.ParameterUtil;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCustomerServiceImpl implements SysCustomerService
{
    private final SysCustomerMapper mapper;

    public SysCustomerServiceImpl(SysCustomerMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String save(SessionVO sessionVO, SysCustomer customer)
    {
        customer.setCustomerId(IDGeneratorUtil.generator());
        customer.setUserId(sessionVO.getUserId());
        customer.setHadAccount(CustomerConstant.ACCOUNT_NOT);
        customer.setRoleId(CustomerConstant.ROLE);
        customer.setDepartmentId(IDGeneratorUtil.generator());
        customer.setDepartmentName(CustomerConstant.DEPARTMENT_NAME);
        customer.setDepartmentType(CustomerConstant.DEPARTMENT_TYPE);
        customer.setPositionId(IDGeneratorUtil.generator());
        customer.setPositionName(CustomerConstant.POSITION_NAME);
        customer.setBranchType(BranchConstant.BRANCH_FIRST);

        int result = mapper.insertSelective(customer);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), customer.getCustomerId()));
    }

    @Override
    public String remove(SessionVO sessionVO, SysCustomer customer)
    {
        int result = mapper.deleteByPrimaryKey(customer.getCustomerId());

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String update(SessionVO sessionVO, SysCustomer customer)
    {
        int result = mapper.updateByPrimaryKeySelective(customer);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

    @Override
    public String list(SessionVO sessionVO, PageVO pageVO)
    {
        if (ParameterUtil.objectIsNull(pageVO))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        SysCustomerExample example = new SysCustomerExample();
        SysCustomerExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(sessionVO.getUserId());
        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());

        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());
        List<SysCustomer> result = mapper.selectByExample(example);

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String get(SessionVO sessionVO, SysCustomer customer)
    {
        SysCustomer result = mapper.selectByPrimaryKey(customer.getCustomerId());

        int flag = result == null ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(flag, sessionVO.getToken(), result));
    }
}
