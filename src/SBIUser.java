import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{

    // attribute
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        SBIUser.rateOfInterest = rateOfInterest;
    }

    public SBIUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        // Bank is initializing
        this.rateOfInterest = 6.5;
        this.accountNo = String.valueOf(UUID.randomUUID());


    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance = balance + amount;
        return "Your new balance is : " + balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword , password)){
            if(amount > balance){
                return "Sorry bro ! Insufficient Money";
            }
            else {
                balance = balance - amount;
                return "Paisa hi Paisa";
            }
        }
        else {
            return "Wrong password";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance * years * rateOfInterest) / 100;
    }
}
