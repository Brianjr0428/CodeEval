#include <cstdlib>
#include <iostream>
using namespace std;
void movements(bool visited[4][4], int x, int y, int &count){
	if(x==3&&y==3)
		count++;
	else{
		if (x+1<4&&!visited[x+1][y]){
           visited[x+1][y]=true;
           movements(visited, x+1,y, count);  
           visited[x+1][y]=false;                     
        }
		if (x-1>=0&&!visited[x-1][y]){
           visited[x-1][y]=true;
           movements(visited, x-1,y, count);
           visited[x-1][y]=false;
        }
		if (y+1<4&&!visited[x][y+1]){
           visited[x][y+1]=true;
           movements(visited, x,y+1, count);
           visited[x][y+1]=false;
        }
        if (y-1>=0&&!visited[x][y-1]){
           visited[x][y-1]=true;
           movements(visited, x,y-1, count);
           visited[x][y-1]=false;
        }
	}
}
int main(int argc, char *argv[])
{
    bool visited[4][4];
    for (int i=0;i<4;i++){
        for (int j=0;j<4;j++)
            visited[i][j]=false;
    }
    visited[0][0]=true;
    int count;
    movements(visited, 0,0, count);
    cout<<count<<endl;
}
