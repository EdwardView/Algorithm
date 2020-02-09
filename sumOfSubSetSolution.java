import java.util.Scanner;

class sumOfSubSet{
    int w[],W,n,weight,total;
    boolean include[];
    sumOfSubSet(int n,int W){
        this.n = n;
        this.W = W;
        include = new boolean[n];
        w = new int[n];
        total = 0;
        weight = 0;
    }
    void input(){
        System.out.print("Enter the Sets Elements :");
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++){
            System.out.print((i+1)+" Elements is ");
            w[i] = sc.nextInt();
            total += w[i];
        }
    }
    void subSet(int i,int weight,int total){
        if(promising(i,weight,total)){
            if(weight == W){
                display(i);
            }
            else{
                include[i+1] = true;
                subSet(i+1,weight+w[i+1],total-w[i+1]);
                include[i+1] = false;
                subSet(i+1,weight,total-w[i+1]);
            }
        }
    }
    void sumofSubsetFunction(int i){
        subSet(i, weight, total);
    }
    boolean promising(int i,int weight,int total){
        if(((weight + total) >= W) && ((weight == W) || ((weight + w[i+1]) <= W)))
            return true;
        else    
            return false; 
    }
    void display(int j){
        for(int i=0; i<=j; i++)
            System.out.print(include[i]+"\t");
        System.out.println();
    }
}

class sumOfSubSetSolution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Total number of Element in Set and Weight to find in Set : ");
        sumOfSubSet s1 = new sumOfSubSet(sc.nextInt(),sc.nextInt());
        s1.input();
        s1.sumofSubsetFunction(-1);
       //s1.display(4);
    }
}