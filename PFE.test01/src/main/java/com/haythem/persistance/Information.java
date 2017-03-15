package com.haythem.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
@Table(name = "information",uniqueConstraints = {
		@UniqueConstraint(columnNames = { "USER_ID", "id" })})
public class Information extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "IDENTITY_CARD_NUMBER")
	private int identityCardNumber;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "BIRTHDAY")
	private String birthday;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@ManyToOne(optional = true)
	@JoinColumn(name = "ADRESS_ID", unique = true)
	private Adress adress;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "USER_ID", unique = true)
	private User user;


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


	public Adress getAdress() {
		return adress;
	}


	public void setAdress(Adress adress) {
		this.adress = adress;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Information(int identityCardNumber, String firstName,
			String lastName, String email, String birthday,String phoneNumber, String gender,
			 Adress adress, User user) {
		this.identityCardNumber = identityCardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		this.user = user;
	}


	public Information() {
	}

	
	
	
	

}
