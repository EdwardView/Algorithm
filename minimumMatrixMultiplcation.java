import java.util.*;

import javafx.scene.effect.DisplacementMap;
/*********Minimum Matrix Multiplcation*******/
class minimumMatixMultiplication{
    int dimension[];
    int noOfMatrix;
    int MM[][],P[][];
    minimumMatixMultiplication(){
        System.out.println("Enter the Number of Matrixs :"); 
        Scanner sc = new Scanner(System.in);
        noOfMatrix = sc.nextInt();
        dimension = new int[noOfMatrix+1];
        MM = int[noOfMatrix][noOfMatrix];
        P =  int[noOfMatrix][noOfMatrix];
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
    }
    int minimumMultiplcation(){
        for(int diagonal = 1; diagonal < noOfMatrix; i++){
            for(int i = 1; i<noOfMatrix-diagonal; i++){
                int j = i+diagonal-1;
                MM[i-1][j] = MM[i-1][i-1] + MM[i][j] + dimension[i-1]*dimension[i]*dimension[j];
                P[i-1][j] = i;
                for(int k = i+1; k<j-1; k++){
                    int temp = MM[i][k] + MM[k+1][j] + dimension[i-1] * dimension[k] * dimension[j];
                    if(temp < MM[i][j]){
                        MM[i][j] = temp;
                        P[i][j] = k;
                    }
                }
            }
        }
        return M[0][noOfMatrix-1];
    }
}
