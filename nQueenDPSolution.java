
import java.lang.Math;
class nQueen{
    int borad[][],n;
    nQueen(int n){
        this.n = n;
        borad = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                borad[i][j] = 0;
        }
    }
    void display(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                System.out.print(borad[i][j]+" ");
            System.out.println();
        }
    }
    boolean promising(int i,int j){
        
        // Check rows left side.
        for(int k=0; k < j; k++){
                if(borad[i][k] == 1)
                    return false;
        }
        // check upper diagonal on left side.  
        for(int k = i, l = j; k >= 0 && l >= 0; k--,l--){
            if(borad[k][l] == 1)
                return false;
        }
        // check lower diagonal on left side.
        for(int k = i,l = j; l >= 0 && i <= n; k++,l--){
            if(borad[k][l] == 1)
                return false;
        }
        return true;
    }
    boolean nQueenDP(int i){
        if(i >= n)
            return true;
        for(int j=0; j<n; j++){
            if(promising(i,j)){
                borad[j][i] = 1;
                if(nQueenDP(i+1) == true)
                    return true;
                borad[j][i] = 0;
            }
        }
        return false;
    }
    // void nQueenDP(int i){
    //     if(promising(i)){
    //         if(i == n){
    //             for(int j=0; j<n; j++)
    //                 System.out.print(col[i]+"\t");
    //         }
    //         else{
    //             for(int j=1; j<n; j++){
    //                 col[i+1] = j;
    //                 nQueenDP(i+1);
    //             }
    //         }
    //     }
    // }
    // boolean promising(int i){
    //     for(int k=1; k<i-1; k++){
    //         if((col[i] == col[k]) || Math.abs(col[i] - col[k]) == Math.abs(i-k))
    //             return false;        
    //     }
    //     return true;
    // }
}

class nQueenDPSolution{
    public static void main(String[] args){
        nQueen q1 = new nQueen(4);
        if(q1.nQueenDP(0) == false){
            System.out.println("Solution doesnt exist.");
        }
        q1.display();
    }
}