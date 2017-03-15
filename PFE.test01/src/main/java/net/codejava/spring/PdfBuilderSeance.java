package net.codejava.spring;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.haythem.model.PatientDetailsInformationModel;
import com.haythem.persistance.Banque;
import com.haythem.persistance.Clinique;
import com.haythem.persistance.Information;
import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.Seance;
import com.haythem.persistance.Type;
import com.haythem.persistance.User;
import com.haythem.service.InformationService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.SeanceService;
import com.haythem.service.TypeService;
import com.haythem.service.Impl.FrenchNumberToWords;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PdfBuilderSeance {

	public static Font normal = FontFactory.getFont(BaseFont.IDENTITY_H, 10,
			Font.NORMAL);
	public static Font normal2 = FontFactory.getFont(BaseFont.IDENTITY_H, 12,
			Font.NORMAL);

	public void doPdf(List<Seance> seanceList, Document doc,
			Information information, PatientDetails patientDetails, Clinique clinique, Banque banque)
			throws DocumentException, ParseException {
		doc.open();
		
		Paragraph preface = new Paragraph(new Phrase("", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
//		preface = new Paragraph(new Phrase("\n", normal));
//		preface.setAlignment(Element.ALIGN_LEFT);
//		doc.add(preface);
//		preface = new Paragraph(new Phrase("\n", normal));
//		preface.setAlignment(Element.ALIGN_LEFT);
//		doc.add(preface);
	
	
		
		
//		 preface = new Paragraph(new Phrase("CLINIQUE EBN EL HAYTHEM DE DIALYSE", normal));
		 preface = new Paragraph(new Phrase(""+clinique.getNom(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
//			preface = new Paragraph(new Phrase("AVENUE DE L'ENVIRONNEMENT EL NAHAL GABES", normal));
			preface = new Paragraph(new Phrase(""+clinique.getAdress(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
//			preface = new Paragraph(new Phrase("T.V.A : 1355934 R A M 000 ", normal));
			preface = new Paragraph(new Phrase("T.V.A : "+clinique.getTva(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
			
//			preface = new Paragraph(new Phrase("N°EMPLOYEUR : 56615159²", normal));
			preface = new Paragraph(new Phrase("N°EMPLOYEUR : "+clinique.getEmployNumber(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
//			preface = new Paragraph(new Phrase("TEL:98 430 095/50 636 847", normal));
			preface = new Paragraph(new Phrase("TEL: "+clinique.getTel(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
//			preface = new Paragraph(new Phrase("REG DE COMMERCE : B02140622014", normal));
			preface = new Paragraph(new Phrase("REG DE COMMERCE : "+clinique.getRegistreDeCmmerce(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
		preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		if (seanceList.size() > 0) {
			
			
			if(seanceList.get(0).getFacture().getFactureNumber()==null){
		preface = new Paragraph(new Phrase("FACTURE D'HEMODIALYSE N° "+seanceList.get(0).getFacture().getId(), normal));
		preface.setAlignment(Element.ALIGN_CENTER);
		doc.add(preface);
			}else{
				preface = new Paragraph(new Phrase("FACTURE D'HEMODIALYSE N° "+seanceList.get(0).getFacture().getFactureNumber(), normal));
				preface.setAlignment(Element.ALIGN_CENTER);
				doc.add(preface);
				
			}
		
		preface = new Paragraph(new Phrase("", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase("", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
//		doc.add(preface);preface = new Paragraph(new Phrase("\n", normal));
//		preface.setAlignment(Element.ALIGN_LEFT);
//		preface = new Paragraph(new Phrase("\n", normal));
//		preface.setAlignment(Element.ALIGN_LEFT);
//		doc.add(preface);
		
//		doc.add(new Paragraph("FACTURE D'HEMODIALYSE N° "+seanceList.get(0).getFacture().getId()));
		doc.addCreator("Educanet");
		
		
		preface = new Paragraph(new Phrase("     Doit                         : "+patientDetails.getDOIT(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase("     Affilé                        : "+patientDetails.getAffile(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		try{
		preface = new Paragraph(new Phrase("     Nom du patient       : "
				+ information.getFirstName() + " " + information.getLastName(), normal));
		
		}catch(Exception e){
			
			preface = new Paragraph(new Phrase("     Nom du patient       : "
					, normal));
		}
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		
		final String OLD_FORMAT = "yyyy-MM-dd";
		final String NEW_FORMAT = "dd/MM/yyyy";

		// August 12, 2010
//		String oldDateString = patientDetails.getDateDebut()+"";
		String newDateString;

		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
//		Date d = sdf.parse(oldDateString);
		sdf.applyPattern(NEW_FORMAT);
//		newDateString = sdf.format(patientDetails.getDateDebut());
		
		preface = new Paragraph(new Phrase("     N°Affilation             : "+patientDetails.getNumAffilation(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("     Prise en charge      : N°"+patientDetails.getNumPriseEnCharge()+" DU "+sdf.format(patientDetails.getDateDebut())+" AU "+sdf.format(patientDetails.getDateFin()), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("     Nombre de Séance      : "+seanceList.size(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.MONTH, seanceList.get(0).getDate().getMonth());
//	    cal.set(Calendar.YEAR, seanceList.get(0).getDate().getYear());
	    cal.set(Calendar.YEAR, 2017);
	    cal.set(Calendar.DAY_OF_MONTH, 1);// This is necessary to get proper results
	    cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
	    cal.getTime();	
	    preface = new Paragraph(new Phrase("     Date Facture          : "+sdf.format(cal.getTime()), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 4.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);

		font.setColor(BaseColor.WHITE);
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Jour de présence", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("MT,H,TAXE", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("MT T,V,A", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("EXONERE", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("M,S,P", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("T,T,C", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		int i = 1;
		// write table row data

		Long MTHTAXE = 0L;
		Long MTTVA = 0L;
		Long EXONERE = 0L;
		Long MSP = 0L;

		Long totalMTHTAXE = 0L;
		Long totalMTTVA = 0L;
		Long totalEXONERE = 0L;
		Long totalMSP = 0L;
		Long totalGlobal = 0L;
		if (seanceList.size() > 0) {
			for (Seance aSeance : seanceList) {

				if (i == 1) {
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase("1 ére seance  "
							+ sdf.format(aSeance.getDate()), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
					i++;
				} else {
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase(i + " éme seance "
							+ sdf.format(aSeance.getDate() ), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);

					i++;
				}

				MTHTAXE = Long.parseLong(aSeance.getType().getMTHTAXE());
				MTTVA = Long.parseLong(aSeance.getType().getMTTVA());
				EXONERE = Long.parseLong(aSeance.getType().getEXONERE());
				MSP = Long.parseLong(aSeance.getType().getMSP());
				totalMTHTAXE = totalMTHTAXE + MTHTAXE;
				totalMTTVA = totalMTTVA + MTTVA;
				totalEXONERE = totalEXONERE + EXONERE;
				totalMSP = totalMSP + MSP;

				String str = MTHTAXE + "";
				str = new StringBuilder(str).insert(str.length() - 3, ",")
						.toString();
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setPhrase(new Phrase(str, normal));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				str = MTTVA + "";
				str = new StringBuilder(str).insert(str.length() - 3, ",")
						.toString();
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setPhrase(new Phrase(str, normal));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				str = EXONERE + "";
				str = new StringBuilder(str).insert(str.length() - 3, ",")
						.toString();
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setPhrase(new Phrase(str, normal));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				str = MSP + "";
				str = new StringBuilder(str).insert(str.length() - 3, ",")
						.toString();
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setPhrase(new Phrase(str, normal));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				str = (MTHTAXE + MTTVA + EXONERE + MSP) + "";
				str = new StringBuilder(str).insert(str.length() - 3, ",")
						.toString();
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setPhrase(new Phrase(str, normal));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				totalGlobal = totalGlobal + MTHTAXE + MTTVA + EXONERE + MSP;

			}
			cell.setPhrase(new Phrase("TOTAL", normal2));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			String str = totalMTHTAXE + "";
			str = new StringBuilder(str).insert(str.length() - 3, ",")
					.toString();
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setPhrase(new Phrase(str, normal2));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			str = totalMTTVA + "";
			str = new StringBuilder(str).insert(str.length() - 3, ",")
					.toString();
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setPhrase(new Phrase(str, normal2));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			str = totalEXONERE + "";
			str = new StringBuilder(str).insert(str.length() - 3, ",")
					.toString();
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setPhrase(new Phrase(str, normal2));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			str = totalMSP + "";
			str = new StringBuilder(str).insert(str.length() - 3, ",")
					.toString();
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setPhrase(new Phrase(str, normal2));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			str = totalGlobal + "";
			str = new StringBuilder(str).insert(str.length() - 3, ",")
					.toString();
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setPhrase(new Phrase(str, normal2));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
		}

		doc.add(table);
//		preface = new Paragraph(new Phrase(convert(totalGlobal.intValue() ), normal));
//		preface.setAlignment(Element.ALIGN_CENTER);
//		doc.add(preface);
		
//		totalGlobal =987L;
		String dinars = FrenchNumberToWords.convert(totalGlobal/1000) +" dinars";
		String Millimes = FrenchNumberToWords.convert(totalGlobal%1000) +" Millimes";
//		preface = new Paragraph(new Phrase("Arretée la présente facture à la somme de : ", normal));
//		preface.setAlignment(Element.ALIGN_LEFT);
//		doc.add(preface);
		preface = new Paragraph(new Phrase("\n" , normal2));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		if(!dinars.equals("zéro dinars")&&!Millimes.equals("zéro Millimes")){
		preface = new Paragraph(new Phrase("Arretée la présente facture à la somme de : "+dinars +" et "+ Millimes, normal2));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		}else if(!dinars.equals("zéro dinars")&&Millimes.equals("zéro Millimes")){
			preface = new Paragraph(new Phrase("Arretée la présente facture à la somme de : "+dinars , normal2));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);

		}else if(dinars.equals("zéro dinars")&&!Millimes.equals("zéro Millimes")){
			preface = new Paragraph(new Phrase("Arretée la présente facture à la somme de : "+Millimes , normal2));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);

		}
		}
		preface = new Paragraph(new Phrase("\n" , normal2));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
//		preface = new Paragraph(new Phrase("BANQUE : (BT) Banque de Tunisie" , normal2));
		preface = new Paragraph(new Phrase("BANQUE : "+banque.getBaqueName() , normal2));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
//		preface = new Paragraph(new Phrase("N°COMPTE : 05038000106300019897" , normal2));
		preface = new Paragraph(new Phrase("N°COMPTE : "+banque.getNumber() , normal2));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase("                                                                           SIGNATURE" , normal2));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);

		doc.close();
	}

	public String convert(int args) {
		String lettre = " ";
		System.out.println(args);
		String chiffre[] = { "un", "deux", "trois", "quatre", "cinq", "six",
				"sept", "huit", "neuf", "Dix", "Onze", "Douze", "Treize",
				"Quatorze", "quinze", "Seize", "Dix Sept", "Dix huit",
				"Dix neuf" };
		String dizaine[] = { "dix", "vingt", "trente", "quarante", "cinquante",
				"soixante", "soixante dix", "quatre vingt", "quatre vingt dix" };
		// System.out.println (dizaine[1]);
		// System.out.println (chiffre[2]);
//		System.out.println("Entrer le montant à convertir");
		int montant = args;
		int resuldiv = (int) (montant) / 1000000;
		System.out.println(resuldiv);
		if (resuldiv == 0) {
			if (resuldiv >= 100) {
				int resuldivpacent = resuldiv / 100;
				System.out.println(resuldivpacent);
				if (resuldivpacent == 1) {
					lettre = lettre + "cent";
				} else {
					lettre = lettre + chiffre[resuldivpacent] + "cent";
					// lettre=lettre+"cent";
				}
			}
		}
		System.out.println(lettre);

		return lettre;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void doPdfTotal(Map<PatientDetailsInformationModel,List<Seance>> seanceListPatient, Document doc,
			 Clinique clinique, Banque banque)
			throws DocumentException, ParseException {
		doc.open();
		String seanceNumber="";
		for (Map.Entry<PatientDetailsInformationModel,List<Seance>> aSeanceListPatient : seanceListPatient.entrySet()) {
		
		
		Paragraph preface = new Paragraph(new Phrase("", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
	
		Long MTHTAXE = 0L;
		Long MTTVA = 0L;
		Long EXONERE = 0L;
//		Long MSP = 0L;

		Long totalMTHTAXE = 0L;
		Long totalMTTVA = 0L;
		Long totalEXONERE = 0L;
//		Long totalMSP = 0L;
		Long totalGlobal = 0L;
		
		
//		 preface = new Paragraph(new Phrase("CLINIQUE EBN EL HAYTHEM DE DIALYSE", normal));
		 preface = new Paragraph(new Phrase(""+clinique.getNom(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
//			preface = new Paragraph(new Phrase("AVENUE DE L'ENVIRONNEMENT EL NAHAL GABES", normal));
			preface = new Paragraph(new Phrase(""+clinique.getAdress(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
//			preface = new Paragraph(new Phrase("T.V.A : 1355934 R A M 000 ", normal));
			preface = new Paragraph(new Phrase("T.V.A : "+clinique.getTva(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
			
//			preface = new Paragraph(new Phrase("N°EMPLOYEUR : 56615159²", normal));
			preface = new Paragraph(new Phrase("N°EMPLOYEUR : "+clinique.getEmployNumber(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
//			preface = new Paragraph(new Phrase("TEL:98 430 095/50 636 847", normal));
			preface = new Paragraph(new Phrase("TEL: "+clinique.getTel(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
//			preface = new Paragraph(new Phrase("REG DE COMMERCE : B02140622014", normal));
			preface = new Paragraph(new Phrase("REG DE COMMERCE : "+clinique.getRegistreDeCmmerce(), normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
		preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		if (aSeanceListPatient.getValue().size() > 0) {
			
			String factureNumber ="";
			if(aSeanceListPatient.getValue().get(0).getFacture().getFactureNumber()==null){
				
				factureNumber =	aSeanceListPatient.getValue().get(0).getFacture().getId()+"";
				
				while (factureNumber.length() < 8) {

					factureNumber = "0" + factureNumber;
				}
				
		preface = new Paragraph(new Phrase("FACTURE D'HEMODIALYSE N° "+factureNumber, normal));
		preface.setAlignment(Element.ALIGN_CENTER);
		doc.add(preface);
			}else{
				
				
	    factureNumber =	aSeanceListPatient.getValue().get(0).getFacture().getFactureNumber()+"";
				
				while (factureNumber.length() < 8) {

					factureNumber = "0" + factureNumber;
				}
				
				preface = new Paragraph(new Phrase("FACTURE D'HEMODIALYSE N° "+factureNumber, normal));
				preface.setAlignment(Element.ALIGN_CENTER);
				doc.add(preface);
				
			}
		
		preface = new Paragraph(new Phrase("", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase("", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
//		doc.add(new Paragraph("FACTURE D'HEMODIALYSE N° "+seanceList.get(0).getFacture().getId()));
		doc.addCreator("Educanet");
		
		
		preface = new Paragraph(new Phrase("     Doit                         : "+aSeanceListPatient.getKey().getPatientDetails().getDOIT(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase("     Affilé                        : "+aSeanceListPatient.getKey().getPatientDetails().getAffile(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		try{
		preface = new Paragraph(new Phrase("     Nom du patient       : "
				+ aSeanceListPatient.getKey().getInformation().getFirstName() + " " + aSeanceListPatient.getKey().getInformation().getLastName(), normal));
		
		}catch(Exception e){
			
			preface = new Paragraph(new Phrase("     Nom du patient       : "
					, normal));
		}
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		
		final String OLD_FORMAT = "yyyy-MM-dd";
		final String NEW_FORMAT = "dd/MM/yyyy";

		// August 12, 2010
//		String oldDateString = patientDetails.getDateDebut()+"";
		String newDateString;

		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
//		Date d = sdf.parse(oldDateString);
		sdf.applyPattern(NEW_FORMAT);
//		newDateString = sdf.format(patientDetails.getDateDebut());
		
		preface = new Paragraph(new Phrase("     N°Affilation             : "+aSeanceListPatient.getKey().getPatientDetails().getNumAffilation(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("     Prise en charge      : N°"+aSeanceListPatient.getKey().getPatientDetails().getNumPriseEnCharge()+" DU "+sdf.format(aSeanceListPatient.getKey().getPatientDetails().getDateDebut())+" AU "+sdf.format(aSeanceListPatient.getKey().getPatientDetails().getDateFin()), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("     Nombre de Séance      : "+aSeanceListPatient.getValue().size(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		 seanceNumber = aSeanceListPatient.getValue().size()+"";
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.MONTH, aSeanceListPatient.getValue().get(0).getDate().getMonth());
//	    cal.set(Calendar.YEAR, seanceList.get(0).getDate().getYear());
	    cal.set(Calendar.YEAR, 2017);
	    cal.set(Calendar.DAY_OF_MONTH, 1);// This is necessary to get proper results
	    cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
	    cal.getTime();	
	    preface = new Paragraph(new Phrase("     Date Facture          : "+sdf.format(cal.getTime()), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase("\n", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);

//		PdfPTable table = new PdfPTable(6);
		PdfPTable table = new PdfPTable(3);
		
		table.setWidthPercentage(100.0f);
//		table.setWidths(new float[] { 4.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
		
		table.setWidths(new float[] { 4.0f, 3.0f, 3.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);

		font.setColor(BaseColor.WHITE);
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPadding(5);
		// write table header
//		cell.setPhrase(new Phrase("Jour de présence", normal));
		cell.setPhrase(new Phrase("SEANCES", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("MONTANT", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("T.V.A", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
//		cell.setPhrase(new Phrase("EXONERE", normal));
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		table.addCell(cell);
//		cell.setPhrase(new Phrase("M,S,P", normal));
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		table.addCell(cell);
//		cell.setPhrase(new Phrase("T,T,C", normal));
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		table.addCell(cell);

		int i = 1;
		// write table row data

	
		if (aSeanceListPatient.getValue().size() > 0) {
			for (Seance aSeance : aSeanceListPatient.getValue()) {

				if (i == 1) {
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase("1 ére seance  "
							+ sdf.format(aSeance.getDate()), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
					i++;
				} else {
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase(i + " éme seance "
							+ sdf.format(aSeance.getDate() ), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);

					i++;
				}

				MTHTAXE = Long.parseLong(aSeance.getType().getMTHTAXE());
				MTTVA = Long.parseLong(aSeance.getType().getMTTVA());
				EXONERE = Long.parseLong(aSeance.getType().getEXONERE());
//				MSP = Long.parseLong(aSeance.getType().getMSP());
				totalMTHTAXE = totalMTHTAXE + MTHTAXE;
				totalMTTVA = totalMTTVA + MTTVA;
				totalEXONERE = totalEXONERE + EXONERE;
//				totalMSP = totalMSP + MSP;
				String str ="";
//				 str = MTHTAXE + "";
//				str = new StringBuilder(str).insert(str.length() - 3, ",")
//						.toString();
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				cell.setPhrase(new Phrase(str, normal));
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				table.addCell(cell);
				
				str = (MTHTAXE + MTTVA + EXONERE ) + "";
				str = new StringBuilder(str).insert(str.length() - 3, ",")
						.toString();
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setPhrase(new Phrase(str, normal));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				
				
				
				
				str = MTTVA + "";
				str = new StringBuilder(str).insert(str.length() - 3, ",")
						.toString();
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setPhrase(new Phrase(str, normal));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
//				str = EXONERE + "";
//				str = new StringBuilder(str).insert(str.length() - 3, ",")
//						.toString();
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				cell.setPhrase(new Phrase(str, normal));
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				table.addCell(cell);

//				str = MSP + "";
//				str = new StringBuilder(str).insert(str.length() - 3, ",")
//						.toString();
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				cell.setPhrase(new Phrase(str, normal));
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				table.addCell(cell);
				
				
//				str = (MTHTAXE + MTTVA + EXONERE + MSP) + "";
//				str = new StringBuilder(str).insert(str.length() - 3, ",")
//						.toString();
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				cell.setPhrase(new Phrase(str, normal));
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//				table.addCell(cell);
				
				
//				totalGlobal = totalGlobal + MTHTAXE + MTTVA + EXONERE + MSP;
				totalGlobal = totalGlobal + MTHTAXE + MTTVA + EXONERE;

			}
			cell.setPhrase(new Phrase("TOTAL", normal2));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			
			String str="";
			
//			 str = totalMTHTAXE + "";
//			str = new StringBuilder(str).insert(str.length() - 3, ",")
//					.toString();
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			cell.setPhrase(new Phrase(str, normal2));
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			table.addCell(cell);
//			
			
			str = totalGlobal + "";
			str = new StringBuilder(str).insert(str.length() - 3, ",")
					.toString();
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setPhrase(new Phrase(str, normal2));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			
			
			
			
			str = totalMTTVA + "";
			str = new StringBuilder(str).insert(str.length() - 3, ",")
					.toString();
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setPhrase(new Phrase(str, normal2));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
//			str = totalEXONERE + "";
//			str = new StringBuilder(str).insert(str.length() - 3, ",")
//					.toString();
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			cell.setPhrase(new Phrase(str, normal2));
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			table.addCell(cell);
//			str = totalMSP + "";
//			str = new StringBuilder(str).insert(str.length() - 3, ",")
//					.toString();
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			cell.setPhrase(new Phrase(str, normal2));
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			table.addCell(cell);
//			str = totalGlobal + "";
//			str = new StringBuilder(str).insert(str.length() - 3, ",")
//					.toString();
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			cell.setPhrase(new Phrase(str, normal2));
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			table.addCell(cell);
		}

		doc.add(table);
//		preface = new Paragraph(new Phrase(convert(totalGlobal.intValue() ), normal));
//		preface.setAlignment(Element.ALIGN_CENTER);
//		doc.add(preface);
		
		
		  String 	str ;
				str = totalEXONERE + "";
				str = new StringBuilder(str).insert(str.length() - 3, ",")
						.toString();
			preface = new Paragraph(new Phrase("Montant exonéré : 33 ,000 D x "+seanceNumber+" = "+str +" D", normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
			
			
			str = totalMTHTAXE + "";
			str = new StringBuilder(str).insert(str.length() - 3, ",")
					.toString();
			preface = new Paragraph(new Phrase("Montant H T       : 62.264 D  x "+seanceNumber+" = "+str +" D", normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
			
			
		 	str = totalMTTVA + "";
				str = new StringBuilder(str).insert(str.length() - 3, ",")
						.toString();
			preface = new Paragraph(new Phrase("Montant TVA      : 3.736 D   x "+seanceNumber+" = "+str +" D", normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
			
		    
			str = totalGlobal + "";
			str = new StringBuilder(str).insert(str.length() - 3, ",")
					.toString();
				preface = new Paragraph(new Phrase("Montant TTC      :  "+str +" D", normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);
//		totalGlobal =987L;
		String dinars = FrenchNumberToWords.convert(totalGlobal/1000) +" dinars";
		String Millimes = FrenchNumberToWords.convert(totalGlobal%1000) +" Millimes";
//		preface = new Paragraph(new Phrase("Arretée la présente facture à la somme de : ", normal));
//		preface.setAlignment(Element.ALIGN_LEFT);
//		doc.add(preface);
//		preface = new Paragraph(new Phrase("\n" , normal2));
//		preface.setAlignment(Element.ALIGN_LEFT);
//		doc.add(preface);
		if(!dinars.equals("zéro dinars")&&!Millimes.equals("zéro Millimes")){
		preface = new Paragraph(new Phrase("Arretée la présente facture à la somme de : "+dinars +" et "+ Millimes, normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		}else if(!dinars.equals("zéro dinars")&&Millimes.equals("zéro Millimes")){
			preface = new Paragraph(new Phrase("Arretée la présente facture à la somme de : "+dinars , normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);

		}else if(dinars.equals("zéro dinars")&&!Millimes.equals("zéro Millimes")){
			preface = new Paragraph(new Phrase("Arretée la présente facture à la somme de : "+Millimes , normal));
			preface.setAlignment(Element.ALIGN_LEFT);
			doc.add(preface);

		}
		}
		
	
		
		

//		preface = new Paragraph(new Phrase("BANQUE : "+banque.getBaqueName() , normal));
//		preface.setAlignment(Element.ALIGN_LEFT);
//		doc.add(preface);
//
//		preface = new Paragraph(new Phrase("N°COMPTE : "+banque.getNumber() , normal));
//		preface.setAlignment(Element.ALIGN_LEFT);
//		doc.add(preface);
		
		
		preface = new Paragraph(new Phrase("                                                                           SIGNATURE" , normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		 doc.newPage();
		}
		doc.close();
	}
	
	

}

//class FrenchNumberToWords {
//	  private static final String[] dizaineNames = {
//	    "",
//	    "",
//	    "vingt",
//	    "trente",
//	    "quarante",
//	    "cinquante",
//	    "soixante",
//	    "soixante",
//	    "quatre-vingt",
//	    "quatre-vingt"
//	  };
//
//	  private static final String[] uniteNames1 = {
//	    "",
//	    "un",
//	    "deux",
//	    "trois",
//	    "quatre",
//	    "cinq",
//	    "six",
//	    "sept",
//	    "huit",
//	    "neuf",
//	    "dix",
//	    "onze",
//	    "douze",
//	    "treize",
//	    "quatorze",
//	    "quinze",
//	    "seize",
//	    "dix-sept",
//	    "dix-huit",
//	    "dix-neuf"
//	  };
//
//	  private static final String[] uniteNames2 = {
//	    "",
//	    "",
//	    "deux",
//	    "trois",
//	    "quatre",
//	    "cinq",
//	    "six",
//	    "sept",
//	    "huit",
//	    "neuf",
//	    "dix"
//	  };
//
//	  private FrenchNumberToWords() {}
//
//	  private static String convertZeroToHundred(int number) {
//
//	    int laDizaine = number / 10;
//	    int lUnite = number % 10;
//	    String resultat = "";
//
//	    switch (laDizaine) {
//	    case 1 :
//	    case 7 :
//	    case 9 :
//	      lUnite = lUnite + 10;
//	      break;
//	    default:
//	    }
//
//	    // séparateur "-" "et"  ""
//	    String laLiaison = "";
//	    if (laDizaine > 1) {
//	      laLiaison = "-";
//	    }
//	    // cas particuliers
//	    switch (lUnite) {
//	    case 0:
//	      laLiaison = "";
//	      break;
//	    case 1 :
//	      if (laDizaine == 8) {
//	        laLiaison = "-";
//	      }
//	      else {
//	        laLiaison = " et ";
//	      }
//	      break;
//	    case 11 :
//	      if (laDizaine==7) {
//	        laLiaison = " et ";
//	      }
//	      break;
//	    default:
//	    }
//
//	    // dizaines en lettres
//	    switch (laDizaine) {
//	    case 0:
//	      resultat = uniteNames1[lUnite];
//	      break;
//	    case 8 :
//	      if (lUnite == 0) {
//	        resultat = dizaineNames[laDizaine];
//	      }
//	      else {
//	        resultat = dizaineNames[laDizaine]
//	                                + laLiaison + uniteNames1[lUnite];
//	      }
//	      break;
//	    default :
//	      resultat = dizaineNames[laDizaine]
//	                              + laLiaison + uniteNames1[lUnite];
//	    }
//	    return resultat;
//	  }
//
//	  private static String convertLessThanOneThousand(int number) {
//
//	    int lesCentaines = number / 100;
//	    int leReste = number % 100;
//	    String sReste = convertZeroToHundred(leReste);
//
//	    String resultat;
//	    switch (lesCentaines) {
//	    case 0:
//	      resultat = sReste;
//	      break;
//	    case 1 :
//	      if (leReste > 0) {
//	        resultat = "cent " + sReste;
//	      }
//	      else {
//	        resultat = "cent";
//	      }
//	      break;
//	    default :
//	      if (leReste > 0) {
//	        resultat = uniteNames2[lesCentaines] + " cent " + sReste;
//	      }
//	      else {
//	        resultat = uniteNames2[lesCentaines] + " cents";
//	      }
//	    }
//	    return resultat;
//	  }
//
//	  public static String convert(long number) {
//	    // 0 à 999 999 999 999
//	    if (number == 0) { return "zéro"; }
//
//	    String snumber = Long.toString(number);
//
//	    // pad des "0"
//	    String mask = "000000000000";
//	    DecimalFormat df = new DecimalFormat(mask);
//	    snumber = df.format(number);
//
//	    // XXXnnnnnnnnn
//	    int lesMilliards = Integer.parseInt(snumber.substring(0,3));
//	    // nnnXXXnnnnnn
//	    int lesMillions  = Integer.parseInt(snumber.substring(3,6));
//	    // nnnnnnXXXnnn
//	    int lesCentMille = Integer.parseInt(snumber.substring(6,9));
//	    // nnnnnnnnnXXX
//	    int lesMille = Integer.parseInt(snumber.substring(9,12));
//
//	    String tradMilliards;
//	    switch (lesMilliards) {
//	    case 0:
//	      tradMilliards = "";
//	      break;
//	    case 1 :
//	      tradMilliards = convertLessThanOneThousand(lesMilliards)
//	         + " milliard ";
//	      break;
//	    default :
//	      tradMilliards = convertLessThanOneThousand(lesMilliards)
//	         + " milliards ";
//	    }
//	    String resultat =  tradMilliards;
//
//	    String tradMillions;
//	    switch (lesMillions) {
//	    case 0:
//	      tradMillions = "";
//	      break;
//	    case 1 :
//	      tradMillions = convertLessThanOneThousand(lesMillions)
//	         + " million ";
//	      break;
//	    default :
//	      tradMillions = convertLessThanOneThousand(lesMillions)
//	         + " millions ";
//	    }
//	    resultat =  resultat + tradMillions;
//
//	    String tradCentMille;
//	    switch (lesCentMille) {
//	    case 0:
//	      tradCentMille = "";
//	      break;
//	    case 1 :
//	      tradCentMille = "mille ";
//	      break;
//	    default :
//	      tradCentMille = convertLessThanOneThousand(lesCentMille)
//	         + " mille ";
//	    }
//	    resultat =  resultat + tradCentMille;
//
//	    String tradMille;
//	    tradMille = convertLessThanOneThousand(lesMille);
//	    resultat =  resultat + tradMille;
//
//	    return resultat;
//	  }
//
//	  public static void main(String[] args) {
//	    System.out.println("*** " + FrenchNumberToWords.convert(0));
//	    System.out.println("*** " + FrenchNumberToWords.convert(9));
//	    System.out.println("*** " + FrenchNumberToWords.convert(19));
//	    System.out.println("*** " + FrenchNumberToWords.convert(21));
//	    System.out.println("*** " + FrenchNumberToWords.convert(28));
//	    System.out.println("*** " + FrenchNumberToWords.convert(71));
//	    System.out.println("*** " + FrenchNumberToWords.convert(72));
//	    System.out.println("*** " + FrenchNumberToWords.convert(80));
//	    System.out.println("*** " + FrenchNumberToWords.convert(81));
//	    System.out.println("*** " + FrenchNumberToWords.convert(89));
//	    System.out.println("*** " + FrenchNumberToWords.convert(90));
//	    System.out.println("*** " + FrenchNumberToWords.convert(91));
//	    System.out.println("*** " + FrenchNumberToWords.convert(97));
//	    System.out.println("*** " + FrenchNumberToWords.convert(100));
//	    System.out.println("*** " + FrenchNumberToWords.convert(101));
//	    System.out.println("*** " + FrenchNumberToWords.convert(110));
//	    System.out.println("*** " + FrenchNumberToWords.convert(120));
//	    System.out.println("*** " + FrenchNumberToWords.convert(200));
//	    System.out.println("*** " + FrenchNumberToWords.convert(201));
//	    System.out.println("*** " + FrenchNumberToWords.convert(232));
//	    System.out.println("*** " + FrenchNumberToWords.convert(999));
//	    System.out.println("*** " + FrenchNumberToWords.convert(1000));
//	    System.out.println("*** " + FrenchNumberToWords.convert(1001));
//	    System.out.println("*** " + FrenchNumberToWords.convert(10000));
//	    System.out.println("*** " + FrenchNumberToWords.convert(10001));
//	    System.out.println("*** " + FrenchNumberToWords.convert(100000));
//	    System.out.println("*** " + FrenchNumberToWords.convert(2000000));
//	    System.out.println("*** " + FrenchNumberToWords.convert(3000000000L));
//	    System.out.println("*** " + FrenchNumberToWords.convert(2147483647));
//	    /*
//	     *** OUTPUT
//	     *** zéro
//	     *** neuf
//	     *** dix-neuf
//	     *** vingt et un
//	     *** vingt-huit
//	     *** soixante et onze
//	     *** soixante-douze
//	     *** quatre-vingt
//	     *** quatre-vingt-un
//	     *** quatre-vingt-neuf
//	     *** quatre-vingt-dix
//	     *** quatre-vingt-onze
//	     *** quatre-vingt-dix-sept
//	     *** cent
//	     *** cent un
//	     *** cent dix
//	     *** cent vingt
//	     *** deux cents
//	     *** deux cent un
//	     *** deux cent trente-deux
//	     *** neuf cent quatre-vingt-dix-neuf
//	     *** mille
//	     *** mille un
//	     *** dix mille
//	     *** dix mille un
//	     *** cent mille
//	     *** deux millions
//	     *** trois milliards
//	     *** deux milliards cent quarante-sept millions
//	     **          quatre cent quatre-vingt-trois mille six cent quarante-sept
//	     */
//	  }
//	}
