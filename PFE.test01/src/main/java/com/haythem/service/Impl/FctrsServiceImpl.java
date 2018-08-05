package com.haythem.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.persistance.Bordereau;
import com.haythem.persistance.Facture;
import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.Seance;
import com.haythem.persistance.Type;
import com.haythem.persistance.User;
import com.haythem.service.BanqueService;
import com.haythem.service.BordereauService;
import com.haythem.service.CliniqueService;
import com.haythem.service.FactureService;
import com.haythem.service.FctrsService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.SeanceService;
import com.haythem.service.TypeService;

@Service
public class FctrsServiceImpl implements FctrsService {

	@Autowired
	BanqueService banqueSerivce;

	@Autowired
	BordereauService bordereauService;

	@Autowired
	CliniqueService cliniqueService;

	@Autowired
	FactureService factureService;

	@Autowired
	SeanceService seanceService;

	@Autowired
	PatientDetailsService patientDetailsService;

	@Autowired
	TypeService typeService;

	@Override
	public String createTextFile(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String borderauLine(Date date) {
		// TODO Auto-generated method stub
		String borderauLine = "";
		borderauLine = "1"; // type borderau
		borderauLine = borderauLine + date.getYear();// year borderau

		String borderauNumber = bordereauService.findByMonthAndYear(
				date.getMonth() + "", date.getYear() + "").getBorderauNumber();
		if (borderauNumber == null) {
			borderauNumber = bordereauService.findByMonthAndYear(
					date.getMonth() + "", date.getYear() + "").getId()
					+ "";

		}
		while (borderauNumber.length() < 3) {

			borderauNumber = "0" + borderauNumber;
		}
		borderauLine = borderauLine + borderauNumber;
		borderauLine = borderauLine
				+ cliniqueService.findAll().get(0).getCodecentre();// code
																	// centre

		borderauLine = borderauLine + date.getYear();
		borderauLine = borderauLine + "00000000";
		borderauLine = borderauLine
				+ cliniqueService.findAll().get(0).getCodebureauxregional();// code
																			// bureau
																			// régional
		borderauLine = borderauLine + "21";
		borderauLine = borderauLine + "0000000000";
		borderauLine = borderauLine
				+ cliniqueService.findAll().get(0).getEmployNumber();
		String factureNumber = factureService.findByMonthAndYear(
				date.getMonth() + "", date.getYear() + "").size()
				+ "";

		while (factureNumber.length() < 3) {
			factureNumber = "0" + factureNumber;

		}

		borderauLine = borderauLine + factureNumber;// nombre de facture par
													// borderau

		Type seanceType = typeService.findAll().get(0);
		Long prixSeance = Long.parseLong(seanceType.getEXONERE())
				+ Long.parseLong(seanceType.getMSP())
				+ Long.parseLong(seanceType.getMTHTAXE())
				+ Long.parseLong(seanceType.getMTTVA());
		int SeanceNumber = seanceService.findByMonthAndYear(
				date.getMonth() + "", date.getYear() + "").size();
		String prixTotal = prixSeance * SeanceNumber + "";
		while (prixTotal.length() < 10) {

			prixTotal = "0" + prixTotal;
		}

		borderauLine = borderauLine + prixTotal;// prix total des factures

		borderauLine = borderauLine + "00000000";// date début
		borderauLine = borderauLine + "00000000";// date fin

		final String OLD_FORMAT = "yyyy-MM-dd";
		final String NEW_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		sdf.applyPattern(NEW_FORMAT);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, date.getMonth());
		cal.set(Calendar.YEAR, date.getYear());
		cal.set(Calendar.DAY_OF_MONTH, 1);// This is necessary to get proper
											// results
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		cal.getTime();

		borderauLine = borderauLine + sdf.format(cal.getTime());// date du
																// borderau
		String tva = (Long.parseLong(seanceType.getMTTVA()) * SeanceNumber)
				+ "";
		while (tva.length() < 9) {

			tva = "0" + tva;
		}

		borderauLine = borderauLine + tva;

		return borderauLine;
	}

	@Override
	public String factureLine(Date date, User user) {

		String borderauLine = "";
		borderauLine = "2"; // type facture

		borderauLine = borderauLine + date.getYear();// year borderau

		String borderauNumber = bordereauService.findByMonthAndYear(
				date.getMonth() + "", date.getYear() + "").getBorderauNumber();
		if (borderauNumber == null) {
			borderauNumber = bordereauService.findByMonthAndYear(
					date.getMonth() + "", date.getYear() + "").getId()
					+ "";

		}
		while (borderauNumber.length() < 3) {

			borderauNumber = "0" + borderauNumber;
		}
		borderauLine = borderauLine + borderauNumber;

		borderauLine = borderauLine
				+ cliniqueService.findAll().get(0).getCodecentre();// code
																	// centre

		borderauLine = borderauLine + date.getYear();

		Facture fact = factureService.findByUserAndMonthAndYear(user,
				date.getMonth() + "", date.getYear() + "");
		String factNumber = "";

		try {
			factNumber = fact.getFactureNumber();
			System.out.print("factNumber  =================== " + factNumber);
		} catch (Exception e) {
			factNumber = fact.getId() + "";
		}

		while (factNumber.length() < 5) {

			factNumber = " " + factNumber;
		}

		borderauLine = borderauLine + factNumber;

		borderauLine = borderauLine + "/";

		borderauLine = borderauLine + (date.getYear() + "").substring(2);

		// borderauLine = borderauLine + "00000000";
		borderauLine = borderauLine
				+ cliniqueService.findAll().get(0).getCodebureauxregional();// code
																			// bureau
																			// régional
		borderauLine = borderauLine + "21";

		PatientDetails patientDet = patientDetailsService.findByUserLike(user);
		// borderauLine=borderauLine+date.getYear()+"";
		borderauLine = borderauLine
				+ patientDet.getNumPriseEnCharge().split(" ")[1];

		String priseEnCharge = patientDet.getNumPriseEnCharge().split(" ")[2];

		while (priseEnCharge.length() < 6) {

			priseEnCharge = "0" + priseEnCharge;
		}
		borderauLine = borderauLine + priseEnCharge;
		String numAff1 = "00000000";
		String numAff2 = "00";

		try {
			numAff1 = patientDet.getNumAffilation().split("-")[0];

			while (numAff1.length() < 8) {

				numAff1 = "0" + numAff1;
			}
		} catch (Exception e) {

		}
		try {
			numAff2 = patientDet.getNumAffilation().split("-")[1];

			while (numAff2.length() < 2) {

				numAff2 = "0" + numAff2;
			}
		} catch (Exception e) {

		}

		borderauLine = borderauLine + numAff1 + numAff2;

		// String factureNumber = factureService.findByMonthAndYear(
		// date.getMonth() + "", date.getYear() + "").size()
		// + "";

		List<Seance> seanceList = seanceService.findByUserAndMonthAndYear(user,
				date.getMonth() + "", date.getYear() + "");
		Collections.sort(seanceList);
		String seanceNumber = seanceList.size() + "";

		while (seanceNumber.length() < 3) {

			seanceNumber = "0" + seanceNumber;

		}
		borderauLine = borderauLine + seanceNumber;
		Type st = typeService.findAll().get(0);

		Long prixttc = Long.parseLong(st.getEXONERE())
				+ Long.parseLong(st.getMSP()) + Long.parseLong(st.getMTHTAXE())
				+ Long.parseLong(st.getMTTVA());

		prixttc = prixttc * Long.parseLong(seanceNumber);
		String ppt = prixttc + "";

		while (ppt.length() < 10) {

			ppt = "0" + ppt;

		}
		borderauLine = borderauLine + ppt;
		Date datedebut = seanceList.get(0).getDate();

		System.out.println("datedebut  == " + datedebut);
		Date datefin = seanceList.get(seanceList.size() - 1).getDate();
		System.out.println("datefin  == " + datefin);

		String DateDebutDay = (datedebut.getDate()) + "";
		while (DateDebutDay.length() < 2) {
			DateDebutDay = "0" + DateDebutDay;
		}
		System.out.println("DateDebutDay  == " + DateDebutDay);
		String DateDebutMonth = (datedebut.getMonth() + 1) + "";
		while (DateDebutMonth.length() < 2) {
			DateDebutMonth = "0" + DateDebutMonth;
		}

		String DateDebut = date.getYear() + DateDebutMonth + DateDebutDay;
		borderauLine = borderauLine + DateDebut;

		String DateFinDay = (datefin.getDate()) + "";
		while (DateFinDay.length() < 2) {
			DateFinDay = "0" + DateFinDay;
		}
		System.out.println("DateFinDay  == " + DateFinDay);
		String DateFinMonth = (datefin.getMonth() + 1) + "";
		while (DateFinMonth.length() < 2) {
			DateFinMonth = "0" + DateFinMonth;
		}

		String DateFin = date.getYear() + DateFinMonth + DateFinDay;
		borderauLine = borderauLine + DateFin;

		final String OLD_FORMAT = "yyyy-MM-dd";
		final String NEW_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		sdf.applyPattern(NEW_FORMAT);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, date.getMonth());
		cal.set(Calendar.YEAR, date.getYear());
		cal.set(Calendar.DAY_OF_MONTH, 1);// This is necessary to get proper
											// results
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		cal.getTime();

		borderauLine = borderauLine + sdf.format(cal.getTime());// date du
																// borderau

		Long prixTVA = seanceList.size() * Long.parseLong(st.getMTTVA());

		String tva = prixTVA + "";

		while (tva.length() < 9) {

			tva = "0" + tva;

		}
		borderauLine = borderauLine + tva;

		return borderauLine;
	}

	@Override
	public String complementfactureLine(Bordereau bordereau) {
		List<Facture> factList = factureService
				.findListFactureByBorderauNumber(bordereau);

		String compList = "";

		for (Facture fact : factList) {

			// ****************************************

			String borderauLine = "";
			borderauLine = "2"; // type facture

			borderauLine = borderauLine + bordereau.getYear();// year borderau

			String borderauNumber = bordereau.getBorderauNumber();
			if (borderauNumber == null) {
				borderauNumber = bordereau.getId() + "";
			}
			while (borderauNumber.length() < 3) {

				borderauNumber = "0" + borderauNumber;
			}
			borderauLine = borderauLine + borderauNumber;

			borderauLine = borderauLine
					+ cliniqueService.findAll().get(0).getCodecentre();// code
																		// centre

			borderauLine = borderauLine + bordereau.getYear();

			// Facture fact =
			// factureService.findByUserAndMonthAndYear(user,date.getMonth()+""
			// , date.getYear()+"");
			String factNumber = "";

			try {
				factNumber = fact.getFactureNumber();
				System.out.print("factNumber  =================== "
						+ factNumber);
			} catch (Exception e) {
				factNumber = fact.getId() + "";
			}

			while (factNumber.length() < 5) {

				factNumber = " " + factNumber;
			}

			borderauLine = borderauLine + factNumber;

			borderauLine = borderauLine + "/";

			borderauLine = borderauLine + (fact.getYear() + "").substring(2);

			// borderauLine = borderauLine + "00000000";
			borderauLine = borderauLine
					+ cliniqueService.findAll().get(0).getCodebureauxregional();// code
																				// bureau
																				// régional
			borderauLine = borderauLine + "21";

			PatientDetails patientDet = patientDetailsService
					.findByUserLike(fact.getUser());
			borderauLine = borderauLine
					+ patientDet.getNumPriseEnCharge().split(" ")[1];

			String priseEnCharge = patientDet.getNumPriseEnCharge().split(" ")[2];

			while (priseEnCharge.length() < 6) {

				priseEnCharge = "0" + priseEnCharge;
			}
			borderauLine = borderauLine + priseEnCharge;
			String numAff1 = "00000000";
			String numAff2 = "00";

			try {
				numAff1 = patientDet.getNumAffilation().split("-")[0];

				while (numAff1.length() < 8) {

					numAff1 = "0" + numAff1;
				}
			} catch (Exception e) {

			}
			try {
				numAff2 = patientDet.getNumAffilation().split("-")[1];

				while (numAff2.length() < 2) {

					numAff2 = "0" + numAff2;
				}
			} catch (Exception e) {

			}

			borderauLine = borderauLine + numAff1 + numAff2;

			// String factureNumber = factureService.findByMonthAndYear(
			// date.getMonth() + "", date.getYear() + "").size()
			// + "";

			List<Seance> seanceList = seanceService.findByUserAndMonthAndYear(
					fact.getUser(), fact.getMonth() + "", fact.getYear() + "");
			Collections.sort(seanceList);
			String seanceNumber = seanceList.size() + "";

			while (seanceNumber.length() < 3) {

				seanceNumber = "0" + seanceNumber;

			}
			borderauLine = borderauLine + seanceNumber;
			Type st = typeService.findAll().get(0);

			Long prixttc = Long.parseLong(st.getEXONERE())
					+ Long.parseLong(st.getMSP())
					+ Long.parseLong(st.getMTHTAXE())
					+ Long.parseLong(st.getMTTVA());

			prixttc = prixttc * Long.parseLong(seanceNumber);
			String ppt = prixttc + "";

			while (ppt.length() < 10) {

				ppt = "0" + ppt;

			}
			borderauLine = borderauLine + ppt;
			Date datedebut = seanceList.get(0).getDate();

			System.out.println("datedebut  == " + datedebut);
			Date datefin = seanceList.get(seanceList.size() - 1).getDate();
			System.out.println("datefin  == " + datefin);

			String DateDebutDay = (datedebut.getDate()) + "";
			while (DateDebutDay.length() < 2) {
				DateDebutDay = "0" + DateDebutDay;
			}
			System.out.println("DateDebutDay  == " + DateDebutDay);
			String DateDebutMonth = (datedebut.getMonth() + 1) + "";
			while (DateDebutMonth.length() < 2) {
				DateDebutMonth = "0" + DateDebutMonth;
			}

			String DateDebut = fact.getYear() + DateDebutMonth + DateDebutDay;
			borderauLine = borderauLine + DateDebut;

			String DateFinDay = (datefin.getDate()) + "";
			while (DateFinDay.length() < 2) {
				DateFinDay = "0" + DateFinDay;
			}
			System.out.println("DateFinDay  == " + DateFinDay);
			String DateFinMonth = (datefin.getMonth() + 1) + "";
			while (DateFinMonth.length() < 2) {
				DateFinMonth = "0" + DateFinMonth;
			}

			String DateFin = fact.getYear() + DateFinMonth + DateFinDay;
			borderauLine = borderauLine + DateFin;

			final String OLD_FORMAT = "yyyy-MM-dd";
			final String NEW_FORMAT = "yyyyMMdd";
			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			sdf.applyPattern(NEW_FORMAT);

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, fact.getDate().getMonth());
			cal.set(Calendar.YEAR, fact.getDate().getYear());
			cal.set(Calendar.DAY_OF_MONTH, 1);// This is necessary to get proper
												// results
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
			cal.getTime();

			borderauLine = borderauLine + sdf.format(cal.getTime());// date du
																	// borderau

			Long prixTVA = seanceList.size() * Long.parseLong(st.getMTTVA());

			String tva = prixTVA + "";

			while (tva.length() < 9) {

				tva = "0" + tva;

			}
			borderauLine = borderauLine + tva;

			// return borderauLine;

			compList = compList + borderauLine + "\n";
			// ****************************************

		}

		return compList;
	}

	@Override
	public String borderauLine2017(Date date) {
		// TODO Auto-generated method stub
		String borderauLine = "";
		borderauLine = "1"; // type borderau
		borderauLine = borderauLine + date.getYear();// year borderau

		String borderauNumber = bordereauService.findByMonthAndYear(
				date.getMonth() + "", date.getYear() + "").getBorderauNumber();
		if (borderauNumber == null || "0".equals(borderauNumber)) {
			borderauNumber = bordereauService.findByMonthAndYear(
					date.getMonth() + "", date.getYear() + "").getId()
					+ "";

		}
		System.out.println("****************borderauNumber "+borderauNumber);
		while (borderauNumber.length() < 3) {

			borderauNumber = "0" + borderauNumber;
		}
		borderauLine = borderauLine + borderauNumber;

		// added 2017 02
		borderauLine = borderauLine + "02";

		borderauLine = borderauLine
				+ cliniqueService.findAll().get(0).getCodecentre();// code
																	// centre

		borderauLine = borderauLine + date.getYear();
		borderauLine = borderauLine + "00000000";
		borderauLine = borderauLine
				+ cliniqueService.findAll().get(0).getCodebureauxregional();// code
																			// bureau
																			// régional
		borderauLine = borderauLine + "21";

		// dded 2017
		borderauLine = borderauLine + date.getYear();// year
		borderauLine = borderauLine + "00000000";

		String employmentNumber = cliniqueService.findAll().get(0)
				.getEmployNumber();

		while (employmentNumber.length() < 12) {
			employmentNumber = "0" + employmentNumber;

		}

		borderauLine = borderauLine + employmentNumber;

		String factureNumber = factureService.findByMonthAndYear(
				date.getMonth() + "", date.getYear() + "").size()
				+ "";

		while (factureNumber.length() < 3) {
			factureNumber = "0" + factureNumber;

		}

		borderauLine = borderauLine + factureNumber;// nombre de facture par
													// borderau

		Type seanceType = typeService.findAll().get(0);
		Long prixSeance = Long.parseLong(seanceType.getEXONERE())
				+ Long.parseLong(seanceType.getMSP())
				+ Long.parseLong(seanceType.getMTHTAXE())
				+ Long.parseLong(seanceType.getMTTVA());
		int SeanceNumber = seanceService.findByMonthAndYear(
				date.getMonth() + "", date.getYear() + "").size();
		String prixTotal = prixSeance * SeanceNumber + "";
		while (prixTotal.length() < 10) {

			prixTotal = "0" + prixTotal;
		}

		borderauLine = borderauLine + prixTotal;// prix total des factures

		borderauLine = borderauLine + "00000000";// date début
		borderauLine = borderauLine + "00000000";// date fin

		final String OLD_FORMAT = "yyyy-MM-dd";
		final String NEW_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		sdf.applyPattern(NEW_FORMAT);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, date.getMonth());
		cal.set(Calendar.YEAR, date.getYear());
		cal.set(Calendar.DAY_OF_MONTH, 1);// This is necessary to get proper
											// results
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		cal.getTime();

		borderauLine = borderauLine + sdf.format(cal.getTime());// date du
																// borderau
		String tva = (Long.parseLong(seanceType.getMTTVA()) * SeanceNumber)
				+ "";
		while (tva.length() < 9) {

			tva = "0" + tva;
		}

		borderauLine = borderauLine + tva;

		// added 2017 total horsTax
		String horsTaxe = (Long.parseLong(seanceType.getMTHTAXE()) * SeanceNumber)
				+ "";

		while (horsTaxe.length() < 10) {

			horsTaxe = "0" + horsTaxe;
		}
		borderauLine = borderauLine + horsTaxe;
		return borderauLine;
	}

	@Override
	public String factureLine2017(Date date, User user) {

		String borderauLine = "";
		borderauLine = "2"; // type facture

		borderauLine = borderauLine + date.getYear();// year borderau

		String borderauNumber = bordereauService.findByMonthAndYear(
				date.getMonth() + "", date.getYear() + "").getBorderauNumber();
		if (borderauNumber == null || "0".equals(borderauNumber)) {
			borderauNumber = bordereauService.findByMonthAndYear(
					date.getMonth() + "", date.getYear() + "").getId()
					+ "";

		}
		while (borderauNumber.length() < 3) {

			borderauNumber = "0" + borderauNumber;
		}
		borderauLine = borderauLine + borderauNumber;

		
		
		
		
		//added  2017
		borderauLine = borderauLine+"02";
		
		borderauLine = borderauLine
				+ cliniqueService.findAll().get(0).getCodecentre();// code
																	// centre

		borderauLine = borderauLine + date.getYear();
		
		
		
		

		Facture fact = factureService.findByUserAndMonthAndYear(user,
				date.getMonth() + "", date.getYear() + "");
		String factNumber = "";

		try {
			factNumber = fact.getFactureNumber();
			System.out.print("factNumber  =================== " + factNumber);
		} catch (Exception e) {
			factNumber = fact.getId() + "";
		}

		
		//modified 2017 5---->8
		while (factNumber.length() < 8) {

			factNumber = "0" + factNumber;
		}

		
		borderauLine = borderauLine + factNumber;

		
		borderauLine = borderauLine
				+ cliniqueService.findAll().get(0).getCodebureauxregional();// code
																			// bureau
																			// régional
		borderauLine = borderauLine + "21";

		
		//added 2017
//		borderauLine = borderauLine + date.getYear();// year borderau
		
		
		
		
		
		PatientDetails patientDet = patientDetailsService.findByUserLike(user);
		// borderauLine=borderauLine+date.getYear()+"";
		borderauLine = borderauLine
				+ patientDet.getNumPriseEnCharge().split(" ")[1];

		String priseEnCharge = patientDet.getNumPriseEnCharge().split(" ")[2];

		while (priseEnCharge.length() < 6) {

			priseEnCharge = "0" + priseEnCharge;
		}
		borderauLine = borderauLine + priseEnCharge;
		
		
		//added 2017    if F0  NOTRE PATIENT
		borderauLine = borderauLine + "F0";
		
		
		
		
		String numAff1 = "00000000";
		String numAff2 = "00";

		
		
		//modified 2017 8----->10
		try {
			numAff1 = patientDet.getNumAffilation().split("-")[0];

			while (numAff1.length() < 10) {

				numAff1 = "0" + numAff1;
			}
		} catch (Exception e) {

		}
		try {
			numAff2 = patientDet.getNumAffilation().split("-")[1];

			while (numAff2.length() < 2) {

				numAff2 = "0" + numAff2;
			}
		} catch (Exception e) {

		}

		borderauLine = borderauLine + numAff1 + numAff2;

		// String factureNumber = factureService.findByMonthAndYear(
		// date.getMonth() + "", date.getYear() + "").size()
		// + "";

		List<Seance> seanceList = seanceService.findByUserAndMonthAndYear(user,
				date.getMonth() + "", date.getYear() + "");
		Collections.sort(seanceList);
		String seanceNumber = seanceList.size() + "";

		while (seanceNumber.length() < 3) {

			seanceNumber = "0" + seanceNumber;

		}
		borderauLine = borderauLine + seanceNumber;
		
		
		
		Type st = typeService.findAll().get(0);

		Long prixttc = Long.parseLong(st.getEXONERE())
				+ Long.parseLong(st.getMSP()) + Long.parseLong(st.getMTHTAXE())
				+ Long.parseLong(st.getMTTVA());

		prixttc = prixttc * Long.parseLong(seanceNumber);
		String ppt = prixttc + "";

		while (ppt.length() < 10) {

			ppt = "0" + ppt;

		}
		borderauLine = borderauLine + ppt;
		
		
		
		
		
		Date datedebut = seanceList.get(0).getDate();

		System.out.println("datedebut  == " + datedebut);
		Date datefin = seanceList.get(seanceList.size() - 1).getDate();
		System.out.println("datefin  == " + datefin);

		String DateDebutDay = (datedebut.getDate()) + "";
		while (DateDebutDay.length() < 2) {
			DateDebutDay = "0" + DateDebutDay;
		}
		System.out.println("DateDebutDay  == " + DateDebutDay);
		String DateDebutMonth = (datedebut.getMonth() + 1) + "";
		while (DateDebutMonth.length() < 2) {
			DateDebutMonth = "0" + DateDebutMonth;
		}

		String DateDebut = date.getYear() + DateDebutMonth + DateDebutDay;
		borderauLine = borderauLine + DateDebut;

		String DateFinDay = (datefin.getDate()) + "";
		while (DateFinDay.length() < 2) {
			DateFinDay = "0" + DateFinDay;
		}
		System.out.println("DateFinDay  == " + DateFinDay);
		String DateFinMonth = (datefin.getMonth() + 1) + "";
		while (DateFinMonth.length() < 2) {
			DateFinMonth = "0" + DateFinMonth;
		}

		String DateFin = date.getYear() + DateFinMonth + DateFinDay;
		borderauLine = borderauLine + DateFin;

		final String OLD_FORMAT = "yyyy-MM-dd";
		final String NEW_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		sdf.applyPattern(NEW_FORMAT);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, date.getMonth());
		cal.set(Calendar.YEAR, date.getYear());
		cal.set(Calendar.DAY_OF_MONTH, 1);// This is necessary to get proper
											// results
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		cal.getTime();

		borderauLine = borderauLine + sdf.format(cal.getTime());// date du
																// borderau

		Long prixTVA = seanceList.size() * Long.parseLong(st.getMTTVA());

		String tva = prixTVA + "";

		while (tva.length() < 9) {

			tva = "0" + tva;

		}
		borderauLine = borderauLine + tva;
		
		
		

		Long prixHtax = seanceList.size() * Long.parseLong(st.getMTHTAXE());

		String horstax = prixHtax + "";

		while (horstax.length() < 10) {

			horstax = "0" + horstax;

		}
		borderauLine = borderauLine + horstax;

		return borderauLine;

	}

}
