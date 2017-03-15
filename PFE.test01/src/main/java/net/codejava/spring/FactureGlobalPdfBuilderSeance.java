package net.codejava.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.haythem.model.FactureGlobaleModel;
import com.haythem.persistance.Banque;
import com.haythem.persistance.Clinique;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;



public class FactureGlobalPdfBuilderSeance {



	public static Font normal = FontFactory.getFont(BaseFont.IDENTITY_H, 10,
			Font.NORMAL);
	public static Font normal2 = FontFactory.getFont(BaseFont.IDENTITY_H, 12,
			Font.NORMAL);

	public void doPdf(List<FactureGlobaleModel> factureList,List<FactureGlobaleModel> complimentList,Long bordereauId, Clinique clinique, Banque banque, Document doc)
			throws DocumentException, ParseException {
		

		doc.setPageSize(PageSize.A4.rotate());
		doc.open();
//		doc = new Document(PageSize.A4.rotate());
//		doc.open();
		Paragraph preface = new Paragraph(new Phrase("", normal));
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
		
		doc.addCreator("Educanet");
		 preface = new Paragraph(new Phrase("BORDEREAU DE PAIEMENT N° "+bordereauId,normal));
		preface.setAlignment(Element.ALIGN_CENTER);
		doc.add(preface);
		Calendar cal = Calendar.getInstance();
	
		//commented 2017
//		PdfPTable table = new PdfPTable(10);
		
		
		//added 2017
		PdfPTable table = new PdfPTable(9);
		
		
		table.setWidthPercentage(100.0f);
		//commented 2017
//		table.setWidths(new float[] {  2.0f, 2.0f , 2.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f});
		
		
		//added 2017
		table.setWidths(new float[] {  2.0f, 2.0f , 2.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f, 2.0f});
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
		cell.setPhrase(new Phrase("DATE", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("NOM PRENOM", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("N°AFFILATION", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("N°FAC", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("NB SEA", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("HORS TAXE", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("TVA", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("EXONERE", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

//		cell.setPhrase(new Phrase("MSP", normal));
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		table.addCell(cell);

		cell.setPhrase(new Phrase("TTC", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

	
		String str = "";
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		
		
		if (factureList.size() > 0) {
		String factureDatdS = factureList.get(0).getDate();
		
		Date factureDate = formatter.parse(factureDatdS);
		
		 cal = Calendar.getInstance();
	    cal.set(Calendar.MONTH, factureDate.getMonth());
	    
	    cal.set(Calendar.YEAR, 2017);
	    cal.set(Calendar.DAY_OF_MONTH, 1);// This is necessary to get proper results
	    cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
	    cal.getTime();	
		}
	    String DATE_FORMAT = "dd/MM/yyyy";
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//		sdf.format(cal.getTime());
		Long totalMTHTAXE = 0L;
		Long totalMTTVA = 0L;
		Long totalEXONERE = 0L;
//		Long totalMSP = 0L;
		Long totalGlobal = 0L;
		Long MTHTAXE = 0L;
		Long MTTVA = 0L;
		Long EXONERE = 0L;
//		Long MSP = 0L;
		Long ttc=0L;
		Long seance = 0L;
		System.out.println("factureList.size() = "+factureList.size());
		
		if (factureList.size() > 0) {
			for (FactureGlobaleModel afact : factureList) {
				
				seance = seance+Long.parseLong(afact.getNumSea());
				MTHTAXE = Long.parseLong(afact.getHorsTax());
				MTTVA = Long.parseLong(afact.getTva());
				EXONERE = Long.parseLong(afact.getExonere());
//				MSP = Long.parseLong(afact.getMsp());
				ttc=Long.parseLong(afact.getTtc());
				totalGlobal=totalGlobal+ttc;
				totalMTHTAXE = totalMTHTAXE + MTHTAXE;
				totalMTTVA = totalMTTVA + MTTVA;
				totalEXONERE = totalEXONERE + EXONERE;
//				totalMSP = totalMSP + MSP;
				
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase(( sdf.format(cal.getTime()) + ""), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase((afact.getNom()+ " "+afact.getPrenom()), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase((afact.getAff() + ""), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase((afact.getNumFact() + ""), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase((afact.getNumSea()+ ""), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				
					
					str = MTHTAXE + "";
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
					
					
					
					
//					str = MSP + "";
//					str = new StringBuilder(str).insert(str.length() - 3, ",")
//							.toString();
//					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//					cell.setPhrase(new Phrase(str, normal));
//					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//					table.addCell(cell);
				
					
					
					str = afact.getTtc() + "";
					str = new StringBuilder(str).insert(str.length() - 3, ",")
							.toString();
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase(str, normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);

					
				

			}
	
			
		
			
		}
		
		
		if (complimentList.size() > 0) {
			for (FactureGlobaleModel afact : complimentList) {
				
				String factureDatdS = afact.getDate();
				
				Date factureDate = formatter.parse(factureDatdS);
				
				 cal = Calendar.getInstance();
			    cal.set(Calendar.MONTH, factureDate.getMonth());
			    
			    cal.set(Calendar.YEAR, 2017);
			    cal.set(Calendar.DAY_OF_MONTH, 1);// This is necessary to get proper results
			    cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
			    cal.getTime();	
				
				seance = seance+Long.parseLong(afact.getNumSea());
				MTHTAXE = Long.parseLong(afact.getHorsTax());
				MTTVA = Long.parseLong(afact.getTva());
				EXONERE = Long.parseLong(afact.getExonere());
//				MSP = Long.parseLong(afact.getMsp());
				ttc=Long.parseLong(afact.getTtc());
				totalGlobal=totalGlobal+ttc;
				totalMTHTAXE = totalMTHTAXE + MTHTAXE;
				totalMTTVA = totalMTTVA + MTTVA;
				totalEXONERE = totalEXONERE + EXONERE;
//				totalMSP = totalMSP + MSP;
				
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase(( sdf.format(cal.getTime()) + ""), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase((afact.getNom()+ " "+afact.getPrenom()), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase((afact.getAff() + ""), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase((afact.getNumFact() + ""), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase((afact.getNumSea()+ ""), normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				
					
					str = MTHTAXE + "";
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
					
					
					
					
//					str = MSP + "";
//					str = new StringBuilder(str).insert(str.length() - 3, ",")
//							.toString();
//					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//					cell.setPhrase(new Phrase(str, normal));
//					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//					table.addCell(cell);
				
					
					
					str = afact.getTtc() + "";
					str = new StringBuilder(str).insert(str.length() - 3, ",")
							.toString();
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setPhrase(new Phrase(str, normal));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);

					
				

			}
	
			
		
			
		}
		cell.setPhrase(new Phrase("TOTAL", normal2));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setColspan(3);
		table.addCell(cell);
		cell.setColspan(1);
		str = "" + "";
//		str = new StringBuilder(str).insert(str.length() - 3, ",")
//				.toString();
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		cell.setPhrase(new Phrase(str, normal2));
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		table.addCell(cell);
		str = "" + "";
//		str = new StringBuilder(str).insert(str.length() - 3, ",")
//				.toString();
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		cell.setPhrase(new Phrase(str, normal2));
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		table.addCell(cell);
		str = "" + "";
//		str = new StringBuilder(str).insert(str.length() - 3, ",")
//				.toString();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPhrase(new Phrase(str, normal2));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		str = seance + "";
//		str = new StringBuilder(str).insert(str.length() - 3, ",")
//				.toString();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPhrase(new Phrase(str, normal2));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		
		str = totalMTHTAXE + "";
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
		
		
//		str = totalMSP + "";
//		str = new StringBuilder(str).insert(str.length() - 3, ",")
//				.toString();
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		cell.setPhrase(new Phrase(str, normal2));
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		table.addCell(cell);
		
		
		
		str = totalGlobal + "";
		str = new StringBuilder(str).insert(str.length() - 3, ",")
				.toString();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPhrase(new Phrase(str, normal2));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		doc.add(table);
//		preface = new Paragraph(new Phrase(convert(totalGlobal.intValue() ), normal));
//		preface.setAlignment(Element.ALIGN_CENTER);
//		doc.add(preface);
		preface = new Paragraph(new Phrase("                                                                                                                                                      SIGNATURE" , normal2));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase(convert(100 ), normal));
		preface.setAlignment(Element.ALIGN_CENTER);
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

}
