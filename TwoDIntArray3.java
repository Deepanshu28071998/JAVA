class TwoDIntArray3
{
	public static void main(String[] args)
    {
    	int[][] Arr={{11,16,14,13},{12,14,10,61,11,34},{31,89,64,87,12},{45,87,91,70,56}};
        for(int i=0;i<Arr.length;i++)
        {
        	for(int j=0;j<Arr[i].length;j++)
            {
            	System.out.println("Value"+"["+i+"]["+j+"]"+" : "+Arr[i][j]);
            }
        	System.out.println();
        }
    }
}