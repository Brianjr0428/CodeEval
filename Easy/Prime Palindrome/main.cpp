#include <cstdlib>
#include <iostream>
#include <string>
#include <sstream>
using namespace std;

bool isPrime(int);
bool isPalindrome(string);
bool isPrimePalindrome(int);

int main(int argc, char *argv[])
{
    int max=0;
    for (int i=2;i<1000;i++){
        if (isPrimePalindrome(i))
           max=i;
    }
    cout<<max;
}

bool isPrime(int x){
     for (int i =2;i<=x/2+1;i++){
         if (x%i==0)
            return false;
         }
     return true;
     }

bool isPalindrome(string str){
    int start = 0;
    int end = str.length()-1;
    while (start<end){
          if (str[start]!=str[end])
             return false;
          start++;
          end--;       
          }         
    return true;
     }

bool isPrimePalindrome(int x){
     stringstream ss;
     string str;
     ss<<x;
     str = ss.str();
     if (isPrime(x)&&isPalindrome(str))
        return true;
     else
         return false;
     }
