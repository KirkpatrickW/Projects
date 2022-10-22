public class User
{	// properties
    	private static int totalNum = 0;
        
        //All set to String since the Scanner didnt seem to like anything other than that datatype
        String user_id;
        String first_name;
        String last_name;
        String email;
	
	//constructors
	public User(String inUser_id, String inFirst_name, String inLast_name, String inEmail)
	{          
            this.user_id = inUser_id;
            this.first_name = inFirst_name;
            this.last_name = inLast_name;
            this.email = inEmail;
            totalNum++;
	}
        
        public User()
	{ 
            totalNum++;
	}
        
        //methods
        public void displayUserDetails()
	{   // display results
            System.out.println("\nUser ID:    " + this.user_id);
            System.out.println("First Name: " + this.first_name);
            System.out.println("Last Name:  " + this.last_name);
            System.out.println("Email:      " + this.email);
	}

	public void setUser_id(String inUser_id)
	{
            this.user_id = inUser_id;
	}

	public void setFirst_name(String inFirst_name)
	{
            this.first_name = inFirst_name;
	}
        
	public void setLast_name(String inLast_name)
	{
            this.last_name = inLast_name;
	}

	public void setEmail(String inEmail)
	{
            this.email = inEmail;
	}
}