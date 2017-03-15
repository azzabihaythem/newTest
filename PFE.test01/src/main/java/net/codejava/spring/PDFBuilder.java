package net.codejava.spring;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.haythem.model.FactureGlobaleModel;
import com.haythem.model.PatientDetailsInformationModel;
import com.haythem.persistance.Banque;
import com.haythem.persistance.Clinique;
import com.haythem.persistance.Information;
import com.haythem.persistance.Mesure;
import com.haythem.persistance.Patient;
import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.Seance;
import com.haythem.persistance.Supervisor;
import com.haythem.persistance.User;
import com.haythem.persistance.Watch;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *  * This view class generates a PDF document 'on the fly' based on the data  *
 * contained in the model.  * @author www.codejava.net  *  
 */
public class PDFBuilder extends AbstractITextPdfView {

	@Autowired
	MeasurPdf measurPdf = new MeasurPdf();
	UserPdf userPdf = new UserPdf();
	UserInformationPdf userInformationPdf = new UserInformationPdf();
	WatchPdf watchPdf = new WatchPdf();
	PatientPdf patientPdf = new PatientPdf();
	SupervisorPdf supervisorPdf = new SupervisorPdf();
	PdfBuilderSeance pdfBuilderSeance = new PdfBuilderSeance();
	FactureGlobalPdfBuilderSeance factureGlobalPdfBuilderSeance = new FactureGlobalPdfBuilderSeance();

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String type = (String) model.get("type");
		if (type.equals("mesureList")) {
			measurPdf.doPdf((List<Mesure>) model.get("listMesure"), doc);
		}

		if (type.equals("userList")) {
			userPdf.doPdf((List<User>) model.get("listUser"), doc);
		}

		if (type.equals("informationUser")) {
			userInformationPdf.doPdf(
					(List<Information>) model.get("listInformationUser"), doc);
		}

		if (type.equals("Watch")) {
			watchPdf.doPdf((List<Watch>) model.get("watchList"), doc);
		}

		if (type.equals("patientWatch")) {
			patientPdf
					.doPdf((List<Patient>) model.get("patientWatchList"), doc);
		}

		if (type.equals("supervisor")) {
			supervisorPdf.doPdf((List<Supervisor>) model.get("supervisorList"),
					doc);
		}

		if (type.equals("seanceFact")) {
			pdfBuilderSeance.doPdf((List<Seance>) model.get("seanceList"), doc,
					(Information) model.get("information"),
					(PatientDetails) model.get("patientDetails"),
					(Clinique) model.get("clinique"),
					(Banque) model.get("banque"));
		}
		if (type.equals("seanceFactTot")) {
			pdfBuilderSeance.doPdfTotal(
					(Map<PatientDetailsInformationModel, List<Seance>>) model
							.get("ListSeancesMap"), doc,

					(Clinique) model.get("clinique"), (Banque) model
							.get("banque"));
		}

		if (type.equals("FactGlob")) {
			// writer.addPageDictEntry(PdfName.ROTATE, rotation);
			// PdfWriter.getInstance(doc, new FileOutputStream(f));
			doc.setPageSize(PageSize.A4.rotate());
			factureGlobalPdfBuilderSeance
					.doPdf((List<FactureGlobaleModel>) model
							.get("factGlobList"),
							(List<FactureGlobaleModel>) model
									.get("complimentGlobList"), (Long) model
									.get("bordereauId"), (Clinique) model
									.get("clinique"), (Banque) model
									.get("banque"), doc);
		}

	}

}