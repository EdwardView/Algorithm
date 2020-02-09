#include<iostream>
using namespace std;
int main(){
	int num;
	cout << "Entre the Number to which find Square Root : ";
	cin >> num;
	float i = 0.0001,x = num,y = 1;
	while(x-y>i){
		x = (x+y)/2;
		y = num/x;
	}
	cout << x << endl;
	return 0;
}
