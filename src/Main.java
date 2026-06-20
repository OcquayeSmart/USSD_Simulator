import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String number;
        int pinOriginal = 0;
        int pinEntered;
        double balance = 150.00;
        int input;
        double send_amount;
        boolean isRunning = true;
        System.out.print("Enter your phone number: ");
        number = scanner.nextLine();
        System.out.print("Enter your pin: ");
        pinEntered = scanner.nextInt();
        if(pinEntered == pinOriginal){
            while(isRunning){
                System.out.println("""
1. Check Balance
2. Send Money
3. Exit
""");
                input = scanner.nextInt();
                switch(input){
                    case 1 -> System.out.printf("%.02f\n",balance);
                    case 2 -> {
                        System.out.print("Enter an amount: ");
                        send_amount = scanner.nextDouble();
                        if(balance >= send_amount){
                            balance = balance - send_amount;
                            System.out.printf("Sent GHS%.02f\n" ,send_amount);
                        }
                        else{
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