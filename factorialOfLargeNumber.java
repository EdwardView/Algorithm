class fONumber{
    int result[];
    int number,resSize;
    fONumber(int n){
        result = new int[500];
        result[0] = 1;
        number = n;
        resSize = 1;
    }
    void factorial(){
        for(int i=2; i<=number; i++){
            multiply(i);
        }
        System.out.print("Factorial of "+number+" is ");
        for(int i=resSize-1; i>=0; i--){
            System.out.print(result[i]);
        }
    }
    void multiply(int x){
       int carry = 0;
       for(int i=0; i<resSize; i++){
           int prod = result[i] * x + carry;
           result[i] = prod%10;
           carry = prod/10; 
       }
       while(carry != 0){
           result[resSize] = carry%10;
           carry /= 10;
           resSize++;
       } 
    }
}

class factorialOfLargeNumber{
    public static void main(String[] args){
        fONumber f1 = new fONumber(100);
        f1.factorial();
    }
}