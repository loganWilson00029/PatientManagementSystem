package PatientManagmentSystem;

public abstract class Employee extends Person {
	private String employeeID;

	public Employee(String name, int age, String gender, String employeeID) {
		super(name, age, gender);
		this.employeeID = employeeID;
	}

	public String getEmployeeID() {
		return employeeID;
	}
}
