package net.codejava.spring;

import java.util.List;


import com.haythem.persistance.Supervisor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class SupervisorPdf {

	
	public void doPdf(List<Supervisor> listSupervisor,Document doc) throws DocumentException {
		
		
		doc.add(new Paragraph("Supervisor - Patient  List"));
	
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 2.0f  });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Supervisor", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Patient", font));
		table.addCell(cell);
		
		
		// write table row data
		for (Supervisor aSupervisor : listSupervisor) {
			
			table.addCell(aSupervisor.getUser().getUsername().toString());
			table.addCell(aSupervisor.getPatient().getUser().getUsername().toString());
			
		}
		doc.add(table);

		
	
	}
}
