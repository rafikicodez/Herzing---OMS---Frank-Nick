package com.springboot.OMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.OMS.model.FrontService;

@Repository
public interface FrontServiceRepository extends JpaRepository<FrontService, Long> {

}
