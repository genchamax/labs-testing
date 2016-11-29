import util.Calculator;

/**
 * Created by Max on 23.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Enter number for adding");
        try {
            System.out.println(calculator.addWithConsoleInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
