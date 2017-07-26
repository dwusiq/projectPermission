package com.wusiq.service.impl;

import com.alibaba.fastjson.JSON;
import com.wusiq.Dto.rsp.RspQueryCatalogTreeListDto;
import com.wusiq.base.CatalogTreeUtils;
import com.wusiq.dao.PermissionDao;
import com.wusiq.entity.PermissionEntity;
import com.wusiq.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 目录管理的实现类
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    private static Logger LOGGER =  LoggerFactory.getLogger(PermissionServiceImpl.class);
    @Autowired
    PermissionDao catalogTreeDao;

    /**
     * 获取权限列表
     */
    @Override
    public List<RspQueryCatalogTreeListDto> queryPermissionList(PermissionEntity perm) {
        LOGGER.info("PermissionServiceImpl.queryPermissionList.start...");
        //获取目录数据
        List<PermissionEntity> catalogList = catalogTreeDao.queryPermissionList(perm);
        LOGGER.info("catalogList:{}",JSON.toJSONString(catalogList));
        //将目录数据组织成树格式
        List<RspQueryCatalogTreeListDto> list = CatalogTreeUtils.list2Catalog(catalogList);
        LOGGER.info("PermissionServiceImpl.queryPermissionList.end.result:{}",JSON.toJSONString(list));
        return list;
    }

    /**
     * 获取目录列表
     */
    @Override
    public List<RspQueryCatalogTreeListDto> queryCatalogList(PermissionEntity perm) {
        LOGGER.info("PermissionServiceImpl.queryCatalogList.start...");
        //获取目录数据
        List<PermissionEntity> catalogList = catalogTreeDao.queryCatalogList(perm);
        LOGGER.info("catalogList:{}",JSON.toJSONString(catalogList));
        //将目录数据组织成树格式
        List<RspQueryCatalogTreeListDto> list = CatalogTreeUtils.list2Catalog(catalogList);
        LOGGER.info("PermissionServiceImpl.queryCatalogList.end.result:{}",JSON.toJSONString(list));
        return list;
    }


}
