public class CreditCardPayment extends Payment {

    public CreditCardPayment(Account sourceAccount, Account destinationAccount, int amount) {
        super(sourceAccount, destinationAccount, amount);
    }

    @Override
    public String processPayment() {
        if (sourceAccount.getBalance() >= amount) {
            sourceAccount.withdraw(amount);
            destinationAccount.deposit(amount);
            return ("Credit card payment processed: " + amount);
        } else {
            return ("Insufficient funds in account: " + sourceAccount.getAccountName());
        }
    }
}
