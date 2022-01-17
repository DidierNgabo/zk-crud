package com.work.diddy.ui.service;

import java.util.List;

import com.work.diddy.domain.User;

public interface IService {

	public List<User> findAll();
	
	public void addUser(User usr);
	
	public void delete(User usr);
	
	public void update(User user);
	
}
