package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

public class ReportDTO {
    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;

    public ReportDTO() {
    }

    public ReportDTO(Long id, LocalDate date, Double amount, String sellerName) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sellerName = sellerName;
    }

    public ReportDTO(Sale entity) {
        this.id = entity.getId();
        this.sellerName = entity.getSeller().getName();
        this.date = entity.getDate();
        this.amount = entity.getAmount();
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Long getId() {
        return id;
    }
}
