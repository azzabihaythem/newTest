package com.haythem.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.haythem.model.InformationModel;
import com.haythem.model.UserModel;
import com.haythem.service.AdressService;
import com.haythem.service.CliniqueService;
import com.haythem.service.InformationService;
import com.haythem.service.MesureService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.PatientService;
import com.haythem.service.RealTimeMeasur;
import com.haythem.service.RoleService;
import com.haythem.service.SupervisorService;
import com.haythem.service.UserService;
import com.haythem.service.WatchService;
import com.haythem.service.Impl.ApplicationMailer;
import com.haythem.service.Impl.FileService;

@Controller
public class UserinformationController {
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
	@Autowired
	private PatientDetailsService patientDetailsService;

	@RequestMapping(value = "/informationUser", method = RequestMethod.GET)
	public String informationUser(Model model, @RequestParam Long id)
			throws IOException {
		model.addAttribute("user", userService.findAll());
		
		
		
		
		
		
		
		model.addAttribute("information", informationService.findAll());
		model.addAttribute("info",
				informationService.findByuserLike(userService.findOne(id)));

		model.addAttribute("adress",
				informationService.findByuserLike(userService.findOne(id))
						.getAdress());
		model.addAttribute("command", new UserModel());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("userNames", informationService.userNamesAv());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "userinformation";
	}

	@RequestMapping(value = "/userinformation", method = RequestMethod.GET)
	public String userinformation(Model model) throws IOException {

		model.addAttribute("user", userService.findAll());
		model.addAttribute("information", informationService.findAll());
		model.addAttribute("command", new UserModel());
		model.addAttribute("Info", new InformationModel());
//		System.out.println("PatientDetailsSize = "+patientDetailsService.findAll().size());
		model.addAttribute("PatientDetails", patientDetailsService.findAll());
		model.addAttribute("userNames", informationService.userNamesAv());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "userinformation";
	}

	@RequestMapping(value = "/addUserInformation", method = RequestMethod.POST)
	public ModelAndView addUserInformation(
			@ModelAttribute("SpringWeb") InformationModel InformationModel,
			ModelMap model) {

		informationService.saveInformation(InformationModel.getUser().getId(),
				InformationModel.getIdentityCardNumber(), InformationModel
						.getFirstName(), InformationModel.getLastName(),
				InformationModel.getEmail(), InformationModel.getBirthday(),
				InformationModel.getPhoneNumber(),
				InformationModel.getGender(), InformationModel.getAdress()
						.getAdress(),
				InformationModel.getAdress().getCountry(), InformationModel
						.getAdress().getState());
		patientDetailsService.save(InformationModel.getUser()
				.getId(), InformationModel.getFirstName(), InformationModel
				.getLastName(), InformationModel.getPatientDetailsModel()
				.getAffile(), InformationModel.getPatientDetailsModel()
				.getNumAffilation(), InformationModel.getPatientDetailsModel()
				.getDOIT(), InformationModel.getPatientDetailsModel()
				.getDateDebut(), InformationModel.getPatientDetailsModel()
				.getDateFin(),InformationModel.getPatientDetailsModel().getNumPriseEnCharge());

		model.addAttribute("information", informationService.findAll());
		model.addAttribute("user", userService.findAll());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("userNames", informationService.userNamesAv());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return new ModelAndView("userinformation", "command", new UserModel());
	}

	@RequestMapping(value = "/deleteInfo", method = RequestMethod.GET)
	public ModelAndView deleteInfo(
			@ModelAttribute("SpringWeb") UserModel userModel, ModelMap model,
			@RequestParam Long id) {
		informationService.delete(id);
		model.addAttribute("information", informationService.findAll());
		model.addAttribute("user", userService.findAll());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("userNames", informationService.userNamesAv());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return new ModelAndView("userinformation", "command", new UserModel());
	}

	@RequestMapping(value = "/editeInformationUser", method = RequestMethod.POST)
	public ModelAndView editeInformationUser(
			@ModelAttribute("SpringWeb") InformationModel InformationModel,
			ModelMap model, @RequestParam Long id) {

		informationService.editInformation(id, InformationModel
				.getIdentityCardNumber(), InformationModel.getFirstName(),
				InformationModel.getLastName(), InformationModel.getEmail(),
				InformationModel.getBirthday(), InformationModel
						.getPhoneNumber(), InformationModel.getGender(),
				InformationModel.getAdress().getAdress(), InformationModel
						.getAdress().getCountry(), InformationModel.getAdress()
						.getState());

		model.addAttribute("information", informationService.findAll());
		model.addAttribute("userNames", informationService.userNamesAv());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("user", userService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return new ModelAndView("userinformation", "command", new UserModel());
	}

}
