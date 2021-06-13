package putcoTicketingSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PUTCO {
	final static String outputFilePath = "C:/Users//Lehlohonolo/Desktop/credentials.txt";

	public static void main(String[] args) {
	int count = 0;
	/* create new HashMap,it will store a string key,and string value.
	 * no duplicate key-value pairs will be stored.
	 */	
	HashMap<String, String> credentials = new HashMap<String, String>();
	ArrayList <String> j = new ArrayList<String>();
	while(true) {
		//Outer array for adding values to the first list
		System.out.println("Algorithm checks if the users entry is already in the ArrayList.\n");
		System.out.println("username:");
		Scanner input1 = new Scanner(System.in);
		String userName = input1.nextLine();
		System.out.println("password:");
		Scanner input2 = new Scanner(System.in);
		String passWord = input2.nextLine();

		if (credentials.containsKey(userName) == true && credentials.containsValue(passWord) == true) {
			System.out.println(userName +" has successfully logged in.");
		}
		else if(credentials.containsKey(userName) == true && credentials.containsValue(passWord) == false) {
    		count +=1;
    		System.out.println("Incorrect password.");
    	
    		if(count>3) {
    			System.out.println(userName +"'s" + " account has been blocked");
    			break;
    		}
    	}
    	else if(credentials.containsKey(userName) == false && credentials.containsValue(passWord) == false){
    	
    		System.out.println("There are no account details for username:"+userName +" password :" +passWord+" if you wish to register new account details,please enter privilaged mode?");
    	
    		Scanner input8 = new Scanner(System.in);
    		System.out.println("Enter root username");
    		String rootUserName = input8.nextLine();
 
    		Scanner input9 = new Scanner(System.in);
    		System.out.println("Enter root password?");
    		String rootPassword = input9.nextLine();
		
    		if(rootUserName.equals("admin")&&rootPassword.equals("admin1")) {
			
    			credentials.put(userName,passWord);
    			System.out.println("The credentials you entered do not exist,new user registered.");
    		}
    		else{
    			System.out.println("The credentials you entered are incorrect,bye sucker!");
    			break;
    		}
    		if(userName.length() > 0 || passWord.length() > 0){
    			credentials.put(userName, passWord);
    		}
    		// key-value pairs
    	}
		// new file object
		File file = new File(outputFilePath);

		BufferedWriter bf = null;

		try {

			// create new BufferedWriter for the output file
			bf = new BufferedWriter(new FileWriter(file));

			// iterate map entries
			for (Map.Entry<String, String> entry :credentials.entrySet()) {

				// put key and value separated by a colon
				bf.write("username :\n" + entry.getKey() + " password :" + entry.getValue());
				// new line
				bf.newLine();
			}
			bf.flush();
			}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
			// always close the writer
			bf.close();
			}
			catch (Exception e) {
			}
		}
		
		while(userName.length()>0) {
			System.out.println("Step 2: ");
			Scanner input3 = new Scanner(System.in);	
			String y = input3.nextLine();
			j.add(y);
			System.out.println("Would you like to amend the second ArrayList?\n");
			Scanner input4 = new Scanner(System.in);
			String a = input4.nextLine();
		if(a.equals("yes")) {
			System.out.println("Step 3 :");
			Scanner input5 = new Scanner(System.in);
			String z = input5.nextLine();
			j = removeElem(j,z);
		}
		if (a.contentEquals("no")) {
			break;
		}

	}
	if (userName.length()>0) {
		System.out.println(credentials);
		System.out.println(j);
	}
   }
  }
  public static ArrayList<String> removeElem(ArrayList<String> arrList,String target){
	  
	  int targetIndex = 0;
	  for(String element : arrList) {
		  targetIndex++;
		  if(element.equals(target)) {
			  break;
		  }
	  }
	  targetIndex -=1;
	  arrList.remove(targetIndex);
	  return arrList;
  }
	
}

	
	

