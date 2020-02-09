import java.util.Random;

class heapsort{
    int arr[];
    int n;
    heapsort(int n){
        this.n = n;
        arr = new int[n];
    }
    void input(){
        Random rand = new Random();
        for(int i=0; i<n; i++)
            arr[i] = rand.nextInt(20);
    }
    void heapify(int n,int i) 
    { 
        int largest = i;  // Initialize largest as root 
        int l = 2*i + 1;  // left = 2*i + 1 
        int r = 2*i + 2;  // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] < arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] < arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(n,largest); 
        } 
    } 
    void buildHeap() 
    { 
        // Index of last non-leaf node 
        int startIdx = (n/ 2) - 1; 
        // Perform reverse level order traversal 
        // from last non-leaf node and heapify 
        // each node 
        for (int i = startIdx; i >= 0; i--) { 
            heapify(n,i); 
        } 
    }
    // public void sort(){ 
    //     int n = arr.length; 
  
    //     // Build heap (rearrange array) 
    //     for (int i = n / 2 - 1; i >= 0; i--) 
    //         heapify(n,i); 
  
    //     // One by one extract an element from heap 
    //     for (int i=n-1; i>=0; i--) 
    //     { 
    //         // Move current root to end 
    //         int temp = arr[0]; 
    //         arr[0] = arr[i]; 
    //         arr[i] = temp; 
  
    //         // call max heapify on the reduced heap 
    //         heapify(i,0); 
    //     } 
    // } 
    void display(){
        System.out.println("Heap Data -----|||");
        for(int i=0; i<n; i++)
            System.out.println(arr[i]);
    }

    public static void main(String[] args){
        heapsort h1 = new heapsort(10);
        h1.input();
        h1.buildHeap();
        h1.display();
    }
}