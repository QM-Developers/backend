package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.SysUser;
import com.qm.backend.service.PasswordService;
import com.qm.backend.service.SysUserService;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class PasswordController
{
    private final PasswordService service;

    private final String PREFIX = "/password/";

    public PasswordController(PasswordService service)
    {
        this.service = service;
    }

    /**
     * 修改当前用户密码
     *
     * @param request 当前用户信息
     * @param user 新密码
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, SysUser user)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, user);
    }
}
