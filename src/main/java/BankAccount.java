import lombok.NoArgsConstructor;
public class BankAccount {
    // TODO: These are 2 private-instance variables
    private double balance;
    private double minBalance;
    private boolean isActive = true;
    private String holderName;

    // TODO: This is 2-arg constructor variant
    public BankAccount(double balanceArg, double minBalanceArg) {
        this.balance = balanceArg;
        this.minBalance = minBalanceArg;
    }

    // TODO: Generate Getters/Setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double withdraw (double amount) throws RuntimeException {
        // TODO: Should throw an error if the difference AFTER withdrawing the money will be lower than the minimum-allowed-balance
        if ((balance - amount) > minBalance) {
            balance -= amount;
            // TODO: This returns the 'amount' that was withdrawn
            return amount;
        } else {
            throw new RuntimeException();
        }
    }

    public double deposit (double amount) {
        // Insert a thread to sleep
        try {
            // ** This will throw an exception must nest in try/catch
            Thread.sleep(5);
            // In JVM, certain methods will Throw an exception; therefore must always NEST them inside try/catch blocks
        } catch (InterruptedException e) {
            // Prints stacktrace of any given *Throwable object*
            e.printStackTrace();
//            System.out.println(e);
        }
        return balance += amount;
    }
}
