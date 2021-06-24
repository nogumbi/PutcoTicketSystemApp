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

	public static void main(String[] args) 
	{
		String outputFilePath = "src/main/java/files/credentials.json";
		String createNewRoutesFile = "src/main/java/files/routes.json";
		/* create 2 new HashMaps,that will store a string key,and string value.
		 * no duplicate key-value pairs will be stored.
		 */
		HashMap<String, String> credentials = new HashMap<String, String>();
		HashSet<putcoTag> etag = new HashSet <putcoTag>();

		createFiles files = new createFiles();
		files.create();
		/*
		 * this count variable will check how many
		 * times an incorrect password is entered.
		 */
		int count = 0;
		while(true)
		{
			//Outer array for adding values to the first list
			Scanner input0 = new Scanner(System.in);
			System.out.println("Enter your bus tag ID\n");
			String userName = input0.nextLine();

			System.out.println("password:");
			Scanner input1 = new Scanner(System.in);
			String passWord = input1.nextLine();

			if (credentials.containsKey(userName) == true && credentials.containsValue(passWord) == true)
			{
				System.out.println(userName +" has successfully logged in.");
			}
			else if(credentials.containsKey(userName) == true && credentials.containsValue(passWord) == false)
			{
				count +=1;
				System.out.println("Incorrect password.");

				if(count>3)
				{
					System.out.println(userName +"'s" + " account has been blocked");
					break;
				}
			}
			else if(credentials.containsKey(userName) == false && credentials.containsValue(passWord) == false)
			{

				System.out.println("There are no account details for username:"+userName +" password :" +passWord+" if you wish to register new account details,please enter privilaged mode?");

				Scanner input2 = new Scanner(System.in);
				System.out.println("Enter root username");
				String rootUserName = input2.nextLine();

				Scanner input3 = new Scanner(System.in);
				System.out.println("Enter root password?");
				String rootPassword = input3.nextLine();

				if(rootUserName.equals("admin")&&rootPassword.equals("admin1"))
				{

					credentials.put(userName,passWord);
					System.out.println("The credentials you entered do not exist,new user registered.");
				}
				else
				{
					System.out.println("The credentials you entered are incorrect, Goodbye!");
					break;
				}
				if(userName.length() > 0 || passWord.length() > 0)
				{
					credentials.put(userName, passWord);
				}
				// key-value pairs
			}
			/* exit the outer while loop and write the
			 * data to the hash-map.
			 */
			// new file object
			File file = new File(outputFilePath);

			BufferedWriter bf = null;

			try {
				// create new BufferedWriter for the output file
				bf = new BufferedWriter(new FileWriter(file));
				// iterate map entries
				for (Map.Entry<String, String> entry :credentials.entrySet()) {
					// put key and value separated by a colon
					bf.write("username : " + entry.getKey() + "\npassword : " + entry.getValue());
					// new line
					bf.newLine();
				}
				//add the hash-map to the file.
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
				System.out.println(" ======================================================\n"
						+"|       Welcome to the Putco Ticketing System         |\n"
						+"|                                                     |\n"
						+"|                                                     |\n"
						+"|                                                     |\n"
						+"|                                                     |\n"
						+"|  Where you get to reload your tag with pure ease    |\n"
						+" ======================================================\n"
						+"#######################################################\n"
						+" =====================================================\n"
						+"|       1. Add a route                                |\n"
						+"|       2. Edit a route                               |\n"
						+"|       3. Delete a route                             |\n"
						+"|       4. Display routes in the program              |\n"
						+"|       5. Exit the program                           |\n"
						+"|  *Type a number to make a selection*                |\n"
						+" =====================================================\n"
						+"\n"
						+"Selection: ");

				int choice =input0.nextInt();

				switch(choice) {

					case 1:
						Scanner input4 = new Scanner(System.in);
						System.out.println("Enter your pick-up point.");
						String pickupPoint = input4.nextLine();

						/*
						 * Put a switch case statement here so the user has three possible
						 * pickup points.
						 */

						Scanner input5 = new Scanner(System.in);
						System.out.println("Enter your drop-off point.");
						String endPoint = input5.nextLine();

						/*
						 * Put a switch case statement here so the user has three possible
						 * end points.
						 */
						Scanner input6 = new Scanner(System.in);
						System.out.println("Enter your tag term 'Weekly,Monthly,Termly'");
						String tagTerm = input6.nextLine();
						/*
						 * Put a switch case statement here so the user has three possible
						 * tag types.
						 */
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						etag.add(new putcoTag(userName, endPoint,pickupPoint, tagTerm));

						System.out.println("Your route to " +endPoint+", has been added to the store.");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.println("Editing...");
						break;
					case 3:
						System.out.println("Deleting...");
						System.out.println("Which route are you removing? ");
						System.out.println("end point to remove : ");

						Scanner input10 = new Scanner(System.in);
						String endPoint1 = input10.nextLine();

						etag = removeElem(etag,endPoint1);

						break;
					case 4:
						System.out.println("Displaying all routes");
						printRoutes(etag, (p) -> p.getUserName().equals(userName));
						/*
						 * Only show the user the routes they entered.
						 * nothing more,nothing less..
						 */
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
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
							e.printStackTrace();
						}

						break;
					default:
						System.out.println("Not a valid option,try again"	);

				}
				File file1 = new File(createNewRoutesFile);
				BufferedWriter bf1 = null;
				try {
					// create new BufferedWriter for the output file
					bf1 = new BufferedWriter(new FileWriter(file1));
					// iterate map entries
					for (putcoTag routes :etag) {
						// put key and value separated by a colon
						bf1.write("Routes |\n" +
								"\n Start Point :"+routes.getStartPoint()+"\n"+
								"\n End Point :"+routes.getEndPoint()+"\n"+
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
				break;
			}
		}
	}
	public static HashSet<putcoTag> removeElem(HashSet<putcoTag> tag,String target){

		for(putcoTag element : tag) {
			if(element.getEndPoint().equals(target)) {
				tag.remove(element);
				break;
			}
		}
		return tag;
	}
	public static void printRoutes(HashSet<putcoTag> etag,routesCondition condition) {
		for(putcoTag p:etag) {
			if(condition.test(p)) {
				p.printRoutes();
			}
		}
	}
}
