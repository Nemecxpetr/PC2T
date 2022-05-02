package cv9;

public class Employee implements Comparable<Employee> {
	
	private String nickname;
	private String email;
	private char[] password;
	
	EmployeeType employeeType;
	
	public Employee(String nickname, String email, char[] password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
	
	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public char[] getPassword() {
		return password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

    @Override
    public int compareTo(Employee employee) {
        return this.getEmail().compareTo(employee.getEmail());
    }

    @Override
    public String toString() {
        return "Employee: " + nickname + "\nEmail: " + email + "\n";
    }
}
