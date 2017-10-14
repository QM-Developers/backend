package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.InterfaceInfo;
import com.qm.backend.pojo.QmPermission;
import com.qm.backend.service.InterfaceInfoService;
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

}
