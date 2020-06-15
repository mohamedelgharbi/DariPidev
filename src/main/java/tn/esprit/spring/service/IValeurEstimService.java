package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.ValeurEstim;

public interface IValeurEstimService {

	
	public int addEstimVal(ValeurEstim valeurEstim);
	
	public int getestimnumber();
	
	public List<String> getAllValEsti();
	
	public List<ValeurEstim> getAll();
	
	public int getValsNumberJPQL();
	
}
