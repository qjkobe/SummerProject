package com.qjkobe.db.model;

public class TVisitNum extends Pojo {
    private String id;

    private String userid;

    private Integer dayvisit;

    private Integer allvisit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getDayvisit() {
        return dayvisit;
    }

    public void setDayvisit(Integer dayvisit) {
        this.dayvisit = dayvisit;
    }

    public Integer getAllvisit() {
        return allvisit;
    }

    public void setAllvisit(Integer allvisit) {
        this.allvisit = allvisit;
    }
}