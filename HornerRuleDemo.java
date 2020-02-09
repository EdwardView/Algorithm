import java.util.Scanner;

class HornerRule{
    int degreePoly,X;
    int coefficent[];
    HornerRule(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Degree of Polynomial :");
        degreePoly = sc.nextInt();
        coefficent = new int[degreePoly+1];
        System.out.println("Entre the Value of X : ");
        X = sc.nextInt();
    }
    void getData(){
        System.out.println("Enter the Coeffiecnt of Polynomial :");
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<degreePoly+1; i++){
            coefficent[i] = sc.nextInt();
        }
    }
    int HornerRulePolynomial(){
        int exp = X*coefficent[degreePoly];
        for(int i=degreePoly-1; i>=1; i--)
            exp = (exp + coefficent[i])*X;
        exp += coefficent[0];
        return exp;
    }
}
class HornerRuleDemo{
    public static void main(String[] agrs){
        HornerRule h1 = new HornerRule();
        h1.getData();
        System.out.println("Value of Express is : "+h1.HornerRulePolynomial());
    }
}