package com.devsuperior.dsmeta.dto;

public class SummaryDTO {
    private String sellerName;
    private Double total;

    public SummaryDTO() {
    }

    public SummaryDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public String getsellerName() {
        return sellerName;
    }

    public void setsellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double gettotal() {
        return total;
    }

    public void settotal(Double total) {
        this.total = total;
    }
}
