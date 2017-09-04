package com.aomm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@MappedSuperclass
public class BaseDetailsEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	@JsonView(DataTablesOutput.View.class)
	private Long id;

	@Column(name = "CRTD_DATE")
	private Date createdDate;

	@Column(name = "UPTD_DATE")
	private Date updatedDate;

	@Column(name = "DLTD_DATE")
	private Date deletedDate;

	@Column(name = "IS_DLTD", columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
	private boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setBaseAttributes() {
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}

	public void setUpdateAttributes() {
		this.updatedDate = new Date();
	}

	public void setDeleteAttributes() {
		this.updatedDate = new Date();
		this.deletedDate = new Date();
		this.deleted = true;
	}

	@Override
	public String toString() {
		return "BaseDetailsEntity [id=" + id + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", deletedDate=" + deletedDate + ", deleted=" + deleted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDetailsEntity other = (BaseDetailsEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}