package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.InterfaceInfo;
import com.qm.backend.pojo.QmPermission;
import com.qm.backend.service.InterfaceInfoService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class InterfaceInfoController
{
    private final InterfaceInfoService service;

    private final String PREFIX = "/interface/";

    public InterfaceInfoController(InterfaceInfoService service)
    {
        this.service = service;
    }

    /**
     * 添加接口
     *
     * @param request 当前用户信息
     * @param info    接口信息
     * @return 操作结果+接口Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, InterfaceInfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, info);
    }

    /**
     * 修改接口
     *
     * @param request 当前用户信息
     * @param info    接口Id+接口信息
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, InterfaceInfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, info);
    }

    /**
     * 获取接口列表(树形结构)
     *
     * @param request 当前用户信息
     * @return 接口列表(树形结构)
     */
    @RequestMapping(value = PREFIX + "tree", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String tree(HttpServletRequest request)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.tree(sessionVO);
    }

    /**
     * 获取接口信息
     *
     * @param request 当前用户信息
     * @param info    接口Id
     * @return 接口信息
     */
    @RequestMapping(value = PREFIX + "get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, InterfaceInfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, info);
    }

    /**
     * 删除接口
     *
     * @param request 当前用户信息
     * @param info    接口Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, InterfaceInfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, info);
    }

    /**
     * 获取接口更新列表
     *
     * @param request 当前用户信息
     * @return 接口更新列表
     */
    @RequestMapping(value = PREFIX + "log/list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String logList(HttpServletRequest request, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.logList(sessionVO,pageVO);
    }
}
