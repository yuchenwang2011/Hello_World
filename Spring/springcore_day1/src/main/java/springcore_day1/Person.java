package springcore_day1;

public class Person {
	private String personName;

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public void printInfo() {
		System.out.println("This person's name: " + personName);
	}
}
