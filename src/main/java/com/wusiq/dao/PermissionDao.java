package com.wusiq.dao;

import com.wusiq.Dto.req.ReqQueryPermissionListDto;
import com.wusiq.entity.PermissionEntity;

import java.util.List;

/**
 * 目录管理的数据库操作DAO类
 */
public interface PermissionDao {
    //获取权限列表
    List<PermissionEntity> queryPermissionList(ReqQueryPermissionListDto perm);
    /*查询目录列表*/
    List<PermissionEntity> queryCatalogList(ReqQueryPermissionListDto perm);
}
