package in.erai.batch.spring.batch.annotation;

public class Person {
	private String lastName;
    public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private String firstName;

	public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
	public Person() {

    }
	@Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

}
