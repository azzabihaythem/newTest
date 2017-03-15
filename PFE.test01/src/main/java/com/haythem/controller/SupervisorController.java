package com.haythem.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haythem.model.SupervisorModel;
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
public class SupervisorController {
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
	
	@RequestMapping(value = "/Supervisor")
	public String Supervisor(Model model,
			@ModelAttribute("SpringWeb") SupervisorModel supervisorModel)
			throws IOException {

		model.addAttribute("supervisorList", userService.findAllSupervisor());
		model.addAttribute("supervisorModel", new SupervisorModel());
		model.addAttribute("patientList", patientService.patientUserName());
		model.addAttribute("PatientSupervisor", supervisorService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "supervisor";
	}

	@RequestMapping(value = "/AddSupervisorToPatient")
	public String AddSupervisorToPatient(Model model,
			@ModelAttribute("SpringWeb") SupervisorModel supervisorModel)
			throws IOException {
		
		model.addAttribute("validator", supervisorService.exist(supervisorModel.getPatient(),
				supervisorModel.getUser()));
		supervisorService.save(supervisorModel.getPatient(),
				supervisorModel.getUser());
		model.addAttribute("supervisorList", userService.findAllSupervisor());
		model.addAttribute("supervisorModel", new SupervisorModel());
		model.addAttribute("patientList", patientService.patientUserName());
		model.addAttribute("PatientSupervisor", supervisorService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "supervisor";
	}

	@RequestMapping(value = "/deletPatientSupervisor")
	public String deletPatientSupervisor(Model model,
			@ModelAttribute("SpringWeb") SupervisorModel supervisorModel,
			@RequestParam Long id) throws IOException {

		supervisorService.delete(id);
		model.addAttribute("supervisorList", userService.findAllSupervisor());
		model.addAttribute("supervisorModel", new SupervisorModel());
		model.addAttribute("patientList", patientService.patientUserName());
		model.addAttribute("PatientSupervisor", supervisorService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "supervisor";
	}

}
