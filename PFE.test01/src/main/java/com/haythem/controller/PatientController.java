package com.haythem.controller;

//import java.util.Map;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haythem.model.PatientModel;
import com.haythem.service.*;
import com.haythem.service.Impl.ApplicationMailer;
import com.haythem.service.Impl.FileService;

@Controller
public class PatientController {

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
	

	@RequestMapping(value = "/Patient")
	public String Patient(Model model,
			@ModelAttribute("SpringWeb") PatientModel PatienthModel)
			throws IOException {

		model.addAttribute("patientList", patientService.findAll());
		model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("patientAv", patientService.patientAv());
		model.addAttribute("WatchAv", patientService.WatchAv());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "patient";
	}

	@RequestMapping(value = "/addPatient")
	public String addPatient(Model model,
			@ModelAttribute("SpringWeb") PatientModel patientModel)
			throws IOException {
		patientService.savePatient(patientModel.getWatch().getId(),
				patientModel.getHbRef(), patientModel.getSRef(), patientModel
						.getUser().getId());

		model.addAttribute("patientList", patientService.findAll());
		model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("patientAv", patientService.patientAv());
		model.addAttribute("WatchAv", patientService.WatchAv());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "patient";
	}

	@RequestMapping(value = "/deletPatient")
	public String deletPatient(Model model,
			@ModelAttribute("SpringWeb") PatientModel patientModel,
			@RequestParam Long id) throws IOException {
		patientService.delete(id);
		model.addAttribute("patientList", patientService.findAll());
		model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("patientAv", patientService.patientAv());
		model.addAttribute("WatchAv", patientService.WatchAv());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());

		return "patient";
	}

	@RequestMapping(value = "/editPatient")
	public String editPatient(Model model,
			@ModelAttribute("SpringWeb") PatientModel patientModel,
			@RequestParam Long id) throws IOException {
		patientService.editPatient(id, patientModel.getWatch().getId(),
				patientModel.getHbRef(), patientModel.getSRef(), patientModel
						.getUser().getId());
		model.addAttribute("patientList", patientService.findAll());
		model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("patientAv", patientService.patientAv());
		model.addAttribute("WatchAv", patientService.WatchAv());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "patient";
	}

	
}
