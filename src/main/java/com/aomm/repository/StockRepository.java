package com.aomm.repository;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aomm.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long>, DataTablesRepository<StockEntity, Long> {

	@Query("select CASE WHEN COUNT(se.id) >=1 THEN TRUE ELSE FALSE END "
			+ "FROM StockEntity se WHERE se.stockCode LIKE :stockCode OR se.stockDesc = :stockDesc ")
	Boolean checkIfStockCodeOrStockDescAlreadyExists( 
			@Param("stockCode") String stockCode,
			@Param("stockDesc") String stockDesc );

	DataTablesOutput<StockEntity> findAllByOrderByUpdatedDateDescStockCodeAsc();

}