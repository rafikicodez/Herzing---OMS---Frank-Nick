package com.springboot.OMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.OMS.model.FrontService;
import com.springboot.OMS.repository.FrontServiceRepository;

@Service
public class FrontManagerServiceImpl implements FrontManagerService {
	
	@Autowired
	private FrontServiceRepository front_repo;

	@Override
	public List<FrontService> getAllFrontServices() {
		// TODO Auto-generated method stub
		return front_repo.findAll();
	}

	@Override
	public void saveFrontService(FrontService front_service) {
		// TODO Auto-generated method stub
		this.front_repo.save(front_service);
	}

	@Override
	public FrontService getFrontServiceByID(long id) {
		Optional<FrontService> optional = front_repo.findById(id);
		FrontService front_service = null;
		if(optional.isPresent()) {
			front_service = optional.get();
		}else {
			throw new RuntimeException(" Front Service not found for id :: " + id);
		}
		return front_service;
	}

	@Override
	public void deleteFrontServiceByID(long id) {
		this.front_repo.deleteById(id);
	}
}
