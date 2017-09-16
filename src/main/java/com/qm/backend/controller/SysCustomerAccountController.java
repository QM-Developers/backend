package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.SysCustomerAccount;
import com.qm.backend.service.SysCustomerAccountService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 建账申请控制器
 */
@Controller
public class SysCustomerAccountController
{
    private final SysCustomerAccountService service;

    private final String PREFIX = "/customer/account/";

    public SysCustomerAccountController(SysCustomerAccountService service)
    {
        this.service = service;
    }


    /**
     * 发起建账申请
     *
     * @param request 当前用户信息
     * @param account 申请信息
     * @return 操作结果+申请的Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, SysCustomerAccount account)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, account);
    }

    /**
     * 审批人获取建账申请列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 申请列表
     */
    @RequestMapping(value = PREFIX + "listByApprove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String listByApprove(HttpServletRequest request, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.listByApprove(sessionVO, pageVO);
    }

    /**
     * 申请人获取建账申请列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 申请列表
     */
    @RequestMapping(value = PREFIX + "listByProposer", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String listByProposer(HttpServletRequest request, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.listByProposer(sessionVO, pageVO);
    }

    /**
     * 同意建账申请
     *
     * @param request 当前用户信息
     * @param account 申请的Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "updateAccept", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String updateAccept(HttpServletRequest request, SysCustomerAccount account)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.updateAccept(sessionVO, account);
    }

    /**
     * 拒绝建账申请
     *
     * @param request 当前用户信息
     * @param account 申请的Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "updateRefuse", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String updateRefuse(HttpServletRequest request, SysCustomerAccount account)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.updateRefuse(sessionVO, account);
    }
}
