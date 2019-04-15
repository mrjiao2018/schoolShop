package edu.whu.iss.mrjiao.schoolShop.vo;

import java.util.Date;

/**
 * 学校周围区域实体类，不同区域有不同的名称和展示优先级
 */
public class Area {
    //id，使用引用类型时为了防止类加载的时候默认初始化，比如 Int 会初始化为0，现在希望空就是空
    private Integer areaId;
    //名称
    private String areaName;
    //权重
    private Integer priority;
    //创建时间
    private Date createTime;
    //修改时间
    private Date lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return lastEditTime;
    }

    public void setUpdateTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
