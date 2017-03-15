package com.haythem.service;

import java.util.List;





import com.haythem.persistance.User;

public interface UserService {

	public void save(User user);

	public void save();

	public User findOne(Long CIN);

	public void delete(Long id);

	public User editUser(Long id, String name, String password);

	public List<User> findAll();

	public void saveUser(int i, String name, String password);

	public User findByUsernameLike(String userName);
	
	public String getNewPassword(String email);

	public List<User> findByRolesLike(String role);

	public List<String> findAllSupervisor();

	public void savePatienSupervisor(String patientName, String supervisorName,
			String supervisroPassword);
	
	public List<String> userStat();

	public String getMeasurOfPatient();

	public List<String> getNameListOfSupervised();

	public String existUser(String username);
	
	

}
