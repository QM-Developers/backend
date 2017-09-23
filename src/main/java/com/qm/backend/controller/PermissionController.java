package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.Permission;
import com.qm.backend.service.PermissionService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 青麦权限控制器
 */
@Controller
public class PermissionController
{
    private final PermissionService service;

    private final String PREFIX = "/qm/permission/";

    public PermissionController(PermissionService service)
    {
        this.service = service;
    }

    /**
     * 添加权限
     *
     * @param request    当前用户信息
     * @param permission 要添加的权限
     * @return 操作结果+权限Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, Permission permission)
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
    public String remove(HttpServletRequest request, Permission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, permission);
    }

    /**
     * 修改权限
     *
     * @param request    当前用户信息
     * @param permission 权限Id+要修改的权限
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, Permission permission)
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
    public String get(HttpServletRequest request, Permission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, permission);
    }

    /**
     * 获取权限列表(树形结构)
     *
     * @param request 当前用户信息
     * @return 权限列表(树形结构)
     */
    @RequestMapping(value = PREFIX + "tree", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String tree(HttpServletRequest request)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.tree(sessionVO);
    }


}
