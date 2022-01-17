package com.work.diddy.ui.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.work.diddy.domain.User;
import com.work.diddy.ui.dao.GeneralDao;

public class ServiceImp implements IService {
	
	public List<User> users= new ArrayList<>();
	
	public GeneralDao<User> dao = new GeneralDao<>(User.class);
	

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}


	@Override
	public void addUser(User usr) {
		// TODO Auto-generated method stub
		
		dao.create(usr);
		System.out.print(usr.getName()+" saved");
		
	}


	@Override
	public void delete(User usr) {
		// TODO Auto-generated method stub
		User us= dao.findById(usr.getId()); 
		dao.delete(us.getId());
		
	}


	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
	

}
