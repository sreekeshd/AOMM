package com.aomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aomm.entity.GstRateLookup;

@Repository
public interface GstRateLookupRepository extends JpaRepository<GstRateLookup, Long>{

}
