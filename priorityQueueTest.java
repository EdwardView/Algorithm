import java.util.Scanner;

class priorityQueue{
    class Node{
        char symbol;
        int frequency;
        Node left,right;
    };
    Node N[];
    char sym[];
    int freq[];
    int length,front,rear,tLength;   /// tLength ---> temprory length.

    priorityQueue(int n){
        this.length = n;
        this.tLength =  0;
        front = rear = -1;
        sym = new char[this.length];
        freq = new int[this.length];
        N = new Node[length];
        for(int i=0; i<this.length; i++)
            N[i] = new Node();
    }
       void input(){
        Scanner sc = new Scanner(System.in);
        int temp1[] = {25,55,35,45,15};
        char temp2[] =  {'a','b','c','d','e'};
        for(int i=0; i<length; i++){
            System.out.println("Entre the Character and their Ferequence ---> ");
            sym[i] = temp2[i];              //(sc.next()).charAt(0);
            freq[i] = temp1[i];              //sc.nextInt();
        }
    }
    void insert(Node nd){
        if(rear == length-1)
            System.out.println("Queue is Full.");
        else if(rear == -1){
            rear = front = 0;
            tLength++;
        }else{
            rear++;
            tLength++;
        }
        N[rear] = nd;
        buildHeap();    // create MIN_Heap.
     }
    Node del(){
        if(front == -1)
            System.out.println("Queue is Empty");
        
        Node temp = N[0];
        if(rear == front){
            rear = front = -1;
            tLength--;
        }else{    
            tLength--;
            rear--;
        }
        for(int i=0; i<tLength; i++)
            N[i] = N[i+1];
        buildHeap();  // after deleting maintaing Heap Properties.
        return temp;
    }
    void heapify(int n,int i) 
    { 
        int largest = i;  // Initialize largest as root 
        int l = 2*i + 1;  // left = 2*i + 1 
        int r = 2*i + 2;  // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && N[l].frequency < N[largest].frequency) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && N[r].frequency < N[largest].frequency) 
            largest = r; 
        // If largest is not root 
        if (largest != i) 
        { 
            Node swap = N[i]; 
            N[i] = N[largest]; 
            N[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(n,largest); 
        } 
    } 
    void buildHeap() 
    { 
        // Index of last non-leaf node 
        int startIdx = (tLength / 2) - 1; 
        // Perform reverse level order traversal 
        // from last non-leaf node and heapify 
        // each node 
        for (int i = startIdx; i >= 0; i--) {
            heapify(tLength,i); 
        } 
    }
    // -------------------HuFFMANCOING to compress the size of message/file ----------------//
    Node huffman(){
        for(int i=0; i<length; i++){
            Node nd = new Node( );  
            nd.symbol = sym[i];
            nd.frequency = freq[i];
            nd.left = nd.right = null;
            insert(nd);   // inert into priority Queue.
        }
        display();
        for(int i=0; i<length-1; i++){
            Node p = new Node();
            Node q = new Node();
            p = del();
            q = del();
            Node r = new Node();
            r.left = p;
            r.right = q;
            r.frequency = p.frequency + q.frequency;
            insert(r);
            display();
        }
        Node r = del();
        return r;
    }
    void display(){
        for(int i=0; i<tLength; i++)
            System.out.print(N[i].frequency+"\t");
        System.out.println();
    }
    
    void displayCharacterCode(Node root,String s){
        if(root.left == null && root.right == null && Character.isLetter(root.symbol)){
            System.out.println("Huffman COde for Character ' '"+root.symbol+" '  ------> " + s);
            return ;
        }
        displayCharacterCode(root.left, s+"0");
        displayCharacterCode(root.right, s+"1");
    } 
}

class priorityQueueTest{
    public static void main(String[] args){
        priorityQueue p1 = new priorityQueue(5);
        p1.input();
        priorityQueue.Node root = p1.huffman();
        p1.displayCharacterCode(root, "");
    }
}