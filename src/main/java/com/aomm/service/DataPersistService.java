package com.aomm.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aomm.dto.SaleDTO;
import com.aomm.dto.StockDTO;

@Service
public interface DataPersistService {

	public ResponseEntity<Map<String, String>> addOrUpdateStock( StockDTO stockDTO );
	
	public ResponseEntity<Map<String, String>> addOrUpdateSale( SaleDTO saleDTO );
}
