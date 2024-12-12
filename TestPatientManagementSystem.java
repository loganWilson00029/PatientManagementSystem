package PatientManagmentSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestPatientManagementSystem {
	private ArrayList<Patient> patients = new ArrayList<>();
	private ArrayList<Doctor> doctors = new ArrayList<>();
	
	@Test
	public void testCreateNewPatient() {
		Patient patient = new Patient("Logan Wilson", 22, "Male", "P01");
		patients.add(patient);
		
		assertEquals(1, patients.size());
		assertEquals("Logan Wilson", patients.get(0).getName());
		assertEquals(22, patients.get(0).getAge());
		assertEquals("P01", patients.get(0).getPatientID());
	}
	
	@Test
	public void testAssignDoctorToPatient() {
		Patient patient = new Patient("Arman", 22, "Male", "P02");
		patients.add(patient);
		
		Doctor doctor = new Doctor("Dr. Logan", 22, "Male", "D01");
		doctors.add(doctor);
		
		patient.assignDoctor(doctor);

        assertNotNull(patient.getAssignedDoctor());
        assertEquals("Dr. Logan", patient.getAssignedDoctor().getName());
	}
}
