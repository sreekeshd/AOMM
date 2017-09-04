package com.aomm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.aomm.dto.SaleDTO;
import com.aomm.dto.StockDTO;
import com.aomm.entity.GstRateLookup;
import com.aomm.entity.SaleEntity;
import com.aomm.entity.StockEntity;
import com.aomm.repository.GstRateLookupRepository;
import com.aomm.repository.SaleRepository;
import com.aomm.repository.StockRepository;
import com.aomm.service.DataPersistService;
import com.aomm.util.Constants;

@Component
public class DataPersistServiceImpl implements DataPersistService {

	@Autowired
	StockRepository stockRepo;

	@Autowired
	SaleRepository saleRepo;

	@Autowired
	GstRateLookupRepository gstRateLookupRepo;

	public ResponseEntity<Map<String, String>> addOrUpdateStock( StockDTO stockDTO ) {
		ResponseEntity responseEntity = null;
		Map<String, String> responseMap = new HashMap<String, String>();
		StockEntity stock = null;
		try {
			if ( stockDTO.getId() == null ) {
				stock = new StockEntity();
				stock = addNewStock( stockDTO, stock );
			} else {
				stock = stockRepo.findOne( stockDTO.getId() );
				stock = updateStock( stockDTO, stock );
			}
			stockRepo.saveAndFlush(stock);
			responseMap.put(Constants.STATUS_MESSAGE, Constants.SUCCESS);
			responseEntity = new ResponseEntity<Map<String, String>>( responseMap, HttpStatus.OK );
		} catch ( Exception e ) {
			responseMap.put(Constants.STATUS_MESSAGE, e.getMessage());
			responseEntity = new ResponseEntity<Map<String, String>>( responseMap, HttpStatus.OK );
		}
		return responseEntity;
	}

	private StockEntity addNewStock( StockDTO stockDTO, StockEntity stock ) throws Exception {
		stock = checkIfValidStockAndSetValues( stockDTO, stock );
		stock = setGstRatePc( stockDTO, stock );
		stock.setBaseAttributes();
		return stock;
	}

	private StockEntity checkIfValidStockAndSetValues( StockDTO stockDTO, StockEntity stock ) throws Exception {
		Boolean stockValidityCheck = 
				stockRepo.checkIfStockCodeOrStockDescAlreadyExists( 
						stockDTO.getStockCode(), stockDTO.getStockDesc() );
		if( stockValidityCheck.equals( Constants.FALSE )){
			stock = setCommonAttributes( stockDTO, stock );
		}else{
			throw new Exception( Constants.INVALID_STOCK_CODE_DESC );
		}
		return stock;
	}

	private StockEntity updateStock(StockDTO stockDTO, StockEntity stock) throws Exception {
		stock = checkIfValidStockAndSetValues( stockDTO, stock );
		stock = setGstRatePc( stockDTO, stock );
		stock.setUpdateAttributes();
		return stock;

	}

	private StockEntity setGstRatePc(StockDTO stockDTO, StockEntity stock) {
		GstRateLookup gstRatePC = new GstRateLookup( stockDTO.getGstRateLookupId() );
		stock.setGstRatePC( gstRatePC );
		return stock;
	}

	public StockEntity setCommonAttributes( StockDTO stockDTO, StockEntity stock ) {
		stock.setStockCode( stockDTO.getStockCode() );
		stock.setStockDesc( stockDTO.getStockDesc() );
		stock.setPrice( stockDTO.getPrice() );
		stock.setGstPrice( stockDTO.getGstPrice() );
		stock.setQuantity( stockDTO.getQuantity() );
		return stock;

	}

	public ResponseEntity<Map<String, String>> addOrUpdateSale( SaleDTO saleDTO ) {
		ResponseEntity responseEntity = null;
		Map<String, String> responseMap = new HashMap<String, String>();
		SaleEntity sale = null;
		try {
			if ( saleDTO.getId() == null ) {
				sale = new SaleEntity();
				sale = addNewSale( saleDTO, sale );
			} else {
				sale = updateSale( saleDTO, sale );
			}
			sale = saleRepo.saveAndFlush( sale );
			responseMap.put( Constants.STATUS, Constants.SUCCESS );
			responseMap.put( Constants.STATUS_MESSAGE, Constants.SUCCESS );
			responseEntity = new ResponseEntity<Map<String, String>>( responseMap, HttpStatus.OK );
		} catch ( Exception e ) {
			responseMap.put( Constants.STATUS_MESSAGE, e.getMessage() );
			responseEntity = new ResponseEntity<Map<String, String>>( responseMap, HttpStatus.OK );
		}
		return responseEntity;
	}

	private SaleEntity updateSale( SaleDTO saleDTO, SaleEntity sale ) throws Exception {
		sale = checkIfValidAndSetStock( saleDTO, sale );
		sale.setTotalPrice( saleDTO.getTotalPrice() );
		sale.setUpdateAttributes();
		return sale;
	}

	private SaleEntity addNewSale( SaleDTO saleDTO, SaleEntity sale ) throws Exception {
		sale = checkIfValidAndSetStock( saleDTO, sale );
		sale.setTotalPrice( saleDTO.getTotalPrice() );
		sale.setBaseAttributes();
		return sale;
	}

	private SaleEntity checkIfValidAndSetStock( SaleDTO saleDTO, SaleEntity sale ) throws Exception {
		StockEntity stockEntity = null;
		ArrayList<StockDTO> stockList = (ArrayList<StockDTO>) saleDTO.getStocks();
		for ( StockDTO stockDTO : stockList ) {
			stockEntity = stockRepo.findOne(stockDTO.getId());
			if (stockDTO.getQuantity() > stockEntity.getQuantity()) {
				throw new Exception( Constants.INVALID_QUANTITY + stockEntity.getQuantity().toString() );
			}
		}
		return sale;
	}

}