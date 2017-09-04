package com.aomm.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aomm.entity.SaleEntity;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long>, DataTablesRepository<SaleEntity, Long> {

}