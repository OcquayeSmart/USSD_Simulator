package service;

import model.Account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class PersistenceService {
    Map<String, Account> accounts = new HashMap<>();
    Path path = Path.of(System.getProperty("user.dir"), "customer_profile.csv");
    public void save(Map<String, Account> account) {
        try(BufferedWriter bf = Files.newBufferedWriter(path)){
            for(Map.Entry<String, Account> entry: account.entrySet()){
                //we take both the key and the value(account)
                String phoneNumber = entry.getKey();
                Account acc = entry.getValue();//gives us the value(account)
                String pin = acc.getPIN();//we use the account to now get the pin, balance and loan balance
                double balance = acc.getBalance();
                double loanBalance = acc.getLoanBalance();
                String combinedString = phoneNumber + "," + pin + "," + balance + "," + loanBalance;
                bf.write("phone,pin,balance,loan");
                bf.write(combinedString);
                bf.newLine();
            }
        }
        catch(IOException e){
            System.out.println("Read and write file error");
        }
        catch(Exception e){
            System.out.println("An error occurred");
        }
    }
    public Map<String, Account> load(){
        if(!Files.exists(path)){
            return new HashMap<>();
        }
        try(BufferedReader br = Files.newBufferedReader(path)){
            String line;
            br.readLine();//skipping the header files
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String phoneNumber = parts[0].trim();
                String pin = parts[1].trim();
                double balance = Double.parseDouble(parts[2].trim());
                double loanBalance = Double.parseDouble(parts[3].trim());
                Account account = new Account(pin, balance);
                account.setLoanBalance(loanBalance);
                accounts.put(phoneNumber, account);
            }
        }
        catch(IOException e){
            System.out.println("Read and Write error");
            return new HashMap<>();
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
        return accounts;
    }
}
