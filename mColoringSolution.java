import java.util.Scanner;
class mColoring{
    int W[][],vColor[],color[];
    int nV,nC;
    static int counter;
    mColoring(int n,int m){
        this.nV = n;
        W = new int[n][n];
        vColor = new int[n];
        this.nC = m;
    }
    void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre the Weighted Matrixes("+nV+" * "+nV+")");
        for(int i=0; i<nV; i++){
            for(int j=0; j<nV; j++){
                if(i == j){
                    W[i][j] = 0;
                }else{
                    System.out.println("Entre Weight of V[" +(i+1)+ "] to V[" +(j+1)+ "]  if there is no path then press 0 else press Weight of Edge : ");
                    W[i][j] = sc.nextInt();
                }
            }
        }
    }
    void mColor(int i){
        if(promising(i)){
                if(i == nV-1){
                    System.out.print("Color Sequence "+(counter++)+" is ");
                    for(int j=0; j<nV; j++)
                        System.out.print(vColor[j]+"\t");
                    System.out.println();
                }
                else{
                    for(int j = 1; j <= nC; j++){
                        //System.out.println(i+" "+j);
                        vColor[i+1] = j;
                        mColor(i+1);
                    }
                }
        }
    }
    boolean promising(int i){
        boolean pro = true;
        int j=0;
        while((j <= i) && pro){
            if((W[i][j] != 0) && (vColor[i] == vColor[j])){
                pro = false;
            }
            j++;
        }
        return pro;
    }
    void display(){
        System.out.print("Color Sequence is ");
        for(int i=0; i<nC; i++){
            System.out.print(vColor[i]+"\t");
        }
    }
}
class mColoringSolution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre tha number of Vertex and number of Colors ;");
        mColoring mc1 = new mColoring(sc.nextInt(),sc.nextInt());
        mc1.input();
        mc1.mColor(-1); 
        //mc1.display();
    }
}