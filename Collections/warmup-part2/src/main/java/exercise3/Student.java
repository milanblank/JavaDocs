package exercise3;

/**
 * Created by Milan.Stojiljkovic on 7/7/2017.
 */
public class Student {
    private final String firstName;
    private final String lastName;

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
