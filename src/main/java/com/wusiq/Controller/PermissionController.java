package com.wusiq.Controller;

import com.alibaba.fastjson.JSON;
import com.wusiq.Dto.rsp.RspQueryCatalogTreeListDto;
import com.wusiq.entity.PermissionEntity;
import com.wusiq.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//public String addUser(@Validated ReqAddUserEntity req, BindingResult result){
/**
 * 目录管理的控制器类
 */
@RequestMapping("permissionManage")
@ResponseBody
@Controller
public class PermissionController {
    private static Logger LOGGER =  LoggerFactory.getLogger(PermissionController.class);
    @Autowired
    PermissionService catalogService;

    @RequestMapping(value = "/queryPermissionList.json",method = RequestMethod.GET)
    public String queryPermissionList(){
        LOGGER.info("PermissionController.queryPermissionList.start...");
        List<RspQueryCatalogTreeListDto> list = catalogService.queryPermissionList(null);
        LOGGER.info("PermissionController.queryPermissionList.end.result:{}", JSON.toJSONString(list));

        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/queryCatalogTreeList.json",method = RequestMethod.GET)
    public String queryCatalogTreeList(){
        LOGGER.info("PermissionController.queryCatalogTreeList.start...");
        PermissionEntity perm = new PermissionEntity();
        List<RspQueryCatalogTreeListDto> list = catalogService.queryCatalogList(perm);
        LOGGER.info("PermissionController.queryCatalogTreeList.end.result:{}", JSON.toJSONString(list));

        return JSON.toJSONString(list);
    }
}
