package com.haythem.service;

import java.util.List;

import com.haythem.model.InformationModel2;
import com.haythem.persistance.Information;
import com.haythem.persistance.User;

public interface InformationService {
	
	public void save(Information information);

	public Information findOne(Long idInformation);

	public void delete(Long id);

	public List<Information> findAll();
	

	public List<InformationModel2> findAll2();
	
	public Information findByuserLike(User user);

	public void saveInformation(String userId, int identityCardNumber,
			String firstName, String lastName, String email, String birthday,
			String phoneNumber, String gender, String adress, String country,
			String State);

	public void editInformation(Long id, int identityCardNumber,
			String firstName, String lastName, String email, String birthday,
			String phoneNumber, String gender, String adress, String country,
			String State);

	public void editPatientInformation(String userName, int identityCardNumber,
			String firstName, String lastName, String email, String birthday,
			String phoneNumber, String gender, String adress, String country,
			String State);

	public List<String> userNamesAv();
	
	public Information findByemailLike(String email);
}
