package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.ReportDTO;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<ReportDTO> getReport(String minDate, String maxDate, String sellerName, Pageable pageable) {
		LocalDate minD = verificaDatas(minDate, LocalDate.now().minusYears(1L));
		LocalDate maxD = verificaDatas(maxDate, LocalDate.now());
		Page<Sale> result = repository.getReport(minD, maxD, sellerName, pageable);
		return result.map(x -> new ReportDTO(x));
	}

	public List<SummaryDTO> getSummary(String minDate, String maxDate, Pageable pageable) {
		LocalDate minD = verificaDatas(minDate, LocalDate.now().minusYears(1L));
		LocalDate maxD = verificaDatas(maxDate, LocalDate.now());
		List<SummaryDTO> result = repository.getSummary(minD, maxD, pageable);
		return result;
	}

	private LocalDate verificaDatas(String dataEntrada, LocalDate valorPadrao) {
		if (dataEntrada != null && !dataEntrada.isEmpty()) {
			return LocalDate.parse(dataEntrada);
		} else {
			return valorPadrao;
		}
	}
}
