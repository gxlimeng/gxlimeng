package com.duopei.other.transaction.model;

import java.util.Date;

public class Stock extends StockKey {
    private Double qty;

    private String operGrogram;

    private String insertId;

    private Date insertDate;

    private String modifyId;

    private Date modifyDate;

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getOperGrogram() {
        return operGrogram;
    }

    public void setOperGrogram(String operGrogram) {
        this.operGrogram = operGrogram == null ? null : operGrogram.trim();
    }

    public String getInsertId() {
        return insertId;
    }

    public void setInsertId(String insertId) {
        this.insertId = insertId == null ? null : insertId.trim();
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getModifyId() {
        return modifyId;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId == null ? null : modifyId.trim();
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}