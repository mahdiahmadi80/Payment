public class CashPayment extends Payment {

    public CashPayment(Account sourceAccount, Account destinationAccount, int amount) {
        super(sourceAccount, destinationAccount, amount);
    }

    @Override
    public String processPayment() {
        if (sourceAccount.getBalance() >= amount) {
            sourceAccount.withdraw(amount);
            destinationAccount.deposit(amount);
            return ("Cash payment of" + amount + "completed");
        } else {
            return ("Insufficient funds in account: " + sourceAccount.getAccountName());
        }
    }
}
