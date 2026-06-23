public class LoanMenuScreen implements MenuScreen{

    @Override
    public void render(Account account) {
        System.out.println("1. Take a quick loan");
        System.out.println("2. Back to Main Menu");
        //Pay back loan
        //Generate loanedAmount variable to keep track of loaned amount
        //SendMoney should automatically subtract the loaned amount after due date
        //Use transaction time variable which increases after every transaction to simulate due date
        //there should be a maximum limit on how much a user is allowed to borrow
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        int user_input = Integer.parseInt(input);
        switch(user_input){
            case 1 -> System.out.println("bla bla bla");
            case 2 -> {
                return new MainMenuScreen();
            }
        }
        return null;
    }
}
