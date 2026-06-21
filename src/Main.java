import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        double send_amount;
        boolean isRunning = true;
        Map<String, Account> accounts = new HashMap<>();
        accounts.put("0241234567", new Account("1234", 150.00));
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
                    System.out.println("""
                            1. Check Balance
                            2. Send Money
                            3. Exit
                            """);
                    input = scanner.nextInt();
                    switch (input) {
                        case 1 -> System.out.printf("%.02f\n", accounts.get(phoneNumber).getBalance());
                        case 2 -> {
                            System.out.print("Enter an amount: ");
                            send_amount = scanner.nextDouble();
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
        }
    }
}
