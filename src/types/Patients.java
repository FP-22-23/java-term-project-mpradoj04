package types;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Patients {
	
	Set<Patient> patients;
	
	public Patients() {
		patients = null;
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
	
	public Set<Patient> addPatient(Patient p){
		patients.add(p);
		return patients;
	}
	
	public Set<Patient> addPatients(Collection<Patient> c){
		patients.addAll(c);
		return patients;
	}
	
	public Set<Patient> deletePatient(String c){
		for (Patient p : patients) {
			if (p.equals(FactoryPatient.parsePatient(c))) {
				patients.remove(p);
			}
		}
		return patients;
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

}
