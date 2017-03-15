package com.haythem.model;




public class InformationModel {
	

	
	
	private AdressModel adress;
	private UserModel user;
	private int identityCardNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String birthday;
	private String gender;
	private String phoneNumber;
	private PatientDetailsModel patientDetailsModel;
	
	
	
	
	
	
	public PatientDetailsModel getPatientDetailsModel() {
		return patientDetailsModel;
	}
	public void setPatientDetailsModel(PatientDetailsModel patientDetailsModel) {
		this.patientDetailsModel = patientDetailsModel;
	}
	public AdressModel getAdress() {
		return adress;
	}
	public void setAdress(AdressModel adress) {
		this.adress = adress;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public int getIdentityCardNumber() {
		return identityCardNumber;
	}
	public void setIdentityCardNumber(int identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public InformationModel(AdressModel adress, UserModel user,
			int identityCardNumber, String firstName, String lastName,
			String email, String birthday, String gender, String phoneNumber,
			PatientDetailsModel patientDetailsModel) {
		super();
		this.adress = adress;
		this.user = user;
		this.identityCardNumber = identityCardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.patientDetailsModel = patientDetailsModel;
	}
	public InformationModel() {
	}
	
	

}
