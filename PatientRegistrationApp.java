package PatientManagmentSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientRegistrationApp {
	private static final String FILE_NAME = "patients.txt";
	private static ArrayList<Patient> patients = new ArrayList<>();
	private static ArrayList<Doctor> doctors = new ArrayList<>();

	// Save patient to file
	public static void savePatientsToFile(Scanner scanner) {
		System.out.println("Enter Patient ID: ");
		String patientID = scanner.nextLine();
		Patient patient = findPatient(patientID);

		if (patient == null) {
			System.out.println("Patient cannot be found. ");
			return;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
			writer.write(patient.getDetails());
			writer.newLine();
			System.out.println("Patient saved to file. ");
		} catch (IOException e) {
			System.out.println("Error saving patient. ");
		}
	}
	
	// Load patient from file
	public static void loadPatientsFromFile(Scanner scanner) {
		System.out.println("Enter patient ID: ");
		String patientID = scanner.nextLine();

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("Patient ID: " + patientID)) {
					System.out.println(line);
					return;
				}
			}
			System.out.println("Patient not found. ");
		} catch (IOException e) {
			System.out.println("Error reading Patient: " + e.getMessage());
		}
	}
	
	// Create new patient in list
	private static void createNewPatient(Scanner scanner) {
		System.out.print("Enter Patient Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Gender: ");
		String gender = scanner.nextLine();
		System.out.print("Enter Patient ID: ");
		String patientID = scanner.nextLine();

		Patient patient = new Patient(name, age, gender, patientID);
		patients.add(patient);
		System.out.println("New patient created: " + patient.getDetails());
	}
	
	// Assign doctor to patient
	private static void assignDoctor(Scanner scanner) {
		System.out.print("Enter Patient ID to assign doctor: ");
		String patientID = scanner.nextLine();
		Patient patient = findPatient(patientID);

		if (patient == null) {
			System.out.println("Patient not found.");
			return;
		}

		System.out.println("Available Doctors:");
		for (int i = 0; i < doctors.size(); i++) {
			System.out.println((i + 1) + ". " + doctors.get(i).getDetails());
		}

		System.out.print("Select a doctor by number: ");
		int doctorIndex = scanner.nextInt() - 1;
		scanner.nextLine();

		if (doctorIndex < 0 || doctorIndex >= doctors.size()) {
			System.out.println("Invalid doctor selection.");
			return;
		}

		Doctor doctor = doctors.get(doctorIndex);
		patient.assignDoctor(doctor);
		System.out.println("Doctor assigned successfully.");
	}
	
	// Add symptoms to patient
	private static void addSymptoms(Scanner scanner) {
		System.out.print("Enter Patient ID: ");
		String patientID = scanner.nextLine();
		Patient patient = findPatient(patientID);

		if (patient == null) {
			System.out.println("Patient not found.");
			return;
		}

		System.out.println("Enter symptoms (type 'done' to finish):");
		while (true) {
			System.out.print("Symptom: ");
			String symptom = scanner.nextLine();
			if (symptom.equalsIgnoreCase("done")) {
				break;
			}
			patient.getMedicalHistory().addSymptom(symptom);
		}

		System.out.println("Symptoms added successfully.");
	}
	
	// Diagnose patient 
	private static void diagnosePatient(Scanner scanner) {
        System.out.print("Enter Patient ID to diagnose: ");
        String patientID = scanner.nextLine();
        Patient patient = findPatient(patientID);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        if (patient.getAssignedDoctor() == null) {
            System.out.println("No doctor assigned to this patient. Please assign a doctor first.");
            return;
        }

        Doctor doctor = patient.getAssignedDoctor();
        System.out.println("Doctor " + doctor.getName() + " is diagnosing the patient.");

        System.out.print("Enter diagnosis condition: ");
        String condition = scanner.nextLine();
        System.out.print("Enter prescribed drug: ");
        String prescribedDrug = scanner.nextLine();

        doctor.diagnose(patient, condition, prescribedDrug);
        System.out.println("Patient Diagnosed: " + patient.getDetails());
    }
	
	// Main method to execute program
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		doctors.add(new Doctor("Dr. Wilson", 22, "Male", "D001"));
		doctors.add(new Doctor("Dr. Arman", 23, "Male", "D002"));

		while (true) {
			System.out.println("\n--- Patient Management System ---");
			System.out.println("1. Create New Patient");
			System.out.println("2. Assign Doctor to Patient");
			System.out.println("3. Add Symptoms to Patient");
			System.out.println("4. Diagnose Patient");
			System.out.println("5. Save Patient to File");
			System.out.println("6. Load Patient from File");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				createNewPatient(scanner);
				break;
			case 2:
				assignDoctor(scanner);
				break;
			case 3:
				addSymptoms(scanner);
				break;
			case 4:
				diagnosePatient(scanner);
				break;
			case 5:
				savePatientsToFile(scanner);
				break;
			case 6:
				loadPatientsFromFile(scanner);
				break;
			case 7:
				System.out.println("Exiting Program");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

	}
	
	// Method to find patient by ID in list
	private static Patient findPatient(String patientID) {
		for (Patient patient : patients) {
			if (patient.getPatientID().equals(patientID)) {
				return patient;
			}
		}
		return null;
	}
}
