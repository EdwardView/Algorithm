#include<iostream>
#include<sstream>
#include<string.h>
#include<cstring>
#include<vector>
using namespace std;

vector<string> tokenize(string);
void k_gram(vector<string>,int,int);
int main(){
	string str = "Jamia miilia islamia is central university";
//	cout << "Enter the String :" << endl;
//	getline(cin,str);
	vector<string> tok = tokenize(str);
	cout << "Entre the value to which cal of gram : " ;
	int k; cin >> k;
	if(k > tok.size())
		cout << "Not possible to calculate K-Gram.\n";
	else{
		cout << "K-Grams are : \n";
		k_gram(tok,tok.size(),k);
	}
	return 0;
}
vector<string> tokenize(string str){
	vector<string> token;
	istringstream ss(str);
	str.clear();
	int i=0;
	while(getline(ss,str,' ')){
		token.push_back(str);
	}
	return token;
}
void k_gram(vector<string> str, int n,int k){
	for(int i=0; i<n+k-1; i++){
		for(int j=i; j<i+k; j++){
			cout << str[j] << " ";
		}
		cout << endl;
	}
}
