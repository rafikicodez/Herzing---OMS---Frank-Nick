package com.springboot.OMS.service;

import java.util.List;

import com.springboot.OMS.model.TableService;

public interface TableManagerService {
	
	List<TableService> getAllTableServices();
	void saveTableService(TableService table_service);
	TableService getTableServiceByID(long id);
	void deleteTableServiceByID(long id);

}
