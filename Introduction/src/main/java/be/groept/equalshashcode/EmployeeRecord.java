package be.groept.equalshashcode;


public class EmployeeRecord {

	private final String employeeFirstName;
	private final String employeeLastName;

	public EmployeeRecord(String employeeFirstName, String employeeLastName) {
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}
}
