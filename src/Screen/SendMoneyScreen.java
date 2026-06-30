package Screen;

import core.MenuScreen;
import model.Account;

import java.util.Map;

public class SendMoneyScreen implements MenuScreen {
    private final Map<String, Account> accounts;
    private Step step = Step.RECIPIENT;
    private String recipientNumber;

    public SendMoneyScreen(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
    @Override
    public void render(Account account) {
        if(step == Step.RECIPIENT){
            System.out.print("\nEnter recipient's phone number: ");
            System.out.println();
        }
        else{
            System.out.print("\nEnter an amount(GHS): ");
            System.out.println();
        }
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        if(step == Step.RECIPIENT){
            recipientNumber = input;
            if(accounts.containsKey(recipientNumber)){
                System.out.println("Send to: " + accounts.get(recipientNumber));
                step = Step.AMOUNT;
            }
            else{
                System.out.println("Account (" + accounts.get(recipientNumber) + ")" + " not found");
                System.out.println("Transaction Failed");
                return new MainMenuScreen(accounts);
            }
        }
        else if(step == Step.AMOUNT){
            try{
                double amountSent = Double.parseDouble(input);
                if(amountSent <= account.getBalance()){
                    double current_balance = account.getBalance();
                    account.setBalance(current_balance - amountSent);
                    System.out.printf("\nSent GHS%.02f to %s", amountSent, accounts.get(recipientNumber));
                    account.setBalance(account.getBalance() + amountSent);
                } else{
                    System.out.println("Insufficient funds");
                    return new SendMoneyScreen(accounts);
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid Input");
            }
            catch(Exception e){
                System.out.println("An error occurred");
            }
        }
        return new MainMenuScreen(accounts);
    }
}
