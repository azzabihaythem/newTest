package com.haythem.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
public class MeasurementController {
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
	
	@RequestMapping(value = "/Measurement")
	public String Measurement(Model model) throws IOException {
		model.addAttribute("measurementList", measurementService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "Measurement";
	}
	
	@RequestMapping(value = "/deleteMeasurment", method = RequestMethod.GET)
	public String deleteMeasurment(
			 ModelMap model,
			@RequestParam Long id) {
		measurementService.delete(id);
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		model.addAttribute("measurementList", measurementService.findAll());
		return "Measurement";
	}
}
