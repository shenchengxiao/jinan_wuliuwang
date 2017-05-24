package com.ontime.response;

import java.io.Serializable;

/**
 * Created by shencx on 2017/5/18.
 */
public class AdminInfoResponse implements Serializable{

    private Integer id;

    private String userName;

    private Integer beUsed;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getBeUsed() {
        return beUsed;
    }

    public void setBeUsed(Integer beUsed) {
        this.beUsed = beUsed;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AdminInfoResponse{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", beUsed=").append(beUsed);
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
