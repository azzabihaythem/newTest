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
import com.haythem.service.PatientService;
import com.haythem.service.RealTimeMeasur;
import com.haythem.service.RoleService;
import com.haythem.service.SupervisorService;
import com.haythem.service.UserService;
import com.haythem.service.WatchService;
import com.haythem.service.Impl.ApplicationMailer;
import com.haythem.service.Impl.FileService;

@Controller
public class UsersAuthenticationsController {

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
	
	
	
	
	
	
	@RequestMapping(value = "/table", method = RequestMethod.GET)
	public String User(Model model) throws IOException {

		model.addAttribute("user", userService.findAll());
		model.addAttribute("information", informationService.findAll());
		model.addAttribute("command", new UserModel());
		model.addAttribute("Info", new InformationModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "table";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser( 
			@ModelAttribute("SpringWeb") UserModel userModel, ModelMap model) {
        
        model.addAttribute("validation", userService.existUser(userModel.getUsername()));
		userService.saveUser(userModel.getRole(), userModel.getUsername(),
				userModel.getPassword());
		model.addAttribute("information", informationService.findAll());
		model.addAttribute("user", userService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return new ModelAndView("table", "command", new UserModel());
	}
	
	@RequestMapping(value = "/addInformation", method = RequestMethod.POST)
	public ModelAndView addInformation(
			@ModelAttribute("SpringWeb") InformationModel InformationModel,
			ModelMap model) {
		model.addAttribute("information", informationService.findAll());
		model.addAttribute("user", userService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return new ModelAndView("table", "command", new UserModel());
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(
			@ModelAttribute("SpringWeb") UserModel userModel, ModelMap model,
			@RequestParam Long id) {
		userService.delete(id);
		model.addAttribute("information", informationService.findAll());
		model.addAttribute("user", userService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return new ModelAndView("table", "command", new UserModel());
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public ModelAndView editUser(
			@ModelAttribute("SpringWeb") UserModel userModel, ModelMap model,
			@RequestParam Long id) {
		model.addAttribute("information", informationService.findAll());
		userService.editUser(id, userModel.getUsername(),
				userModel.getPassword());
		model.addAttribute("user", userService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return new ModelAndView("table", "command", new UserModel());
	}

	
	

	
}
