package com.abadia.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abadia.entity.ActivityRegister;
import com.abadia.repository.IActivityRegisterRepository;



@Service
public class ActivityRegisterService {
	
	
	@Autowired
	private IActivityRegisterRepository activityRegister;
	

	
	public ArrayList<ActivityRegister> getAllData() {
		
		return (ArrayList<ActivityRegister>) activityRegister.findAll();
					
	}
	

	
	public void save(ActivityRegister activityModel) {
		activityRegister.save(activityModel);
		
	}
	
	public Optional<ActivityRegister> getByid(String id) {
		return (Optional<ActivityRegister> ) activityRegister.findById(id);
	}
	
}
