import java.util.Scanner;
class Knapsack_0_1{
    static int maxProfit;
    int W,n;
    boolean include[];
    int w[],profit[];
    double pW[];
    Knapsack_0_1(int n,int W){
        this.n = n;
        this.W = W;
        include = new boolean[n];
        w = new int[n];
        profit = new int[n];
        pW = new double[n];
    }
    void input(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Entre the Weigth and Profit of items : ");
       for(int i=0; i<n; i++){
            System.out.print("Weigth "+(i+1)+" :\t");  w[i] = sc.nextInt();
            System.out.print("Profit "+(i+1)+" :\t");  profit[i] = sc.nextInt();
            pW[i] = profit[i]/w[i];
        }
        sortAccordingToP_W();
    }
    void sortAccordingToP_W(){

            for(int i=1; i<n; i++){
                double x = pW[i];
                int p = profit[i];
                int weight = w[i];
                int j=i-1;
                while(j>=0 && pW[j] > x){
                    profit[j+1] = profit[j];
                    w[j+1] = w[j];
                    pW[j+1] = pW[j];
                    j--;
                }   
                pW[j+1] = x;
                w[j+1] = weight;
                profit[j+1] = p;
            }
    }
    void knapsack(int i,int weight,int pro){
        if((weight <= W) && (pro > maxProfit)){
            maxProfit = pro;
        }
        if(promising(i,weight,pro)){
            include[i+1] = true;
            knapsack(i+1,weight+w[i+1],pro+profit[i+1]);
            include[i+1] = false;
            knapsack(i+1,weight,pro);
        }
    }
    boolean promising(int i,int weight,int pro){
        if(weight >= W)
            return false;
        int bound = pro;
        int totalWeight = weight;
        int j = i+1;
         while(j < n && (totalWeight + w[j]) <= W){
             bound += profit[j];
             totalWeight += w[j];
             j++;
         }
         int k = j;
         if(k < n)
            bound += (W-totalWeight)*(profit[k]/w[k]);
        if(bound > maxProfit)
            return true;
        else
            return false;
    }
    void display(){
        for(int i=0; i<n; i++)
            System.out.print(include[i]+"\t");
        System.out.println("Maximum Profit is : "+maxProfit);
    }
    void KS(){
        knapsack(-1,0,0);
    }
}
class knapsackBacktrackingSolution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre the number of Items and Total Weight of Knapsack ");
        Knapsack_0_1 k1 = new Knapsack_0_1(sc.nextInt(),sc.nextInt());
        k1.input();
        k1.KS();
        k1.display(); 
    }
}