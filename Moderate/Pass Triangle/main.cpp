#include <cstdlib>
#include <iostream>
#include <fstream>
#include <vector>
#include <string.h>

using namespace std;
void maxSum(vector< vector<int> > &content, int levels);
int main(int argc, char *argv[])
{
    int lines=0;
    string lineBuffer;
    ifstream file;
    vector< vector<int> > content;
    file.open(argv[1]);
    while (!file.eof()) 
       {
           getline(file, lineBuffer);
           if (lineBuffer.length() == 0)
               continue; 
           else 
           {
                lines++;
                char str[lineBuffer.length()];
                vector<int> numbers;
                char *pnt;
                strcpy(str,lineBuffer.c_str());
                pnt=strtok(str," ");
                while (pnt!=NULL){
                      numbers.push_back(atoi(pnt));                      
                      pnt=strtok(NULL, " ");
                      }
                content.push_back(numbers);
           }
    }
    maxSum(content,lines);
    cout<<content[0][0];
}

void maxSum(vector< vector<int> > &content, int levels){
    for (int i=levels-2;i>=0;i--){
        for (int j=0;j<content[i].size();j++){
            if (content[i+1][j]>content[i+1][j+1])
               content[i][j]+=content[i+1][j];
            else 
                 content[i][j]+=content[i+1][j+1];
            }
        }
    }
