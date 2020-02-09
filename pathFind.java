import java.util.Scanner;
//import org.omg.CORBA.NVList;
class shortestPath{
    private int W[][],P[][],D[][],noVertice;
    int maxInt = 23456;
    shortestPath(int n){
        noVertice = n;
        W = new int[n][n];
        P = new int[n][n];
        D = new int[n][n];
    } 
    void getData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre the Weighted Matrixes("+noVertice+" * "+noVertice+")");
        for(int i=0; i<noVertice; i++){
            for(int j=0; j<noVertice; j++){
                if(i == j){
                    W[i][j] = 0;
                    D[i][j] = 0;
                }else{
                System.out.println("Entre Weight of V[" +(i+1)+ "] to V[" +(j+1)+ "]  if there is no path then press 0 else press Weight of Edge : ");
                int x = sc.nextInt();
                if(x <= 0)
                    D[i][j] = W[i][j] = maxInt;
                else
                    D[i][j] = W[i][j] = x;
                }
            }
        }
    }
    void showData(){
        System.out.println("---Weighted Matrix---");
        for(int i=0; i<noVertice; i++){
            for(int j=0; j<noVertice; j++){
                if(D[i][j] == maxInt)
                    System.out.println("INF");
                else
                    System.out.print("\t" + D[i][j]);
            }
            System.out.println();
        }
        System.out.println("Fake Matrix");
        for(int i=0; i<noVertice; i++){
            for(int j=0; j<noVertice; j++){
                System.out.print("\t" + P[i][j]);
            }
            System.out.println();
        }
    }
    void floyd(){
        for(int i=0; i<noVertice; i++){
            for(int j=0; j<noVertice; j++)  P[i][j] = 0;
        }
        for(int k=0; k<noVertice; k++){
            for(int i=0; i<noVertice; i++){
                for(int j=0; j<noVertice; j++){
                    if(D[i][j] > (D[i][k] + D[k][j])){
                        D[i][j] = D[i][k] + D[k][j];
                        P[i][j] = k;
                    }
                }
            }
        }
    }
    void path(int q,int r){
        if(P[q][r] != 0){
            path(q,P[q][r]);
            System.out.print("V["+(P[q][r]+1)+"] -> ");
          //  System.out.print("V["+()"] -> ");
            path(P[q][r],r);
        }
    }
    void getPath(int i,int j){
        if(i == j){
            System.out.println("Path Doet exit");
            return;
        }
        System.out.print("V["+(i+1)+"] ->");
        path(i,j);
        System.out.println("V["+(j+1)+"]");
    }
}

class pathFind{
    public static void main(String[] args){
        shortestPath p1 = new shortestPath(4);
        p1.getData();
        System.out.println("Before Finding SHortest path : ");
        p1.showData();
        p1.floyd();
        System.out.println("After Finding SHortest path : ");
        p1.showData();
        p1.getPath(0,3);
        p1.getPath(0,0);
        p1.getPath(0,2);
        // for(int k=0; k<4; k++){
        //     for(int l=0; l<4; l++)
        //         p1.getPath(k,l);
        //         System.out.println();
        // }
    }
}