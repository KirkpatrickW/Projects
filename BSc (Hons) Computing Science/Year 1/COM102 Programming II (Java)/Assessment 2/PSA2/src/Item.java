public class Item
{	// properties
    	private static int totalNum = 0;
        
        //All set to String since the Scanner didnt seem to like anything other than that datatype
        String barcode;
        String author;
        String title;
        String type;
        String year;
        String ISBN;
	
	//constructors
	public Item(String inBarcode, String inAuthor, String inTitle, String inType, String inYear, String inISBN)
	{          
            this.barcode = inBarcode;
            this.author = inAuthor;
            this.title = inTitle;
            this.type = inType;
            this.year = inYear;
            this.ISBN = inISBN;
            totalNum++;
	}
        
        public Item()
	{ 
            totalNum++;
	}
        
        //methods
        public void displayItemDetails()
	{   // display results
            System.out.println("\nBarcode: " + this.barcode);
            System.out.println("Author:  " + this.author);
            System.out.println("Title:   " + this.title);
            System.out.println("Type:    " + this.type);
            System.out.println("Year:    " + this.year);
            System.out.println("ISBN:    " + this.ISBN);
	}

	public void setBarcode(String inBarcode)
	{
            this.barcode = inBarcode;
	}

	public void setAuthor(String inAuthor)
	{
            this.author = inAuthor;
	}
        
	public void setTitle(String inTitle)
	{
            this.title = inTitle;
	}

	public void setType(String inType)
	{
            this.type = inType;
	}

	public void setYear(String inYear)
	{
            this.year = inYear;
	}

	public void setISBN(String inISBN)
	{
            this.ISBN = inISBN;
	}
}