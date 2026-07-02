package Screen;

import core.MenuScreen;
import model.Account;

import java.util.Map;

public class SendMoneyScreen implements MenuScreen {
    private Map<String, Account> accounts;
    private Step step = Step.RECIPIENT;
    private String recipientNumber;
    public SendMoneyScreen(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
    @Override
    public void render(Account account) {
        if(step == Step.RECIPIENT){
            System.out.print("\nEnter recipient's phone number: ");
        }
        else{
            System.out.print("Enter an amount(GHS): ");
        }
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        if(step == Step.RECIPIENT){
            recipientNumber = input;
            if(input.equals(account.getPhoneNumber())){
                System.out.println("----------------------------");
                System.out.println("You cannot send to yourself!");
                System.out.println("----------------------------");
                System.out.println();
                return new MainMenuScreen(accounts);
            }
            else if(accounts.containsKey(recipientNumber)){
                System.out.println("\nSend to: " + "+233" + recipientNumber);
                step = Step.AMOUNT;
                return this;
            }
            else{
                System.out.println("\nAccount (" + accounts.get(recipientNumber) + ")" + " not found");
                System.out.println("Transaction Failed");
                return new MainMenuScreen(accounts);
            }
        }
        else if(step == Step.AMOUNT){
            try{
                Account receiver = accounts.get(recipientNumber);
                double amountSent = Double.parseDouble(input);
                if(amountSent <= account.getBalance()){
                    double current_balance = account.getBalance();
                    account.setBalance(current_balance - amountSent);
                    System.out.printf("\nSent GHS%.02f to %s\n", amountSent, recipientNumber);
                    System.out.println();
                    receiver.setBalance(receiver.getBalance() + amountSent);
                }
                else{
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
