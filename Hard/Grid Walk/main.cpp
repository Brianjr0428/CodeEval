#include <cstdlib>
#include <iostream>
#include <vector>
#include <set>

using namespace std;

bool checkAccess(int x, int y){
		int total=0;
		while (x!=0){
			total+=abs(x%10);
			x/=10;
		}
		while (y!=0){
			total+=abs(y%10);
			y/=10;
		}
		if(total>19)
			return false;
		else
			return true;
	}
int main(int argc, char *argv[])
{
    vector<pair<int,int> > list; 
    set<pair<int,int> > set;
    list.push_back(make_pair<int,int>(0,0));
    set.insert(make_pair<int,int>(0,0));
    int index=0;
    while (index<list.size()){
          int x=list.at(index).first;
          int y=list.at(index).second;
          if (checkAccess(x-1,y)&&set.find(make_pair<int,int>(x-1,y))==set.end()){
                 list.push_back(make_pair<int,int>(x-1,y));
                 set.insert(make_pair<int,int>(x-1,y));                                 
             }
          if (checkAccess(x+1,y)&&set.find(make_pair<int,int>(x+1,y))==set.end()){
                 list.push_back(make_pair<int,int>(x+1,y));
                 set.insert(make_pair<int,int>(x+1,y));                                 
             }
          if (checkAccess(x,y+1)&&set.find(make_pair<int,int>(x,y+1))==set.end()){
                 list.push_back(make_pair<int,int>(x,y+1));
                 set.insert(make_pair<int,int>(x,y+1));                                   
             }
          if (checkAccess(x,y-1)&&set.find(make_pair<int,int>(x,y-1))==set.end()){
                 list.push_back(make_pair<int,int>(x,y-1));
                 set.insert(make_pair<int,int>(x,y-1));                                      
             }
          index++;
    }
    cout<<list.size()<<endl;
    return 0;
}
