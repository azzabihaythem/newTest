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
import com.haythem.model.PatientDetailsModel;
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
public class PatientDetailsController {
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
	private PatientDetailsService patientDetailsService;
	@Autowired
	private CliniqueService cliniqueService;
	

	@RequestMapping(value = "/PatientDetailsinformation", method = RequestMethod.GET)
	public String userinformation(Model model) throws IOException {

//		model.addAttribute("user", userService.findAll());
//		model.addAttribute("information", informationService.findAll());
		model.addAttribute("command", new UserModel());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("PatientDetailsModel", new PatientDetailsModel());
//		System.out.println("PatientDetailsSize = "+patientDetailsService.findAll().size());
		model.addAttribute("PatientDetails", patientDetailsService.findAll());
		model.addAttribute("userNames", informationService.userNamesAv());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "PatientDetails";
	}
	@RequestMapping(value = "/deletepatientDetails", method = RequestMethod.GET)
	public ModelAndView deleteInfo(
			@ModelAttribute("SpringWeb") UserModel userModel, ModelMap model,
			@RequestParam Long id) {
		patientDetailsService.delete(id);
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("PatientDetails", patientDetailsService.findAll());
		model.addAttribute("userNames", informationService.userNamesAv());
		model.addAttribute("PatientDetailsModel", new PatientDetailsModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return new ModelAndView("PatientDetails", "command", new UserModel());
	}
	
	@RequestMapping(value = "/editePatientDetails", method = RequestMethod.POST)
	public ModelAndView editeInformationUser(
			@ModelAttribute("SpringWeb") InformationModel InformationModel,
			ModelMap model, @RequestParam Long id) {
		
		patientDetailsService.update(id, "", "",
				InformationModel.getPatientDetailsModel().getAffile(),
				InformationModel.getPatientDetailsModel().getNumAffilation(),
				InformationModel.getPatientDetailsModel().getNumPriseEnCharge(),
				InformationModel.getPatientDetailsModel().getDOIT(),
				InformationModel.getPatientDetailsModel().getDateDebut(),
				InformationModel.getPatientDetailsModel().getDateFin());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());

		model.addAttribute("command", new UserModel());
		model.addAttribute("Info", new InformationModel());
//		System.out.println("PatientDetailsSize = "+patientDetailsService.findAll().size());
		model.addAttribute("PatientDetails", patientDetailsService.findAll());
		model.addAttribute("userNames", informationService.userNamesAv());

		return new ModelAndView("PatientDetails", "command", new UserModel());
	}
	

}
