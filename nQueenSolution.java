class nQueen{
    int board[][],n;
    nQueen(int n){
        this.n = n;
        board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                board[i][j] = 0;
        }
    }
    boolean nQueenDP(int col){
        if(col >= n)
            return true;
        for(int i=0; i<n; i++){
            if(promising(i,col)){
                board[i][col] = 1;
                if(nQueenDP(col+1) == true)
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }
    boolean promising(int row,int col){
        for(int i=0; i<col; i++){   // Check left side.
            if(board[row][i] == 1)
                return false;
        }
        // Check Upper Diagonal
        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 1)
                return false;
        }
        // Check lower Diagonal.
        for(int i=row,j=col; j>=0 && i<n; i++,j--){
            if(board[i][j] == 1)
                return false;
        }
        return true;
    }
    void display(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class nQueenSolution{
    public static void main(String[] args){
        nQueen q1 = new nQueen(4);
        if(q1.nQueenDP(0))
            q1.display();
        else
            System.out.println("Not found.");
    }
}