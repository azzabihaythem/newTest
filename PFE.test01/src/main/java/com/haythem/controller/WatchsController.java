package com.haythem.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haythem.model.WatchModel;
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
public class WatchsController {
	
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
	
	@RequestMapping(value = "/Watchs")
	public String watchs(Model model,
			@ModelAttribute("SpringWeb") WatchModel watchModel)
			throws IOException {
		model.addAttribute("watchList", watchService.findAll());
		model.addAttribute("watchModel", new WatchModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "watchs";
	}

	@RequestMapping(value = "/addWatch")
	public String addWatch(Model model,
			@ModelAttribute("SpringWeb") WatchModel watchModel)
			throws IOException {
		
		model.addAttribute("validator", watchService.existWatch(watchModel.getWatchSerialNumber()));
		watchService.saveWatch(watchModel.getWatchSerialNumber(),
				watchModel.getHardVersion(), watchModel.getSoftVersion(),
				watchModel.getCommunicationType());
		model.addAttribute("watchList", watchService.findAll());
		model.addAttribute("watchModel", new WatchModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "watchs";
	}

	@RequestMapping(value = "/deletWatch")
	public String deletWatch(Model model,
			@ModelAttribute("SpringWeb") WatchModel watchModel,
			@RequestParam Long id) throws IOException {
		watchService.delete(id);
		model.addAttribute("watchList", watchService.findAll());
		model.addAttribute("watchModel", new WatchModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "watchs";
	}

	@RequestMapping(value = "/editWatch")
	public String editWatch(Model model,
			@ModelAttribute("SpringWeb") WatchModel watchModel,
			@RequestParam Long id) throws IOException {
		watchService.editWatch(id, watchModel.getWatchSerialNumber(),
				watchModel.getHardVersion(), watchModel.getSoftVersion(),
				watchModel.getCommunicationType());
		model.addAttribute("watchList", watchService.findAll());
		model.addAttribute("watchModel", new WatchModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "watchs";
	}

}
