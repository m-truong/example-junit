import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class.")
public class BankAccountAssertionTest {
    private BankAccount bankAccountTest;

//    @BeforeEach
//    public void initTest() {
//        bankAccountTest = new BankAccount();
//    }

//    Not there are many different overloads for the Assertion methods
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

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero() {
        BankAccount newInstanceOfBankAccount = new BankAccount(500, -1000);
        newInstanceOfBankAccount.withdraw(800);
        assertNotEquals(0, newInstanceOfBankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    // assertNotNull
    @Test
    @DisplayName("Test set holder name")
    public void testHolderNameSet() {
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Cathy");
        assertNotNull(bankAccount.getHolderName());
    }

    // assertSame --> checks if two const's refer to the exact same object

    // assertThrows --> should throw an exception // if throws an exception ; then definitely not Production code
    // Note: it should throw a Specific Type of Exception not AnyType

    @Test
    @DisplayName("Test that we can't withdraw below the minimum balance")
    public void testNoWithDrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        // Pass it an anon-arrow f(x), it executes it and asserts that a RunTimeException.class is thrown!
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit methods")
    public void testWithdrawAndDepositWithoutExceptions() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        // ** Important Notes **
//        fail();
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
    }

    // assertTimeout

    @Test
    @DisplayName("Test speed deposit")
    public void testDepositTimeout() {
        BankAccount bankAccount = new BankAccount(400, 0);
        // Give 1 nano-second to complete
        assertTimeout(Duration.ofNanos(10), () -> bankAccount.deposit(200));
        // ** Important Notes **
//        assertEquals(0.33, 1/3, 0.01);
        // ** Important Notes **
//        assertEquals(0.33, 1/3, "Oops, not the same"); // custom message for Fail
    }

//    @Test
//    @DisplayName("Test delta decimal difference")
//    public void testDeltaDifference() {
//    }
}
