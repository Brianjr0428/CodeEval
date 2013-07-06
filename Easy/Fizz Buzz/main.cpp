#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string.h>
#include <vector>

using namespace std;

int main(int argc, char *argv[])
{
    string lineBuffer;
    ifstream file;
    file.open(argv[1]);
    vector<int> vect;
    int fizz;
    int buzz;
    int total;
    while (!file.eof())
       {
           getline(file, lineBuffer);
           if (lineBuffer.length() == 0)
               continue; //ignore all empty lines
           else 
           {
               char str[lineBuffer.length()];
               strncpy(str, lineBuffer.c_str(),lineBuffer.length());
               char *pnt;
               pnt = strtok(str, " ");
               while (pnt!=NULL){
                     vect.push_back(atoi(pnt));
                     pnt = strtok(NULL, " ");
                     }              
               fizz=vect[0];
               buzz=vect[1];
               total=vect[2];
               for (int i=1;i<=total;i++){
                   if (i%fizz==0 && i%buzz==0)
                      cout<<"FB";
                   else if (i%fizz==0)
                        cout<<"F";
                   else if (i%buzz==0)
                        cout<<"B";
                   else
                       cout<<i;
                       
                   if (i==total)
                      printf("\n");
                   else
                       cout<<" ";
                   }
           }
       vect.clear();
    }
}
