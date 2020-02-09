import java.util.*;
class Grames{
    String str;
    String S[];
    Grames(){
     //   Scanner sc = new Scanner(System.in);
      //  System.out.println("Entre the String ");
      //  str = sc.nextLine();
        str = "Jamia miilia islamia is a central university";
    }   
    void Tokenizer(){
        S = str.split(" ");
    }
    void Kgram(int k){
       for(int i=0; i<(S.length-k+1); i++){
            for(int j=i; j<(i+k); j++){
                System.out.print(S[j]+" ");
            }
         System.out.print("\t");
        }
    }
    void nGrams(){
        for(int i=0; i<S.length; i++){
            System.out.print((i+1)+ " Gram : ");
            Kgram(i+1);
            System.out.println();
        }
    }

}
class KgramTest{
    public static void main(String[] args){
        Grames G = new Grames();
        G.Tokenizer();
       // G.Kgram(3);
        G.nGrams();
    }
}