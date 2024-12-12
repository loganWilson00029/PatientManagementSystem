package PatientManagmentSystem;

public class Doctor extends Employee {
	public Doctor(String name, int age, String gender, String employeeID) {
        super(name, age, gender, employeeID);
    }

    public void diagnose(Patient patient, String diagnoses, String prescribedDrug) {
    	Diagnosis diagnosis = new Diagnosis(diagnoses, prescribedDrug);
    	patient.getMedicalHistory().addDiagnosis(diagnosis);
    }

    @Override
    public String getDetails() {
        return "Doctor Name: " + getName() + ", Age: " + getAge() + ", Gender: " + getGender() +
               ", Employee ID: " + getEmployeeID();
    }
}
