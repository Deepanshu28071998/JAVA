class SquareFillePattern1
{
	static void Pattern(int n)
    {
    	for(int i=1;i<=n;i++)
        {
        	for(int j=1;j<=n;j++)
            {
            	System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
    	Pattern(6);
    }
}