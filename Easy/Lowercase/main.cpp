#include <cstdlib>
#include <iostream>
#include <fstream>

using namespace std;

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
                for (int i=0;i<lineBuffer.length();i++){
                    if (lineBuffer.at(i)>=65&&lineBuffer.at(i)<=90)
                       cout<<char(lineBuffer.at(i)+32);
                    else
                        cout<<lineBuffer.at(i);
                }
                printf("\n");
           }
    }
}
