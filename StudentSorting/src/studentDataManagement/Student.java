package studentDataManagement;
//Creating the Student class by implementing elements attributed to the student.
public class Student {
	int rollno;
	String name;
	String address;
	
	//Creating the non parameterized constructor.
	public Student() {
		rollno = -1;
		name = "NO NAME";
		address = "NO ADDRESS";
	}
	
	//Creating the parameterized constructor
	public Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}
	//Getters and setters for the student class
	public int getRollNo() {
		return rollno;
	}
	
	public void setRollNo(int rollno) {
		this.rollno = rollno;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	//Overriden toString method to control the print method for the student object
	@Override
	public String toString() {
		return rollno + " - " + name + " - " + address;
	}

}
