package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.InterfaceType;
import com.qm.backend.service.InterfaceTypeService;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class InterfaceTypeController
{
    private final InterfaceTypeService service;

    private final String PREFIX = "/interface/type/";

    public InterfaceTypeController(InterfaceTypeService service)
    {
        this.service = service;
    }

    /**
     * 添加接口分类
     *
     * @param request 当前用户信息
     * @param type    要添加的添加接口分类
     * @return 操作结果+分类Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, InterfaceType type)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, type);
    }

    /**
     * 删除接口分类
     *
     * @param request 当前用户信息
     * @param type    分类Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, InterfaceType type)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, type);
    }

    /**
     * 修改接口分类
     *
     * @param request 当前用户信息
     * @param type    要修改的分类Id以及分类信息
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, InterfaceType type)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, type);
    }

    /**
     * 获取接口分类列表(树形结构)
     *
     * @param request 当前用户信息
     * @return 接口分类列表(树形结构)
     */
    @RequestMapping(value = PREFIX + "tree", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String tree(HttpServletRequest request)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.tree(sessionVO);
    }
}
