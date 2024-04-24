public class TypeConv1 {
    public static void main(String[] args) {
        byte b =10;
        double d=1000.45677654;
        int a =b; //Implicit/widening Type Conversion of byte to int
        System.out.println("Value of a= "+a);
        float f=(float)d; //Explicit/Narrowing Type conversion
        System.out.println("value of f = "+f);
        int x=(int)d; //Explicit/Narrowing Type conversion
        System.out.println("Value of x is = "+x);
    }
}
