package com.qjkobe.db.model;

import java.util.Date;

public class Orderlist extends Pojo {
    private Integer oid;

    private Integer sid;

    private Integer cid;

    private Integer gid;

    private Integer rid;

    private Integer expense;

    private Date xiadantime;

    private Integer status;

    private String destination;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getExpense() {
        return expense;
    }

    public void setExpense(Integer expense) {
        this.expense = expense;
    }

    public Date getXiadantime() {
        return xiadantime;
    }

    public void setXiadantime(Date xiadantime) {
        this.xiadantime = xiadantime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}