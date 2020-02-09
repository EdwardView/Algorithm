#include<iostream>
using namespace std;
void fib(int);
int main(){
	int n;
	cout << "Enter the Number to which find Fibonaci Series : " << endl;
	cin >> n;
	fib(n);
	return 0;
} 
void fib(int n){
	int a=0,b=1,c=1;
	int count = 2;
	if(n <= 0){
		cout << "Fibonacii Series is not exist for this number.\n";
		return ;
	}
	else if(n == 1){
		cout << n << "th Fibonacii Number is " << 0 << endl;
		return;
	}	
	else if(n == 2){
		cout << n << "th Fibonacii Number is " << c << endl;
		return ;
	}
	else{
		while(count != n){
			c = a+b;
			a = b;
			b = c;
			count++;
		}
	}
	cout << n << "th Fibonacii Number is " << c << endl;
}

