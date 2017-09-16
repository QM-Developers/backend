package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.SysPermission;
import com.qm.backend.service.SysPermissionService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 系统权限控制器
 */
@Controller
public class SysPermissionController
{
    private final SysPermissionService service;

    private final String PREFIX = "/permission/";

    @Autowired
    public SysPermissionController(SysPermissionService service)
    {
        this.service = service;
    }

    /**
     * 添加权限
     *
     * @param request    当前用户信息
     * @param permission 要添加的权限信息
     * @return 操作结果+权限Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, SysPermission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, permission);
    }

    /**
     * 删除权限
     *
     * @param request    当前用户信息
     * @param permission 权限Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, SysPermission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, permission);
    }

    /**
     * 修改权限
     *
     * @param request    当前用户信息
     * @param permission 权限Id+新的权限信息
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, SysPermission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, permission);
    }

    /**
     * 获取权限列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 权限列表
     */
    @RequestMapping(value = PREFIX + "list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String list(HttpServletRequest request, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.list(sessionVO, pageVO);
    }

    /**
     * 获取权限详情
     *
     * @param request    当前用户信息
     * @param permission 权限Id
     * @return 权限详情
     */
    @RequestMapping(value = PREFIX + "get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, SysPermission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, permission);
    }
}
