package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.QmPermission;
import com.qm.backend.service.QmPermissionService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 青麦角色控制器
 */
@Controller
public class QmPermissionController
{
    private final QmPermissionService service;

    private final String PREFIX = "/qm/role/";

    public QmPermissionController(QmPermissionService service)
    {
        this.service = service;
    }

    /**
     * 添加青麦角色
     *
     * @param request    当前用户信息
     * @param permission 要添加的角色信息
     * @return 操作结果+角色Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, QmPermission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, permission);
    }

    /**
     * 删除角色
     *
     * @param request    当前用户信息
     * @param permission 要删除的角色Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, QmPermission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, permission);
    }

    /**
     * 修改角色
     *
     * @param request    当前用户信息
     * @param permission 要修改的角色Id以及修改的信息
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, QmPermission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, permission);
    }

    /**
     * 获取角色列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 角色列表
     */
    @RequestMapping(value = PREFIX + "list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String list(HttpServletRequest request, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.list(sessionVO, pageVO);
    }

    /**
     * 获取角色详情
     *
     * @param request    当前用户信息
     * @param permission 角色Id
     * @return 角色详情
     */
    @RequestMapping(value = PREFIX + "get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, QmPermission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, permission);
    }

    /**
     * 为角色分配权限
     *
     * @param request    当前用户信息
     * @param permission 权限信息
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "updatePermission", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String updatePermission(HttpServletRequest request, QmPermission permission)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.updatePermission(sessionVO, permission);
    }
}
