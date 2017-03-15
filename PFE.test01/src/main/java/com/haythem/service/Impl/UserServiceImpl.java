package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haythem.dao.UserDao;
import com.haythem.persistance.Patient;
import com.haythem.persistance.Role;
import com.haythem.persistance.Supervisor;
import com.haythem.persistance.User;
import com.haythem.service.InformationService;
import com.haythem.service.MesureService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.PatientSeanceDaysService;
import com.haythem.service.PatientService;
import com.haythem.service.RoleService;
import com.haythem.service.SupervisorService;
import com.haythem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userRepository;

	@Resource
	private InformationService informationService;

	@Resource
	private RoleService roleService;

	@Resource
	private SupervisorService supervisorService;

	@Resource
	private PatientService patientService;

	@Autowired
	private MesureService measurementService;

	@Autowired
	private ApplicationMailer applicationMailer;
	@Autowired
	PatientDetailsService patientDetailsService;
	@Autowired
	PatientSeanceDaysService patientSeanceDaysService;

	// @Override
	// @Transactional
	// public void save(User user) {
	//
	// // Role role = roleService.
	// Role role = roleService.findByRole("Admin");
	// user = findOne(3L);
	// user.getRoles().add(role);
	// save(user);
	//
	// }

	@Override
	@Transactional
	public void save() {
		System.out.println("**************Start SAVE ***************");
		User user = findOne(3L);
		Role role = roleService.findOne(1);
		System.out.println(role.getRole());
		user.getRoles().add(role);
		save(user);
		System.out.println("**************End SAVE ***************");
		// TODO Auto-generated method stub
	}

	@Override
	public User findOne(Long id) {

		User user = userRepository.findOne(id);
		return user;
	}

	@Override
	public void delete(Long CIN) {
		// TODO Auto-generated method stub

		User user = findOne(CIN);

		if (user.getRoles().get(0).getId() == 1) {

			System.out.println("*****************1*************");

		} else if (user.getRoles().get(0).getId() == 2) {
			System.out.println("****************2*************");

			try {
				Patient patient = patientService.findByUserLike(user);
				patientSeanceDaysService.deleteAllByUser(user);
				supervisorService.deleteAllByPatient(patient);
				measurementService.deleteAllByPatient(patient);
				patientService.delete(patient.getId());
				
				
			} catch (Exception e) {
				// TODO: handle exception
				// throw new IllegalArgumentException();
			}

			// (supervisorService.findByPatientLike(patient).getId());

		} else if (user.getRoles().get(0).getId() == 3) {
			System.out.println("*****************3*************");
			try {
				supervisorService.deleteAllByUser(user);

			} catch (Exception e) {
				// TODO: handle exception
				// throw new IllegalArgumentException();
			}

		}

		System.out.println("*****************4*************");

		user.getRoles().clear();
		save(user);
		try {
			patientDetailsService.delete(patientDetailsService.findByUserLike(user).getId());
			informationService.delete(informationService.findByuserLike(user)
					.getId());

		} catch (Exception e) {
			// TODO: handle exception
			// throw new IllegalArgumentException();
		}

		userRepository.delete(CIN);

	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public void saveUser(int i, String name, String password) {
		
		if(findByUsernameLike(name)==null){
		System.out.println("**************Start SAVE ***************");

		ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
		String hash = sha.encodePassword(password, name);

		User user = new User(name, hash, null);
		save(user);
		user = findOne(user.getId());
		if (i == 1) {
			Role role = roleService.findOne(1);
			user.getRoles().add(role);
		} else if (i == 2) {
			Role role = roleService.findOne(2);
			user.getRoles().add(role);
		} else if (i == 3) {

			Role role = roleService.findOne(3);
			user.getRoles().add(role);
		}

		save(user);
		System.out.println("**************end SAVE ***************");
		}else{
			
			System.out.println("************user name in use***************");
			
		}
	}

	@Override
	@Transactional
	public void save(User user) {
		userRepository.save(user);

	}

	@Modifying
	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	// @Transactional(propagation=Propagation.REQUIRED)
	public User editUser(Long id, String name, String password) {
		System.out.println("*******************start update**********");
		ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
		String hash = sha.encodePassword(password, name);

		User user = findOne(id);
		System.out.println("*******************user name**********" + id);
		System.out.println(user.getUsername());
		user.setUsername(name);
		user.setPassword(hash);
		userRepository.save(user);

		System.out.println("*******************end update**********");
		return user;
	}

	@Override
	public User findByUsernameLike(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUsernameLike(userName);
	}

	@Override
	public List<User> findByRolesLike(String role) {
		// TODO Auto-generated method stub
		return userRepository.findByRolesLike(role);
	}

	@Override
	public List<String> findAllSupervisor() {
		List<String> findAllSupervisor = new ArrayList<String>();
		for (User u : findAll()) {
			if (u.getRoles().get(0).getId() == 3) {
				findAllSupervisor.add(u.getUsername());
			}
		}
		return findAllSupervisor;
	}

	@Override
	public void savePatienSupervisor(String patientName, String supervisorName,
			String supervisorPassword) {

		if (findByUsernameLike(supervisorName) != null) {

			// supervisorName exist

		} else {

			ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
			String hash = sha
					.encodePassword(supervisorPassword, supervisorName);
			User user = new User(supervisorName, hash, null);
			save(user);
			user = findOne(user.getId());
			Role role = roleService.findOne(3);
			user.getRoles().add(role);
			supervisorService.save(patientName, supervisorName);
			save(user);
		}

	}

	@Override
	public List<String> userStat() {

		List<String> stat = new ArrayList<String>();
		int adm = 0, pat = 0, sup = 0;

		for (User u : findAll()) {
			if (u.getRoles().get(0).getId() == 1) {
				adm = adm + 1;
			}
			if (u.getRoles().get(0).getId() == 2) {
				pat = pat + 1;
			}
			if (u.getRoles().get(0).getId() == 3) {
				sup = sup + 1;
			}
		}

		stat.add(Integer.toString(adm));
		stat.add(Integer.toString(pat));
		stat.add(Integer.toString(sup));
		return stat;
	}

	@Override
	public String getMeasurOfPatient() {
		String userName = (String) SecurityContextHolder.getContext()
				.getAuthentication().getName();
		return userName;
	}

	@Override
	public List<String> getNameListOfSupervised() {
		String userName = (String) SecurityContextHolder.getContext()
				.getAuthentication().getName();
		User user = findByUsernameLike(userName);
		ArrayList<String> test = new ArrayList<String>();

		if (user.getRoles().get(0).getId() == 2) {
			test.add(userName);

		} else if (user.getRoles().get(0).getId() == 1) {
			for (User u : findAll()) {
				if (u.getRoles().get(0).getId() == 2) {

					test.add(u.getUsername());
				}

			}

		}

		else {

			List<Supervisor> su = supervisorService.findAllByUserLike(user);
			for (Supervisor u : su) {

				test.add(u.getPatient().getUser().getUsername());
			}
		}

		return test;
	}

	@Override
	public String getNewPassword(String email) {
		
		int len = 8;
		char[] pwd = new char[len];
		int c = 'A';
		int rand = 0;
		for (int i = 0; i < 8; i++) {
			rand = (int) (Math.random() * 3);
			switch (rand) {
			case 0:
				c = '0' + (int) (Math.random() * 10);
				break;
			case 1:
				c = 'a' + (int) (Math.random() * 26);
				break;
			case 2:
				c = 'A' + (int) (Math.random() * 26);
				break;
			}
			pwd[i] = (char) c;
		}
		
		try {
			System.out.println("******************");
			System.out.println(informationService.findByemailLike(email));
			User user =informationService.findByemailLike(email).getUser();
			
			//String email = informationService.findByuserLike(user).getEmail();

			applicationMailer.sendMail(email , "Educanet Watch  : New Password" , "user name is : "+user.getUsername()
					+" and password is : "+pwd.toString());
			ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
			String hash = sha.encodePassword(pwd.toString(), user.getUsername());
			user.setPassword(hash);
			save(user);
			System.out.println("******************");
			return "passWordRecSucc";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "passWordRecFail";
	}

	@Override
	public String existUser(String username) {
		// TODO Auto-generated method stub
	if (findByUsernameLike(username)!=null){
	
		return "Username Already Exists";
	}
	return "";
		
	}

}
