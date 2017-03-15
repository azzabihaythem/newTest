package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.persistance.Mesure;
import com.haythem.service.MesureService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.PatientService;
import com.haythem.service.RealTimeMeasur;
import com.haythem.service.SeanceService;
import com.haythem.service.UserService;
import com.haythem.service.WatchService;

@Service
public class RealTimeMeasurImpl implements RealTimeMeasur {

	@Autowired
	private MesureService measurementService;
	@Autowired
	PatientDetailsService patientDetailsService;
	@Autowired
	private UserService userService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private WatchService watchtService;
	@Autowired
	private SeanceService seanceService;

	@Override
	public String getRealTimeMeasur(String userName) {
		ArrayList<Mesure> mes = new ArrayList<Mesure>();
		try {
		
			System.out.println("**************************************start Real time1");
			List<Mesure> mesPatient = measurementService
					.findAllMesureByPatient(userName);
			int size = mesPatient.size();
			
			System.out.print("size=================");
			System.out.println(size);
			System.out.println("**************************************start Real time2");
			int watchAvSize = watchtService.findAll().size();
			System.out.println("**************************************start Real time3");
			int patientSize = patientDetailsService.findAllName().size();
			System.out.println("**************************************start Real time4");
			int usersSize = userService.findAll().size();
			System.out.println("**************************************start Real time5");
			 int mesureSize = seanceService.findAll().size();
		    System.out.println("**************************************start Real time6");

			if (size > 10) {
				for (int i = 0; i < 10; i++) {
					mes.add(mesPatient.get(size - i - 1));
					System.out.println(mes.get(i).getId());
				}

			} else {
				for (int i = 0; i < size; i++) {
					mes.add(mesPatient.get(i));
					System.out.println(mes.get(i).getId());
				}
			}
		    System.out.println("**************************************start Real time7");
			JSONObject one = new JSONObject();
			JSONObject two = new JSONObject();
			JSONObject three = new JSONObject();
			JSONObject four = new JSONObject();

			JSONArray result = new JSONArray();
			   System.out.println("**************************************start Real time7.1");
			int[] r1 = { Integer.parseInt(mes.get(9).getFall()),
					Integer.parseInt(mes.get(8).getFall()),
					Integer.parseInt(mes.get(7).getFall()),
					Integer.parseInt(mes.get(6).getFall()),
					Integer.parseInt(mes.get(5).getFall()),
					Integer.parseInt(mes.get(4).getFall()),
					Integer.parseInt(mes.get(3).getFall()),
					Integer.parseInt(mes.get(2).getFall()),
					Integer.parseInt(mes.get(1).getFall()),
					Integer.parseInt(mes.get(0).getFall()),
					Integer.parseInt(mes.get(0).getFall()) };
			 System.out.println("**************************************start Real time7.2");
			int[] r2 = { Integer.parseInt(mes.get(9).getTemperature()),
					Integer.parseInt(mes.get(8).getTemperature()),
					Integer.parseInt(mes.get(7).getTemperature()),
					Integer.parseInt(mes.get(6).getTemperature()),
					Integer.parseInt(mes.get(5).getTemperature()),
					Integer.parseInt(mes.get(4).getTemperature()),
					Integer.parseInt(mes.get(3).getTemperature()),
					Integer.parseInt(mes.get(2).getTemperature()),
					Integer.parseInt(mes.get(1).getTemperature()),
					Integer.parseInt(mes.get(0).getTemperature()),
					Integer.parseInt(mes.get(0).getTemperature()) };
			 System.out.println("**************************************start Real time7.3");
			int[] r3 = { Integer.parseInt(mes.get(9).getHeartbeat()),
					Integer.parseInt(mes.get(8).getHeartbeat()),
					Integer.parseInt(mes.get(7).getHeartbeat()),
					Integer.parseInt(mes.get(6).getHeartbeat()),
					Integer.parseInt(mes.get(5).getHeartbeat()),
					Integer.parseInt(mes.get(4).getHeartbeat()),
					Integer.parseInt(mes.get(3).getHeartbeat()),
					Integer.parseInt(mes.get(2).getHeartbeat()),
					Integer.parseInt(mes.get(1).getHeartbeat()),
					Integer.parseInt(mes.get(0).getHeartbeat()),
					Integer.parseInt(mes.get(0).getHeartbeat()) };
			int[] r4 = { 0, mesureSize, usersSize, watchAvSize, patientSize , size , 0 };
			 System.out.println("**************************************start Real time8");
			one.put("one", r1);
			two.put("two", r2);
			three.put("three", r3);
			four.put("four", r4);

			result.put(one);
			result.put(two);
			result.put(three);
			result.put(four);

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("sparkData", result);
			System.out.println("Sendig this data to view (sparkline.jsp): "
					+ jsonObj.toString());
			 System.out.println("**************************************end Real time");
			return jsonObj.toString();

		} catch (Exception e) {

			
//		    int mesureSize = measurementService.findAll().size();
			  int mesureSize = seanceService.findAll().size();
			int watchAvSize = watchtService.findAll().size();
			int patientSize = patientDetailsService.findAll().size();
			int usersSize = userService.findAll().size();

			JSONObject one = new JSONObject();
			JSONObject two = new JSONObject();
			JSONObject three = new JSONObject();
			JSONObject four = new JSONObject();

			JSONArray result = new JSONArray();
			int[] r1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int[] r2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int[] r3 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int[] r4 = { 0, mesureSize, usersSize, watchAvSize, patientSize , 0 , 0 };
			one.put("one", r1);
			two.put("two", r2);
			three.put("three", r3);
			four.put("four", r4);

			result.put(one);
			result.put(two);
			result.put(three);
			result.put(four);

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("sparkData", result);
			System.out.println("Sendig this data to view (sparkline.jsp): "
					+ jsonObj.toString());

			return jsonObj.toString();
		}

		
	}
}
