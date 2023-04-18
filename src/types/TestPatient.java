package types;

import common.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestPatient {

	public static void main(String[] args) {
		List<String> c1 = new ArrayList<String>();
		c1.add("defiant");
		c1.add("negative");
		c1.add("impulsive");
		
		List<String> c2 = new ArrayList<String>();
		c2.add("no memory");
		c2.add("scared");
		c2.add("lacks paternal figure");
		
		//Here we try the constructors
		
		Patient p1 = new Patient("Elysa",1,LocalDateTime.of(2014,8,27,11,29,31),37,Gender.WOMAN, "United States", "IL",new Treatment(false,true),3.0,false,c1);
		Patient p2 = new Patient("Richard",50,40,new Treatment(true,true));
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(" ");
		
		
		//Getters and setters
		System.out.print(p1.getName()+ " "); System.out.print(p1.getnPatient() + " "); System.out.print(p1.getDate()+ " ");
		System.out.print(p1.getAge()+ " "); System.out.print(p1.getGender()+ " "); System.out.print(p1.getCountry()+ " "); System.out.print(p1.getState()+ " ");
		System.out.print(p1.getTreatment()+ " "); System.out.print(p1.getWorkInterfere()+ " "); System.out.print(p1.getRemoteW()+ " "); System.out.println(p1.getComentaries());
		
		p2.setName("Leo"); p2.setnPatient(2); p2.setGender(Gender.MAN); p2.setCountry("United States"); 
		 p2.setTreatment(new Treatment(false,false)); p2.setWorkInterfere(1.0); p2.setRemoteW(false); p2.setComentaries(c2);
		System.out.println(" ");
		System.out.println(p2);
		System.out.println(" ");

		
		//equals
		System.out.println("Is patient number 1 equal to patient number 2? " + p1.equals(p2));
		System.out.println(" ");

		//compare to
		if (p1.compareTo(p2) == 0) {
			System.out.println("Patient "+ p1.getnPatient() + " and patient " + p2.getnPatient() + " are the same patient");}
		else if (p1.compareTo(p2) < 0) {
			System.out.println("Patient "+ p1.getnPatient() + " goes before patient " + p2.getnPatient());
		}
		else {
			System.out.println("Patient "+ p2.getnPatient() + " goes before patient " + p1.getnPatient());
		}
		
		System.out.println(" ");
		
		Patient p3 = FactoryPatient.parsePatient("Miguel Prado,1300,2014-08-27-11-31-50,18,-1,Spain,Andalucia,1,1,2.0,Yes");
		System.out.println(p3);
		System.out.println(" ");
		
		Patients patients = FactoryPatient.readPatients("data/mentalHealth.csv");
		//System.out.println(patients);
		
		System.out.println(patients.getNumberPatients());
		System.out.println(" ");
		patients.addPatient(p3);
		
		patients.displayPatient(1300);
		System.out.println(" ");
		
	}
		
}
