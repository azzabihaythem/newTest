package com.haythem.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haythem.model.FactureGlobaleModel;
import com.haythem.model.PatientDetailsInformationModel;
import com.haythem.model.SeanceModel;
import com.haythem.model.SeanceModel2;
import com.haythem.persistance.Information;
import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.Seance;
import com.haythem.service.AdressService;
import com.haythem.service.BanqueService;
import com.haythem.service.BordereauService;
import com.haythem.service.CliniqueService;
import com.haythem.service.FactureService;
import com.haythem.service.FctrsService;
import com.haythem.service.InformationService;
import com.haythem.service.MesureService;
import com.haythem.service.PatientDetailsService;
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
public class PdfController {
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
	FactureService factureService;
	@Autowired
	BordereauService bordereauService;

	@Autowired
	private CliniqueService cliniqueService;
	@Autowired
	private BanqueService BanqueService;

	@Autowired
	private FctrsService fctrsService;

	@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
	public String downloadExcel(Model model) {
		// create some sample data
		String userName = (String) SecurityContextHolder.getContext()
				.getAuthentication().getName();

		model.addAttribute("type", "mesureList");
		// return a view which will be resolved by an excel view resolver
		model.addAttribute("listMesure",
				measurementService.findByUser(userName));
		return "pdfView";

	}

	@RequestMapping(value = "/downloadUsersPDF", method = RequestMethod.GET)
	public String downloadPdf(Model model) {
		model.addAttribute("type", "userList");
		// return a view which will be resolved by an excel view resolver
		model.addAttribute("listUser", userService.findAll());
		return "pdfView";

	}

	@RequestMapping(value = "/downloadInformationUserPdf", method = RequestMethod.GET)
	public String downloadInformationUserPdf(Model model) {
		model.addAttribute("type", "informationUser");
		// return a view which will be resolved by an excel view resolver
		model.addAttribute("listInformationUser", informationService.findAll());
		return "pdfView";

	}

	@RequestMapping(value = "/downloadWatchPdf", method = RequestMethod.GET)
	public String downloadWatchPdf(Model model) {
		model.addAttribute("type", "Watch");
		// return a view which will be resolved by an excel view resolver
		model.addAttribute("watchList", watchService.findAll());
		return "pdfView";

	}

	@RequestMapping(value = "/downloadPatientWatchPdf", method = RequestMethod.GET)
	public String downloadPatientWatchPdf(Model model) {
		model.addAttribute("type", "patientWatch");
		// return a view which will be resolved by an excel view resolver
		model.addAttribute("patientWatchList", patientService.findAll());
		return "pdfView";

	}

	@RequestMapping(value = "/downloadSupervisorPdf", method = RequestMethod.GET)
	public String downloadSupervisorPdf(Model model) {
		model.addAttribute("type", "supervisor");
		// return a view which will be resolved by an excel view resolver
		model.addAttribute("supervisorList", supervisorService.findAll());
		return "pdfView";

	}

	@RequestMapping(value = "/downloadSeanceFctPdf")
	public String downloadSeanceFctPdf(
			@ModelAttribute("SpringWeb") SeanceModel seanceModel, Model model)
			throws ParseException {

		try {

			model.addAttribute("type", "seanceFact");
			System.out.println(seanceModel.getUser());
			System.out.println();
			Calendar cal = Calendar.getInstance();
			cal.setTime(seanceModel.getDate());
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);

			model.addAttribute("clinique", cliniqueService.findAll().get(0));
			model.addAttribute("banque", BanqueService.findAll().get(0));
			// factureService.findByUserAndMonthAndYear(userService.findByUsernameLike(seanceModel.getUser()),
			// month+"", year+"");
			model.addAttribute("information", informationService
					.findByuserLike(userService.findByUsernameLike(seanceModel
							.getUser())));

			model.addAttribute("patientDetails", patientDetailsService
					.findByUserLike(userService.findByUsernameLike(seanceModel
							.getUser())));

			// return a view which will be resolved by an excel view resolver

			if (!"".equals(seanceModel.getNumber())
					&& seanceModel.getNumber() != null) {
				System.out.println("heloooooooooooo");
				factureService.updateFactNumber(
						userService.findByUsernameLike(seanceModel.getUser()),
						month + "", year + "", seanceModel.getNumber(),
						seanceModel.getDate(), typeService.findAll().get(0));

			}

			List<Seance> seances = seanceService.findByUserAndMonthAndYear(
					userService.findByUsernameLike(seanceModel.getUser()),
					month + "", year + "");
			Collections.sort(seances);
			model.addAttribute("seanceList", seances);
		} catch (Exception e) {

		}
		return "pdfView";

	}

	
	
	@RequestMapping(value = "/downloadSeanceFctPdfTotal")
	public String downloadSeanceFctPdfTotal(
			@ModelAttribute("SpringWeb") SeanceModel2 seanceModel, Model model)
			throws ParseException {

		try {

			model.addAttribute("type", "seanceFactTot");
		
			System.out.println();
			Calendar cal = Calendar.getInstance();
			cal.setTime(seanceModel.getDate());
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);

			model.addAttribute("clinique", cliniqueService.findAll().get(0));
			model.addAttribute("banque", BanqueService.findAll().get(0));
			// factureService.findByUserAndMonthAndYear(userService.findByUsernameLike(seanceModel.getUser()),
			// month+"", year+"");
		

//			model.addAttribute("patientDetails", patientDetailsService
//					.findByUserLike(userService.findByUsernameLike(seanceModel
//							.getUser())));

			// return a view which will be resolved by an excel view resolver

		

			List<PatientDetails>  listPatient = patientDetailsService.findAll();
			List<Seance> seances;
			Information information ;
			
			PatientDetailsInformationModel patientDetailsInformation ;
			Map<PatientDetailsInformationModel,List<Seance>> seancesMap = new HashMap();
			
			
			for (PatientDetails aPatient: listPatient){
				
			 seances = seanceService.findByUserAndMonthAndYear(
					userService.findByUsernameLike(aPatient.getUser().getUsername()),
					month + "", year + "");
			 information = informationService
				.findByuserLike(userService.findByUsernameLike(aPatient.getUser().getUsername()));
			 patientDetailsInformation = new PatientDetailsInformationModel(information, aPatient);
			Collections.sort(seances);
			seancesMap.put(patientDetailsInformation, seances);
			
			
			}
			model.addAttribute("ListSeancesMap", seancesMap);
			
			
		} catch (Exception e) {

		}
		return "pdfView";

	}
	
	
	@RequestMapping(value = "/downloadSeanceFctGlobPdf")
	public String downloadSeanceFctGlobPdf(
			@ModelAttribute("SpringWeb") SeanceModel seanceModel, Model model)
			throws ParseException {

		try {
			model.addAttribute("clinique", cliniqueService.findAll().get(0));
			model.addAttribute("banque", BanqueService.findAll().get(0));
			model.addAttribute("type", "FactGlob");
			System.out.println(seanceModel.getDate());
			System.out.println();
			Calendar cal = Calendar.getInstance();
			cal.setTime(seanceModel.getDate());
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			
			System.out.println("month = "+month+" year = "+ year);
			bordereauService.save(seanceModel.getDate(), "0");

			Long bordereauId = bordereauService.findByMonthAndYear(month + "",
					year + "").getId();
			model.addAttribute("bordereauId", bordereauId);

			List<FactureGlobaleModel> lfact = factureService
					.CreateGlobalFactureByMonthAndYear2(seanceModel.getDate());
			List<FactureGlobaleModel> complimentGlobList = factureService
					.findByBorderauNumber( bordereauService.findByMonthAndYear(month + "",
							year + ""));
			
			System.out.println("lfact.size() = " + lfact.size());
			Collections.sort(lfact);

			model.addAttribute("factGlobList", lfact);
			
			model.addAttribute("complimentGlobList", complimentGlobList);

		} catch (Exception e) {

		}
		return "pdfView";

	}

	@ResponseBody
	@RequestMapping(value = "/txt")
	public String txtResponse(HttpServletResponse response, @RequestParam int m, @RequestParam int year) {
		String fileName = "fctrs.txt";
		response.setHeader("Content-Disposition", "attachment; filename="
				+ fileName);
		 Date date = new Date();
		 System.out.println("month = "+m);
		 System.out.println("***********year = "+year);
//		 date.setMonth(Integer.parseInt(m.substring(0, 1)));
//		 date.setYear(Integer.parseInt(m.substring(2)));
		 
		 date.setMonth(m);
		 date.setYear(year);
//		 List<User> user = userService.findAll();
		 String borderau ="";
		 String borderauComp ="";
		 
		 
		//commented 2017 
//		 borderau =fctrsService.borderauLine(date)+"\n";
//		for(  PatientDetails ps :patientDetailsService.findAll()){
//			
//			borderau = borderau +fctrsService.factureLine(date, ps.getUser())+"\n";
//		}
		
		
	//added 2017
		 borderau =fctrsService.borderauLine2017(date)+"\n";
			for(  PatientDetails ps :patientDetailsService.findAll()){
				
				borderau = borderau +fctrsService.factureLine2017(date, ps.getUser())+"\n";
			}
		
		
		
		
//		borderauComp=fctrsService.complementfactureLine(bordereauService.findByMonthAndYear(
//				date.getMonth() + "", date.getYear() + ""));
		//
		String content = borderau+borderauComp;
		return content;
	}

}
