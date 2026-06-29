import core.MenuScreen;
import model.Account;
import service.PersistenceService;
import Screen.PinLoginScreen;

import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        PersistenceService ps = new PersistenceService();
        Scanner scanner = new Scanner(System.in);
        Map<String, Account> accounts = ps.load();
//        System.out.println("Loaded accounts: " + accounts.keySet());
        if(accounts.isEmpty()){
            accounts.put("0241234567", new Account("1234", 150.00));
            accounts.put("0501112222", new Account("4321", 75.50));
        }
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        Account account = accounts.get(phoneNumber);
        if (!accounts.containsKey(phoneNumber)) {
            System.out.println("Number not registered");
        }
        else{
            MenuScreen currentScreen = new PinLoginScreen();
            while(currentScreen != null){
                currentScreen.render(account);
                String input = scanner.nextLine().trim();
                currentScreen = currentScreen.handleInput(input, account);
            }
            ps.save(accounts);
        }
   }
}
