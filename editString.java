class editString{
    String X,Y;
    int Cost[][];
    char B[][];
    editString(String X,String Y){
        this.X = X; this.Y = Y;    
        Cost = new int[X.length()+1][Y.length()+1];
        B = new char[X.length()+1][Y.length()+1];
    }
    void minCost(){
        int m = X.length(),n = Y.length();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0)
                    Cost[i][j] = 0;
                else if( i == 0){
                    Cost[i][j] = Cost[i][j-1]+1;
                    B[i][j] = 'I';
                }else if(j == 0){
                    Cost[i][j]  = Cost[i-1][j]+1;
                    B[i][j] = 'D';
                }else{
                    if(X.charAt(i) == Y.charAt(i))
                        Cost[i][j] = Cost[i-1][j-1];
                    else{
                        Cost[i][j] = Cost[i-1][j-1]+2;
                        B[i][j] = 'C';
                        if(Cost[i-1][j] + 1 <= Cost[i][j]){
                            Cost[i][j] = Cost[i-1][j] + 1;
                            B[i][j] = 'D';
                        }else {
                            if(Cost[i][j-1] +1 < Cost[i][j]){
                                Cost[i][j] = Cost[i][j-1] + 1;
                                B[i][j] = 'I';
                            }
                        }
                    }
                }
             }
        }    
    }
    void display(){
        System.out.println("Cost  is  :");
        for(int i=0; i<X.length()+1; i++){
            for(int j=0; j<Y.length(); j++){
                System.out.print(Cost[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Direction  is  :");
        for(int i=0; i<X.length()+1; i++){
            for(int j=0; j<Y.length(); j++){
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        for(int i=X.length(); i>=0; i--){
            for(int j=Y.length(); j>=0; j--){
                if(B[i][j] == 'D'){
                    System.out.print(" D\t");
                    i--;
                }else if(B[i][j] == 'I'){
                    System.out.print(" I\t");
                    j--;
                }else{
                    System.out.print(" C\t");
                    i--;    j--;
                }
            }
        }
    }
    public static void main(String[] args){
        editString e1 = new editString("ALGORITHIM", "ALTRUISTIC");
        e1.minCost();
        e1.display();
    }
}