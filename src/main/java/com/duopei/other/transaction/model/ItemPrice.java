package com.duopei.other.transaction.model;

public class ItemPrice extends ItemPriceKey {
    private Double salePrice;

    private Double saleCost;

    private Double saleVat;

    private Double saleRate;

    private Double buyPrice;

    private Double buyCost;

    private Double buyVat;

    private Double buyRate;

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getSaleCost() {
        return saleCost;
    }

    public void setSaleCost(Double saleCost) {
        this.saleCost = saleCost;
    }

    public Double getSaleVat() {
        return saleVat;
    }

    public void setSaleVat(Double saleVat) {
        this.saleVat = saleVat;
    }

    public Double getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(Double saleRate) {
        this.saleRate = saleRate;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getBuyCost() {
        return buyCost;
    }

    public void setBuyCost(Double buyCost) {
        this.buyCost = buyCost;
    }

    public Double getBuyVat() {
        return buyVat;
    }

    public void setBuyVat(Double buyVat) {
        this.buyVat = buyVat;
    }

    public Double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(Double buyRate) {
        this.buyRate = buyRate;
    }
}