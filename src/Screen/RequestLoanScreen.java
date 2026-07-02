package Screen;

import core.MenuScreen;
import model.Account;

import java.util.InputMismatchException;
import java.util.Map;

public class RequestLoanScreen implements MenuScreen {
    private Map<String, Account> accounts;

    public RequestLoanScreen(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void render(Account account) {
        System.out.print("Enter amount to borrow: ");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        try{
            double borrow_amount = Double.parseDouble(input);
            double user_balance = account.getBalance();
            account.setBalance(user_balance + borrow_amount);
            account.setLoanBalance(account.getLoanBalance() + borrow_amount);
            System.out.printf("\nCongratulations! You have borrowed GHS%.02f\n", borrow_amount);
            System.out.printf("Current balance: GHS%.02f\n", account.getBalance());
        }
        catch(NumberFormatException e){
            System.out.println("Invalid Input");
        }
        catch(InputMismatchException e){
            System.out.println("Not a valid number");
        }
        catch(Exception e){
            System.out.println("An error occurred");
        }
        return new LoanMenuScreen(accounts);
    }
}
