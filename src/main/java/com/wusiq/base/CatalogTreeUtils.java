package com.wusiq.base;

import com.alibaba.fastjson.JSON;
import com.wusiq.Dto.rsp.RspQueryCatalogTreeListDto;
import com.wusiq.entity.PermissionEntity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 目录树的数据组织工具
 */
public class CatalogTreeUtils {
    private static Logger LOGGER =  LoggerFactory.getLogger(CatalogTreeUtils.class);
    /**
     * 数据列表转换成目录
     */
    public static final List<RspQueryCatalogTreeListDto> list2Catalog(List<PermissionEntity> catalogList){
        LOGGER.info("CatalogTreeUtils.list2Catalog.start.param:{}", JSON.toJSONString(catalogList));
        if(catalogList==null){
            return null;
        }
        //顶层父目录列表
        List<RspQueryCatalogTreeListDto> topCatalogList = new ArrayList<>();
        for(PermissionEntity catalog:catalogList){
            if(catalog.getResParent()==null){
                //顶层目录对象
                RspQueryCatalogTreeListDto topCatalog = new RspQueryCatalogTreeListDto();
                //获取父目录下的子目录
                List<RspQueryCatalogTreeListDto> childCatalogList= getChildrenNode(catalog.getResCode(),catalogList);
                topCatalog.setChildren(childCatalogList);
                topCatalog.setId(catalog.getResCode());
                topCatalog.setState(catalog.getResState().equals("0")?"open":"close");
                topCatalog.setText(catalog.getResDescription());

                topCatalogList.add(topCatalog);
            }
        }
        LOGGER.info("CatalogTreeUtils.list2Catalog.end.result:{}", JSON.toJSONString(topCatalogList));
        return topCatalogList;
    }

    /**
     * 根据父目录id和数据列表获取子目录
     */
    private static final List<RspQueryCatalogTreeListDto> getChildrenNode(String parentId,List<PermissionEntity> catalogList){
        //子目录列表
        List<RspQueryCatalogTreeListDto> childCatalogList = new ArrayList<>();
        for(PermissionEntity catalogTreeEntity:catalogList){
            if(catalogTreeEntity.getResParent()==null){
                continue;
            }
            if(catalogTreeEntity.getResParent().equals(parentId)){

                //子目录对象
                RspQueryCatalogTreeListDto childCatalog = new RspQueryCatalogTreeListDto();
                childCatalog.setId(catalogTreeEntity.getResCode());//id
                childCatalog.setText(catalogTreeEntity.getResDescription());//显示文本
                childCatalog.setState(catalogTreeEntity.getResState().equals("0")?"open":"close");//状态

                //目录的其他属性
                String resContent = catalogTreeEntity.getResContent();
                Map<String,Object> attributes = new HashMap<>();
                if(StringUtils.isNotBlank(resContent)){
                    attributes = JSON.parseObject(resContent);
                }
                childCatalog.setAttributes(attributes);//其他属性

                //继续获取更下一层的所有子目录
                List<RspQueryCatalogTreeListDto> nextChildCatalogList = getChildrenNode(catalogTreeEntity.getResCode(),catalogList);
                if(nextChildCatalogList != null){
                    //更一层的子目录
                    childCatalog.setChildren(nextChildCatalogList);
                }

                childCatalogList.add(childCatalog);
            }
        }
        return childCatalogList;
    }
}
