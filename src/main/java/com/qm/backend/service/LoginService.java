package com.qm.backend.service;

import com.qm.backend.vo.LoginVO;

import javax.servlet.http.HttpSession;

public interface LoginService
{
    String LoginOnBrowser(HttpSession session, LoginVO loginVO);
}
