import java.util.Scanner;
class kruskalMst{
    int W[][]; // Weigted Graph 
    //int vertices[]; // Vertices 
    int numOfVertices; 
    int numOfEdges;
    int maxInt = 234518;
    int disjointSet[]; // Disjoint set of vertices.
    int counter = 0; // counter number of edges in the Final Set.
    nodeEdge edge[],egdeFinal[];
    class nodeEdge{
        int start,end,weight;
    };
    kruskalMst(int numOfEdges,int numOfVertices){
        this.numOfEdges = numOfEdges;
        this.numOfVertices = numOfVertices;
        W = new int[numOfVertices][numOfVertices];
        edge = new nodeEdge[numOfEdges];
        egdeFinal = new nodeEdge[numOfEdges];
        //vertices = new int[numOfVertices];
        disjointSet = new int[numOfVertices]; 
        for(int i=0; i<numOfVertices; i++){
            // vertices[i] = i;
            disjointSet[i] = i;
            if(i < numOfVertices-1)
                egdeFinal[i] = new nodeEdge();
        }
        for (int i=0; i<numOfEdges; i++){
            edge[i] = new nodeEdge(); 
        }
    }
    void input(){
        Scanner sc = new Scanner(System.in);
        int k=0;
        System.out.println("Entre the Weighted Matmrixes(Undirected Graph)("+numOfVertices+" * "+numOfVertices+")");
        for(int i=0; i<numOfVertices; i++){
            for(int j=i+1; j<numOfVertices; j++){
                if(i == j){
                    W[i][j] = 0;
                }else{
                  System.out.println("Entre Weight of V[" +(i+1)+ "] to V[" +(j+1)+ "]  if there is no path then press 0 else press Weight of Edge : ");
                  int x = sc.nextInt();
                  if(x == 0){
                     W[i][j] = maxInt;
                     W[j][i] = maxInt;
                  }else{
                     W[i][j] = x;
                     W[j][i] = x;
                     edge[k].start = i;
                     edge[k].end = j;
                     edge[k++].weight = x;
                   }
                }
            }
        }
    }
    void sortEdgesInsertion(){
        for(int i=1; i<numOfEdges; i++){
                int x = edge[i].weight;
                int start = edge[i].start;
                int end = edge[i].end;
                int j=i-1;
                while(j>=0 && edge[j].weight > x){
                    edge[j+1].weight = edge[j].weight;
                    edge[j+1].start = edge[j].start;
                    edge[j+1].end = edge[j].end;
                    j--;
                }
                edge[j+1].weight = x;
                edge[j+1].start = start;
                edge[j+1].end = end;
        }
    }
    int Find(int i){
        int j = i;
        while(disjointSet[j] != j){
            j = disjointSet[j];
        }
        return j;
    }
    boolean equal(int p,int q){
        if(p == q)
            return true;
        else
            return false;
    }
    void merge(int p,int q,int i){
        if(p < q)
            disjointSet[q] = p;
        else
            disjointSet[p] = q;

        egdeFinal[counter].weight = edge[i].weight;
        egdeFinal[counter].start = edge[i].start;
        egdeFinal[counter++].end = edge[i].end;
        System.out.println();

    }
    void kruskal(){
        sortEdgesInsertion();
        int p,q;
        int i=0;
        while(counter < numOfVertices - 1){
            nodeEdge e = new nodeEdge();
            e.start = edge[i].start;
            e.end = edge[i].end;
            p = Find(e.start);
            q = Find(e.end);
            if(equal(p, q) == false){
                merge(p, q, i);
            }
            // counter++;
            i++;
        }
    }
    void display(){
        System.out.println("----Graph---");
        for(int i=0; i<numOfVertices; i++)  
            System.out.print(i+"\t");
        System.out.println();
        for(int i=0; i<numOfVertices; i++){
            for(int j=0; j<numOfVertices; j++){
                System.out.print(W[i][j]+"\t");
            }
            System.out.println();
        }
        for(int i=0; i<numOfEdges; i++){
            System.out.println("V [ "+(edge[i].start+1)+" ] --> V [ "+(edge[i].end+1)+" ]"+" --> "+edge[i].weight);
        }
        System.out.println("Shortest Path ");
        for(int i=0; i<numOfVertices-1; i++){
            System.out.println("V [ "+(egdeFinal[i].start+1)+" ] --> V [ "+(egdeFinal[i].end+1)+" ]");
        }
    }
}
class kruskalMstAlgo{
    public static void main(String[] args){
        kruskalMst k = new kruskalMst(7,5);
        k.input();
        k.kruskal();
        k.display();
    }
}
            

