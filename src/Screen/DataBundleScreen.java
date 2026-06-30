package Screen;

import core.MenuScreen;
import model.Account;
import model.DataBundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBundleScreen implements MenuScreen {
    private final Map<String, Account> accounts;
    List<DataBundle> bundles = new ArrayList<>();
    public DataBundleScreen(Map<String, Account> accounts) {
        this.accounts = accounts;
        bundles.add(new DataBundle(2.45, 20, 30));
        bundles.add(new DataBundle(6.13, 50, 30));
        bundles.add(new DataBundle(12.81, 80, 30));
        bundles.add(new DataBundle(39.00, 200, 30));
        bundles.add(new DataBundle(111.43, 300, 30));
        bundles.add(new DataBundle(263.38, 400, 30));
    }

    @Override
    public void render(Account account) {
        int counter = 1;
        for(DataBundle bundle : bundles){
            System.out.println(counter + ". " + bundle.describe());
            counter++;
        }
        System.out.print("\nChoose your preferred bundle(or 0 to go back): ");
        System.out.println();
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        try{
            int bundleInput = Integer.parseInt(input);

            if (bundleInput == 0) {
                return new MainMenuScreen(accounts);
            }
            int index = bundleInput - 1;
            DataBundle selectedBundle = bundles.get(index);
            if(selectedBundle.getBundlePrice() <= account.getBalance()){
                double user_balance = account.getBalance();
                account.setBalance(user_balance - selectedBundle.getBundlePrice());
                System.out.println("----------------CONGRATULATIONS------------------");
                System.out.printf("You have purchased %.2fGB at GHS%.2f for %d days\n", selectedBundle.getBundleSize(), selectedBundle.getBundlePrice(), selectedBundle.getBundleDuration());
                System.out.println();
            } else {
                System.out.println("Insufficient funds");
                return new DataBundleScreen(accounts);
            }
        }
        catch(NumberFormatException e){
            System.out.println("Invalid Input");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Input out of range");
        }
        catch(Exception e){
            System.out.println("An error occurred");
        }
        return new MainMenuScreen(accounts);
    }
}
