class LCS{
    String X,Y;
    int lengthX,lengthY;
    int C[][];
    char B[][];
    LCS(String X,String Y){
        this.X = X; this.Y = Y;
        lengthX = X.length();
        lengthY = Y.length();
        C = new int[lengthX+1][lengthY+1];
        B = new char[lengthX+1][lengthY+1];
    }
    void LCSByDP(){
        for(int i=0; i<lengthX+1; i++)
            C[i][0] = 0;
        for(int i=0; i<lengthY+1; i++)
            C[0][i] = 0;
        for(int i=1; i<lengthX+1; i++){
            for(int j=1; j<lengthY+1; j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    C[i][j] = C[i-1][j-1]+1;
                    B[i][j] = 'D';
                }else if(C[i-1][j] >= C[i][j-1]){
                    C[i][j] = C[i-1][j];
                    B[i][j] = 'N';
                }else{
                    C[i][j] = C[i][j-1];
                    B[i][j] = 'W';
                }
            }
        }
    }
    void Display(){
        // for(int i=0; i<lengthX+1; i++){
        //     for(int j=0; j<lengthY+1; j++){
        //         System.out.print(C[i][j]+"  ");
        //     }
        //     System.out.println();
        // }
        // for(int i=0; i<lengthX+1; i++){
        //     for(int j=0; j<lengthY+1; j++){
        //         System.out.print(B[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // int i = lengthX,j = lengthY;
        // String subStr = "";
        // while(i != 0 && j != 0){
        //     if(B[i][j] == 'D'){
        //         subStr += X.charAt(i-1);
        //         i = i-1;    j = j-1;
        //     }else if(B[i][j] == 'N'){
        //         i = i-1;
        //     }else{
        //         j = j-1;
        //     }
        // }
        // StringBuffer a = new StringBuffer(subStr);
        // System.out.println("SubSequence is " + a.reverse());      
       printLCS(lengthX,lengthY);
    }
    void printLCS(int i,int j){
        if(i == 0 || j == 0)    
            return;
        if(B[i][j] == 'D'){
            printLCS(i-1, j-1);
            System.out.print("\t"+X.charAt(i-1)+'\t');
        }else if(B[i][j] == 'N'){
            printLCS(i-1, j);
        }else{
            printLCS(i, j-1);
        }
    }
}
class longstCommonSubsequences{
    public static void main(String[] args){
        // LCS l1 = new LCS("BDCABA","ABCBDAB");
        // l1.LCSByDP();
        // l1.Display();
        LCS l1 = new LCS("ABCBDAB","BDCABAB");
        l1.LCSByDP();
        l1.Display();
    }
}