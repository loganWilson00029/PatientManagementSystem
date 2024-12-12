package PatientManagmentSystem;

public class Diagnosis {
	private String diagnosis;
	private String prescribedDrug;

	public Diagnosis(String diagnosis, String prescribedDrug) {
		this.diagnosis = diagnosis;
		this.prescribedDrug = prescribedDrug;
	}
	
	@Override
	public String toString() {
		return "Diagnosis: " + diagnosis + ", Prescribed Drug: " + prescribedDrug;
	}
}

