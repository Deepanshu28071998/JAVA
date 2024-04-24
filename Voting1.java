class Voting1
{
	public static void main(String[] args)
    {
    	int age= 64;
        if (age<=10)
        {
        	System.out.print("You are a Child.");
        }
        else if(age<=17)
        {
        	System.out.println("You are not Adult.");
        }
        else if(age<=60)
        {
        	System.out.println("You are Eligible for Vote.");
        }
        else 
        {
        	System.out.println("You are Senior Citizen.");
        }
    }
}