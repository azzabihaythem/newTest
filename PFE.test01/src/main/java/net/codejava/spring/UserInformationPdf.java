package net.codejava.spring;

import java.util.List;
import com.haythem.persistance.Information;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class UserInformationPdf {

	
	public void doPdf(List<Information> listUserInformation,Document doc) throws DocumentException {
		
		
		doc.add(new Paragraph("User Information"));
	
		PdfPTable table = new PdfPTable(9);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f,2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f});
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("First Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Last Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Email", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Birthday", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Phone Numbere", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("State", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Country", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Adress", font));
		table.addCell(cell);
		
		// write table row data
		for (Information aUserInformation : listUserInformation) {
			
			table.addCell(aUserInformation.getFirstName().toString());
			table.addCell(aUserInformation.getLastName().toString());
			table.addCell(aUserInformation.getEmail().toString());
			table.addCell(aUserInformation.getBirthday().toString());
			table.addCell(aUserInformation.getGender().toString());
			table.addCell(aUserInformation.getPhoneNumber().toString());
			table.addCell(aUserInformation.getAdress().getState().toString());
			table.addCell(aUserInformation.getAdress().getCountry().toString());
			table.addCell(aUserInformation.getAdress().getAdress().toString());
			
		}
		doc.add(table);

		
	
	}
}
