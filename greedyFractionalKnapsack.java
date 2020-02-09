import java.util.Scanner;

class knapsack{
    class item{
        int weight;
        int profit;
        float profit_weight;
        item(){ weight = 0; profit = 0; profit_weight = 0;}
    }
    item I[];
    int W;
    float X[];
    int n;
    knapsack(int n){
        this.n = n;
        I = new item[this.n];
        X = new float[this.n];
        for(int i=0; i<n; i++)
            I[i] = new item();
   }
   void input(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Entre the Weigth and Profit of items : ");
       for(int i=0; i<n; i++){
            System.out.print("Weigth "+(i+1)+" :\t");  I[i].weight = sc.nextInt();
            System.out.print("Profit "+(i+1)+" :\t");  I[i].profit = sc.nextInt();
            I[i].profit_weight = I[i].profit / I[i].weight;
       }
       System.out.println("Entre the total weigth of Knapack : ");  W = sc.nextInt();
    }
    void insertion_sort(){
        for(int i=1; i<n; i++){
            item a = new item();
            a = I[i];
            int j=i-1;
            while(j>=0 && I[j].profit_weight < a.profit_weight){
                I[j+1] = I[j]; 
                j--;
            }
            I[j+1] = a;
        }
    }
   void knapsackFraction(){
        insertion_sort();
       for(int i=0; i<n; i++)
            X[i] = 0;
        int weightTemp = 0;
        for(int i=0; i<n; i++){
            if((weightTemp + I[i].weight) < W){
                X[i] = 1;
                weightTemp += I[i].weight; 
            }
            else{
                X[i] = (float)(W - weightTemp)/I[i].weight;
                weightTemp = W;
                break;
            }
        }
   }
   void displayOptimalProfit(){
       float optimalProfit = 0;
       for(int i=0; i<n; i++){
            System.out.print(X[i]+"\t");
       }
       for(int i=0; i<n; i++){
        System.out.println(I[i].weight+"\t"+I[i].profit+"\t"+I[i].profit_weight);
        }
       for(int i=0; i<n; i++){
           if(X[i] > 0)
                optimalProfit += I[i].profit * X[i];  
       }
       System.out.println("Optimal Profit is : " + optimalProfit);
   }
}

class greedyFractionalKnapsack{
    public static void main(String[] args){
        knapsack k1 = new knapsack(3);
        k1.input();
        k1.knapsackFraction();
        k1.displayOptimalProfit();
    }
}