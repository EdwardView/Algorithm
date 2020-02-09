import java.util.Scanner;

class scheduling{
    int nOfJob;
    int deadline[],profit[];
    int j[],l,k[];
    int maxdeadline;
    scheduling(int n){
        this.nOfJob = n;
        deadline = new int[nOfJob];
        profit = new int[nOfJob];
        int d[] = {3,1,1,3,1,3,2};
        int p[] = {40,35,30,25,20,15,10};
        //Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Deadline and Profit of Jobs  -|");
        for(int i=0; i<nOfJob; i++){
            // System.out.print("Job "+(i+1)+"DeadLine -> ");
            // deadline[i] = sc.nextInt();
            // System.out.println("job "+(i+1)+"Profit -> ");
            // profit[i] = sc.nextInt();
            deadline[i] = d[i];
            profit[i] = p[i];
        }
        findMaxDeadline();
        j = new int[nOfJob];   // J -> Job Sequence
     //   k = new int[maxdeadline];
    }
    void sorting(){   // insertion Sorting to sort profit of jobs
        for(int i=1; i<nOfJob; i++){
                int x = profit[i];
                int y = deadline[i];
                int j=i-1;
                while(j>=0 && profit[j] > x){
                    profit[j+1] = profit[j];
                    deadline[j+1] = deadline[j];
                    j--;
                }
                profit[j+1] = x;
                deadline[j+1] = y;
            }
    }
    void findMaxDeadline(){
        maxdeadline = deadline[0];
        for(int i=1; i<nOfJob; i++){
            if(maxdeadline < deadline[i])
                maxdeadline = deadline[i];
        }
    }
    void schedule(){
        //sorting();  
        l = 0;
        j[l] = 0;
        for(int i=1; i<nOfJob; i++){
            k = j;
            int m = l;
            while((m >= 0) && (deadline[i] < deadline[k[m]])){
                k[m+1] = k[m];
                m--;
            }
            k[m+1] = i;
            l++;
            if(feasible(l) == true)
                j = k;
            else{ 
                k[m+1] = k[l];     
                l--;
            }
        }   
    }

    boolean feasible(int n){
        boolean flag = true;
        for(int i=0; i<n; i++){
            if(deadline[k[i]] <= i){
                flag = false;
                break;
            }
        }
        return flag;
    }
    void display(){
        System.out.println("Job Sequence is -->> ");
        int profitMax = 0;
        for(int i=0 ;i<maxdeadline; i++){
            System.out.print((j[i]+1)+"\t");
            profitMax += profit[j[i]];
        }
        System.out.println("Max profit is -->> "+profitMax);

    }
}

class jobScheduling{
    public static void main(String[] args){
        scheduling s1 = new scheduling(7);
        s1.schedule();
        s1.display();
    }
}