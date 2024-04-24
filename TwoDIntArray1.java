class TwoDIntArray1
{
	public static void main(String[] args)
    {
    	int[][] Arr={{11,15,13},{10,25}};
        for(int i=0;i<Arr.length;i++)
        {
        	for(int j=0;j<Arr[i].length;j++)
            {
            	System.out.println("Run: "+Arr[i][j]);
            }
        }
    }
}