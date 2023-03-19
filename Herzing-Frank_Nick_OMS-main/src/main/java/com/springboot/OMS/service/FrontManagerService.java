package com.springboot.OMS.service;

import java.util.List;

import com.springboot.OMS.model.FrontService;

public interface FrontManagerService {
	
	List<FrontService> getAllFrontServices();
	void saveFrontService(FrontService front_service);
	FrontService getFrontServiceByID(long id);
	void deleteFrontServiceByID(long id);

}
