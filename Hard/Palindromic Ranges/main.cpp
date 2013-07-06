#include <cstdlib>
#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include <string.h>

using namespace std;
bool isPalindrome(int);

int main(int argc, char *argv[])
{
    string lineBuffer;
    ifstream file;
    file.open(argv[1]);
    vector<int> vect;
    vector<int> numbers;
    int interRange;
    while (!file.eof()) 
       {
           getline(file, lineBuffer);
           if (lineBuffer.length() == 0)
               continue; 
           else 
           {    
                interRange=0;
                vect.clear();
                numbers.clear();
                char str[lineBuffer.length()];
                strcpy(str,lineBuffer.c_str());
                char *pnt;
                pnt=strtok(str, " ");
                while (pnt!=NULL){
                      vect.push_back(atoi(pnt));
                      pnt=strtok(NULL, " ");
                      }
                for (int i = vect[0];i<=vect[1];i++){
                    numbers.push_back(i);
                    }
                int setSize;
                int palins;
                for (int i=1;i<=numbers.size();i++){
                    setSize=i;
                    for (int j=0;j<=numbers.size()-i;j++){
                        palins=0;
                        for (int k =0;k<setSize;k++){
                            if (isPalindrome(numbers[j+k]))
                               palins++;
                            }
                        if (palins%2==0)
                           interRange++;
                        }
                    }
                cout<<interRange<<endl;
           }
    }
}

bool isPalindrome(int x){
    char charArr[10];
    string str="";
    stringstream ss;
    ss<<x;
    str = ss.str().c_str();
    strcpy(charArr, str.c_str());

    int start=0;
    int end = strlen(charArr)-1;
    while (start<end){
          if (charArr[start]!=charArr[end])
             return false;
          start++;
          end--;
          }
    return true;
    }
