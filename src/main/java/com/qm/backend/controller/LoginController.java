package com.qm.backend.controller;

import com.qm.backend.constant.RequestConstant;
import com.qm.backend.service.LoginService;
import com.qm.backend.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController
{
    private final LoginService service;

    private final String PREFIX = "/login/";

    @Autowired
    public LoginController(LoginService service)
    {
        this.service = service;
    }

    @RequestMapping(value = PREFIX + "browser", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String browser(HttpServletRequest request,LoginVO loginVO)
    {
        HttpSession session = request.getSession();

        return service.LoginOnBrowser(session,loginVO);
    }
}
