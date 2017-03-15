package net.codejava.spring;

import java.util.List;
import com.haythem.persistance.User;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class UserPdf {

	
	public void doPdf(List<User> listUser,Document doc) throws DocumentException {
		
		
		doc.add(new Paragraph("User List"));
	
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
		cell.setPhrase(new Phrase("User", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Role", font));
		table.addCell(cell);
		
		
		// write table row data
		for (User aUser : listUser) {
			
			table.addCell(aUser.getUsername());
			table.addCell(aUser.getRoles().get(0).getRole());
			
		}
		doc.add(table);

		
	
	}
}
