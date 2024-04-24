class ContinueBreak1
{
	public static void main(String[] args)
    {
    	for (int i=1;i<=10;i++)
        {
        	while (i<11)
            {
            	System.out.println("Run: "+i);
                i++;
                if(i==4)
                {
                	break;
                }
            }
        }
    }
}