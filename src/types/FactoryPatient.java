package types;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import common.Gender;
import common.Treatment;
import utils.Checkers;

public class FactoryPatient {

	public static Patient parsePatient(String s) {
			String[] values = s.split(",");
			String[] dval = values[2].split("-");
			Checkers.check("Invalid format of string", values.length == 11);
			String name = String.valueOf(values[0].trim());
			int nPatient = Integer.parseInt(values[1].trim());
			LocalDateTime date = LocalDateTime.of(Integer.parseInt(dval[0]),Integer.parseInt(dval[1]),Integer.parseInt(dval[2]),Integer.parseInt(dval[3]),Integer.parseInt(dval[4]),Integer.parseInt(dval[5]));
			int age = Integer.parseInt(values[3].trim());
			Gender gender = Patient.parseGender(Integer.parseInt(values[4].trim()));
			String country = values[5].trim();
			String state = values[6].trim();
			Treatment treatment = new Treatment(Patient.parseFrecord(Integer.parseInt(values[7].trim())),Patient.parseTreatment(Integer.parseInt(values[8].trim())));
			Double workInterfere = Double.valueOf(values[9]);
			boolean remoteW = Patient.parseRemoteW(values[10].trim());
			
			Checkers.check("The name cannot be empty", name != "");
			Checkers.check("Patient can`t have less than 5 years", age >= 5);
			Checkers.check("The date of the examination can't be before 2014", date.isAfter(LocalDateTime.of(2014,1,1,1,1,1)));
			
			return new Patient(name,nPatient,date,age,gender,country,state,treatment,workInterfere,remoteW,null);
	}
	
	public static Patients readPatients(String route){
		Patients res = null;
		try {
			Stream<Patient> sp = Files.lines(Paths.get(route))
					.skip(1).map(FactoryPatient::parsePatient);
			res = new Patients(sp);
		} catch(IOException e) {
			System.out.println("Error with the file " + route);
			e.printStackTrace();
		}
		return res;
	} 
}
