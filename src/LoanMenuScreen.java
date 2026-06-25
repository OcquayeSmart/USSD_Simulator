import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LoanMenuScreen implements MenuScreen{
    Map<String, Supplier<MenuScreen>> loanOptions = new HashMap<>(){{
        put("1", RequestLoanScreen::new);
        put("2", LoanBalanceScreen::new);
        put("3", RepayLoanScreen::new);
        put("4", MainMenuScreen::new);
    }};
    @Override
    public void render(Account account) {
        System.out.println("1. Request loan\n2. Check loan balance\n3. Repay loan\n4. Back");
        //Pay back loan
        //Generate loanedAmount variable to keep track of loaned amount
        //SendMoney should automatically subtract the loaned amount after due date
        //Use transaction time variable which increases after every transaction to simulate due date
        //there should be a maximum limit on how much a user is allowed to borrow
    }
    @Override
    public MenuScreen handleInput(String input, Account account) {
        try{
            int user_input = Integer.parseInt(input);
            switch(user_input){
                case 1 -> {
                    return loanOptions.get("1").get();
                }
                case 2 -> {
                    return loanOptions.get("2").get();
                }
                case 3 -> {
                    return loanOptions.get("3").get();
                }
                case 4 -> {
                    return new MainMenuScreen();
                }
            }
        }
        catch(NumberFormatException e){
            System.out.println("Invalid Input");
        }
        catch(Exception e){
            System.out.println("An error occurred");
        }
        return new LoanMenuScreen();
    }
}
