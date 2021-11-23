package com.it.iotplatform.model;

import java.util.Date;
/**
 * 基础字段类，所有业务实体类都应该继承此类
 * @author luojiajia
 * @since 1.0
 * @date 2021/11/17 22:39
 */
public class BaseModel {
    protected String createUser;
    protected Date createTime;
    protected String updateUser;
    protected Date updateTime;
    protected int state;
    protected Integer page;
    protected Integer pageSize;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}