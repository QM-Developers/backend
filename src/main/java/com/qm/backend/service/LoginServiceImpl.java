package com.qm.backend.service;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.Constant;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.mapper.SysUserMapper;
import com.qm.backend.pojo.SysUser;
import com.qm.backend.pojo.SysUserExample;
import com.qm.backend.util.CryptographyUtil;
import com.qm.backend.util.ParameterUtil;
import com.qm.backend.vo.LoginVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService
{
    private final SysUserMapper mapper;

    public LoginServiceImpl(SysUserMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public String LoginOnBrowser(HttpSession session, LoginVO loginVO)
    {
        if (ParameterUtil.objectIsNull(loginVO))
            return JSONObject.toJSONString(RequestConstant.FAILED_102);

        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();

        criteria.andUserPhoneEqualTo(loginVO.getPhone());
        criteria.andUserPasswordEqualTo(CryptographyUtil.md5(loginVO.getPassword(), Constant.SALT));

        List<SysUser> result = mapper.selectByExample(example);
        if (result.size() < 1)
            return JSONObject.toJSONString(RequestConstant.FAILED);

        SysUser user = result.get(0);

        SessionVO sessionVO = new SessionVO();
        sessionVO.setUserId(user.getUserId());
        sessionVO.setToken(user.getToken());
        sessionVO.setUserPhone(user.getUserPhone());

        session.setAttribute(KeyConstant.LOGIN_INFO,sessionVO);

        return JSONObject.toJSONString(RequestConstant.SUCCEED);
    }
}
