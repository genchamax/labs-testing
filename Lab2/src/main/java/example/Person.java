package example;

/**
 * Created by Max on 23.11.2016.
 */
public class Person implements IPerson {

    private String firstName;
    private String lastName;
    private String middleName;

    public Person() {}

    public Person(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Override
    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
}
