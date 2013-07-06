#include <cstdlib>
#include <iostream>
#include <fstream>

using namespace std;

int climb(int x){
    if (x<0)
       return 0;
    if (x==0)
       return 1;
    return climb(x-1)+climb(x-2);
}
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
                int num=atoi(lineBuffer.c_str());
                cout<<climb(num)<<endl;
           }
    }
}
