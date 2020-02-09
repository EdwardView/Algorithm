import java.util.Scanner;
import java.io.*; 
import java.util.*;

class dijsktraSPAlgo{
    int W[][];
    int numOfVertices,numOfEdges; 
    int maxInt = 234518;
    int touch[];
    nodeEdge edge[];
    ArrayList<nodeEdge> F; // store the edge whose shorest Path are taken. 
    class nodeEdge{   // Edge contain initial and target vertex at eich they connect.
        int start,end,weight;
    };
    dijsktraSPAlgo(int numOfVertices,int numOfEdges){
        
        this.numOfVertices = numOfVertices;
        this.numOfEdges = numOfEdges;
        W = new int[numOfVertices][numOfVertices];
        edge = new nodeEdge[numOfEdges];
        for (int i=0; i<numOfEdges; i++){
            edge[i] = new nodeEdge();
        }
        touch = new int[numOfVertices-1];
        F = new ArrayList<nodeEdge>();
    }
    void input(){
        Scanner sc = new Scanner(System.in);
        int k=0;
        System.out.println("Entre the Weighted Matrixes(directed Graph)("+numOfVertices+" * "+numOfVertices+")");
        for(int i=0; i<numOfVertices; i++){
            for(int j=0; j<numOfVertices; j++){
                if(i == j){
                    W[i][j] = 0;
                }else{
                  System.out.println("Entre Weight of V[" +(i+1)+ "] to V[" +(j+1)+ "]  if there is no path then press 0 else press Weight of Edge : ");
                  int x = sc.nextInt();
                  if(x == 0){
                     W[i][j] = maxInt;
                   }else{
                     W[i][j] = x;
                     edge[k].start = i;
                     edge[k].end = j;
                     edge[k++].weight = x;
                   }
                }
            }
        }
    }
    void dijskata(){
        int length[] = new int[numOfVertices-1];
        int sLength[] = new int[numOfVertices-1];
        int vNear=0,min;
        for(int i=0; i<numOfVertices-1; i++){
            touch[i] = 1;
            sLength[i] = maxInt;
            length[i] = W[0][i+1];
        }
        int temp = 0;
        while(temp < numOfVertices-1){
            min = maxInt;
            for(int i=0; i<numOfVertices-1; i++){
                if(length[i] > 0 && length[i] < min){
                    min = length[i];
                    vNear = i;  // i -> i+1
                }
            }
            nodeEdge e = new nodeEdge();
            e.start = touch[vNear]; e.end = vNear+2;    //  vNear -> vNear+1 , vNear -> vNear+1
            F.add(e);
            for(int i=0; i<numOfVertices-1; i++){
                if(min + W[vNear+1][i+1] < length[i]){    //  vNear -> vNear+1
                    length[i] = min + W[vNear+1][i+1];
                    touch[i] = vNear+2;
                }
            }
            sLength[vNear] = min;   // vNear -> vNear-1; 
            length[vNear] = -1;      // vNear -> vNear - 1 ;   
            temp++;
        }
    }
    void display(){
        for(int i=0; i<numOfVertices; i++){
            for(int j=0; j<numOfVertices; j++){
                System.out.print(W[i][j]+"\t");
            }
            System.out.println();
        }
        for(int i=0; i<numOfEdges; i++){
            System.out.println("V [ "+(edge[i].start+1)+" ] --> V [ "+(edge[i].end+1)+" ]"+" --> "+edge[i].weight);
        }
        F.forEach((n) -> System.out.println(n.start+"\t"+n.end));
    }
}   

class shortestPath_Dijsktra{
    public static void main(String[] args){
        dijsktraSPAlgo d1 = new dijsktraSPAlgo(5,8);
        d1.input();
       d1.dijskata();
        d1.display();
    }
}