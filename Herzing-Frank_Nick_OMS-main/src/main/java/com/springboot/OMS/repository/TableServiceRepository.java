package com.springboot.OMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.OMS.model.TableService;

@Repository
public interface TableServiceRepository extends JpaRepository<TableService, Long> {

}
