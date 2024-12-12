package PatientManagmentSystem;

import java.util.ArrayList;

public class Symptoms {
	private ArrayList<String> symptomList = new ArrayList<>();

	public Symptoms() {
		this.symptomList = new ArrayList<>();
	}

	public void addSymptom(String symptom) {
		symptomList.add(symptom);
	}

	public ArrayList<String> getSymptomList() {
		return symptomList;
	}

	@Override
	public String toString() {
		return symptomList.toString();
	}
}
