package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.SysRole;
import com.qm.backend.service.SysRoleService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 系统角色控制器
 */
@Controller
public class SysRoleController
{
    private final SysRoleService service;

    @Autowired
    public SysRoleController(SysRoleService service)
    {
        this.service = service;
    }

    /**
     * 添加系统角色
     *
     * @param request 当前用户信息
     * @param role    要添加的角色信息
     * @return 操作结果+角色Id
     */
    @RequestMapping(value = "/role/save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, SysRole role)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, role);
    }

    /**
     * 删除角色
     *
     * @param request 当前用户信息
     * @param role    要删除的角色Id
     * @return 操作结果
     */
    @RequestMapping(value = "/role/remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, SysRole role)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, role);
    }

    /**
     * 修改角色
     *
     * @param request 当前用户信息
     * @param role    要修改的角色Id以及修改的信息
     * @return 操作结果
     */
    @RequestMapping(value = "/role/update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, SysRole role)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, role);
    }

    /**
     * 获取角色列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 角色列表
     */
    @RequestMapping(value = "/role/list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String list(HttpServletRequest request, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.list(sessionVO, pageVO);
    }

    /**
     * 获取角色详情
     *
     * @param request 当前用户信息
     * @param role    角色Id
     * @return 角色详情
     */
    @RequestMapping(value = "/role/get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, SysRole role)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, role);
    }

    /**
     * 为角色分配权限
     *
     * @param request 当前用户信息
     * @param role    权限信息
     * @return 操作结果
     */
    @RequestMapping(value = "/role/updatePermission", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String updatePermission(HttpServletRequest request, SysRole role)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.updatePermission(sessionVO, role);
    }


}
