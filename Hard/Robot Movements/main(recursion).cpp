#include <cstdlib>
#include <iostream>
using namespace std;
int movements(bool visited[4][4], int x, int y){
	if(x==3&&y==3)
		return 1;
	else{
		int count=0;
		if (x+1<4&&!visited[x+1][y]){
           visited[x+1][y]=true;
           count+=movements(visited, x+1,y);  
           visited[x+1][y]=false;                     
        }
		if (x-1>=0&&!visited[x-1][y]){
           visited[x-1][y]=true;
           count+=movements(visited, x-1,y);
           visited[x-1][y]=false;
        }
		if (y+1<4&&!visited[x][y+1]){
           visited[x][y+1]=true;
           count+=movements(visited, x,y+1);
           visited[x][y+1]=false;
        }
        if (y-1>=0&&!visited[x][y-1]){
           visited[x][y-1]=true;
           count+=movements(visited, x,y-1);
           visited[x][y-1]=false;
        }
		return count;	
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
    int count=movements(visited, 0,0);
    cout<<count<<endl;
}
