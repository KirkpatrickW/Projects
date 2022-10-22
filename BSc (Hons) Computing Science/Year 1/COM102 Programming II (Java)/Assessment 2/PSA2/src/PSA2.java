import java.io.*;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class PSA2
{	
	public static void main (String [] arguments)
	{      
            Scanner in = null;
            
            //"Scan" Section located in main (This is used to scan each file in the directory to be used in Arrays)
            //This Sub-Section is responsible for scanning the "USER.csv" file
            int nUserLines = 0;
            try
            { 	
                in = new Scanner(new File("USERS.csv"));
                //This will count how many lines are in the file other than the first line of text in order to create an appriorate size for the array.
                in.nextLine();
                while(in.hasNextLine())
                {
                    nUserLines++;    
                    in.nextLine();
                }
            } 
            catch (FileNotFoundException ex)
            { 	//this is an error message that will be displayed if the file cannot be found
                System.out.println(ex.getMessage());
                System.out.println("in " + System.getProperty("user.dir"));
                System.exit(1);
            }

            //This will create new Objects inside of the Array and give each Variable an "Identifier"
            User[] userObjects = new User[nUserLines];
            nUserLines = 0;
            try
            { 	
                in = new Scanner(new File("USERS.csv"));
                in.useDelimiter(",|\n");
                in.nextLine();
            } 
            catch (FileNotFoundException ex)
            { 	//this is an error message that will be displayed if the file cannot be found
                System.out.println(ex.getMessage());
                System.out.println("in " + System.getProperty("user.dir"));
                System.exit(1);
            }
            while (in.hasNextLine())
            { 
                userObjects[nUserLines] = new User();
                readFromUserFile(in, userObjects[nUserLines]);
                nUserLines++;
            }
            
            //This Sub-Section is responsible for scanning the "ITEMS.csv" file
            int nItemLines = 0;
            try
            { 	
                in = new Scanner(new File("ITEMS.csv"));
                //This will count how many lines are in the file other than the first line of text in order to create an appriorate size for the array
                in.nextLine();
                while(in.hasNextLine())
                {
                    nItemLines++;    
                    in.nextLine();
                }
            } 
            catch (FileNotFoundException ex)
            { 	//this is an error message that will be displayed if the file cannot be found
                System.out.println(ex.getMessage());
                System.out.println("in " + System.getProperty("user.dir"));
                System.exit(1);
            }
            
            //This will create new Objects inside of the Array and give each Variable an "Identifier"
            Item[] itemObjects = new Item[nItemLines];
            nItemLines = 0;
            try
            { 	
                in = new Scanner(new File("ITEMS.csv"));
                in.useDelimiter(",|\n");
                in.nextLine();
            } 
            catch (FileNotFoundException ex)
            { 	//this is an error message that will be displayed if the file cannot be found
                System.out.println(ex.getMessage());
                System.out.println("in " + System.getProperty("user.dir"));
                System.exit(1);
            }
            while (in.hasNextLine())
            { 
                itemObjects[nItemLines] = new Item();
                readFromItemFile(in, itemObjects[nItemLines]);
                nItemLines++;
            }
            
            //This Sub-Section is responsible for scanning the "LOANS.csv" file
            int nLoanLines = 0;
            try
            { 	
                in = new Scanner(new File("LOANS.csv"));
                //This will count how many lines are in the file other than the first line of text in order to create an appriorate size for the array
                in.nextLine();
                while(in.hasNextLine())
                {
                    nLoanLines++;    
                    in.nextLine();
                }
            } 
            catch (FileNotFoundException ex)
            { 	//this is an error message that will be displayed if the file cannot be found
                System.out.println(ex.getMessage());
                System.out.println("in " + System.getProperty("user.dir"));
                System.exit(1);
            }
            
            //This will create new Objects inside of the Array and give each Variable an "Identifier"
            Loan[] loanObjects = new Loan[nLoanLines];
            nLoanLines = 0;
            try
            { 	
                in = new Scanner(new File("LOANS.csv"));
                in.useDelimiter(",|\n");
                in.nextLine();
            } 
            catch (FileNotFoundException ex)
            { 	//this is an error message that will be displayed if the file cannot be found
                System.out.println(ex.getMessage());
                System.out.println("in " + System.getProperty("user.dir"));
                System.exit(1);
            }
            while (in.hasNextLine())
            { 
                loanObjects[nLoanLines] = new Loan();
                readFromLoanFile(in, loanObjects[nLoanLines]);
                nLoanLines++;
            }

            //This will redirect the user to a Main Menu of sorts
            displayOptions(in, userObjects, itemObjects, loanObjects);
        }
        
        //"readFrom" Methods (Used to give each variable in an object an identifier when scanned in main)
        public static void readFromUserFile(Scanner in, User user)
	{   // read in details from the "USERS.csv" file
            String user_id = in.next();
            user.setUser_id(user_id);
            String first_name = in.next();
            user.setFirst_name(first_name);
            String last_name = in.next();
            user.setLast_name(last_name);
            String email = in.next();
            user.setEmail(email);
            in.nextLine();
	}
        
        public static void readFromItemFile(Scanner in, Item item)
	{   // read in details from the "ITEMS.csv" file
            String barcode = in.next();
            item.setBarcode(barcode);
            String author = in.next();
            item.setAuthor(author);
            String title = in.next();
            item.setTitle(title);
            String type = in.next();
            item.setType(type);
            String year = in.next();
            item.setYear(year);
            String ISBN = in.next();
            item.setISBN(ISBN);
            in.nextLine();
	}
        
        public static void readFromLoanFile(Scanner in, Loan loan)
	{   // read in details from the "LOANS.csv" file
            String loanBarcode = in.next();
            loan.setLoanBarcode(loanBarcode);
            String loanUser_id = in.next();
            loan.setLoanUser_id(loanUser_id);
            String issueDate = in.next();
            loan.setIssueDate(issueDate);
            String dueDate = in.next();
            loan.setDueDate(dueDate);
            //"numRenews" needs to be an integer value whereas the scanner reads it as a string, this seemed to be the only work around that worked
            String numRenews = in.next();
            int intNumRenews;
            switch (numRenews) 
            {   //This converts the string to an integer, "numRenews" can only have a maximum value of 3
                case "0":
                    intNumRenews = 0;
                    loan.setNumRenews(intNumRenews);
                    break;
                case "1":
                    intNumRenews = 1;
                    loan.setNumRenews(intNumRenews);
                    break;
                case "2":
                    intNumRenews = 2;
                    loan.setNumRenews(intNumRenews);
                case "3":
                    intNumRenews = 3;
                    loan.setNumRenews(intNumRenews);
            }
            in.nextLine();
	}
        
        //"display" Methods (Used to display options so the user can continue)
        public static void displayOptions(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects)
	{   //Main Menu
            in = new Scanner(System.in);
            System.out.println("\n1.  Display User Records");
            System.out.println("2.  Display Item Records");
            System.out.println("3.  Loan Menu");
            
            System.out.println("\n4.  Exit and Save Application");
            
            System.out.print("\nWhat option would you like to choose?: ");
            String optionCounter = in.next();
            
            switch (optionCounter) 
            {   //This will redirect the user to various methods upon entering a number displayed on the list
                case "1":
                    //This method will display User Details
                    displayUserMethod(in, userObjects, itemObjects, loanObjects);
                    break;
                case "2":
                    //This method will display Item Details
                    displayItemMethod(in, userObjects, itemObjects, loanObjects);
                    break;
                case "3":
                    //This method will display the Loan Menu
                    loanDisplayOptions(in, userObjects, itemObjects, loanObjects);
                    break;
                case "4":
                    //This method will save the Loan Details to LOANS.csv and Exit the Application
                    exitOptions(loanObjects);
                    break;
                default:
                    //This is displayed if you enter anything other than what is present in the list and redirect you back to the Main Menu
                    System.out.println("\nYou must only input an integer from the list, please try again.");
                    displayOptions(in, userObjects, itemObjects, loanObjects);
                    break;
            }
	}
        
        static void returnDisplayOptions(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects)
	{   //Return Menu, this is displayed at the end of a "branch" in order to give you a choice to continue or not
            in = new Scanner(System.in);
            System.out.print("\nWould you like to contiune? [Y/N]: ");
            String optionCounter = in.next();
            
            switch (optionCounter) 
            {   //This is used to asked the user if they wish to continue giving them the options of Yes or No
                case "Y":
                case "y":
                    //This will redirect the user to a Main Menu of sorts
                    displayOptions(in, userObjects, itemObjects, loanObjects);
                    break;
                case "N":
                case "n":
                    //This method will save the Loan Details to LOANS.csv and Exit the Application
                    exitOptions(loanObjects);
                    break;
                default:
                    //This is displayed if you enter anything other than what is present in the list and redirect you back to the Return Menu
                    System.out.println("\nYou must only input Y or N, please try again.");
                    returnDisplayOptions(in, userObjects, itemObjects, loanObjects);
                    break;
            }
	}
        
        public static void loanDisplayOptions(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects)
	{   //Loan Menu
            in = new Scanner(System.in);
            
            System.out.println("\n1.  Display Loan Records");
            System.out.println("2.  Issue a New Loan");
            System.out.println("3.  Renew an Existing Loan");
            System.out.println("4.  Return an Item");
            System.out.println("\n5.  Return to Main Menu");
            
            System.out.print("\nWhat option would you like to choose?: ");
            String optionCounter = in.next();

            switch (optionCounter) 
            {   //This will redirect the user to various methods upon entering a number displayed on the list
                case "1":
                    //This method will display Loan Details
                    displayLoanMethod(in, userObjects, itemObjects, loanObjects);
                    break;
                case "2":
                    //Upon selecting option "2" this will create a new temporary array copying all the original objects to it and increasing its size by one
                    int newLoanNum = 0;
                    for (int i = 0; i < loanObjects.length; i++) 
                    {
                        newLoanNum = i;
                    }
                    newLoanNum++;
                    newLoanNum++;
                    
                    Loan[] tempObjects = new Loan[newLoanNum];
                    for (int i = 0; i < loanObjects.length; i++)
                    {
                        tempObjects[i] = loanObjects[i];
                    }
                    
                    newLoanNum--;
                    tempObjects[newLoanNum] = new Loan();
                    //This method will add user inputted details to variables within the new object.
                    newLoan(in, userObjects, itemObjects, loanObjects, tempObjects, tempObjects[newLoanNum]);
                    break;
                case "3":
                    //This method will allow you to renew a Loan by inputting the Barcode if the item exists and it is currently on loan
                    renewLoan(in, userObjects, itemObjects, loanObjects);
                    break;
                case "4":
                    //This method will allow you to return a Loan by inputting the Barcode if the item is currently on loan and will delete its object.
                    returnLoan(in, userObjects, itemObjects, loanObjects);
                    break;
                case "5":
                    //This method will return you back to the Main Menu
                    displayOptions(in, userObjects, itemObjects, loanObjects);
                    break;
                default:
                    //This is displayed if you enter anything other than what is present in the list and redirect you back to the Loan Menu
                    System.out.println("\nYou must only input an integer from the list, please try again.");
                    loanDisplayOptions(in, userObjects, itemObjects, loanObjects);
                    break;
            }
	}

        //"display" Methods
        public static void displayUserMethod(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects)
	{   //Displays User Details
            for (int i = 0; i < userObjects.length; i++) {
                userObjects[i].displayUserDetails();
            }
            
            //This displays the Return Menu method which gives the user the option to either continue or exit the application
            returnDisplayOptions(in, userObjects, itemObjects, loanObjects);
	}

        public static void displayItemMethod(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects)
	{   //Displays Item Details
            for (int i = 0; i < itemObjects.length; i++) {
                itemObjects[i].displayItemDetails();
            }
            
            //This displays the Return Menu method which gives the user the option to either continue or exit the application
            returnDisplayOptions(in, userObjects, itemObjects, loanObjects);
	}

        public static void displayLoanMethod(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects)
	{   //Displays Loan Details
            for (int i = 0; i < loanObjects.length; i++) {
                loanObjects[i].displayLoanDetails();
            }
            
            //This displays the Return Menu method which gives the user the option to either continue or exit the application
            returnDisplayOptions(in, userObjects, itemObjects, loanObjects);
	}
        
        //Loan Option Methods
        public static void newLoan(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects, Loan[] tempObjects, Loan loan)
	{   //This method is used to create a new loan and assign each input a variable inside the object, this includes its validation
            try
            {
                in = new Scanner(System.in);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
                Date tempDate = cal.getTime();
                
                //This will get the current date in a "dd/MM/yyyy" format and convert it to a string and set it to the variable "issueDate"
                String issueDate = dateFormat.format(tempDate);
                String dueDate;
                loan.setIssueDate(issueDate);

                //This will set the values of "loanBarcode" and "issueDate" after some validation
                System.out.print("Enter Barcode: ");
                String loanBarcode = in.next();
                int counter = findBarcodeCounter(loanBarcode, itemObjects);
                if(findBarcode(loanBarcode, itemObjects) == true)
                {   //If the item exists in the Items array it will continue
                    System.out.println("Barcode: '" + loanBarcode + "' was found in Items file, continuing.\n");
                    if(findLoanBarcode(loanBarcode, loanObjects) == false)
                    {   //If the item is currently not on loan it will set the barcode to the inputted value and continue
                        System.out.println("Barcode: '" + loanBarcode + "' is currently NOT on loan, continuing.\n");
                        loan.setLoanBarcode(loanBarcode);
                        
                        //This is used to determine the type of the item being put on loan and give it the corresponding "dueDate" depending on its type
                        switch (itemObjects[counter].type) {
                            case "Book":
                                //This will set the "dueDate" to 4 weeks after the issue date if it is of type "Book"
                                cal.setTime(tempDate);
                                cal.add(Calendar.DAY_OF_YEAR, 28);
                                tempDate = cal.getTime();

                                dueDate = dateFormat.format(tempDate);
                                loan.setDueDate(dueDate);
                                break;
                            case "Multimedia":
                                //This will set the "dueDate" to 1 week after the issue date if it is of type "Multimedia"
                                cal.setTime(tempDate);
                                cal.add(Calendar.DAY_OF_YEAR, 7);
                                tempDate = cal.getTime();

                                dueDate = dateFormat.format(tempDate);
                                loan.setDueDate(dueDate);
                                break;
                            }
                    }
                    else
                    {   //If the barcode is currently on Loan it will repeat the method "newLoan"
                        System.out.println("Barcode: '" + loanBarcode + "' is currently on loan, please re-enter Loan details.\n");
                        newLoan(in, userObjects, itemObjects, loanObjects, tempObjects, loan);
                    }
                }
                else
                {   //If the barcode does not exist in the Items array then it will repeat the method "newLoan"
                    System.out.println("Barcode: '" + loanBarcode + "' was NOT found in Items file, please re-enter Loan details.\n");
                    newLoan(in, userObjects, itemObjects, loanObjects, tempObjects, loan);
                }
                
                //This will set the value of "loanUser_id" after some validation
                System.out.print("Enter User ID: ");
                String loanUser_id = in.next();
                if(findUser_id(loanUser_id, userObjects) == true)
                {   //If the user exists in the User array it will set the value of "loanUser_id" to the corresponding input
                    System.out.println("User ID: " + "'" + loanUser_id + "'" + " was found in Users file, continuing.\n");
                    loan.setLoanUser_id(loanUser_id);
                }
                else 
                {   //If the user does not exist in the User array then it will repeat the method "newLoan"
                    System.out.println("User ID: " + "'" + loanUser_id + "'" + " was NOT found in Users file, please re-enter Loan details.\n");
                    newLoan(in, userObjects, itemObjects, loanObjects, tempObjects, loan);
                }
                
                //This will set the value of "numRenews" to 0 as it is the default value
                int numRenews = 0;
                loan.setNumRenews(numRenews);
            }
            catch (Exception ex) 
            {   System.out.println(ex.getMessage());
                    System.out.println("ParseException " + System.getProperty("user.dir"));
                    System.exit(1);
            }

            //If the loan has been successfully created it will display this message and its corresponding details
            System.out.println("A new Loan has been successfully issued, displaying new Loan details.");
            loan.displayLoanDetails();
            
            //This will set the value of "loanObjects" to "tempObjects" so it has the new Loan Object and it has increased size and then display the Return Menu
            loanObjects = tempObjects;
            returnDisplayOptions(in, userObjects, itemObjects, loanObjects);
	}
        
        public static void renewLoan(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects)
	{   //This method is used to renew a loan after the inputting a barcode and it being validated
            in = new Scanner(System.in);
            System.out.print("\nPlease enter the barcode of the loan you wish to renew: ");
            String searchBarcode = in.next();
            
            //This is used to keep track of what record number it is currently on for both "itemObjects" and "loanObjects"
            int counter = findBarcodeCounter(searchBarcode, itemObjects);
            int loanCounter = findLoanBarcodeCounter(searchBarcode, loanObjects);
            
            if (findLoanBarcode(searchBarcode, loanObjects))
            {   //If the loan exists with the corresponding barcode in the Loan array it will continue
                switch (itemObjects[counter].type) {
                case "Book":
                    if(loanObjects[loanCounter].numRenews <= 2)
                    {   //If the loan with the corresponding barcode has the type of "Book" and has less than 3 renews it will set the new "dueDate" to a 2 weeks after the current
                        int noDays = 14;
                        String type = "Book";
                        newDueDate(in, userObjects, itemObjects, loanObjects, noDays, type, loanObjects[loanCounter]);
                    }
                    else
                    {   //If the loan with the corresponding barcode has 3 renews it will cancel and return you to the Loan Menu
                        System.out.println("An Item classified as Book can only be renewed 3 times, returning to Loans Menu");
                        loanDisplayOptions(in, userObjects, itemObjects, loanObjects);
                    }
                    
                    break;
                case "Multimedia":
                    if(loanObjects[loanCounter].numRenews <= 1)
                    {   //If the loan with the corresponding barcode has the type of "Multimedia" and has less than 2 renews it will set the new "dueDate" to a week after the current
                        int noDays = 7;
                        String type = "Multimedia";
                        newDueDate(in, userObjects, itemObjects, loanObjects, noDays, type, loanObjects[loanCounter]);
                    }
                    else
                    {   //If the loan with the corresponding barcode has 2 renews it will cancel and return you to the Loan Menu
                        System.out.println("An Item classified as Multimedia can only be renewed 3 times, returning to Loans Menu");
                        loanDisplayOptions(in, userObjects, itemObjects, loanObjects);
                    }
                    break;
                }
            }
            else
            {   //If the loan does not exit with the corresponding barcode in the Loan array it will return to the Loan Menu
                System.out.println("Result not found. Please try again, returning to Loans Menu");
                loanDisplayOptions(in, userObjects, itemObjects, loanObjects);
            }
	}
        
        public static void returnLoan(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects)
	{   //This method is used to return a loan after the inputting a barcode and it being validated
            in = new Scanner(System.in);
            System.out.print("\nPlease enter the barcode of the loan you wish to return: ");
            String searchBarcode = in.next();
            
            //This is used to keep track of what record number it is currently on for "loanObjects"
            int counter = findLoanBarcodeCounter(searchBarcode, loanObjects);
            
            if (findLoanBarcode(searchBarcode, loanObjects))
            {   //If the loan with the corresponding barcode exists in the Loan array it will continue
                //This creates a new temporary array to copy the original arrays objects to however it omits the object with the inputted barcode
                Loan[] tempObjects = new Loan[loanObjects.length -1];
                for (int i = 0, j = 0; i < loanObjects.length; i++) 
                    {
                        if (i != counter) 
                        {
                            tempObjects[j++] = loanObjects[i];
                        }
                    }

                //This changes the value of "loanObjects" to the current value of "tempObjects" which will be an object smaller in size
                loanObjects = tempObjects;
                
                //If this method has been successful it will print this message and display the Return Menu
                System.out.println("Result Found! Item has been returned.");
                returnDisplayOptions(in, userObjects, itemObjects, loanObjects);
            }
            else
            {   //If the loan with the corresponding barcode cannot be found it will display this message and return you to the Loan Menu
                System.out.println("Result not found. Please try again, returning to Loans Menu.");
                loanDisplayOptions(in, userObjects, itemObjects, loanObjects);
            }
	}
        
        //Logic Methods to be used in "newLoan" "renewLoan" and "returnLoan"
        public static void newDueDate(Scanner in, User[] userObjects, Item[] itemObjects, Loan[] loanObjects, int noDays, String type, Loan loan)
	{   //This is to be used in the method "renewLoan" to add a specific number of days to the dueDate provided.
            try
            {
                loan.numRenews++;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date tempDate = dateFormat.parse(loan.dueDate);

                Calendar cal = Calendar.getInstance();
                cal.setTime(tempDate);
                cal.add(Calendar.DAY_OF_YEAR, noDays);
                tempDate = cal.getTime();

                String dueDate = dateFormat.format(tempDate);
                loan.setDueDate(dueDate);
                
                System.out.println("The Loan with the barcode '" + loan.loanBarcode + "' has been successfully renewed, due to it being of the type '" + type + "' it has been incremented by " + noDays + " days and has the new date of " + dueDate);
                
                returnDisplayOptions(in, userObjects, itemObjects, loanObjects);
            } 
            catch (Exception ex) 
            {   System.out.println(ex.getMessage());
                    System.out.println("ParseException " + System.getProperty("user.dir"));
                    System.exit(1);
            }
	}
        
        static boolean findBarcode(String searchBarcode, Item[] itemObjects)
	{   //This is used in the method "newLoan" to search if the Barcode entered exists in Items 
            int counter = 1;
            for (int i = 0; i < itemObjects.length; i++) {
                System.out.println("Scan " + counter + " in Item for the phrase " + "'" + searchBarcode + "'...");
                counter++;
                if (itemObjects[i].barcode.equals(searchBarcode))
                {
                    return true;
                }
            }
            return false;
	}
        
        static int findBarcodeCounter(String searchBarcode, Item[] itemObjects)
	{   //This is used in the method "renewLoan" and "returnLoan" to count what object the result is
            for (int i = 0; i < itemObjects.length; i++) {
                if (itemObjects[i].barcode.equals(searchBarcode))
                {
                    return i;
                }
            }
            return -1;
	}
        
        static boolean findLoanBarcode(String searchBarcode, Loan[] loanObjects)
	{   //This is used in the methods "newLoan", "renewLoan" and "returnLoan" to search for a Barcode in Loans
            int counter = 1;
            for (int i = 0; i < loanObjects.length; i++) {
                System.out.println("Scan " + counter + " in Loan for the phrase " + "'" + searchBarcode + "'...");
                counter++;
                if (loanObjects[i].loanBarcode.equals(searchBarcode))
                {
                    return true;
                }
            }
            return false;
	}
        
        static int findLoanBarcodeCounter(String searchBarcode, Loan[] loanObjects)
	{   //This is used in the method "renewLoan" and "returnLoan" to count what object the result is
            for (int i = 0; i < loanObjects.length; i++) {
                if (loanObjects[i].loanBarcode.equals(searchBarcode))
                {
                    return i;
                }
            }
            return -1;
	}
        
        static boolean findUser_id(String searchUser_id, User[] userObjects)
	{   //This is used in the method "newLoan" to search if the User ID entered exists in Users
            int counter = 1;
            for (int i = 0; i < userObjects.length; i++) {
                System.out.println("Scan " + counter + " in User for the phrase " + "'" + searchUser_id + "'...");
                counter++;
                if (userObjects[i].user_id.equals(searchUser_id))
                {
                    return true;
                }
            }
            return false;
	}
        
        //"exit" Methods
        static void exitOptions(Loan[] loanObjects)
	{   //This will save each line of the Loan array into the "LOANS.csv" file including the initial line of text
            PrintWriter out = null;
            try
            { 	
                out = new PrintWriter(new FileOutputStream("LOANS.csv"));
                out.println("Barcode,User_id,Issue_Date,Due_Date,numRenews");
                for (int i = 0; i < loanObjects.length; i++) {
                produceLoan(out, loanObjects[i]);
                }
            } 
            catch (Exception ex)
            {       
                System.out.println(ex.getMessage());
                System.out.println("in " + System.getProperty("user.dir"));
                System.exit(1);
            }
            finally 
            {
                if(out != null)
                {
                    out.close();
                    System.out.println("\nSuccessfully saved Loan details to 'LOANS.csv', Exiting Application");
                }
            }
	}
        
        public static void produceLoan(PrintWriter out, Loan loan)
	{   //This is used in the method "exitOptions" to format how each line will be displayed in the file.
            out.println(loan.getLoanBarcode() + "," + loan.getLoanUser_id() + "," + loan.getIssueDate() + "," + loan.getDueDate() + "," + loan.getNumRenews());
	}
} 