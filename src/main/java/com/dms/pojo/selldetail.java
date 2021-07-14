package com.dms.pojo;

import java.util.Date;

public class selldetail {
    private int id;
    private String sellName;
    private double sellPrice;
    private int sellCount;
    private Date sellTime;
    private int medid;
    private int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    public int getMedid() {
        return medid;
    }

    public void setMedid(int medid) {
        this.medid = medid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
