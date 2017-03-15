package com.haythem.controller;
import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haythem.model.MailModel;
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
public class DashboardController {
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
	
	
	//**
	@RequestMapping(value = "index-2", method = RequestMethod.GET)
	public String setupForm(Model model) throws IOException {
		
		

		model.addAttribute("mailModel", new MailModel());
		model.addAttribute("userModel", new UserModel());
		
			model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		model.addAttribute("userNames",userService.getNameListOfSupervised());
		model.addAttribute("stat", userService.userStat());
		return "index-2";
	}

	
	@RequestMapping(value = "sendMail", method = RequestMethod.POST)
	public String sendMail(Model model,@ModelAttribute("SpringWeb") MailModel mailModel) throws IOException {
		
		 String userName = (String) SecurityContextHolder.getContext().getAuthentication().getName();
		applicationMailer.sendMail("azzabi.haythem@gmail.com", "Message from "+ userName , mailModel.getBody());
		model.addAttribute("mailModel", new MailModel());
		model.addAttribute("stat", userService.userStat());
		
		model.addAttribute("userModel", new UserModel());
		//model.addAttribute("userNames",test);
		model.addAttribute("userNames",userService.getNameListOfSupervised());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "index-2";
	}
	
	 @RequestMapping(value = "/mesure", method = RequestMethod.GET)
	    public @ResponseBody
	    String constructJSONArray(@RequestParam String id) throws JSONException {
		 
	        return realTimeMeasur.getRealTimeMeasur(id);

	      
	    }
	
}
