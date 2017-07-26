package com.wusiq.service;

import com.wusiq.Dto.rsp.RspQueryCatalogTreeListDto;
import com.wusiq.entity.PermissionEntity;

import java.util.List;

/**
 * 目录管理的服务类
 */
public interface PermissionService {
    /*查询权限列表*/
    List<RspQueryCatalogTreeListDto> queryPermissionList(PermissionEntity perm);
    /*查询目录列表*/
    List<RspQueryCatalogTreeListDto> queryCatalogList(PermissionEntity perm);
}
