public class Account {
    String phoneNumber;
    private final String PIN;
    private double balance;
    private double loanBalance = 0;

    public double getLoanBalance() {
        return loanBalance;
    }
    public void setLoanBalance(double loanBalance) {
        this.loanBalance = loanBalance;
    }
    Account(String PIN, double balance){
        this.PIN = PIN;
        this.balance = balance;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPIN() {
        return PIN;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
