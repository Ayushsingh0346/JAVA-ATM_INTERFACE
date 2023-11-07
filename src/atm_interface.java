import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atm_interface {
    public static void main(String[] args) {
        ATMop obj = new ATMop();
    }

}
class Data{
    float balance;
}

class ATMop{
    Scanner sc = new Scanner(System.in);
    Map<Integer, Data> mp = new HashMap<>();
    ATMop(){
        System.out.println("****************************************");
        System.out.println("Welcome to our ATM");
        op();
    }

    public void op(){
        System.out.println("**********************************");
        System.out.println("Enter your pin code");
        int pincode = sc.nextInt();

        if(mp.containsKey(pincode) == true){
            Data obj = mp.get(pincode);
            menu(obj);
        }
        else{
            System.out.println("********************************");
            System.out.println("Please create account first");
            System.out.println("Set your pin code");
            int pin = sc.nextInt();
            Data obj = new Data();
            mp.put(pin , obj);
            menu(obj);
        }
    }

    public void menu(Data obj){

        System.out.println("Please enter valid number");
        System.out.println("1 . Check balance");
        System.out.println("2 . Deposit money");
        System.out.println("3 . Withdraw money");
        System.out.println("4 . Check another account");
        System.out.println("5 . Exit");

        int x = sc.nextInt();

        if(x == 1){
            check_balance(obj);
        }
        else if (x == 2) {
            deposit(obj);
        }
        else if(x == 3){
            withdraw(obj);
        }
        else if(x == 4){
            op();
        }
        else if(x == 5){
            System.out.println("Thank you !");
        }
        else{
            System.out.println("Please enter a valid number");
            menu(obj);
        }
    }
    public  void check_balance(Data obj){
        System.out.println("*********************************");
        System.out.println("YOUR BALANCE " + obj.balance);
        System.out.println("*********************************");
        menu(obj);
    }

    public void deposit(Data obj){
        System.out.println("Enter your amount");
        float a = sc.nextFloat();
        obj.balance += a;

        System.out.println("Amount Deposited Successfully");
        System.out.println("*********************************");
        menu(obj);
    }

    public void withdraw(Data obj){
        System.out.println("Enter the amount to Withdraw");
        float a = sc.nextFloat();
        if(obj.balance >= a){
            obj.balance -= a;
            System.out.println("Amount withdrawn Successfully");
        }
        else{
            System.out.println("Insufficient balance");
        }

        System.out.println("**************************************");
        menu(obj);
    }



}
