package com.qm.backend.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.Constant;
import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.mapper.PermissionInterceptorMapper;
import com.qm.backend.util.ServletUtil;
import com.qm.backend.vo.ResultVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class PermissionInterceptor implements HandlerInterceptor
{
    private final PermissionInterceptorMapper mapper;

    public PermissionInterceptor(PermissionInterceptorMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        if (mapper.countPermission(sessionVO.getUserId(), request.getServletPath()) > 0)
            return true;

        JSONObject json = (JSONObject) JSONObject.toJSON(new ResultVO((int) RequestConstant.PERMISSION_DENIED));
        ServletUtil.printData(response, json.toJSONString());

        return false;
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
