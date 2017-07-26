package com.wusiq.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 目录实体类
 */
public class PermissionEntity implements Serializable{
    private static final long serialVersionUID = -1365162799316911562L;

    private String resCode;//权限编号【以001开头的七尾数】
    private String resName;//权限名称【系统名_模块名(had)_页面(had)_按钮(had)】
    private String resContent;//权限内容【如果是目录，则是目录的实体类结构】
    private String resStatus;//权限状态【0-正常 1-删除】
    private String resType;//权限级别【sys-系统,module-模块,view-视图,button-按钮】
    private String resParent;//父权限编号【以001开头的七尾数】
    private String createUser;//资料创建人员编号
    private Date createDate;//资料创建时间【YYYY-MM-DD HH:MM:SS】
    private String updateUser;//最近修改人员编号
    private Date updateDate;//最近修改时间【YYYY-MM-DD HH:MM:SS】
    private String resDescription;//权限描述
    private Integer resSequence;//权限序号
    private String resState;//是否打开目录(easyui的目录树：0-open,1-close)

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

    public String getResContent() {
        return resContent;
    }

    public void setResContent(String resContent) {
        this.resContent = resContent;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getResDescription() {
        return resDescription;
    }

    public void setResDescription(String resDescription) {
        this.resDescription = resDescription;
    }

    public Integer getResSequence() {
        return resSequence;
    }

    public void setResSequence(Integer resSequence) {
        this.resSequence = resSequence;
    }

    public String getResState() {
        return resState;
    }

    public void setResState(String resState) {
        this.resState = resState;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"resCode\":\"")
                .append(resCode).append('\"');
        sb.append(",\"resName\":\"")
                .append(resName).append('\"');
        sb.append(",\"resContent\":\"")
                .append(resContent).append('\"');
        sb.append(",\"resStatus\":\"")
                .append(resStatus).append('\"');
        sb.append(",\"resType\":\"")
                .append(resType).append('\"');
        sb.append(",\"resParent\":\"")
                .append(resParent).append('\"');
        sb.append(",\"createUser\":\"")
                .append(createUser).append('\"');
        sb.append(",\"createDate\":\"")
                .append(createDate).append('\"');
        sb.append(",\"updateUser\":\"")
                .append(updateUser).append('\"');
        sb.append(",\"updateDate\":\"")
                .append(updateDate).append('\"');
        sb.append(",\"resDescription\":\"")
                .append(resDescription).append('\"');
        sb.append(",\"resSequence\":")
                .append(resSequence);
        sb.append(",\"resState\":\"")
                .append(resState).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
