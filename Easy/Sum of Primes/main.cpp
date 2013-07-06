#include <cstdlib>
#include <iostream>

using namespace std;
int isPrime(int);
int main(int argc, char *argv[])
{
    int count=0;
    int sum=0;
    int num=2;
    while (count<1000){
          if (isPrime(num)){
             sum+=num;
             count++;
             }
          num++;
          }
    cout<<sum;
}

int isPrime(int x){
    for (int i=2;i<=x/2;i++){
        if (x%i==0)
           return false;
    }
    return true;
}
