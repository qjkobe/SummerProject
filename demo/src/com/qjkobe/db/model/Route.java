package com.qjkobe.db.model;

public class Route extends Pojo {
    private String rid;

    private String place;

    private String daodatime;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDaodatime() {
        return daodatime;
    }

    public void setDaodatime(String daodatime) {
        this.daodatime = daodatime;
    }
}