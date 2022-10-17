package com.abadia.services;



import java.util.ArrayList;
import java.util.Iterator;
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
	

	
	public List<ActivityRegister> getAllData() {
		
		return (List<ActivityRegister>) activityRegister.findAll();




					
	}
	

	
	public ActivityRegister save(ActivityRegister activityModel) {
		return activityRegister.save(activityModel);
		
	}
	
	public List<ActivityRegister> findAllByIP(String ip) {
		List<ActivityRegister> actiRegiRespuesta = new ArrayList<>();
		List<ActivityRegister> registers = (List<ActivityRegister>) activityRegister.findAll();
		
		for (int i= 0; i < registers.size(); i++) {
			if (registers.get(i).getIp() == ip) {
				actiRegiRespuesta.add(registers.get(i));
			}
		}
		
		return actiRegiRespuesta;
		
	}

	public int countByIp(String ip){

		List<ActivityRegister> actiRegiRespuesta = new ArrayList<>();
		List<ActivityRegister> registers = (List<ActivityRegister>) activityRegister.findAll();

		for (int i= 0; i < registers.size(); i++) {
			if (registers.get(i).getIp() == ip) {
				actiRegiRespuesta.add(registers.get(i));
			}
		}
		return actiRegiRespuesta.size();
	}
}
