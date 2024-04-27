class OddNumbetIncreaingPyramid1
{
	static void MyMethod(int n)
    {
    	for(int i=1;i<=n;i++)
        {
        	for(int j=1;j<=i;j++)
            {
            	//for(int q=1;q<=i;q++)
                //{
                	if(i%2!=0)
                    {
                    	System.out.print(i+" ");
                    }
                //}
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
    	MyMethod(6);
    }
}