package types;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
}
