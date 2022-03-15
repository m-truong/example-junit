import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500,0);
        // Note: This assumes that BankAccount instance is not null ; only want test to run if truthy
//        assumeFalse(bankAccount == null, "Account is null");
//        assertTrue(bankAccount.isActive());

        // Do a Combo
        assumingThat(bankAccount == null, () -> assertTrue(bankAccount.isActive()));
    }

}
