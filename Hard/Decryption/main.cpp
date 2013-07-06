#include <cstdlib>
#include <iostream>
#include <fstream>
using namespace std;
int findIndex(char c,string key){
	for(int i=0;i<key.length();i++){
		if(c==key.at(i))
			return i;	
	}
	return -1;
}
int main(int argc, char *argv[])
{
    string msg="012222 1114142503 0313012513 03141418192102 0113 2419182119021713 06131715070119";
    string key="BHISOECRTMGWYVALUZDNFJKPQX";
    int i=0;
	int value;
	string result="";
	while(i<msg.length()){
		if(msg.at(i)==' '){
			result+=" ";
			i++;
		}
		else{
			value=msg.at(i)-'0';
			i++;
			value*=10;
			value+=msg.at(i)-'0';
			i++;
			result+=(char)('A'+findIndex((char)('A'+value),key));
		}
	}
	cout<<result<<endl;
}
