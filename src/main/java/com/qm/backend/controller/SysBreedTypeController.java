package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.SysBreedType;
import com.qm.backend.service.SysBreedTypeService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 养殖类目控制器
 */
@Controller
public class SysBreedTypeController
{
    private final SysBreedTypeService service;

    private final String PREFIX = "/breed/";

    @Autowired
    public SysBreedTypeController(SysBreedTypeService service)
    {
        this.service = service;
    }

    /**
     * 添加养殖类目
     *
     * @param request   当前用户信息
     * @param breedType 要添加的养殖类目
     * @return 操作结果+养殖类目Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, SysBreedType breedType)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, breedType);
    }

    /**
     * 删除养殖类目
     *
     * @param request   当前用户信息
     * @param breedType 养殖类目Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, SysBreedType breedType)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, breedType);
    }

    /**
     * 修改养殖类目
     *
     * @param request   当前用户信息
     * @param breedType 养殖类目Id+新的养殖类目信息
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, SysBreedType breedType)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, breedType);
    }

    /**
     * 获取养殖类目列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 养殖类目列表
     */
    @RequestMapping(value = PREFIX + "list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String list(HttpServletRequest request, SysBreedType type, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.list(sessionVO, type, pageVO);
    }

    /**
     * 获取养殖类目详情
     *
     * @param request   当前用户信息
     * @param breedType 养殖类目Id
     * @return 养殖类目详情
     */
    @RequestMapping(value = PREFIX + "get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, SysBreedType breedType)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, breedType);
    }
}
