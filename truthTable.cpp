#include<iostream>
#include<cmath>
using namespace std;
int main(){
	cout << "Enter the number: ";
	int num;
	cin >> num;
	char *a = new char[num];
	 
	for(int i=0; i<num; i++)
		a[i] = 'F';	
		
	for(int i=0; i<pow(2,num); i++){
		int j = num-1;
		int k = i;
		while(k != 0){
			if(k%2 == 1)
				a[j] = 'T';
			else
				a[j] = 'F';
			j--;
			k = k/2;
		}
		cout << "[ ";
		for(int i=0; i<num; i++)
			cout << a[i] << ",";
		cout << "]" <<endl;
	}
	return 0;
}
