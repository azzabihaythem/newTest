package com.haythem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.haythem.model.BilanModel;
import com.haythem.model.ObservationModel;
import com.haythem.model.Tensionarterielle;
import com.haythem.persistance.Bilan;
import com.haythem.persistance.Observation;
import com.haythem.persistance.Seance;
import com.haythem.service.AdressService;
import com.haythem.service.BilanService;
import com.haythem.service.CliniqueService;
import com.haythem.service.InformationService;
import com.haythem.service.MesureService;
import com.haythem.service.ObservationService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.PatientService;
import com.haythem.service.RealTimeMeasur;
import com.haythem.service.RoleService;
import com.haythem.service.SeanceService;
import com.haythem.service.SupervisorService;
import com.haythem.service.UserService;
import com.haythem.service.WatchService;
import com.haythem.service.Impl.ApplicationMailer;
import com.haythem.service.Impl.FileService;

@Controller
public class BilanController {
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
	private CliniqueService cliniqueService;

	@Autowired
	private RealTimeMeasur realTimeMeasur;

	@Autowired
	private PatientDetailsService patientDetailsService;

	@Autowired
	private BilanService bilanService;

	@Autowired
	private SeanceService seanceService;

	@Autowired
	private ObservationService observationService;

	@RequestMapping(value = "/bilan", method = RequestMethod.GET)
	public String bilan(ModelMap model, @RequestParam Long id) {
		Seance seance = seanceService.findOne(id);
		Bilan bilan = bilanService.findBySeance(seance);
		BilanModel bilanModel = new BilanModel();
		bilanModel.setHeparine(false);
		if (bilan == null) {
			bilan = new Bilan();
			bilan.setSeance(seance);
			bilanModel.setSeanceId(id);
			model.addAttribute("bilanModel", bilanModel);
			model.addAttribute("bilanId", bilanService.save(bilan));
		} else {
			Long infermierid = 0L;
			String userName = "";
			try {
				infermierid = bilan.getInfirmier().getId();
				userName =	userService.findOne(infermierid).getUsername();
			} catch (Exception e) {
				infermierid = 0L;
			}

			bilanModel = new BilanModel(bilan.getId(), bilan.getGenerateur(), bilan.getFiltre(), bilan.getPoidsSec(),
					bilan.getUftDuree(), bilan.getDebutDeDialyse(), bilan.getPoidsDebut(), bilan.getPriseDePoids(),
					new Tensionarterielle(bilan.getTensionarterielleDebutSystolique(),
							bilan.getTensionarterielleDebutDiastolique()),
					bilan.getFinDeDialyse(), bilan.getPoidsFin(), bilan.getPerteDePoids(),
					new Tensionarterielle(bilan.getTensionarterielleFinSystolique(),
							bilan.getTensionarterielleFinDiastolique()),
					bilan.getHeparine(), bilan.getTraitement(), userName , bilan.getSeance().getId(),
					bilan.getObservationMedicales(), bilan.getUft(), bilan.getOptions());

			model.addAttribute("bilanModel", bilanModel);
			model.addAttribute("bilanId", bilan.getId());
		}
		try {
			if (bilanModel.getHeparine()) {
				model.addAttribute("checked", "checked");
			} else {
				model.addAttribute("checked", "");
			}
		} catch (Exception e) {
			model.addAttribute("checked", "");
		}
		model.addAttribute("userNames", informationService.userNamesAv());
		model.addAttribute("cliniqueName", cliniqueService.findAll().get(0).getNom());
		return "bilan";
	}

	@RequestMapping(value = "/addBilan", method = RequestMethod.POST)
	public String addBilan(@ModelAttribute("SpringWeb") BilanModel bilanModel, ModelMap model) {

		boolean heparine = false;
		try {
			if (bilanModel.getHeparine()) {
				model.addAttribute("checked", "checked");
				heparine = true;
			} else {
				model.addAttribute("checked", "");
				heparine = false;
			}
		} catch (Exception e) {
			model.addAttribute("checked", "");
		}
		Long bilanId = bilanService.update(bilanModel.getGenerateur(), bilanModel.getFiltre(), bilanModel.getPoidsSec(),
				bilanModel.getUFTDuree(), bilanModel.getDebutDeDialyse(), bilanModel.getPoidsDebut(),
				bilanModel.getPriseDePoids(), bilanModel.getTensionarterielleDebut().getSystolique(),
				bilanModel.getTensionarterielleDebut().getDiastolique(), bilanModel.getFinDeDialyse(),
				bilanModel.getPoidsFin(), bilanModel.getPerteDePoids(),
				bilanModel.getTensionarterielleFin().getSystolique(),
				bilanModel.getTensionarterielleFin().getDiastolique(), heparine, bilanModel.getTraitement(),
				userService.findByUsernameLike(bilanModel.getInfirmierName()), seanceService.findOne(bilanModel.getSeanceId()),
				bilanModel.getObservationMedicales(), bilanModel.getUFT(), bilanModel.getOptions());
		model.addAttribute("userNames", informationService.userNamesAv());
		model.addAttribute("bilanId", bilanId);
		model.addAttribute("bilanModel", bilanModel);

		model.addAttribute("cliniqueName", cliniqueService.findAll().get(0).getNom());

		return "bilan";
	}

	@RequestMapping(value = "/observation", method = RequestMethod.GET)
	public String observation(ModelMap model, @RequestParam Long id) {

		ObservationModel observationModel = new ObservationModel();
		observationModel.setBilanId(id);
		model.addAttribute("bilanId", id);
		model.addAttribute("observationModel", observationModel);
		model.addAttribute("observationsList", observationService.findByBilan(bilanService.findOne(id)));

		return "observation";
	}

	@RequestMapping(value = "/addObservation", method = RequestMethod.POST)
	public String addBilan(@ModelAttribute("SpringWeb") ObservationModel observationModel, ModelMap model) {
		Long bilanId = observationModel.getBilanId();
		Observation observation = new Observation(observationModel.getHeure(),
				observationModel.getTension_arterielle_s(), observationModel.getTension_arterielle_d(),
				observationModel.getHeparine(), observationModel.getDebit_sang(), observationModel.getUf(),
				observationModel.getPv(), observationModel.getPtm(), observationModel.getUf_cumule(),
				observationModel.getObservation(), bilanService.findOne(observationModel.getBilanId()));
		observationService.save(observation);// boolean heparine = false;
		observationModel = new ObservationModel();
		observationModel.setBilanId(bilanId);
		model.addAttribute("bilanId", bilanId);
		model.addAttribute("observationModel", observationModel);
		model.addAttribute("observationsList", observationService.findByBilan(bilanService.findOne(bilanId)));
		return "observation";
	}

	@RequestMapping(value = "/deleteobservation", method = RequestMethod.GET)
	public String deleteobservation(@RequestParam("idobs") Long idobs, @RequestParam("idBilan") Long idBilan,
			@ModelAttribute("SpringWeb") ObservationModel observationModel, ModelMap model) {
		Long bilanId = idBilan;
		observationService.delete(idobs);
		observationModel = new ObservationModel();
		observationModel.setBilanId(bilanId);
		model.addAttribute("bilanId", bilanId);
		model.addAttribute("observationModel", observationModel);
		model.addAttribute("observationsList", observationService.findByBilan(bilanService.findOne(bilanId)));

		return "observation";
	}

}
