package com.haythem.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.haythem.model.InformationModel;
import com.haythem.model.PatientModel;
import com.haythem.model.SupervisorModel;
import com.haythem.model.UserModel;
import com.haythem.service.AdressService;
import com.haythem.service.CliniqueService;
import com.haythem.service.InformationService;
import com.haythem.service.MesureService;
import com.haythem.service.PatientService;
import com.haythem.service.RealTimeMeasur;
import com.haythem.service.RoleService;
import com.haythem.service.SupervisorService;
import com.haythem.service.UserService;
import com.haythem.service.WatchService;
import com.haythem.service.Impl.ApplicationMailer;
import com.haythem.service.Impl.FileService;

@Controller
public class PatientUserController {
	@Autowired
	private PatientService patientService;

	@Autowired
	private FileService FileService;

	@Autowired
	private UserService userService;

	@Autowired
	private InformationService informationService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AdressService adressService;

	@Autowired
	private WatchService watchService;

	@Autowired
	private MesureService measurementService;

	@Autowired
	private SupervisorService supervisorService;
	
	@Autowired
	private ApplicationMailer applicationMailer;
	
	@Autowired
	private RealTimeMeasur realTimeMeasur;
	@Autowired
	private CliniqueService cliniqueService;
	
	@RequestMapping(value = "/PatientUser", method = RequestMethod.GET)
	public String PatientUser(Model model) throws IOException {
		String userName = (String) SecurityContextHolder.getContext().getAuthentication().getName();
	    model.addAttribute("supervisorPatientList", supervisorService.findAllByPatientLike(patientService.findByUserLike(userService.findByUsernameLike(userName))));
		model.addAttribute("informationPatient", informationService.findByuserLike(userService.findByUsernameLike(userName)));
		model.addAttribute("measurementPatient", measurementService.findAllMesureByPatient(userName));
		model.addAttribute("userOne",userService.findByUsernameLike(userName));
		model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("UserModel", new UserModel());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("supervisorModel", new SupervisorModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "PatientUser";
	}

	@RequestMapping(value = "/editPatientUser", method = RequestMethod.POST)
	public String editPatientUser(
			@ModelAttribute("SpringWeb") UserModel userModel, ModelMap model,
			@RequestParam Long id) {
		
		
		String userName = (String) SecurityContextHolder.getContext().getAuthentication()
		.getName();
        
		Long idP = (Long)Long.parseLong(userModel.getId());

		userService.editUser(idP, userModel.getUsername(),
				userModel.getPassword());
	
		model.addAttribute("supervisorPatientList", supervisorService.findAllByPatientLike(patientService.findByUserLike(userService.findByUsernameLike(userName))));
		model.addAttribute("informationPatient", informationService.findByuserLike(userService.findByUsernameLike(userName)));
		model.addAttribute("measurementPatient", measurementService.findAllMesureByPatient(userName));
		model.addAttribute("userOne",userService.findByUsernameLike(userName));
		model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("UserModel", new UserModel());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("supervisorModel", new SupervisorModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "PatientUser";
	}

	@RequestMapping(value = "/editPatientInformation", method = RequestMethod.POST)
	public String editPatientInformation(
			@ModelAttribute("SpringWeb") InformationModel InformationModel,
			ModelMap model, @RequestParam Long id) {
String userName = (String) SecurityContextHolder.getContext().getAuthentication()
.getName();
		informationService.editPatientInformation(
				userName, InformationModel.getIdentityCardNumber(),
				InformationModel.getFirstName(),
				InformationModel.getLastName(), InformationModel.getEmail(),
				InformationModel.getBirthday(), InformationModel
						.getPhoneNumber(), InformationModel.getGender(),
				InformationModel.getAdress().getAdress(), InformationModel
						.getAdress().getCountry(), InformationModel.getAdress()
						.getState());
		model.addAttribute("supervisorPatientList", supervisorService.findAllByPatientLike(patientService.findByUserLike(userService.findByUsernameLike(userName))));
		model.addAttribute("informationPatient", informationService.findByuserLike(userService.findByUsernameLike(userName)));
		model.addAttribute("measurementPatient", measurementService.findAllMesureByPatient(userName));
		model.addAttribute("userOne",userService.findByUsernameLike(userName));
		model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("UserModel", new UserModel());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("supervisorModel", new SupervisorModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "PatientUser";
	}
	
	@RequestMapping(value = "/addPatientSupervisor", method = RequestMethod.POST)
	public String addPatientSupervisor(
			@ModelAttribute("SpringWeb") UserModel UserModel,
			ModelMap model) {
String userName = (String) SecurityContextHolder.getContext().getAuthentication()
.getName();

		userService.savePatienSupervisor(userName, UserModel.getUsername(), UserModel.getPassword());
		model.addAttribute("supervisorPatientList", supervisorService.findAllByPatientLike(patientService.findByUserLike(userService.findByUsernameLike(userName))));
		model.addAttribute("informationPatient", informationService.findByuserLike(userService.findByUsernameLike(userName)));
		model.addAttribute("measurementPatient", measurementService.findAllMesureByPatient(userName));
		model.addAttribute("userOne",userService.findByUsernameLike(userName));
		model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("UserModel", new UserModel());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("supervisorModel", new SupervisorModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "PatientUser";
	}
	
	@RequestMapping(value = "/deletSupervisorPatient")
	public String deletSupervisorPatient(Model model,
			@ModelAttribute("SpringWeb") SupervisorModel supervisorModel,
			@RequestParam Long id) throws IOException {
		String userName = (String) SecurityContextHolder.getContext().getAuthentication()
				.getName();
		supervisorService.delete(id);
		model.addAttribute("supervisorPatientList", supervisorService.findAllByPatientLike(patientService.findByUserLike(userService.findByUsernameLike(userName))));
		model.addAttribute("informationPatient", informationService.findByuserLike(userService.findByUsernameLike(userName)));
		model.addAttribute("measurementPatient", measurementService.findAllMesureByPatient(userName));
		model.addAttribute("userOne",userService.findByUsernameLike(userName));
		model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("UserModel", new UserModel());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("supervisorModel", new SupervisorModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());

		return "PatientUser";
	}
	
	
}
