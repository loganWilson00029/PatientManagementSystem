package PatientManagmentSystem;

import java.util.ArrayList;

public class MedicalHistory {
	private Symptoms symptoms;
	private ArrayList<Diagnosis> diagnoses = new ArrayList<>();

	public MedicalHistory() {
		this.symptoms = new Symptoms();
		this.diagnoses = new ArrayList<>();
	}

	public Symptoms getSymptoms() {
		return symptoms;
	}

	public void addSymptom(String symptom) {
		symptoms.addSymptom(symptom);
	}

	public void addDiagnosis(Diagnosis diagnosis) {
		diagnoses.add(diagnosis);
	}

	public ArrayList<Diagnosis> getDiagnoses() {
		return diagnoses;
	}

	@Override
	public String toString() {
		return "Symptoms: " + symptoms + ", Diagnoses: " + diagnoses;
	}
}
