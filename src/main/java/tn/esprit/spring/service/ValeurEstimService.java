package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.ValeurEstim;
import tn.esprit.spring.repository.ValeurEstimRepository;

@Service
public class ValeurEstimService implements IValeurEstimService {
	@Autowired
	ValeurEstimRepository valeurEstimRepository;

	@Override
	public int addEstimVal(ValeurEstim valeurEstim) {
		valeurEstimRepository.save(valeurEstim);
		return valeurEstim.getId();
	}

	@Override
	public int getestimnumber() {
		// TODO Auto-generated method stub
		return valeurEstimRepository.countval();
	}

	@Override
	public List<String> getAllValEsti() {
		// TODO Auto-generated method stub
		return valeurEstimRepository.estimValAll();
	}

	@Override
	public List<ValeurEstim> getAll() {
		// TODO Auto-generated method stub
		return (List<ValeurEstim>) valeurEstimRepository.findAll();
	}

	@Override
	public int getValsNumberJPQL() {
		
		return valeurEstimRepository.countval();
	}
	
	
	

}
