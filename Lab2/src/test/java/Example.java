import example.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Max on 23.11.2016.
 */
public class Example {

    @Test
    public void getFullName_CallMethod_ReturnsFullName() {

        Person person = new Person("First", "Last", "Middle");

        //act
        String result = person.getFullName();

        //assert
        Assert.assertEquals("First Middle Last", result);
    }

}
