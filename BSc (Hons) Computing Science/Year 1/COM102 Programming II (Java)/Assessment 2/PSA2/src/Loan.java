public class Loan
{	// properties
    	private static int totalNum = 0;
        
        //All set to String since the Scanner didnt seem to like anything other than that datatype
        String loanBarcode;
        String loanUser_id;
        String issueDate;
        String dueDate;
        
        //This had to be integer to work with calculations however the Scanner still reads it as a string and converts it to an integer through a Switch Case
        int numRenews;
	
	//constructors
	public Loan(String inLoanBarcode, String inLoanUser_id, String inIssueDate, String inDueDate, int inNumRenews)
	{          
            this.loanBarcode = inLoanBarcode;
            this.loanUser_id = inLoanUser_id;
            this.issueDate = inIssueDate;
            this.dueDate = inDueDate;
            this.numRenews = inNumRenews;
            totalNum++;
	}
        
        public Loan()
	{ 
            totalNum++;
	}
        
        //methods
        public void displayLoanDetails()
	{   // display results
            System.out.println("\nItem Barcode: " + this.loanBarcode);
            System.out.println("User ID:      " + this.loanUser_id);
            System.out.println("Issue Date:   " + this.issueDate);
            System.out.println("Due Date:     " + this.dueDate);
            System.out.println("No. Renews:   " + this.numRenews);
	}

	public void setLoanBarcode(String inLoanBarcode)
	{
            this.loanBarcode = inLoanBarcode;
	}
        
        public String getLoanBarcode()
	{
            return this.loanBarcode;
	}

	public void setLoanUser_id(String inLoanUser_id)
	{
            this.loanUser_id = inLoanUser_id;
	}
        
        public String getLoanUser_id()
	{
            return this.loanUser_id;
	}
        
	public void setIssueDate(String inIssueDate)
	{
            this.issueDate = inIssueDate;
	}
        
        public String getIssueDate()
	{
            return this.issueDate;
	}

	public void setDueDate(String inDueDate)
	{
            this.dueDate = inDueDate;
	}
        
        public String getDueDate()
	{
            return this.dueDate;
	}

	public void setNumRenews(int inNumRenews)
	{
            this.numRenews = inNumRenews;
	}
        
        public int getNumRenews()
	{
            return this.numRenews;
	}
}