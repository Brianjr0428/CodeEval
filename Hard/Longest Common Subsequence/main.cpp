#include <cstdlib>
#include <iostream>
#include <fstream>
#include <vector>
#include <string.h>

using namespace std;
void printLCS(int a, int b, char direction[100][100],int index, char *LCS, char *sequence);

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
                char *pnt;
                char str[lineBuffer.length()];
                strcpy(str,lineBuffer.c_str());
                vector<char*> seqs;
                pnt=strtok(str,";");
                while (pnt!=NULL){
                      seqs.push_back(pnt);
                      pnt=strtok(NULL,";");
                      }
                char sequence1[strlen(seqs[0])+1];
                char sequence2[strlen(seqs[0])+1];
                sequence1[0]='0';
                sequence2[0]='0';
                for (int i =1; i<=strlen(sequence1);i++)
                    sequence1[i]=seqs[0][i-1];
                for (int i =1; i<=strlen(sequence2);i++)
                    sequence2[i]=seqs[1][i-1];
                int s1 = strlen(sequence1);
                int s2 = strlen(sequence2);
                char direction[100][100];
                int length[s1][s2];
                for (int i=0;i<s1;i++)
                    length[i][0]=0;
                for (int i=0;i<s2;i++)
                    length[0][i]=0;
                
                direction[0][0]=' ';
                
                for (int i=1;i<=s1;i++)
                    direction[i][0]=sequence1[i];
                for (int i=1;i<s2;i++)
                    direction[0][i]=sequence2[i];
                
                for (int i=1;i<s1;i++){
                    for (int j=1;j<s2;j++)
                         if (sequence1[i]==sequence2[j]){
                            length[i][j]=length[i-1][j-1]+1;
                            direction[i][j]='d';
                            }
                         else {
                              if (length[i-1][j]>=length[i][j-1]){
                                 length[i][j]=length[i-1][j];
                                 direction[i][j]='u';
                                 }
                              else {
                                   length[i][j]=length[i][j-1];
                                   direction[i][j]='l';
                                   }
                              }
                     }
                int index=length[s1-1][s2-1];
                char LCS[index];
                printLCS(s1-1, s2-1, direction,index-1, LCS, sequence1);
                for (int i=0;i<sizeof(LCS);i++)
                    cout<<LCS[i];
                printf("\n");
                
           }
    }
}

void printLCS(int a, int b, char direction[100][100],int index, char *LCS, char *sequence){
     if (index==-1)
        return;
     if (direction[a][b]=='d'){
        LCS[index]= sequence[a];
        printLCS(a-1, b-1, direction,index-1, LCS, sequence);
        }
     else if (direction[a][b]=='u'){
        printLCS(a-1, b, direction,index, LCS, sequence);
        }
     else if (direction[a][b]=='l'){
        printLCS(a, b-1, direction,index, LCS, sequence);
        }
     }
