package com.qm.backend.controller;

import com.qm.backend.constant.KeyConstant;
import com.qm.backend.constant.RequestConstant;
import com.qm.backend.pojo.GoodsTypeinfo;
import com.qm.backend.service.GoodsTypeinfoService;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 商品类目控制器
 */
@Controller
public class GoodsTypeinfoController
{
    private final GoodsTypeinfoService service;

    public GoodsTypeinfoController(GoodsTypeinfoService service)
    {
        this.service = service;
    }

    private final String PREFIX = "/goods/type/";

    /**
     * 添加商品类目
     *
     * @param request 当前用户信息
     * @param info    要添加的商品类目
     * @return 操作结果+商品类目Id
     */
    @RequestMapping(value = PREFIX + "save", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String save(HttpServletRequest request, GoodsTypeinfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.save(sessionVO, info);
    }

    /**
     * 删除商品类目
     *
     * @param request 当前用户信息
     * @param info    商品类目Id
     * @return 操作结果
     */
    @RequestMapping(value = PREFIX + "remove", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String remove(HttpServletRequest request, GoodsTypeinfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.remove(sessionVO, info);
    }

    /**
     * 修改商品类目
     *
     * @param request 当前用户信息
     * @param info    商品类目Id+要修改的商品类目信息
     * @return
     */
    @RequestMapping(value = PREFIX + "update", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String update(HttpServletRequest request, GoodsTypeinfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.update(sessionVO, info);
    }

    /**
     * 获取商品类目列表
     *
     * @param request 当前用户信息
     * @param pageVO  分页参数
     * @return 商品类目列表
     */
    @RequestMapping(value = PREFIX + "list", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String list(HttpServletRequest request, PageVO pageVO)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.list(sessionVO, pageVO);
    }

    /**
     * 获取商品类目详情
     *
     * @param request 当前用户信息
     * @param info    商品类目Id
     * @return 商品类目详情
     */
    @RequestMapping(value = PREFIX + "get", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String get(HttpServletRequest request, GoodsTypeinfo info)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.get(sessionVO, info);
    }

    /**
     * 获取商品类目列表(树形结构)
     *
     * @param request 当前用户信息
     * @return 类目列表(树形结构)
     */
    @RequestMapping(value = PREFIX + "tree", method = POST, produces = {RequestConstant.CONTENT_TYPE})
    @ResponseBody
    public String tree(HttpServletRequest request)
    {
        SessionVO sessionVO = (SessionVO) request.getAttribute(KeyConstant.LOGIN_INFO);

        return service.tree(sessionVO);
    }

}
