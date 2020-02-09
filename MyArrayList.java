import java.io.*;
import java.util.ArrayList; 

class nodeEdge{   // Edge contain initial and target vertex at eich they connect.
    int start,end,weight;
    nodeEdge(int s,int e,int w){
        this.start = s;
        this.end = e;
        this.weight = w;
    }
}
class MyArrayList{
    public static void main(String[] args){
    nodeEdge N[] = new nodeEdge[10];
    for(int i=0; i<10; i++){
        N[i] = new nodeEdge(i,i,i);
    }
    ArrayList<nodeEdge> L = new ArrayList<nodeEdge>();
    for(int i=0; i<10; i++)
        L.add(N[i]);
    L.forEach((n) -> System.out.println(n.start));         
    }
}