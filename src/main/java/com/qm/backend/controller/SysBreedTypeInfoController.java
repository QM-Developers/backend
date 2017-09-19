package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.SysBreedTypeInfo;
import com.qm.backend.service.SysBreedTypeInfoService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 养殖类目信息控制器
 */
@Controller
public class SysBreedTypeInfoController
{
    private final SysBreedTypeInfoService service;

    private final String PREFIX = "/breed/info/";

    @Autowired
    public SysBreedTypeInfoController(SysBreedTypeInfoService service)
    {
        this.service = service;
    }

    /**
     * 添加养殖类目信息
     *
     * @param request 当前用户信息
     * @param info    要添加的养殖类目信息
     * @return 操作结果+养殖类目信息Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, SysBreedTypeInfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, info);
    }

    /**
     * 删除养殖类目信息
     *
     * @param request 当前用户信息
     * @param info    养殖类目信息Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, SysBreedTypeInfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, info);
    }

    /**
     * 修改养殖类目信息
     *
     * @param request 当前用户信息
     * @param info    养殖类目信息Id+新的养殖类目信息
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, SysBreedTypeInfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, info);
    }

    /**
     * 获取养殖类目信息列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 养殖类目信息列表
     */
    @RequestMapping(value = PREFIX + "list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String list(HttpServletRequest request, SysBreedTypeInfo info, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.list(sessionVO, info, pageVO);
    }

    /**
     * 获取养殖类目信息详情
     *
     * @param request 当前用户信息
     * @param info    养殖类目信息Id
     * @return 养殖类目信息详情
     */
    @RequestMapping(value = PREFIX + "get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, SysBreedTypeInfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, info);
    }
}
