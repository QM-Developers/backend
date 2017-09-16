package com.qm.backend.interceptor;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.mapper.SysUserMapper;
import com.qm.backend.pojo.SysUser;
import com.qm.backend.util.TokenUtil;
import com.qm.backend.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TokenInterceptor implements HandlerInterceptor
{
    @Autowired
    private SysUserMapper mapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String userId = request.getParameter(KeyConstant.USER_ID);
        String token = request.getParameter(KeyConstant.TOKEN);

        HttpSession session = request.getSession();
        SessionVO sessionVO = (SessionVO) session.getAttribute(KeyConstant.LOGIN_INFO);

        if (sessionVO == null)
        {
            sessionVO = new SessionVO();
            SysUser user = mapper.selectByPrimaryKey(userId);

            if (user == null)
                return false;

//            if (user.getToken().equals(token))
//            {
//                user.setToken(TokenUtil.getToken());
//                mapper.updateByPrimaryKeySelective(user);
                sessionVO.setUserId(userId);
                sessionVO.setToken(token);
//            }
        }

        request.setAttribute(KeyConstant.LOGIN_INFO, sessionVO);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {

    }
}
