import java.util.Scanner;
import java.lang.Math;
class primS{
    int maxInt = 217453;
     int W[][];
     // = { {0,1,3,maxInt,maxInt},
    //             {1,0,3,6,maxInt},
    //             {3,3,0,4,2},
    //             {maxInt,6,4,0,5},
    //             {maxInt,maxInt,2,5,0}
    //             };
    int nearest[],distance[];
    int n;
    int F[][];
    int near;
    primS(){
        System.out.println("Enter the Number of Vertics");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        W = new int[n][n];
        F = new int [n-1][2];
        nearest = new int[n];
        distance = new int[n];
    }
    void input(){
           for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j)
                    W[i][j] = 0;
                else{
                    if((i+j) % 2 == 0)
                        W[i][j] = i+j;
                    else{
                        int x = Math.min(i,j);
                        Double fib = Math.floor((Math.pow((1+Math.sqrt(5))/2,x) - Math.pow((1-Math.sqrt(5))/2,x))/Math.sqrt(5));
                        W[i][j] = fib.intValue();
                    }
                }   
            }
        }
    }
    // void input(){
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Entre the Weighted Matrixes(Undirected Graph)("+n+" * "+n+")");
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<n; j++){
    //             if(i == j){
    //                 W[i][j] = 0;
    //             }else{
    //             System.out.println("Entre Weight of V[" +(i+1)+ "] to V[" +(j+1)+ "]  if there is no path then press 0 else press Weight of Edge : ");
    //             int x = sc.nextInt();
    //             if(x == 0)
    //                 W[i][j] = maxInt;
    //             else
    //                 W[i][j] = x;
    //             }
    //         }
    //     }    
    // }
    void display(){
        System.out.print("Path -- [ ");
        for(int i=0; i<F.length; i++){
            System.out.print("( ");
            for(int j=0; j<2; j++){
                System.out.print(F[i][j]+" ");
            }
            System.out.print(" )");
        }
        System.out.print("]");
    }
    void primsMST(){
        for(int i=0; i<n; i++){
            nearest[i] = 0;
            distance[i] = W[0][i];
        }
        int temp = 0;
        while(temp < n-1){
            int min = maxInt;
            for(int i=1; i<n; i++){
                if(distance[i] >= 0 && distance[i] < min){
                   min = distance[i];
                   near = i;
                }
            }
            F[temp][0] = nearest[near]+1; F[temp][1] = near+1;
            distance[near] = -1;
            for(int i=0; i<n; i++){
                if(W[near][i] < distance[i]){
                    distance[i] = W[near][i];
                    nearest[i] = near;
                }
            }
            temp++;
        }
    }
    void displayGraph(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(W[i][j]+"  ");
            }
            System.out.println();
        }
    }
}

class customeGraphMST{
    public static void main(String[] args){
        primS p = new primS();
        p.input();
        //p.primsMST();
        p.displayGraph();
        p.primsMST();
        p.display();
    }
}