package com.aomm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "STOCK")
@Where(clause="is_active=1")
public class StockEntity extends BaseDetailsEntity{

	@Column(name = "STK_CODE")
	@JsonView(DataTablesOutput.View.class)
	private String stockCode;

	@Column(name = "STK_DESC")
	@JsonView(DataTablesOutput.View.class)
	private String stockDesc;
	
	@Column(name = "PRICE")
	@JsonView(DataTablesOutput.View.class)
	private Double price;
	
	@Column(name = "QUANTITY")
	@JsonView(DataTablesOutput.View.class)
	private Integer quantity;

	@Column(name = "GST_PRICE")
	private Double gstPrice;
	
	@JoinColumn(name="GST_RATE_ID")
	@OneToOne(fetch=FetchType.EAGER)
	private GstRateLookup gstRatePC;

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockDesc() {
		return stockDesc;
	}

	public void setStockDesc(String stockDesc) {
		this.stockDesc = stockDesc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getGstPrice() {
		return gstPrice;
	}

	public void setGstPrice(Double gstPrice) {
		this.gstPrice = gstPrice;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public GstRateLookup getGstRatePC() {
		return gstRatePC;
	}

	public void setGstRatePC(GstRateLookup gstRatePC) {
		this.gstRatePC = gstRatePC;
	}

	@Override
	public String toString() {
		return "StockEntity [stockCode=" + stockCode + ", stockDesc=" + stockDesc + ", price=" + price + ", quantity="
				+ quantity + ", gstPrice=" + gstPrice + ", gstRatePC=" + gstRatePC + ", toString()=" + super.toString()
				+ "]";
	}
}
