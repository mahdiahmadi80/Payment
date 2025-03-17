public class DigitalWalletPayment extends Payment {
    private String walletName;
    private String email;


    public DigitalWalletPayment(Account sourceAccount, Account destinationAccount, String walletName, String email, int amount) {
        super(sourceAccount, destinationAccount, amount);
        this.walletName = walletName;
        this.email = email;
    }

    @Override
    public String processPayment() {

        if (sourceAccount.getBalance() >= amount) {
            sourceAccount.withdraw(amount);
            destinationAccount.deposit(amount);
            return ("Payment of " + amount + " processed via " + walletName + " for " + email);
        } else {

            return ("Insufficient funds in account:" + sourceAccount.getAccountName());
        }
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
