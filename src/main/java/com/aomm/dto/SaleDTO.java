package com.aomm.dto;

import java.util.List;

public class SaleDTO {
	
	private Long id;

	private String saleDocNo;
	
	private List< StockDTO > stocks;

	private Double totalPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSaleDocNo() {
		return saleDocNo;
	}

	public void setSaleDocNo(String saleDocNo) {
		this.saleDocNo = saleDocNo;
	}

	public List<StockDTO> getStocks() {
		return stocks;
	}

	public void setStocks(List<StockDTO> stocks) {
		this.stocks = stocks;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
