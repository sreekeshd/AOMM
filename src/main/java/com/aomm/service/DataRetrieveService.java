package com.aomm.service;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.aomm.entity.StockEntity;

@Service
public interface DataRetrieveService {

	DataTablesOutput<StockEntity> getStocks(DataTablesInput input);

}
