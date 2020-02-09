import java.util.Scanner;

class Graph{
    int V,E;
    Edge Ed[];
    class Edge{
        int src,dest,weigth;
    };
    Graph(int V,int E){
        this.V = V;
        this.E = E;
        Ed = new Edge[E];
        for(int i=0; i<E; i++){
                Ed[i] = new Edge();
        }
    }
    void input(){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<V; i++){
            int e = 0;
            System.out.print("V"+(i+1)+" connected to - ");
            Ed[i].src = i;
            Ed[e++].dest = sc.nextInt();
            System.out.print("V"+(i+1)+"is connected to other verrtices if the press Y else N");
            char is = sc.next().charAt(0);
            while(is == 'Y'){
                System.out.print("V"+(i+1)+" connected to -");
                Ed[e++].dest = sc.nextInt();
                System.out.print("V"+(i+1)+"is connected to other verrtices if the press Y else N");
                is = sc.next().charAt(0);
            }
        }
    }
    void display(){
        for(int i=0; i<V; i++){
            System.out.println("V["+(i+1)+"]-->V["+(Ed[i].dest+1)+"]");
        }
    }
}
class disjointSet{
    public static void main(String[] args){
        Graph g = new Graph(5,7);
        g.input();
        g.display();
    }
}