package putcoTicketingSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class putcoTicketingSystem {

	final static String outputFilePath = "src/main/java/files/credentials.json";
	final static String createNewRoutesFile = "src/main/java/files/routes.json";
	private static int input0;
	private static String userName;
	private static String passWord;
	private static HashSet<putcoTag> etag = new HashSet <putcoTag>();

	public static void main(String[] args) {

	/* create new HashMap,it will store a string key,and string value.
	 * no duplicate key-value pairs will be stored.
	 */
		createFiles files = new createFiles();
		files.create();

		User user = new User();
		HashMap<String, String> credentials = user.login();

		//new file object
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
	
		while(credentials.containsKey(userName) == true && credentials.containsValue(passWord) == true) {
			
            System.out.println(" ======================================================");
            System.out.println("|       Welcome to the Putco Ticketing System         |");
            System.out.println("|                                                     |");
            System.out.println("|                                                     |");
            System.out.println("|                                                     |");
            System.out.println("|                                                     |");
            System.out.println("|  Where you get to reload your tag with pure ease    |");
            System.out.println(" ======================================================");
	    System.out.println("#######################################################");
            System.out.println(" =====================================================");
            System.out.println("|       1. Add a route                                |");
            System.out.println("|       2. Edit a route                             |");
            System.out.println("|       3. Delete a route                             |");
            System.out.println("|       4. Display routes in the program              |");
            System.out.println("|       5. Exit the program                           |"); 
            System.out.println("|  *Type a number to make a selection*                |");
            System.out.println(" =====================================================");
            System.out.println("");
            System.out.print("Selection: ");

			Scanner input0 = new Scanner(System.in);
    		int choice = input0.nextInt();
			
    		switch(choice) {
    		
    		case 1:    			
    			Scanner input4 = new Scanner(System.in);
    			System.out.println("Enter your pick-up point.");
    			String pickupPoint = input4.nextLine();
            
    			Scanner input5 = new Scanner(System.in);
    			System.out.println("Enter your drop-off point.");
    			String endPoint = input5.nextLine();
            
    			Scanner input6 = new Scanner(System.in);
    			System.out.println("Enter your tag term 'Weekly,Monthly,Termly'");
    			String tagTerm = input6.nextLine();
    			
    			//etag.add(new putcoTag(userName,pickupPoint, endPoint, tagTerm));
            
 			//System.out.println("\n"+userName+",please wait while we add your car to the store..."+"\n");
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    			etag.add(new putcoTag(userName,pickupPoint, endPoint, tagTerm));

    			System.out.println("Your route to " +endPoint+",has been added to the store.");
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		break;
    		case 2:
    		System.out.println("Editing...");
    		break;
    		case 3:
    		System.out.println("Deleting...");
			//System.out.println(etag);
    		
    		break;
    		case 4:
    			

    		System.out.println("Displaying all routes");
    		
    		/*Only show the user the routes they entered.
    		 * nothing more,nothing less..
    		 */
    		System.out.println(etag);
    		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
    		case 5:
    		System.out.println("Signing out");
			System.out.println(userName +" thank you for using this app.Goodbye");
			System.out.println("\n"+"Signing you out..."+"\n");
			System.out.println("Routes added\n");
			System.out.println(etag);
			System.out.println("Session terminated.\n");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
    		default:
    		System.out.println("Not a valid option,try again"	);
    		
    		
    		}   
			// new file object
			File file1 = new File(createNewRoutesFile);
			BufferedWriter bf1 = null;
			try {
				// create new BufferedWriter for the output file
				bf1 = new BufferedWriter(new FileWriter(file1));
				// iterate map entries
				for (putcoTag routes :etag) {
					// put key and value separated by a colon
					bf1.write("Routes |" + 
							  "\n End Point :"+routes.getEndPoint()+"\n"+
							  "\n Start Point :"+routes.getStartPoint()+"\n"+
							  "\n Tag Term :"+ routes.getTagTerm());
					bf1.newLine();
				}
				bf1.flush();
				}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
				// always close the writer
				bf1.close();
				}
				catch (Exception e) {
				}
			}	
			System.out.println("Would you like to remove a route?\n");
			Scanner input40 = new Scanner(System.in);
			String a = input40.nextLine();
		if(a.equals("yes")) {
			System.out.println("Which route are we going to delete?:");
			Scanner input50 = new Scanner(System.in);
			String z = input50.nextLine();
			etag = removeElem(etag,z);
		}
		if (a.contentEquals("no")) {
			break;
		}

	}
   }

  public static HashSet<putcoTag> removeElem(HashSet<putcoTag> tag,String target){
	  
	  int targetIndex = 0;
	  for(Object element : tag) {
		  targetIndex++;
		  if(element.equals(target)) {
			  break;
		  }
	  }
	  targetIndex -=1;
	  tag.remove(targetIndex);
	  return tag;
  }
}
