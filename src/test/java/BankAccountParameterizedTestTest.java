import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {
    // TODO: When using @ParameterizedTest JavaSpring Annotations; must always specify a data-source for where all
    //  the parameters are coming from
    @ParameterizedTest // this Repeats due to the number of Items in DataSource
    @ValueSource(ints = {100, 400, 800, 1000}) // Note: Always an *array* of data or objects
    // Allows only certain data-types.
    @DisplayName("Deposit all amounts from @ValueSource successfully.")
    // TODO: Also add as a parameter, the implicit amount to be added
    // TODO: Implicitly deposits all values and re-runs 4 times, depending on the items in the @ValueSource
    public void testDepositBalanceExpect500(int amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @ParameterizedTest
    // TODO: Passes an EnumerableSource; value = EnumSource
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"} )
    // This names is an arbVar // This is the names @ValueSource
    // @ValueSource
    // Repeats twice and inserted for each day
    // Checks for only Tuesday, and Thursday
    public void testDayOfWeek(DayOfWeek day) {
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
//    @CsvSource({"100, Mike", "100, Mary", "200, Rachid", "150, Ted"})
    @CsvFileSource(resources = "details.csv", delimiter = ';') // set the resources arbVar equal to the CSV file name!
    public void depositAndNameTest(double amount, String name, BankAccount bankAccount) {
    bankAccount.deposit(amount); // this is implictly parsing the csv-source so that the double-value is being
        // deposited as amount; while the String Name is setHolderName()
    bankAccount.setHolderName(name);
    assertEquals(amount, bankAccount.getBalance());
    assertEquals(name, bankAccount.getHolderName());
    // it tries to type-cast the CSV values into a double and then a
        // String ; if it can't it will throw an ExceptionPreconditionViolation Error!!
    }

    // TODO: you can initialize an Array with {curly-brace-syntax} in Java Spring!

    // TODO: Note: For Test file data sources // Always add to the resources folder
}
