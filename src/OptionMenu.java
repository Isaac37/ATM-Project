import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogIn() throws IOException {
        int x = 1;
        do {
            try {
                data.put(952141, 191904);
                data.put(989947, 71976);

                System.out.println("Welcome to the ATM Project");
                System.out.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());
            }catch (Exception e)  {
                System.out.println("\n" + "Invalid Characters(s). Only Number." + "\n");
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            }else
                System.out.println("\n" + "Wrong customer or pin number" + "\n");
        }while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using ATM bye. \n");
                break;
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2- Withdraw funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using ATM bye. \n");
                break;
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getChecking();

        }
    }

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2- Withdraw funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving account balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using ATM bye. \n");
                break;
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getChecking();

        }
    }

}
