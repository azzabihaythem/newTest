package net.codejava.spring;

import java.text.SimpleDateFormat;
import java.util.List;

import com.haythem.persistance.Banque;
import com.haythem.persistance.Bilan;
import com.haythem.persistance.Clinique;
import com.haythem.persistance.Information;
import com.haythem.persistance.Observation;
import com.haythem.persistance.Seance;
import com.haythem.persistance.User;
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

public class PdfBuilderBilan {
	
	public static Font normal = FontFactory.getFont(BaseFont.IDENTITY_H, 10,
			Font.NORMAL);
	public static Font normal2 = FontFactory.getFont(BaseFont.IDENTITY_H, 12,
			Font.NORMAL);

	public void doPdfTotal(Seance seance, Information patientInformation, User adminInformation, Bilan bilan, Clinique clinique, Document doc, List<Observation> listObservation, Banque banque) throws DocumentException {

		doc.open();
		final String OLD_FORMAT = "yyyy-MM-dd";
		final String NEW_FORMAT = "dd/MM/yyyy";

		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		sdf.applyPattern(NEW_FORMAT);
		
		Paragraph preface = new Paragraph(new Phrase(""+clinique.getNom(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
	
		
		preface = new Paragraph(new Phrase("Seance d'hémodialyse du : "+sdf.format(seance.getDate()), normal));
		preface.setAlignment(Element.ALIGN_CENTER);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("Nom du patient : "
				+ patientInformation.getFirstName() + " " + patientInformation.getLastName(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("Generateur      : "+bilan.getGenerateur() + " " , normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("Filtre            : "+bilan.getFiltre() + " " , normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("Poids Sec       : "+bilan.getPoidsSec() + " " , normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("Responsable    : "+adminInformation.getUsername() + " " , normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		preface = new Paragraph(new Phrase("Uft/Durée        : "+bilan.getUftDuree() + " " , normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 4.0f, 4.0f,});
		table.setSpacingBefore(10);
		
		PdfPCell cell = new PdfPCell();
		cell.setPhrase(new Phrase("", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("Debut De Dialyse", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("Fin De Dialyse", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Heures", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase(bilan.getDebutDeDialyse(), normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase(bilan.getFinDeDialyse(), normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		
		cell.setPhrase(new Phrase("Poids", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase(bilan.getPoidsDebut() , normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase(bilan.getPoidsFin(), normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Poids (Prise/Perte)", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase(bilan.getPriseDePoids() , normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase(bilan.getPerteDePoids() , normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Tension arterielle", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase(bilan.getTensionarterielleDebutSystolique()+"/"+bilan.getTensionarterielleDebutDiastolique() , normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase(bilan.getTensionarterielleFinSystolique()+"/"+bilan.getTensionarterielleFinDiastolique()  , normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		doc.add(table);
		
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		String heparine = "";
		if (bilan.getHeparine()) {
			heparine="oui";
		}
		
		table = new PdfPTable(2);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 4.0f, 4.0f,});
		table.setSpacingBefore(10);
		
		cell = new PdfPCell();
		cell.setPhrase(new Phrase("Heparine : "+heparine, normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("Traitement : "+bilan.getTraitement(), normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		doc.add(table);
		
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		table = new PdfPTable(9);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 4.0f });
		table.setSpacingBefore(10);

		cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPadding(5);
		
		// write table header
		cell.setPhrase(new Phrase("Heures", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("Tension arterielle", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell.setPhrase(new Phrase("Heparine", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Debit sang", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("U.F", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
	
		cell.setPhrase(new Phrase("PV", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("PTM", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("U.F cumulée", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Observations", normal));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		
		for (Observation observation : listObservation) {
			cell.setPhrase(new Phrase(observation.getHeure(), normal));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);

			cell.setPhrase(new Phrase(observation.getTension_arterielle_s()+"/"+observation.getTension_arterielle_d(), normal));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);

			cell.setPhrase(new Phrase(observation.getHeparine(), normal));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			
			cell.setPhrase(new Phrase(observation.getDebit_sang(), normal));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			
			cell.setPhrase(new Phrase(observation.getUf(), normal));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
		
			cell.setPhrase(new Phrase(observation.getPv(), normal));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			
			cell.setPhrase(new Phrase(observation.getPtm(), normal));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			
			cell.setPhrase(new Phrase(observation.getUf_cumule(), normal));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			
			cell.setPhrase(new Phrase(observation.getObservation(), normal));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
		}
		
		doc.add(table);
		
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		preface = new Paragraph(new Phrase(" ", normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
	
		preface = new Paragraph(new Phrase("Observation Medicales : "+bilan.getObservationMedicales(), normal));
		preface.setAlignment(Element.ALIGN_LEFT);
		doc.add(preface);
		
		doc.close();		
	}
}
