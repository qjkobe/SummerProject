package com.qjkobe.db.model;

import java.util.Date;

public class Orderlist extends Pojo {
    private String oid;

    private String sid;

    private String cid;

    private String gid;

    private String rid;

    private Integer expense;

    private Date xiadantime;

    private Integer status;

    private String destination;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
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