class OddNumberChangingPyramid1
{
	static void Pyramid(int n)
    {
    	int num=1;
        for(int i=1;i<=n;i++)
        {
        	if(num%2!=0)
            {
            	for(int j=1;j<=i;j++)
                {
                	System.out.print(num+" ");
                }
            }
            num+=2;
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
    	Pyramid(4);
    }
}