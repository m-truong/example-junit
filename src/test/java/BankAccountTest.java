import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Test BankAccount class.")
public class BankAccountTest {
    private BankAccount bankAccountTest;

//    @BeforeEach
//    public void initTest() {
//        bankAccountTest = new BankAccount();
//    }

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
}
