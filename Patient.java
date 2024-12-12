package PatientManagmentSystem;

public class Patient extends Person {
	private String patientID;
	private MedicalHistory medicalHistory;
	private Doctor assignedDoctor;

	public Patient(String name, int age, String gender, String patientID) {
		super(name, age, gender);
		this.patientID = patientID;
		this.medicalHistory = new MedicalHistory();
	}

	public String getPatientID() {
		return patientID;
	}

	public void assignDoctor(Doctor doctor) {
		this.assignedDoctor = doctor;
	}

	public Doctor getAssignedDoctor() {
		return assignedDoctor;
	}

	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}

	@Override
	public String getDetails() {
		return "Name: " + getName() + ", Age: " + getAge() + ", Gender: " + getGender() + ", Patient ID: " + patientID
				+ ", Assigned Doctor: " + (assignedDoctor != null ? assignedDoctor.getName() : "None")
				+ ", Medical History: " + medicalHistory;
	}
}
