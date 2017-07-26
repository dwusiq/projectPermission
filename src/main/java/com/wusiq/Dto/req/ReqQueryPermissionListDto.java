package com.wusiq.Dto.req;

import java.io.Serializable;

/**
 * Created by wicker on 2017/7/26.
 */
public class ReqQueryPermissionListDto implements Serializable{
    private String resCode;
    private String resName;
    private String resStatus="0";
    private String resType;
    private String resParent;



    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getResParent() {
        return resParent;
    }

    public void setResParent(String resParent) {
        this.resParent = resParent;
    }
}