package types;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import common.Employ;
import common.Gender;
import common.Treatment;
import utils.Checkers;

public class Patient {

	private String name;
	private int nPatient;
	private LocalDateTime date;
	private int age;
	private Gender gender;
	private String country;
	private String state;
	private Treatment treatment;
	private Double workInterfere;
	private boolean remoteW;
	private List<String> comentaries;
	
	
	public Patient(String name,int nPatient, LocalDateTime date, int age, Gender gender, String country, String state, Treatment treatment, Double workInterfere, boolean remoteW, List<String> comentaries) {
		Checkers.check("The name cannot be empty", name != "");
		Checkers.check("Patient can`t have less than 5 years", age >= 5);
		Checkers.check("The date of the examination can't be before 2014", date.isAfter(LocalDateTime.of(2014,1,1,1,1,1)));
		this.name = name;
		this.nPatient = nPatient;
		this.date = date;
		this.age = age;
		this.gender = gender;
		this.country = country;
		this.state = state;
		this.treatment = treatment; 
		this.workInterfere = workInterfere;
		this.remoteW = remoteW;
		this.comentaries = comentaries;
	}
	
	public Patient(String name, int nPatient, int age, Treatment treatment) {
		Checkers.check("The name cannot be empty", name != "");
		Checkers.check("Patient can`t have less than 5 years", age >= 5);
		this.name = name;
		this.nPatient = nPatient;
		this.date = null;
		this.age = age;
		this.gender = null;
		this.country = null;
		this.state = null;
		this.treatment = treatment; 
		this.workInterfere = 0.0;
		this.remoteW = false;
		this.comentaries = null;
	}

	public static Gender parseGender(int i) {
		if (i == 1) {
			return Gender.WOMAN;
		}
		else {
			return Gender.MAN;
		}
	}
	
	public static boolean parseFrecord(int i) {
		if (i==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean parseTreatment(int i) {
		if (i==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean parseRemoteW(String s) {
		if (s == "Yes") {
			return true;
		}
		else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Checkers.check("The name cannot be empty", name != "");
		this.name = name;
	}

	public Integer getnPatient() {
		return nPatient;
	}

	public void setnPatient(int nPatient) {
		this.nPatient = nPatient;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	public Double getWorkInterfere() {
		return workInterfere;
	}

	public void setWorkInterfere(Double workInterfere) {
		this.workInterfere = workInterfere;
	}

	public Employ getEmploy() {
		if (workInterfere == 0.0) {
			return Employ.UNKNOWN;}
		else if (workInterfere <= 1) {
			return Employ.UNEMPLOYED;}
		else if (1 < workInterfere && workInterfere <= 2) {
			return Employ.WORKER;}
		else {
			return Employ.SELFEMPLOYED;
		}
	}

	public boolean getRemoteW() {
		return remoteW;
	}

	public void setRemoteW(boolean remoteW) {
		this.remoteW = remoteW;
	}

	public List<String> getComentaries() {
		return comentaries;
	}

	public void setComentaries(List<String> comentaries) {
		this.comentaries = comentaries;
	}

	public int hashCode() {
		return Objects.hash(age, comentaries, country, date, gender, nPatient, name, remoteW, state, treatment,
				workInterfere);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return age == other.age && Objects.equals(comentaries, other.comentaries)
				&& Objects.equals(country, other.country) && Objects.equals(date, other.date) && gender == other.gender
				&& nPatient == other.nPatient && Objects.equals(name, other.name) && remoteW == other.remoteW
				&& Objects.equals(state, other.state) && Objects.equals(treatment, other.treatment)
				&& Objects.equals(workInterfere, other.workInterfere);
	}

	public String toString() {
		return "Patient [name=" + name + ", nPatient=" + nPatient + ", date=" + date + ", age=" + age + ", gender="
				+ gender + ", country=" + country + ", state=" + state + ", treatment=" + treatment + ", workInterfere="
				+ workInterfere + ", remoteW=" + remoteW + ", employ= " + getEmploy() + ", comentaries=" + comentaries + ", urgent = "+ treatment.isUrgent() + "]";
	}

	public int compareTo(Patient p) {
        int r;
        if (p == null) {
            throw new NullPointerException();
        }
         r = this.getName().compareTo(p.getName());
           if(r == 0) {
               r = this.getnPatient().compareTo(p.getnPatient());
           }
        return r;
    }

}