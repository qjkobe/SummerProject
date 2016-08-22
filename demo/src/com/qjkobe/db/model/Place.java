package com.qjkobe.db.model;

public class Place extends Pojo {
    private Integer pid;

    private String namex;

    private String namey;

    private Integer distance;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getNamex() {
        return namex;
    }

    public void setNamex(String namex) {
        this.namex = namex;
    }

    public String getNamey() {
        return namey;
    }

    public void setNamey(String namey) {
        this.namey = namey;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}