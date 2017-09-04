package com.aomm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Component;

import com.aomm.entity.StockEntity;
import com.aomm.repository.SaleRepository;
import com.aomm.repository.StockRepository;
import com.aomm.service.DataRetrieveService;

@Component
public class DataRetrieveServiceImpl implements DataRetrieveService{

	@Autowired
	StockRepository stockRepo;

	@Autowired
	SaleRepository saleRepo;

	public DataTablesOutput<StockEntity> getStocks( DataTablesInput input ) {
		return stockRepo.findAll( input );
	}
	
}
