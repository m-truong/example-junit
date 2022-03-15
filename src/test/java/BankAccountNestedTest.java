import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountNestedTest {
    @Test
    @DisplayName("Withdraw 500 successfully.")
    public void testWithdrawBalanceExpect200() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        // TODO: Expectation is bank.getBalance() returns 200
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully.")
    public void testDepositBalanceExpect900(){
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }

    // ** Note: You can always nest classes within a save .java file
    // ** You have to make a nested class ->  with it's own test methods!
    @Nested
    class WhenBalanceEqualsZero {

//        @BeforeEach
//        public void initEachTest() {
//            BankAccount bA1 = new BankAccount(0, 0);
//        }

        @Test
        public void testWithdrawMinimumBalanceIs0() {
            BankAccount bA1 = new BankAccount(0, 0);
            // 2nd Arg is a first-class citizen executable
            assertThrows(RuntimeException.class, () -> bA1.withdraw(500));
        }

        @Test
        public void testWithdrawMinimumBalanceNegative1000() {
            BankAccount bA2 = new BankAccount(0, -1000);
            // Takes 2 values args
            assertEquals(-500, bA2.getBalance());
        }
    }
}
