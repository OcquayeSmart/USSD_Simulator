import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        boolean isRunning = true;
        Map<String, Account> accounts = new HashMap<>();
        accounts.put("0241234567", new Account("1234", 150.00));
        //added second demo account
        accounts.put("0501112222", new Account("4321", 75.50));
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        if (!accounts.containsKey(phoneNumber)) {
            System.out.println("Number not registered");
        }
        else {
            accounts.get(phoneNumber).setPhoneNumber(phoneNumber);
            System.out.print("Enter your pin: ");
            String pinEntered = scanner.nextLine();
            if(pinEntered.equals(accounts.get(phoneNumber).getPIN())){
                while (isRunning) {
                    String output = "1. Check Balance\n2. Send Money\n3. Exit\n";
                    System.out.println(output);
                    input = scanner.nextInt();
                    switch (input) {
                        case 1 -> System.out.printf("%.02f\n", accounts.get(phoneNumber).getBalance());
                        case 2 -> {
                            System.out.print("Enter an amount: ");
                            double send_amount = scanner.nextDouble();
                            if (accounts.get(phoneNumber).getBalance() >= send_amount) {
                                double current_balance = accounts.get(phoneNumber).getBalance();
                                accounts.get(phoneNumber).setBalance(current_balance - send_amount);
                                System.out.printf("Sent GHS%.02f\n", send_amount);
                            } else {
                                System.out.println("Insufficient funds\n");
                            }
                        }
                        case 3 -> isRunning = false;
                        default -> System.out.println("Invalid Option");
                    }
                }
            }
            else{
                System.out.println("Incorrect PIN");
            }
        }
    }
}
