package common;

import java.util.Objects;

public class Treatment {

	private boolean frecord, treatment;
	
	public Treatment(boolean frecord, boolean treatment) {
		this.frecord = frecord;
		this.treatment = treatment;
	}
	
	public Treatment() {
		this.frecord = false;
		this.treatment = false;
	}
	
	public Treatment(String s) {
		
	}
	
	public boolean getFrecord() {
		return frecord;
	}
	
	public boolean getTreatment() {
		return treatment;
	}

	public void setFrecord(boolean frecord) {
		this.frecord = frecord;
	}

	public void setTreatment(boolean treatment) {
		this.treatment = treatment;
	}
	
	public boolean isUrgent() {
		if(this.frecord == true && this.treatment == true) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(frecord, treatment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treatment other = (Treatment) obj;
		return frecord == other.frecord && treatment == other.treatment;
	}

	@Override
	public String toString() {
		return "Treatment [frecord=" + frecord + ", treatment=" + treatment + "]";
	}
	
}
