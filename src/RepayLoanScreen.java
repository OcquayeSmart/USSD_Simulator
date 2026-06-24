import java.util.InputMismatchException;

public class RepayLoanScreen implements MenuScreen{

    @Override
    public void render(Account account) {
        System.out.print("Enter amount to repay: \n");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        try{
            double loanedAmount = Double.parseDouble(input);
            if(loanedAmount <= account.getLoanBalance()){
                System.out.println("Eligible to repay loan");
                //whatever you do to the balance, do to the loan balance
                account.setBalance(account.getBalance() - loanedAmount);
                account.setLoanBalance(account.getLoanBalance() - loanedAmount);
                System.out.printf("Loan of GHS%.02f paid\n", account.getLoanBalance());
            }
            else{
                System.out.println("Insufficient funds");
                return new MainMenuScreen();
            }
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
        return new MainMenuScreen();
    }
}
