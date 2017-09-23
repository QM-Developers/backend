package com.qm.backend.util;

import com.qm.backend.vo.TreeVO;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TreeUtil
{
    /**
     * 将所有查询到的菜单，以 树 的形式重新整合
     *
     * @param allItems 全部菜单信息
     * @param pid 父类菜单 id
     * @return 整合完成的菜单
     */
    public static List<TreeVO> addChild(List<TreeVO> allItems, String pid)
    {
        // 子菜单
        List<TreeVO> children = new ArrayList<>();
        TreeVO item = null;
        for (int i = 0; i < allItems.size(); i++)
        {
            item = allItems.get(i);
            if (pid.equals(item.getpId()))
            {   // 当前菜单的 父类id 与传入的 父类id 相等，就添加到 子菜单
                children.add(item);
                // 删除以添加的 菜单
                allItems.remove(item);
                i--;
            }
        }

        // 还没有添加完成就继续 添加
        if (allItems.size() > 0)
        {
            for (TreeVO child : children)
            {
                child.setChildren(addChild(allItems, child.getId()));
            }
        }
        return children;
    }

}
