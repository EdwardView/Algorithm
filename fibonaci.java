import java.util.*;
class fibonaci{
    // double fib(int n){
    //     if(n <= 1)
    //         return n;
    //     else
    //         return (fib(n-1) + fib(n-2));
    // }
    public static void main(String[] agrs){
        System.out.println("Entre the Number to which for find Fibonaci series :");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // fibonaci f1 = new fibonaci();
        // // for(int i=0; i<num; i++)
        // //     System.out.print(f1.fib(i)+"\t");
        // System.out.print(f1.fib(10e));
        Double str = new Double(0);
        String s;
        for(int i=1; i<num; i++)
            str = Math.floor((Math.pow((1+Math.sqrt(5))/2,i) - Math.pow((1-Math.sqrt(5))/2,i))/Math.sqrt(5));
            //s = Double.toString(str);

            int j = str.intValue();
            System.out.println(str+"\t"+j);
        }
}

