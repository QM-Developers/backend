package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.Constant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.mapper.SysUserMapper;
import com.qm.backend.pojo.SysUser;
import com.qm.backend.util.CryptographyUtil;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService
{
    private final SysUserMapper mapper;

    public PasswordServiceImpl(SysUserMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String update(SessionVO sessionVO, SysUser user)
    {
        SysUser params = new SysUser();
        params.setUserPassword(CryptographyUtil.md5(user.getUserPassword(), Constant.SALT));
        params.setUserId(sessionVO.getUserId());
        int result = mapper.updateByPrimaryKeySelective(params);

        result = result < 1 ? RequestConstant.FAILED : RequestConstant.SUCCEED;

        return JSONObject.toJSONString(new ResultVO(result, sessionVO.getToken()));
    }
}
