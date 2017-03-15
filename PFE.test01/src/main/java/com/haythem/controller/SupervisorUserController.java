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
public class SupervisorUserController {
	
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
	private CliniqueService cliniqueService;
	
	@Autowired
	private RealTimeMeasur realTimeMeasur;
	@RequestMapping(value = "/SupervisorUser")
	public String SupervisorUser(Model model) throws IOException {
		String supervisorName = (String) SecurityContextHolder.getContext().getAuthentication()
				.getName();
		model.addAttribute("supervisorName", supervisorName);
		model.addAttribute("userOne",userService.findByUsernameLike(supervisorName));
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("UserModel", new UserModel());
		model.addAttribute("informationPatient", informationService.findByuserLike(userService.findByUsernameLike(supervisorName)));
		model.addAttribute("measurementList", measurementService.findAllSupervised(supervisorName));
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "SupervisorUser";
	}
	
	
	
	@RequestMapping(value = "/editSupervisorInformation", method = RequestMethod.POST)
	public String editSupervisorInformation(
			@ModelAttribute("SpringWeb") InformationModel InformationModel,
			ModelMap model, @RequestParam Long id) {
String supervisorName = (String) SecurityContextHolder.getContext().getAuthentication()
.getName();
		informationService.editPatientInformation(
				supervisorName, InformationModel.getIdentityCardNumber(),
				InformationModel.getFirstName(),
				InformationModel.getLastName(), InformationModel.getEmail(),
				InformationModel.getBirthday(), InformationModel
						.getPhoneNumber(), InformationModel.getGender(),
				InformationModel.getAdress().getAdress(), InformationModel
						.getAdress().getCountry(), InformationModel.getAdress()
						.getState());
		model.addAttribute("supervisorName", supervisorName);
		model.addAttribute("userOne",userService.findByUsernameLike(supervisorName));
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("informationPatient", informationService.findByuserLike(userService.findByUsernameLike(supervisorName)));
		model.addAttribute("UserModel", new UserModel());
		model.addAttribute("measurementList", measurementService.findAllSupervised(supervisorName));
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "SupervisorUser";
	}
	
	
	

	@RequestMapping(value = "/editSupervisorUser", method = RequestMethod.POST)
	public String editSupervisorUser(
			@ModelAttribute("SpringWeb") UserModel userModel, ModelMap model,
			@RequestParam Long id) {
		String supervisorName = (String) SecurityContextHolder.getContext().getAuthentication().getName();
		Long idP = (Long)Long.parseLong(userModel.getId());
		model.addAttribute("supervisorName", supervisorName);
		userService.editUser(idP, userModel.getUsername(),userModel.getPassword());
		model.addAttribute("userOne",userService.findByUsernameLike(supervisorName));
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("informationPatient", informationService.findByuserLike(userService.findByUsernameLike(supervisorName)));
		model.addAttribute("UserModel", new UserModel());
		model.addAttribute("measurementList", measurementService.findAllSupervised(supervisorName));
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "SupervisorUser";
	}
	

}
