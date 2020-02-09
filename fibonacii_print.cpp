#include<iostream>
using namespace std;
void fib(double long);
int main(){
	double long n;
	cout << "Enter the Number to which find Fibonaci Series : " << endl;
	cin >> n;
	fib(n);
	return 0;
} 
void fib(double long n){
	double long a=-1,b=1,c=1;
//	int count = 2;
	if(n <= 0){
		cout << "Fibonacii Series is not exist for this number.\n";
		return ;
	}
	else if(n == 1){
		cout << n << "th Fibonacii Number is " << 0 << endl;
		return;
	}	
	else{
		cout << "Fibonacii Series is : ";
		while(--n >= 0){
			c = a+b;
			cout << c << " ";
			a = b;
			b = c;
			//count++;
		}
	}
	//cout << n << "th Fibonacii Number is " << c << endl;
}

