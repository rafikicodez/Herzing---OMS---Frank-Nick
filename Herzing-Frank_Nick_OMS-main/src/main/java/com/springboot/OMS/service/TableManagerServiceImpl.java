package com.springboot.OMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.OMS.model.TableService;
import com.springboot.OMS.repository.TableServiceRepository;

@Service
public class TableManagerServiceImpl implements TableManagerService {
	
	@Autowired
	private TableServiceRepository table_repo;

	@Override
	public List<TableService> getAllTableServices() {
		// TODO Auto-generated method stub
		return table_repo.findAll();
	}

	@Override
	public void saveTableService(TableService table_service) {
		// TODO Auto-generated method stub
		this.table_repo.save(table_service);
	}

	@Override
	public TableService getTableServiceByID(long id) {
		Optional<TableService> optional = table_repo.findById(id);
		TableService table_service = null;
		if(optional.isPresent()) {
			table_service = optional.get();
		}else {
			throw new RuntimeException(" Table Service not found for id :: " + id);
		}
		return table_service;
	}

	@Override
	public void deleteTableServiceByID(long id) {
		this.table_repo.deleteById(id);
	}
}
