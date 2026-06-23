public class AirtimeScreen implements MenuScreen{

    @Override
    public void render(Account account) {
        System.out.print("How much airtime would you like to buy: ");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        try{
            double amount = Double.parseDouble(input);
            double user_balance = account.getBalance();
            if(amount <= account.getBalance()){
                account.setBalance(user_balance - amount);
                System.out.printf("Congratulations! You have received GHS%.02f of airtime", amount);
            }
            else{
                System.out.println("Insufficient funds");
                return new AirtimeScreen();
            }
        }
        catch(NumberFormatException e){
            System.out.println("Invalid Input");
        }
        catch(Exception e){
            System.out.println("An error occurred");
        }
        return new MainMenuScreen();
    }
}
