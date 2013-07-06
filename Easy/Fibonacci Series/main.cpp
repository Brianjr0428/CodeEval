#include <cstdlib>
#include <iostream>
#include <fstream>

using namespace std;
int fib(int value);
int main(int argc, char *argv[])
{
    string lineBuffer;
    ifstream file;
    file.open(argv[1]);
    while (!file.eof()) 
       {
           getline(file, lineBuffer);
           if (lineBuffer.length() == 0)
               continue; 
           else 
           {
                int value=atoi(lineBuffer.c_str());
                cout<<fib(value)<<endl;
                
           }
    }
}
int fib(int value){
    if (value==0)
       return 0;
    if (value==1)
       return 1;
    int num1=0;
    int num2=1;
    int sum;
    for (int i=2;i<=value;i++){
        sum=num1+num2;
        num1=num2;
        num2=sum;
    }
    return sum;
}
