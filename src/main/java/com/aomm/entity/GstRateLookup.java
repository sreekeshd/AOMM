package com.aomm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "GST_RATE_LOOKUP")
public class GstRateLookup {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "rateDesc")
	private String rate;
	
	@Column(name = "ratePercent")
	@JsonView(DataTablesOutput.View.class)
	private Float ratePercent;

	public GstRateLookup() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRate() {
		return rate;
	}

	public GstRateLookup(Long id) {
		super();
		this.id = id;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Float getRatePercent() {
		return ratePercent;
	}

	public void setRatePercent(Float ratePercent) {
		this.ratePercent = ratePercent;
	}

	@Override
	public String toString() {
		return "GstRateLookup [id=" + id + ", rate=" + rate + ", ratePercent=" + ratePercent + "]";
	}

}
