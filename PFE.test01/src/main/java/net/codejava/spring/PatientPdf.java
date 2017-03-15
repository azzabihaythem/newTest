package net.codejava.spring;

import java.util.List;



import com.haythem.persistance.Patient;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PatientPdf {

	
	public void doPdf(List<Patient> listPatient ,Document doc) throws DocumentException {
		
		
		doc.add(new Paragraph("User List"));
	
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 2.0f , 2.0f, 2.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Patient", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Watch", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Heart Beat Reference", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Sweat Reference", font));
		table.addCell(cell);
		
		
		// write table row data
		for (Patient aPatient : listPatient) {
			
			table.addCell(aPatient.getUser().getUsername().toString());
			table.addCell(aPatient.getWatch().getWatchSerialNumber().toString());
			table.addCell(aPatient.getHbRef().toString());
			table.addCell(aPatient.getSRef().toString());
			
		}
		doc.add(table);

		
	
	}
}
