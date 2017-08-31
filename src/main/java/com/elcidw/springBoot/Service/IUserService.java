package com.elcidw.springBoot.Service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.elcidw.springBoot.Entity.User;

@Repository
public interface IUserService {
	
	 public List<User> findAll();

	    public void saveUser(User book);
	   
	    public User findOne(long id);

	    public void delete(long id);

	    public List<User> findByName(String name);

}
