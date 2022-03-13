import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CodeTest {
    private Code instanceCodeClass;

    @BeforeEach
    public void initTests() {
        instanceCodeClass = new Code();
    }

    @Test
    public void testSayHelloHappyPath() {
        assertEquals("Hello World!", instanceCodeClass.sayHello());
    }

    @Test
    public void testSayHelloErrorPath() {
        assertNotEquals("Not Hello World~",instanceCodeClass.sayHello());
    }
}
