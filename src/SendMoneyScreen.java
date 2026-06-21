public class SendMoneyScreen implements MenuScreen{
    @Override
    public void render(Account account) {
        System.out.print("Enter an amount(GHS): ");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        try{
            double amountSent = Double.parseDouble(input);
            if(amountSent <= account.getBalance()){
                double current_balance = account.getBalance();
                account.setBalance(current_balance - amountSent);
                System.out.printf("You have sent GHS%.02f\n", amountSent);
            }
            else{
                System.out.println("Insufficient funds");
                return new SendMoneyScreen();
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
