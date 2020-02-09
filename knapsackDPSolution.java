import java.util.Scanner;
import java.util.*;

class knapsack{
    int W,n;
    int profit[],Keep[][],weight[],P[][];
    Set<Integer> S;
    int maxProfit;
    knapsack(int n,int W){
        this.n = n;
        this.W = W;
        P = new int[n+1][W+1];
        Keep = new int[n][W];
        weight = new int[n];
        profit = new int[n];
        S = new HashSet<Integer>();
        maxProfit = 0;
    }
    void input(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Entre the Weigth and Profit of items : ");
       for(int i=0; i<n; i++){
            System.out.print("Weigth "+(i+1)+" :\t");  weight[i] = sc.nextInt();
            System.out.print("Profit "+(i+1)+" :\t");  profit[i] = sc.nextInt();
       }
        // int we[] = {5,4,6,3};
        // int pro[] = {10,40,30,50};
        // for(int i=0; i<n; i++){
        //     weight[i] = we[i];
        //     profit[i] = pro[i];
        // }
    }
    void knapsackDP(){
        for(int j=0; j<=W ; j++)
            P[0][j] = 0;    
        for(int i=0; i<=n; i++)
            P[i][0] = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                if(j >= weight[i-1] && ((profit[i-1]+P[i-1][j-weight[i-1]]) > P[i-1][j])){
                    P[i][j] = profit[i-1] + P[i-1][j-weight[i-1]];
                    Keep[i-1][j-1] = 1;
                } 
                else{
                    P[i][j] = P[i-1][j];
                    Keep[i-1][j-1] = 0;
                }
            }
        }
    }
    // void knapsackRefinedDP(){
    //     for(int i=0; i<=n; i++){
    //         for(int j=0; j<=W; j++)
    //             P[i][j] = 0;
    //     }
    // }
    void getMaxProfit(){
        int K = W-1;
        for(int i = n-1; i>=0; i--){
             if(Keep[i][K] == 1){
                S.add(i+1);
                K -= weight[i]+1;
            }
        }
        maxProfit = P[n][W];
    }
    void display(){
        for(int i=0; i<=n; i++){
            for(int j=0; j<=W; j++){
                System.out.print(P[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<W; j++){
                System.out.print(Keep[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Maximum Profit : "+maxProfit);
        System.out.println("Selected Items are : " + S);
    }
}

class knapsackDPSolution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of items and total weigth of Knapsack : ");
        knapsack k1 = new knapsack(sc.nextInt(),sc.nextInt());
       //knapsack k1 = new knapsack(4,10);
       k1.input();
       k1.knapsackDP();
       k1.getMaxProfit();
        k1.display();
    }
}