class ZPattern
{
	static void Pattren(int n)
    {
    	for(int i=1;i<=n;i++)
        {
        	for(int j=1;j<=n;j++)
            {
            	if(i==1 || i==n || j==(n-i+1))
                {
                	System.out.print("* ");
                }
                else
                {
                	System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
    	Pattren(8);
    }
}