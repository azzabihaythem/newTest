package net.codejava.spring;

import java.util.List;
import com.haythem.persistance.Watch;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class WatchPdf {

	
	public void doPdf(List<Watch> listWatch,Document doc) throws DocumentException {
		
		
		doc.add(new Paragraph("User List"));
	
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f  });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Watch Serial Number", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Hard Version", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Soft Version", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Communication Type", font));
		table.addCell(cell);
		
		
		// write table row data
		for (Watch aWatch : listWatch) {
			
			table.addCell(aWatch.getWatchSerialNumber().toString());
			table.addCell(aWatch.getHardVersion().toString());
			table.addCell(aWatch.getSoftVersion().toString());
			table.addCell(aWatch.getCommunicationType().toString());
			
		}
		doc.add(table);

		
	
	}
}
