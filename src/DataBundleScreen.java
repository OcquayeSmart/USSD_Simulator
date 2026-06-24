import java.util.ArrayList;
import java.util.List;

public class DataBundleScreen implements MenuScreen{
    int counter = 1;
    List<DataBundle> bundles = new ArrayList<>(){{
       add(new DataBundle(2.45, 20, 30));
       add(new DataBundle(6.13, 50, 30));
       add(new DataBundle(12.81, 80, 30));
       add(new DataBundle(39.00, 200, 30));
       add(new DataBundle(111.43, 300, 30));
       add(new DataBundle(263.38, 400, 30));
    }};
    @Override
    public void render(Account account) {
        for(DataBundle bundle : bundles){
            System.out.println(counter + ". " + bundle.describe());
            counter++;
        }
        System.out.print("\nEnter your preferred choice: ");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        try{
            int bundleInput = Integer.parseInt(input);
            int index = bundleInput - 1;
            DataBundle selectedBundle = bundles.get(index);
            if(selectedBundle.bundlePrice < account.getBalance()){
                double user_balance = account.getBalance();
                account.setBalance(user_balance - selectedBundle.getBundlePrice());
                System.out.println("----------------CONGRATULATIONS------------------");
                System.out.printf("You have purchased %.2fGB at GHS%.2f for %d days\n", selectedBundle.getBundleSize(), selectedBundle.getBundlePrice(), selectedBundle.getBundleDuration());
            }
            else{
                System.out.println("Insufficient funds");
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
