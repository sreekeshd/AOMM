package com.aomm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "SALE")
@Where(clause="is_active=1")
public class SaleEntity extends BaseDetailsEntity{

	@Column(name="SALE_DOC_NO")
	@JsonView(DataTablesOutput.View.class)
	private String saleDocNo;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "SALE_STOCK_TABLE", joinColumns = @JoinColumn(name = "STOCK_ID"), inverseJoinColumns = @JoinColumn(name = "SALE_ID"))
	private List< StockEntity > stocks;

	@Column(name="TOTAL_PRICE")
	@JsonView(DataTablesOutput.View.class)
	private Double totalPrice;
	
	public String getSaleDocNo() {
		return saleDocNo;
	}

	public void setSaleDocNo(String saleDocNo) {
		this.saleDocNo = saleDocNo;
	}

	public List<StockEntity> getStocks() {
		return stocks;
	}

	public void setStock(List<StockEntity> stocks) {
		this.stocks = stocks;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "SaleEntity [saleDocNo=" + saleDocNo + ", stocks=" + stocks + ", totalPrice=" + totalPrice
				+ ", toString()=" + super.toString() + "]";
	}
	
}
