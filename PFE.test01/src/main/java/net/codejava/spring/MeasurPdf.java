package net.codejava.spring;

import java.util.List;



import com.haythem.persistance.Mesure;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class MeasurPdf {

	
	public void doPdf(List<Mesure> listMesure,Document doc) throws DocumentException {
		
		
		doc.add(new Paragraph("Measurements"));
	
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f  });
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
		cell.setPhrase(new Phrase("Date/time", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Heartbeat", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Temperature", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Fall", font));
		table.addCell(cell);
		
		// write table row data
		for (Mesure aMesures : listMesure) {
			
			table.addCell(aMesures.getPatient().getUser().getUsername().toString());
			table.addCell(aMesures.getWatchSerialNumber());
			table.addCell(aMesures.getDate().toString());
			
			table.addCell(aMesures.getHeartbeat().toCharArray()[0]+""+aMesures.getHeartbeat().toCharArray()[1]+","+aMesures.getHeartbeat().toCharArray()[2]);
			table.addCell(aMesures.getTemperature().toCharArray()[0]+""+aMesures.getTemperature().toCharArray()[1]+","+aMesures.getTemperature().toCharArray()[2]);
			table.addCell(aMesures.getFall());
		}
		doc.add(table);

		
	
	}
}
