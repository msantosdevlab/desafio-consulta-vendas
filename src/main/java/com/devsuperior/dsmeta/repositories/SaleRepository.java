package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
        @Query(value = "SELECT s FROM Sale s WHERE s.date BETWEEN :minDate AND :maxDate AND UPPER(s.seller.name) LIKE UPPER(CONCAT('%', :sellerName, '%'))")
        Page<Sale> getReport(LocalDate minDate, LocalDate maxDate, String sellerName, Pageable pageable);

        @Query(value = "SELECT new com.devsuperior.dsmeta.dto.SummaryDTO(obj.seller.name, SUM(obj.amount)) "
                        + "FROM Sale obj WHERE obj.date BETWEEN :minDate AND :maxDate GROUP BY obj.seller.name")
        List<SummaryDTO> getSummary(LocalDate minDate, LocalDate maxDate, Pageable pageable);
}
