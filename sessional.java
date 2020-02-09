import java.util.Scanner;

class sessional1{
    int ary[];
    int num,resSize=1;
    sessional1(){
        System.out.print("Enter the Number : ");
        int num = 23456712;
        for(int i=0; i<7; i++){
            ary[i] = num%10;
            num /=10;
        }

    }
}