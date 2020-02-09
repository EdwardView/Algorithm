#include<iostream>
using namespace std;
int fib(int);
int main(){
	int num;
	cout << "Enter the Number to find Finonacii : ";
	cin >> num;
	for(int i=0; i<num; i++)
		cout << fib(i) << " ";
	return 0;
}
int fib(int num){
	if(num == 0 || num == 1)
		return num;
	else{
		return fib(num-1)+fib(num-2);
	}
}

