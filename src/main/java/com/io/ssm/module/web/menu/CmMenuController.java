package com.io.ssm.module.web.menu;

import com.alibaba.fastjson.JSON;
import com.io.ssm.framework.annotation.ControllerLog;
import com.io.ssm.module.domain.menu.CmMenu;
import com.io.ssm.module.service.common.PageListDto;
import com.io.ssm.module.service.menu.CmMenuService;
import com.io.ssm.module.web.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/11
 * @time: 18:48
 * @version: 1.0
 */
@Controller
@RequestMapping("menu")
public class CmMenuController extends BaseController {

    @Autowired
    private CmMenuService cmMenuService;

    @GetMapping("menuList")
    public String menuList() {
        return "menu/list";
    }

    @ControllerLog(description="菜单列表")
    @RequestMapping("getList")
    public @ResponseBody List<CmMenu> getList(CmMenu cmMenu) {
        return cmMenuService.selectByExample(cmMenu);
    }

//    public @ResponseBody String getList() {
//        String s="[{\"id\":1,\"pid\":0,\"status\":1,\"name\":\"系统管理\",\"permissionValue\":\"open:system:get\"},{\"id\":2,\"pid\":0,\"status\":1,\"name\":\"字典管理\",\"permissionValue\":\"open:dict:get\"},{\"id\":20,\"pid\":1,\"status\":1,\"name\":\"新增系统\",\"permissionValue\":\"open:system:add\"},{\"id\":21,\"pid\":1,\"status\":1,\"name\":\"编辑系统\",\"permissionValue\":\"open:system:edit\"},{\"id\":22,\"pid\":1,\"status\":1,\"name\":\"删除系统\",\"permissionValue\":\"open:system:delete\"},{\"id\":33,\"pid\":2,\"status\":1,\"name\":\"系统环境\",\"permissionValue\":\"open:env:get\"},{\"id\":333,\"pid\":33,\"status\":1,\"name\":\"新增环境\",\"permissionValue\":\"open:env:add\"},{\"id\":3333,\"pid\":33,\"status\":1,\"name\":\"编辑环境\",\"permissionValue\":\"open:env:edit\"},{\"id\":233332,\"pid\":33,\"status\":0,\"name\":\"删除环境\",\"permissionValue\":\"open:env:delete\"}]";
//        return s;
//    }

}
