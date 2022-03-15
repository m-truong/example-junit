import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

// *** This @nnotation allows the BankAccount class, to already be instantiated
@ExtendWith(BankAccountParameterResolver.class) // ONLY supports the BankAccount
public class BankAccountDependencyInjectionTest {
    @Test
    @DisplayName("Deposit 400 successfully.")
    // TODO: Instead of CREATING an INSTANCE --> With the ParameterResolver import-module; you can JUST pass the
    // *** Class-Dependency as a parameter; then the parameter-resolver will check if the class is the correct type
    public void testDepositBalanceExpect900(BankAccount bankAccount){
        // TODO: No longer Creating instance of the Dependency
//        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
