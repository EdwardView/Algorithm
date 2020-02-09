#include<iostream>
#include<cmath>
using namespace std;
void permutation(char *,int,int);
int main(){
	int num;
	cin >> num;
	char *str = new char[num];
	char ch = 'a';
	for(int i=0; i<num; i++)
		str[i] = ch++;
//	for(int i=0; i<num; i++)
//		cout << str[i];
	permutation(str,0,num-1);
	return 0;	
}
void permutation(char *str,int k,int num){
	if(num == k){
		for(int i=0; i<num; i++)
			cout << str[i];
		cout << endl;
	}else{
		for(int j=k; j<=num; j++){
			char temp = str[k];
			str[k] = str[j];
			str[j] = temp;
			permutation(str,k+1,num);
			temp = str[k];
			str[k] = str[j];
			str[j] = temp;
 		}
	}
}

