import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import static org.junit.jupiter.api.Assertions.assertEquals;

// ** Note: ** order of execution is always top-down for code-flow
// ** However: ** you can specify order of execution of JUnit tests if the order matters!
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderExecutionTest {
    // **static** means a member-variable belongs to the Type itself; not instance of the type
    static BankAccount bankAccount = new BankAccount(0, 0);

    @Test
    @Order(2)
    public void testWithdraw() {
        bankAccount.withdraw(300);
        // Assumption.Annotations must go before the Assertion.Annotation
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @Order(1)
    public void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
