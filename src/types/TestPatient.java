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
		
		
		/// ----SECOND DELIVERY----
		
		//Factory, from a String
		Patient p3 = FactoryPatient.parsePatient("Miguel Prado,1300,2014-08-27-11-31-50,18,-1,Spain,Andalucia,1,1,2.0,Yes");
		System.out.println(p3);
		System.out.println(" ");
		
		//Factory, from the csv file
		Patients patients = FactoryPatient.readPatients("data/mentalHealth.csv");
		//System.out.println(patients);
		
		//Get number patients, add a patient, remove a patient
		System.out.println(patients.getNumberPatients());
		System.out.println(" ");
		patients.addPatient(p3);
		patients.displayPatient(1300);
		System.out.println(" ");
		patients.deletePatient(p3);
		patients.displayPatient(1300);
		System.out.println(" ");
		//patients.addPatient(p3);
		
		// Sequential treatments
		// a. exists
		patients.existsPatient(p3);
		System.out.println(" ");
		//b. counter 
		patients.countPatientsGender(Gender.WOMAN);
		System.out.println(" ");
		//c. a selection with filtering
		System.out.println(patients.filterYoungerThan(50));
		System.out.println(" ");
		//d. grouping method with collections as values
		System.out.println(patients.patientsByCountry());
		System.out.println(" ");
		//e. grouping method with counts as values
		System.out.println(patients.countPatientsState());
		System.out.println(" ");
		
		/// ----THIRD DELIVERY----
		
		//To choose one of the following two: exists / for everything (the same implemented in delivery 2, but with streams)
		System.out.println(patients.existsPatient2(p3));
		System.out.println(" ");
		
		// To choose one of the following three: counter / sum / average (the same implemented in delivery 2, but with streams)
		System.out.println(patients.countPatientsGender2(Gender.WOMAN));
		System.out.println(" ");
		
		// A selection with filtering (the same implemented in delivery 2, but with streams).
		System.out.println(patients.filterYoungerThan2(50));
		System.out.println(" ");
		
		//A maximum/minimum with filtering.
		System.out.println(patients.getOldestPatient(Gender.MAN));
		System.out.println(" ");
		
		//  A selection, with filtering and sorting.
		System.out.println(patients.getLatestPatientsFrom("United States"));
		System.out.println(" ");
		
		// One of the methods (4) or (5) implemented in delivery 2, but with streams.
		System.out.println(patients.patientsByCountry2());
		System.out.println(" ");
		
		System.out.println(patients.patientsByCountry2().equals(patients.patientsByCountry()));
		System.out.println(" ");
		
		// A method whose implementation is used, either the Collector collectingAndThen, or the Collector mapping.
		System.out.println(patients.patientsByAge());
		System.out.println(" ");
		
		// A method that returns a Map in which the keys are an attribute or a function over an attribute, and the values are maximum/minimum of the elements that have that value.
		System.out.println(patients.youngestPatientByYear());
		System.out.println(" ");
		
		// A method that returns a SortedMap in which the keys are an attribute or a function over an attribute, and the values are lists with the n best or worst elements that share the value of that attribute (or function over the attribute).
		System.out.println(patients.nMoreWorkInterferePatientsByState(3));
		System.out.println(" ");
		
		// A method that calculates a Map and returns the key with the associated value (largest or smallest) of the entire Map.
		System.out.println(patients.mostRecentUrgentPatientAge());
		System.out.println(" ");
		
		System.out.println(patients.check());
	}
		
}
