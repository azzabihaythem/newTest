package com.haythem.controller;

//import java.util.Map;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.haythem.model.SeanceModel;
import com.haythem.model.SeanceModel2;
import com.haythem.model.SeanecAutomatiqueModel;
import com.haythem.model.UserModel;
import com.haythem.service.AdressService;
import com.haythem.service.CliniqueService;
import com.haythem.service.InformationService;
import com.haythem.service.MesureService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.PatientSeanceDaysService;
import com.haythem.service.PatientService;
import com.haythem.service.RealTimeMeasur;
import com.haythem.service.RoleService;
import com.haythem.service.SeanceService;
import com.haythem.service.SupervisorService;
import com.haythem.service.TypeService;
import com.haythem.service.UserService;
import com.haythem.service.WatchService;
import com.haythem.service.Impl.ApplicationMailer;
import com.haythem.service.Impl.FileService;

@Controller
public class SeanceController {

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
	private SeanceService seanceService;
	@Autowired
	private PatientDetailsService patientDetailsService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private PatientSeanceDaysService patientSeanceDaysService;
	@Autowired
	private CliniqueService cliniqueService;
	@RequestMapping(value = "/Seance")
	public String Patient(Model model,
			@ModelAttribute("SpringWeb") SeanceModel seanceModel)
			throws IOException {
		
//		model.addAttribute("seanceList", seanceService.findAll());
		 Pageable top = new PageRequest(0,1200,Direction.DESC,"id");
		 
		model.addAttribute("seanceList", seanceService.findAll(top).getContent());
		model.addAttribute("seanceModel", new SeanceModel());
		
		model.addAttribute("seanceModel2", new SeanceModel2());
		// model.addAttribute("patientList",
		// userService.findByRolesLike("Patient"));
		// model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		model.addAttribute("SeanecAutomatiqueModel",
				new SeanecAutomatiqueModel());
		model.addAttribute("patientAv3", patientDetailsService.findAllName());
		model.addAttribute("patientAv2", patientDetailsService.findAllName());
		model.addAttribute("patientAv", patientDetailsService.findAllName());
		model.addAttribute("typeAv", typeService.findAllName());
		return "seance";
		// return "cal";
	}

//	@RequestMapping(value = "/addSeance")
//	public String addPatient(Model model,
//			@ModelAttribute("SpringWeb") SeanceModel seanceModel)
//			throws IOException, ParseException {
//		//System.out.println(seanceModel.getType());
//		//System.out.println(seanceModel.getUser());
//		//System.out.println(seanceModel.getDate());
//		
//		model.addAttribute("patientAv3", patientDetailsService.findAllName());
//		String oldstring = "2011-01-18 00:00:00.0";
//		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//				.parse(oldstring);
//		model.addAttribute("SeanecAutomatiqueModel",
//				new SeanecAutomatiqueModel());
//		date.setDate(seanceModel.getDate().getDate());
//		date.setYear(seanceModel.getDate().getYear());
//		date.setMonth(seanceModel.getDate().getMonth());
//
//		//System.out.println("user ="
//				+ userService.findByUsernameLike(seanceModel.getUser()));
//		//System.out.println("date =" + date);
//		//System.out.println("type ="
//				+ typeService.findByTypeNameLike(seanceModel.getType()));
//
//		seanceService.save(date,
//				typeService.findByTypeNameLike(seanceModel.getType()),
//				userService.findByUsernameLike(seanceModel.getUser()));
//
//		model.addAttribute("seanceList", seanceService.findAll());
//		model.addAttribute("seanceModel", new SeanceModel());
//		// model.addAttribute("patientList",
//		// userService.findByRolesLike("Patient"));
//		// model.addAttribute("patientModel", new PatientModel());
//		model.addAttribute("patientAv", patientDetailsService.findAllName());
//		model.addAttribute("typeAv", typeService.findAllName());
//
//		// model.addAttribute("patientList",
//		// userService.findByRolesLike("Patient"));
//		// model.addAttribute("patientModel", new PatientModel());
//		model.addAttribute("patientAv2", patientDetailsService.findAllName());
//		//System.out.println("seanceService.findByDate(new Date()).size() = "+seanceService.findByDate(new Date()).size());
//
//		return "seance";
//	}

	@RequestMapping(value = "/addAjaxSeance", method = RequestMethod.POST)
	public @ResponseBody
	String addSeance(@RequestParam String type, @RequestParam String user,
			@RequestParam String date) throws JSONException, ParseException {
		//System.out.println("addAjaxSeance");
		//System.out.println("user = " + user);
		//System.out.println("type = " + type);
		//System.out.println("date = " + date);
		//System.out.println("seanceService.findByDate(new Date()).size() = "+seanceService.findByDate(new Date()).size());
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		Date date2 = formatter.parse(date);
		//System.out.println(date2);
		// //System.out.println(formatter.format(date));
		seanceService.save(date2, typeService.findOne(Long.parseLong(type)),
				userService.findByUsernameLike(user));
		return "seance";

	}

	// @RequestMapping(value = "/addAjaxSeanceDay", method = RequestMethod.POST)
	// public @ResponseBody
	// String addAjaxSeanceDaY(@RequestParam String user,@RequestParam String
	// day,@RequestParam Long index) throws JSONException, ParseException {
	// //System.out.println("addAjaxSeance");
	// //System.out.println("user = "+user);
	//
//	 try{
//	 //System.out.print("index = "+index);
//	 // if(index<1){
//	 //
//	 patientSeanceDaysService.deleteByUser(userService.findByUsernameLike(user));
//	 // }
//	 patientSeanceDaysService.save(userService.findByUsernameLike(user), day);
//	 }catch(Exception e){
	//
	//
	// }
	// return "seance";
	//
	// }
	
	
//	,@RequestParam("Monday") String monday
	@RequestMapping(value = "/addAjaxSeanceDay", method = RequestMethod.POST)
	public @ResponseBody
	String addAjaxSeanceDaY(HttpServletRequest request) throws JSONException,
			ParseException {

		//System.out.println(request.getParameter("Monday"));

		
		 try{
		
		 patientSeanceDaysService.deleteByUser(userService.findByUsernameLike(request.getParameter("category")));
		  
		 
		 if(request.getParameter("Monday")!=null)
		 patientSeanceDaysService.save(userService.findByUsernameLike(request.getParameter("category")), request.getParameter("Monday"));
		 if(request.getParameter("Tuesday")!=null)
			 patientSeanceDaysService.save(userService.findByUsernameLike(request.getParameter("category")), request.getParameter("Tuesday"));
		 if(request.getParameter("Wednesday")!=null)
			 patientSeanceDaysService.save(userService.findByUsernameLike(request.getParameter("category")), request.getParameter("Wednesday"));
		 if(request.getParameter("Thursday")!=null)
			 patientSeanceDaysService.save(userService.findByUsernameLike(request.getParameter("category")), request.getParameter("Thursday"));
		 if(request.getParameter("Friday")!=null)
			 patientSeanceDaysService.save(userService.findByUsernameLike(request.getParameter("category")), request.getParameter("Friday"));
		 if(request.getParameter("Saturday")!=null)
			 patientSeanceDaysService.save(userService.findByUsernameLike(request.getParameter("category")), request.getParameter("Saturday"));
	
		 }catch(Exception e){
		
		
		 }
		
		
		return "seance";

	}

	@RequestMapping(value = "/deleteAjaxSeanceDay", method = RequestMethod.POST)
	public @ResponseBody
	String deleteAjaxSeanceDay(@RequestParam String user) throws JSONException,
			ParseException {

		try {

			patientSeanceDaysService.deleteByUser(userService
					.findByUsernameLike(user));
		} catch (Exception e) {

		}
		return "seance";

	}

	@RequestMapping(value = "/deletSeance")
	public String deletPatient(Model model,
			@ModelAttribute("SpringWeb") SeanceModel seanceModel,
			@RequestParam Long id) throws IOException {
		try {
			seanceService.delete(id);
		} catch (Exception e) {

		}
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		model.addAttribute("SeanecAutomatiqueModel",
				new SeanecAutomatiqueModel());
		model.addAttribute("patientAv3", patientDetailsService.findAllName());
		Pageable top = new PageRequest(0,1200,Direction.DESC);
		 
			model.addAttribute("seanceList", seanceService.findAll(top).getContent());
		model.addAttribute("seanceModel", new SeanceModel());
		model.addAttribute("seanceModel2", new SeanceModel2());
		// model.addAttribute("patientList",
		// userService.findByRolesLike("Patient"));
		// model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("patientAv", patientDetailsService.findAllName());
		model.addAttribute("typeAv", typeService.findAllName());
		model.addAttribute("patientAv2", patientDetailsService.findAllName());

		return "seance";
	}
	
	
	@RequestMapping(value = "/deletAjaxSeance", method = RequestMethod.POST)
	public @ResponseBody
	String deletAjaxSeance(@RequestParam String id) throws JSONException,
			ParseException {

		try {
			seanceService.delete(Long.parseLong(id));
		} catch (Exception e) {

		}
		return "seance";

	}
	
	

	@RequestMapping(value = "/editSeance")
	public String editPatient(Model model,
			@ModelAttribute("SpringWeb") SeanceModel seanceModel,
			@RequestParam Long id) throws IOException, ParseException {

		try {
			//System.out.println(seanceModel.getType());
			//System.out.println(seanceModel.getUser());
			//System.out.println(seanceModel.getDate());

			String oldstring = "2011-01-18 00:00:00.0";
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(oldstring);
			date.setDate(seanceModel.getDate().getDate());
			date.setYear(seanceModel.getDate().getYear());
			date.setMonth(seanceModel.getDate().getMonth());

		

			seanceService.update(id, date,
					typeService.findByTypeNameLike(seanceModel.getType()),
					userService.findByUsernameLike(seanceModel.getUser()));
		} catch (Exception e) {

		}
		model.addAttribute("SeanecAutomatiqueModel",
				new SeanecAutomatiqueModel());
		model.addAttribute("patientAv3", patientDetailsService.findAllName());
		Pageable top = new PageRequest(0,1200,Direction.DESC);
		 
			model.addAttribute("seanceList", seanceService.findAll(top).getContent());
		model.addAttribute("seanceModel", new SeanceModel());
		model.addAttribute("seanceModel2", new SeanceModel2());
		// model.addAttribute("patientList",
		// userService.findByRolesLike("Patient"));
		// model.addAttribute("patientModel", new PatientModel());
		model.addAttribute("patientAv", patientDetailsService.findAllName());
		model.addAttribute("typeAv", typeService.findAllName());
		model.addAttribute("patientAv2", patientDetailsService.findAllName());
		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
		return "seance";
	}

	@RequestMapping(value = "/seanecAutomatiqueAdd", method = RequestMethod.POST)
	public String rechercheFee(
			@ModelAttribute("SpringWeb") SeanecAutomatiqueModel seanecAutomatiqueModel,
			ModelMap model) {

		//System.out.println(seanecAutomatiqueModel.getDate());
		seanceService.addAuotomatiqueSeanceBetweenDate(
				seanecAutomatiqueModel.getDate(),
				seanecAutomatiqueModel.getDate2());
//		model.addAttribute("SeanecAutomatiqueModel",
//				new SeanecAutomatiqueModel());
//		model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
//		model.addAttribute("patientAv3", patientDetailsService.findAllName());
//		Pageable top = new PageRequest(0,1200,Direction.DESC);
//		 
//			model.addAttribute("seanceList", seanceService.findAll(top).getContent());
//		model.addAttribute("seanceModel", new SeanceModel());
//		model.addAttribute("seanceModel2", new SeanceModel2());
//		model.addAttribute("patientAv", patientDetailsService.findAllName());
//		model.addAttribute("typeAv", typeService.findAllName());
//		model.addAttribute("patientAv2", patientDetailsService.findAllName());

//		return new ModelAndView("seance", "command", new UserModel());
		
		
		
		 Pageable top = new PageRequest(0,1200,Direction.DESC,"id");
		 
			model.addAttribute("seanceList", seanceService.findAll(top).getContent());
			model.addAttribute("seanceModel", new SeanceModel());
			
			model.addAttribute("seanceModel2", new SeanceModel2());
			// model.addAttribute("patientList",
			// userService.findByRolesLike("Patient"));
			// model.addAttribute("patientModel", new PatientModel());
			model.addAttribute("cliniqueName",cliniqueService.findAll().get(0).getNom());
			model.addAttribute("SeanecAutomatiqueModel",
					new SeanecAutomatiqueModel());
			model.addAttribute("patientAv3", patientDetailsService.findAllName());
			model.addAttribute("patientAv2", patientDetailsService.findAllName());
			model.addAttribute("patientAv", patientDetailsService.findAllName());
			model.addAttribute("typeAv", typeService.findAllName());
			
			
		return "seance";
	}

}
