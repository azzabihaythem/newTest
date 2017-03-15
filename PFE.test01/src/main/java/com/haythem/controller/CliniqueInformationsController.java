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

import com.haythem.model.CliniqueModel;
import com.haythem.model.InformationModel;
import com.haythem.model.UserModel;
import com.haythem.service.AdressService;
import com.haythem.service.BanqueService;
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
public class CliniqueInformationsController {
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
	@Autowired
	private BanqueService BanqueService;

	@RequestMapping(value = "/CliniqueInformations", method = RequestMethod.GET)
	public String userinformation(Model model) throws IOException {

		model.addAttribute("clinique", cliniqueService.findAll().get(0));
		model.addAttribute("BanqueName", BanqueService.findAll().get(0)
				.getBaqueName());
		model.addAttribute("BanqueNumber", BanqueService.findAll().get(0)
				.getNumber());
		model.addAttribute("CliniqueModel", new CliniqueModel());
		model.addAttribute("cliniqueService", cliniqueService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "CliniqueInformations";
	}

	@RequestMapping(value = "/editeCliniqueInformation", method = RequestMethod.POST)
	public ModelAndView editeInformationUser(
			@ModelAttribute("SpringWeb") CliniqueModel CliniqueModel,
			ModelMap model) {

		cliniqueService.update(1L, CliniqueModel.getNom(),
				CliniqueModel.getAdress(), CliniqueModel.getTva(),
				CliniqueModel.getRegistreDeCmmerce(),
				CliniqueModel.getEmployNumber(), CliniqueModel.getTel(),CliniqueModel.getCodeCentre(),CliniqueModel.getCodebureauxregional());
		BanqueService.update(1L, CliniqueModel.getBanqueName(), CliniqueModel.getBanqueNumber(), null);
		model.addAttribute("clinique", cliniqueService.findAll().get(0));
		model.addAttribute("BanqueName", BanqueService.findAll().get(0)
				.getBaqueName());
		model.addAttribute("BanqueNumber", BanqueService.findAll().get(0)
				.getNumber());
		model.addAttribute("CliniqueModel", new CliniqueModel());
		model.addAttribute("cliniqueService", cliniqueService.findAll());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return new ModelAndView("CliniqueInformations", "command",
				new UserModel());
	}

}
