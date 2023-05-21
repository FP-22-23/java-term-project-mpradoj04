package types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import common.Gender;

public class Patients {
	
	Set<Patient> patients;
	
	public Patients() {
		patients = null;
	}
	
	public Patients(Collection<Patient> patients) {
		this.patients = patients.stream().collect(Collectors.toSet());
	}
	
	public Patients(Stream<Patient> p) {
		this.patients = p.collect(Collectors.toSet());
	}

	public int hashCode() {
		return Objects.hash(patients);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patients other = (Patients) obj;
		return Objects.equals(patients, other.patients);
	}

	public String toString() {
		return "Patients [patients=" + patients + "]";
	}
	
	public Integer getNumberPatients() {
		return patients.size();
	}
	
	public void addPatient(Patient p){
		patients.add(p);
	}
	
	public void addPatients(Collection<Patient> c){
		patients.addAll(c);
	}
	
	public void deletePatient(Patient c){
		patients.removeIf(p->p.equals(c));
	}
	
	public Patient displayPatient(Integer nPatient) {
		Patient lista = null;
		for (Patient p : patients) {
			if (p.getnPatient().equals(nPatient)) {
				lista = p;
			}
		}
		System.out.println(lista);
		return lista;
	}
	
	public Boolean existsPatient(Patient patient) {
		Boolean res = false;
		for(Patient p:patients) {
			if(p.equals(patient)) {
				res = true;
			}
		}
		System.out.println(res);
		return res;
	}
	
	public Integer countPatientsGender(Gender g) {
		Integer res = 0;
		for(Patient p : patients) {
			if (p.getGender().equals(g)) {
				res++;
			}
		}
		System.out.println("There are " + res + " " + g);
		return res;
	}
	
	public Set<Patient> filterYoungerThan(Integer age){
		Set<Patient> res = new HashSet<Patient>();
		for (Patient p:patients) {
			if(p.getAge()<age) {
				res.add(p);
			}
		}
		return res;
	}
	
	public Map<String, Set<Patient>> patientsByCountry(){
		Map<String, Set<Patient>> res = new HashMap<String, Set<Patient>>();
		for (Patient p:patients) {
			if (res.containsKey(p.getCountry())) {
				res.get(p.getCountry()).add(p);
			}
			else {
				Set<Patient> aux = new HashSet<Patient>();
				aux.add(p);
				res.put(p.getCountry(), aux);
			}
		}
		return res;
	}

	public Map<String, Integer> countPatientsState(){
		Map<String, Integer> res = new HashMap<String, Integer>();
		for(Patient p:patients) {
			if(res.containsKey(p.getState())) {
				res.put(p.getState(), res.get(p.getState()) + 1);
			}
			else {
				res.put(p.getState(), 1);
			}
		}
		return res;
	}
	
	/// ----THIRD DELIVERY----
	
	// To choose one of the following two: exists / for everything (the same implemented in delivery 2, but with streams).
	public Boolean existsPatient2(Patient p) {
		return patients.stream()
				.anyMatch(x->x.equals(p));
	}
	
	// To choose one of the following three: counter / sum / average (the same implemented in delivery 2, but with streams)
	public Integer countPatientsGender2(Gender g) {
		return (int) patients.stream()
				.filter(x->x.getGender().equals(g))
				.count();
	}
	
	// A selection with filtering (the same implemented in delivery 2, but with streams).
	public Set<Patient> filterYoungerThan2(Integer age){
		return patients.stream()
				.filter(x->x.getAge()<age)
				.collect(Collectors.toSet());
	}
	
	// A maximum/minimum with filtering.
	public Patient getOldestPatient(Gender g) {
		return patients.stream()
				.filter(x->x.getGender().equals(g))
				.max(Comparator.comparing(x->x.getAge()))
				.orElse(null);
	}
	
	// A selection, with filtering and sorting.
	public List<Patient> getLatestPatientsFrom(String c) {
		List<Patient> res =  patients.stream()
				.filter(x->x.getCountry().equals(c))
				.collect(Collectors.toList());
		
		Collections.sort(res,Collections.reverseOrder());
		return res;
	}
	
	// One of the methods (4) or (5) implemented in delivery 2, but with streams.
	public Map<String, Set<Patient>> patientsByCountry2(){
		return patients.stream()
				.collect(Collectors.groupingBy(x->x.getCountry(),
						Collectors.toSet()));
	}
	
	// A method whose implementation is used, either the Collector collectingAndThen, or the Collector mapping.
	public Map<Integer, List<String>> patientsByAge(){
		return patients.stream()
				.collect(Collectors.groupingBy(x->x.getAge(),
						Collectors.mapping(Patient::getName, Collectors.toList())));
	}
	
	// A method that returns a Map in which the keys are an attribute or a function over an attribute, and the values are maximum/minimum of the elements that have that value.
	public Map<Integer, Patient> youngestPatientByYear(){
		return patients.stream()
				.collect(Collectors.groupingBy(x->x.getDate().getYear(),
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(x->x.getAge())),
								z->z.orElse(null)
						)));
	}
	
	// A method that returns a SortedMap in which the keys are an attribute or a function over an attribute, and the values are lists with the n best or worst elements that share the value of that attribute (or function over the attribute).
	public SortedMap<String,List<Patient>> nMoreWorkInterferePatientsByState(Integer n) {
		
		return patients.stream()
				.sorted(Comparator.comparing(Patient::getWorkInterfere).reversed())
				.collect(Collectors.groupingBy(x->x.getState(),
						TreeMap::new,
						Collectors.collectingAndThen(Collectors.toList(),l->l.size()<n?l:l.subList(0,n))
						));
	}
	
	// A method that calculates a Map and returns the key with the associated value (largest or smallest) of the entire Map.
	public Integer mostRecentUrgentPatientAge(){
		Map<Integer, Patient> aux = patients.stream()
				.filter(x->x.getTreatment().isUrgent())
				.collect(Collectors.groupingBy(Patient::getAge,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Patient::getDate).reversed()), z->z.orElse(null))));
		
		 List<Patient> aux2 = new ArrayList<Patient>(aux.values());
		 aux2.sort(Comparator.comparing(Patient::getDate).reversed());
		 
		 Integer res = 0;
		 
		 for (Map.Entry<Integer, Patient> entry : aux.entrySet()) {
	            if (entry.getValue().equals(aux2.get(0))) {
	                res = entry.getKey();
	                break;
	            }
		 }
		 
		 return res;
		
	}
	
	// I created this map to check that I got the right answer in the exercise before
	public Map<Integer,Patient> check(){
		return patients.stream()
				.filter(x->x.getTreatment().isUrgent())
				.collect(Collectors.groupingBy(Patient::getAge,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Patient::getDate).reversed()), z->z.orElse(null))));
	}
}


