package putcoTicketingSystem;

import java.io.File;

public class createFiles {

    public void create()
    {
        /*checks to see if files exists, if not creates them or throws an exception if
		  there is a problem.
		*/
        try {

            File outputFilePath = new File("src/main/java/files/credentials.json");
            File createNewRoutesFile = new File("src/main/java/files/routes.json");

            if (!outputFilePath.exists() && !outputFilePath.isDirectory() && outputFilePath.createNewFile()) {
                System.out.println("File created:  " + outputFilePath.getName());
                System.out.println("File Path:    " + outputFilePath.getAbsolutePath());
            }
            if(!createNewRoutesFile.exists() && !createNewRoutesFile.isDirectory() && createNewRoutesFile.createNewFile())
            {
                System.out.println("File created:  " + createNewRoutesFile.getName());
                System.out.println("File Path:    " + createNewRoutesFile.getAbsolutePath());
            }
        }catch (Exception e) {
            System.out.println("An error occured while creating a database file.");
        }
    }
}
