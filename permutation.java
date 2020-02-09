import java.util.*;
class data{
    public String arry;
    public char temp[];
    data(String str){
        arry = str;
        temp = new char[arry.length()];
        arry.getChars(0,arry.length(),temp, 0);
    }
    void permut(int k,int len){
        if(k == len){
        for(char p : temp)
            System.out.print(p+" ");
        System.out.println();
        }else{
            for(int i=k-1; i<len; i++){
                swap(i,k-1);
                permut(k+1,len);
                swap(i,k-1);
            }
        }
    }
    void swap(int i,int j){
        char ch = temp[i];
        temp[i] = temp[j];
        temp[j] = ch;
    }
}
class permutation{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        data d1 = new data(st);
        d1.permut(2-1,st.length());
    }
}