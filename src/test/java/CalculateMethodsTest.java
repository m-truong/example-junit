 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.Test;

 public class CalculateMethodsTest {
    // TODO: This is instance of the class your are testing
    // TODO: instantiate the class you are testing
    private CalculateMethods calcMethodInstance;

    @BeforeEach
    public void initTest() {
        calcMethodInstance = new CalculateMethods();
    }

    // TODO: then create individual methods inside the TestClass that runs the method unit testing!
    // TODO: must always writes test using Assertions; that'll give Assertion error
    @Test
    public void testDivideMethod() {
        assertEquals(10, calcMethodInstance.divide(100,10));
    }

    @Test
    public void testDivideByZero() {
        // TODO: You can also use Assertions.sub-method to assertThrows an error
        // TODO: also pracitce using first-class higher-order anonymous fat-arrow functional expressions (i.e. Executable)
        assertThrows(ArithmeticException.class, () -> calcMethodInstance.divide(100, 0));
    }
}
