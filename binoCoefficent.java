import java.lang.Math;
class Binomial{
   public int B[][];
    // by using Divide and Conquer.
    int bin0(int n,int k){
        if(k == 0 || n == k)
            return 1;
        else
            return bin0(n-1,k-1)+bin0(n-1,k);
    }
    // by using Dynamic Approach
    void bin1(int n,int k){
        int B[][] = new int[n+1][];
        for(int i=0; i<=n; i++){
            B[i] = new int[i+1];
            for(int j=0; j<=Math.min(i,k); j++){
                if(j == 0 || j == k)
                    B[i][j] = 1;
                else
                    B[i][j] = B[i-1][j-1] + B[i-1][j];
            }
        }
        for(int i=0; i<B.length; i++){
            for(int j=0; j<B[i].length; j++)
                System.out.print(B[i][j]+"\t");
            System.out.println();
        }     
    }   
}
class binoCoefficent{
    public static void main(String[] args){
        // Binomial b1 = new Binomial();
        // System.out.println(b1.bin0(4,4));
        Binomial b2 = new Binomial();
        b2.bin1(5,5);
        // b2.display();
    }
}