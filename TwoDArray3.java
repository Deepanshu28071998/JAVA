class TwoDArray3
{
	public static void main(String[] args)
    {
    	String[][] Car={{"Audi","BMW","Thar"},{"Nano","Maruti800"}};
        for(int i=0;i<Car.length;i++)
        {
        	for(int j=0;j<Car[i].length;j++)
            {
        		System.out.println(Car[i][j]);
        	}
        }
        System.out.println();
        Car[1][0]="Punch";
        for(int i=0;i<Car.length;i++)
        {
        	for(int j=0;j<Car[i].length;j++)
            {
            	System.out.println(Car[i][j]);
            }
        }
    }
}