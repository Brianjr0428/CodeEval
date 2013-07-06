#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string.h>
#include <vector>
#include <algorithm>
#include <math.h> 
using namespace std;


double dist(int x[], int y[]);
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
                vector<int> vect;
                string s="";
                for (int i=0;i<lineBuffer.length();i++){
                    if (lineBuffer.at(i)!='('&&lineBuffer.at(i)!=')'&&lineBuffer.at(i)!=' '&&lineBuffer.at(i)!='\r'&&lineBuffer.at(i)!='\t'&&lineBuffer.at(i)!='\n')
                       s+=lineBuffer.at(i);
                }
                char str[s.length()];
                strcpy(str, s.c_str());
                char *pnt;
                pnt = strtok(str, ",");
                while (pnt!=NULL){
                     vect.push_back(atoi(pnt));
                     pnt = strtok(NULL, ",");
                } 
                int points[4][2] ={{vect[0],vect[1]},{vect[2],vect[3]},{vect[4],vect[5]},{vect[6],vect[7]}};
                double distance[6];
                int index=0;
                for (int i=0;i<3;i++){
                    for (int j=i+1;j<4;j++){
                        distance[index]=dist(points[i],points[j]);
                        index++;
                    }
                }
                sort(distance, distance+sizeof(distance)/sizeof(double));
                if (distance[4]/distance[3]>=1.141&&distance[4]/distance[3]<=1.415&&distance[4]==distance[5]&&distance[0]==distance[1]&&distance[0]==distance[2]&&distance[0]==distance[3])
                   cout<<"true"<<endl;
                else
                    cout<<"false"<<endl;
           }
    }
}
double dist(int x[], int y[]){
       return   sqrt(pow(x[0]-y[0],2)+pow(x[1]-y[1],2));     
}
