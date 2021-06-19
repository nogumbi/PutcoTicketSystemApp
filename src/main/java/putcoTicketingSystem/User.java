package putcoTicketingSystem;

import java.util.HashMap;
import java.util.Scanner;

public class User {
    private HashMap<String, String> credentials = new HashMap<String, String>();
    //HashSet<putcoTag> j = new ArrayList<String>();

    private int count = 0;

    public HashMap<String, String> login(){
        while(true) {
            //Outer array for adding values to the first list
            Scanner input1 = new Scanner(System.in);
            System.out.println("Enter your bus tag ID\n");
            String userName = input1.nextLine();

            System.out.println("password:");
            Scanner input2 = new Scanner(System.in);
            String passWord = input2.nextLine();

            if (credentials.containsKey(userName) == true && credentials.containsValue(passWord) == true) {
                System.out.println(userName + " has successfully logged in.");
            } else if (credentials.containsKey(userName) == true && credentials.containsValue(passWord) == false) {
                count += 1;
                System.out.println("Incorrect password.");

                if (count > 3) {
                    System.out.println(userName + "'s" + " account has been blocked");
                    break;
                }
            } else if (credentials.containsKey(userName) == false && credentials.containsValue(passWord) == false) {

                System.out.println("There are no account details for username:" + userName + " password :" + passWord + " if you wish to register new account details,please enter privilaged mode?");

                Scanner input8 = new Scanner(System.in);
                System.out.println("Enter root username");
                String rootUserName = input8.nextLine();

                Scanner input9 = new Scanner(System.in);
                System.out.println("Enter root password?");
                String rootPassword = input9.nextLine();

                if (rootUserName.equals("admin") && rootPassword.equals("admin1")) {

                    credentials.put(userName, passWord);
                    System.out.println("The credentials you entered do not exist,new user registered.");
                } else {
                    System.out.println("The credentials you entered are incorrect, bye sucker!");
                    break;
                }
                if (userName.length() > 0 || passWord.length() > 0) {
                    credentials.put(userName, passWord);
                }
                // key-value pairs
            }
        }
        return credentials;
    }
}
