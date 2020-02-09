#include<iostream>
using namespace std;
string decimalToHexdecimal(int);
int main(){
	int dec;
	cout << "Entre the Decimal Number : ";
	cin >> dec;
	cout << "Decimal : " << dec << " to HexaDecimal : " << decimalToHexdecimal(dec) << endl;
	return 0;
}
string decimalToHexdecimal(int Dec){
	int rem;
	string str;
	while(Dec != 0){
		rem = Dec%16;
		if(rem > 9){
			str += ('A'+ rem%10);
		}else{
			str += (char)(rem+'0');
		}
		Dec /=16;
	}
	int n = str.length();
	for (int i = 0; i < n / 2; i++) 
        swap(str[i], str[n - i - 1]); 
	return str;
}
