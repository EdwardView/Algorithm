import java.util.*;
/*********Minimum Matrix Multiplcation*******/
class minimumMatixMultiplication{
    int dimension[];
    int noOfMatrix;
    int MM[][],P[][];   // MM store the no of Matrix Multiplcation and P store the Orders of Multiplcation. 
    minimumMatixMultiplication(){
        System.out.println("Enter the Number of Matrixs :"); 
        Scanner sc = new Scanner(System.in);
        noOfMatrix = sc.nextInt();
        dimension = new int[noOfMatrix+1];
        MM = new int[noOfMatrix][noOfMatrix];
        P =  new int[noOfMatrix][noOfMatrix];
    }
    void getData(){
        System.out.println("Enter the Orders of Matrixs :");
        Scanner sc = new Scanner(System.in);
        int i;
        for(i=0; i<noOfMatrix; i++){
            dimension[i] = sc.nextInt();
            MM[i][i] = 0;
        }
        dimension[i] = sc.nextInt();
        for(i=0; i<noOfMatrix; i++){
            for(int j=0; j<noOfMatrix; j++)
                System.out.print(MM[i][j]+"\t");
            System.out.println();
        }
    }
    int minimumMultiplcation(){
        for(int diagonal = 1; diagonal < noOfMatrix-1; diagonal++){
            for(int i = 1; i<=noOfMatrix-diagonal; i++){
                int j = i+diagonal-1;
                MM[i-1][j] = MM[i][i] + MM[i][j] + dimension[i-1]*dimension[i]*dimension[j+1];
                P[i][j] = i;
                for(int k = i; k<j-1; k++){
                    int temp = MM[i-1][k] + MM[k+1][j] + dimension[i-1] * dimension[k] * dimension[j];
                    if(temp < MM[i][j]){
                        MM[i][j] = temp;
                        P[i][j] = k;
                    }
                }
            }
        }
        return MM[0][noOfMatrix-1];
    }
}

class MMM{
        public static void main(String[] args){
        minimumMatixMultiplication m1 = new minimumMatixMultiplication();
        m1.getData();
        System.out.println("Minimum Matrix Multiplcation is\t"+m1.minimumMultiplcation());
    }
}