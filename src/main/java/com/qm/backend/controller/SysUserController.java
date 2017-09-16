package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.SysUser;
import com.qm.backend.service.SysUserService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 系统用户控制器
 */
@Controller
public class SysUserController
{
    private final SysUserService service;

    @Autowired
    public SysUserController(SysUserService service)
    {
        this.service = service;
    }

    /**
     * 添加系统用户
     *
     * @param request 当前用户信息
     * @param user    要添加的用户信息
     * @return 操作结果+用户Id
     */
    @RequestMapping(value = "/user/save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, SysUser user)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, user);
    }

    /**
     * 修改系统用户
     *
     * @param request 当前用户信息
     * @param user    要修改的用户信息
     * @return 操作结果
     */
    @RequestMapping(value = "/user/update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, SysUser user)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, user);
    }

    /**
     * 获取系统用户列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 系统用户列表
     */
    @RequestMapping(value = "/user/list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String list(HttpServletRequest request, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.list(sessionVO, pageVO);
    }

    /**
     * 获取系统用户详情
     *
     * @param request 当前用户信息
     * @param user    系统用户Id
     * @return 系统用户详情
     */
    @RequestMapping(value = "/user/get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, SysUser user)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, user);
    }

    /**
     * 分配用户角色
     *
     * @param request 当前用户信息
     * @param user    用户角色信息
     * @return 操作结果
     */
    @RequestMapping(value = "/user/updateRole", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String updateRole(HttpServletRequest request, SysUser user)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.updateRole(sessionVO, user);
    }


}
