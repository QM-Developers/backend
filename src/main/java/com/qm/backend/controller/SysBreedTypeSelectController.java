package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.SysBreedType;
import com.qm.backend.pojo.SysBreedTypeSelect;
import com.qm.backend.service.SysBreedTypeSelectService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 养殖类目的选项控制器
 */
@Controller
public class SysBreedTypeSelectController
{
    private final SysBreedTypeSelectService service;

    private final String PREFIX = "/breed/select/";

    public SysBreedTypeSelectController(SysBreedTypeSelectService service)
    {
        this.service = service;
    }

    /**
     * 添加养殖类目选项
     *
     * @param request 当前用户信息
     * @param select  要添加的养殖类目选项
     * @return 操作结果+选项Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, SysBreedTypeSelect select)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, select);
    }

    /**
     * 删除添加养殖类目选项
     *
     * @param request 当前用户信息
     * @param select  养殖类目选项Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, SysBreedTypeSelect select)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, select);
    }

    /**
     * 修改养殖类目选项
     *
     * @param request 当前用户信息
     * @param select  养殖类目选项Id+新的养殖类目选项信息
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, SysBreedTypeSelect select)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, select);
    }

    /**
     * 获取养殖类目选项列表
     *
     * @param request 当前用户信息
     * @param select  类目信息
     * @param pageVO  分页参数
     * @return 养殖类目选项列表
     */
    @RequestMapping(value = PREFIX + "list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String list(HttpServletRequest request, SysBreedTypeSelect select, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.list(sessionVO, select, pageVO);
    }

    /**
     * 获取养殖类目选项详情
     *
     * @param request 当前用户信息
     * @param select  养殖类目选项Id
     * @return 养殖类目选项详情
     */
    @RequestMapping(value = PREFIX + "get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, SysBreedTypeSelect select)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, select);
    }
}
