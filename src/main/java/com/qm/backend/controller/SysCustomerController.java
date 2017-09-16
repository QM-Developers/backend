package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.SysCustomer;
import com.qm.backend.service.SysCustomerService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 客户控制器
 */
@Controller
public class SysCustomerController
{
    private final SysCustomerService service;

    private final String PREFIX = "/customer/";


    public SysCustomerController(SysCustomerService service)
    {
        this.service = service;
    }

    /**
     * 添加客户
     *
     * @param request  当前用户信息
     * @param customer 要添加的客户信息
     * @return 操作结果+客户Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, SysCustomer customer)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, customer);
    }

    /**
     * 删除客户
     *
     * @param request  当前用户信息
     * @param customer 客户Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, SysCustomer customer)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, customer);
    }

    /**
     * 修改客户
     *
     * @param request  当前用户信息
     * @param customer 客户Id+新的客户信息
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, SysCustomer customer)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, customer);
    }

    /**
     * 获取客户列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 客户列表
     */
    @RequestMapping(value = PREFIX + "list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String list(HttpServletRequest request, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.list(sessionVO, pageVO);
    }

    /**
     * 获取客户详情
     *
     * @param request  当前用户信息
     * @param customer 客户Id
     * @return 客户详情
     */
    @RequestMapping(value = PREFIX + "get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, SysCustomer customer)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, customer);
    }

}
