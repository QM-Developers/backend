package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.*;
import com.qm.backend.mapper.SysCustomerAccountMapper;
import com.qm.backend.mapper.SysCustomerMapper;
import com.qm.backend.pojo.QmBranch;
import com.qm.backend.pojo.SysCustomer;
import com.qm.backend.pojo.SysCustomerAccount;
import com.qm.backend.pojo.SysCustomerAccountExample;
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
public class SysCustomerAccountServiceImpl implements SysCustomerAccountService
{
    private final SysCustomerAccountMapper mapper;
    private final SysCustomerMapper customerMapper;

    @Autowired
    public SysCustomerAccountServiceImpl(SysCustomerAccountMapper mapper, SysCustomerMapper customerMapper)
    {
        this.mapper = mapper;
        this.customerMapper = customerMapper;
    }

    @Override
    public String save(SessionVO sessionVO, SysCustomerAccount account)
    {
        account.setUserId(sessionVO.getUserId());
        account.setUserName(mapper.getUserName(sessionVO.getUserId()));
        account.setAccountId(IDGeneratorUtil.generator());
        account.setAccountStatus(AccountConstant.WAITING);

        if (ParameterUtil.objectIsNull(account))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        int result = mapper.insert(account);
        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken(), account.getAccountId()));
    }

    @Override
    public String listByApprove(SessionVO sessionVO, PageVO pageVO)
    {
        if (ParameterUtil.objectIsNull(pageVO))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        SysCustomerAccountExample example = new SysCustomerAccountExample();
        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());

        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());
        List<SysCustomerAccount> result = mapper.selectByExample(example);

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String listByProposer(SessionVO sessionVO, PageVO pageVO)
    {
        if (ParameterUtil.objectIsNull(pageVO))
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        SysCustomerAccountExample example = new SysCustomerAccountExample();
        SysCustomerAccountExample.Criteria criteria = example.createCriteria();

        example.setPageNum(PagingUtil.getStart(pageVO.getPageNum(), pageVO.getPageSize()));
        example.setPageSize(pageVO.getPageSize());
        criteria.andUserIdEqualTo(sessionVO.getUserId());

        int pageCount = PagingUtil.getCount((int) mapper.countByExample(example), pageVO.getPageSize());
        List<SysCustomerAccount> result = mapper.selectByExample(example);

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken(), result));
        json.put(KeyConstant.PAGE_COUNT, pageCount);

        return json.toJSONString();
    }

    @Override
    public String updateAccept(SessionVO sessionVO, SysCustomerAccount account)
    {
        account = mapper.selectByPrimaryKey(account.getAccountId());

        if (AccountConstant.WAITING != account.getAccountStatus())
            return JSONObject.toJSONString(new ResultVO((int) RequestConstant.FAILED_102, sessionVO.getToken()));

        int result = 1;
        int index = 0;

        while (result > 0)
        {
            switch (index)
            {
                case 0:
                    result = mapper.insertTeam(account.getCustomerId());
                    break;
                case 1:
                    result = mapper.insertDepartment(account.getCustomerId());
                    break;
                case 2:
                    result = mapper.insertUser(account.getCustomerId());
                    break;
                case 3:
                    result = mapper.insertPosition(account.getCustomerId());
                    break;
                case 4:
                    result = mapper.insertBranch(account.getCustomerId());
                    break;
                case 5:
                    SysCustomerAccount newAccount = new SysCustomerAccount();
                    newAccount.setAccountId(account.getAccountId());
                    newAccount.setAccountStatus(AccountConstant.ACCEPT);
                    result = mapper.updateByPrimaryKeySelective(newAccount);
                    break;
                case 6:
                    SysCustomer customer = new SysCustomer();
                    customer.setCustomerId(account.getCustomerId());
                    customer.setHadAccount(CustomerConstant.ACCOUNT_HAD);
                    result = customerMapper.updateByPrimaryKeySelective(customer);
                    break;
                default:
                    result = 0;
                    break;
            }
            index++;
        }

        if (8 != index)
            throw new RuntimeException(Constant.SAVE_FAILED);

        return JSONObject.toJSONString(new ResultVO((int) RequestConstant.SUCCEED, sessionVO.getToken()));
    }

    @Override
    public String updateRefuse(SessionVO sessionVO, SysCustomerAccount account)
    {
        SysCustomerAccount newAccount = new SysCustomerAccount();
        newAccount.setAccountId(account.getAccountId());
        newAccount.setAccountStatus(AccountConstant.REFUSE);

        int result = mapper.updateByPrimaryKeySelective(newAccount);
        result = result < 0 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }

}
