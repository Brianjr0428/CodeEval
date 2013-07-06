#include <cstdlib>
#include <iostream>
#include <fstream>
#include <vector>
#include <string.h>

using namespace std;


class Hand{
      
      int rank;
      int four;
      int onePairValue;
      int twoPairsValue;
      int threeKind;
      
      public:
             vector<int> values;
             vector<char> suits;
             Hand (vector<int> v, vector<char> s){
                  for (int i=0;i<(int)v.size();i++){
                      values.push_back(v[i]);
                      suits.push_back(s[i]);
                      sort();
                      }                  
                  }  
             int getFour(){
                 return four;
                 }
             int getOnePair(){
                 return onePairValue;
                 }
             int getTwoPairs(){
                 return twoPairsValue;
                 }
             int getThree(){
                 return threeKind;
                 }
             void print(){
                  for (int i=0;i<(int)values.size();i++)
                      cout<<values[i]<<suits[i]<<" ";
                  printf("\n");
                  }
                  
             template<class T>
             vector<T> swap(int a, int b, vector<T> v){
                  T temp= v[a];
                  v[a]=v[b];
                  v[b]=temp;
                  return v;
                  }
                  
             void sort(){
                  int currentIndex=0;
                  int smallest;
                  while (currentIndex<(int)values.size()-1){
                        smallest=currentIndex;
                        for (int i=currentIndex+1;i<(int)values.size();i++){
                            if (values[i]<(int)values[smallest])
                               smallest=i;
                            }
                        values=swap(currentIndex, smallest, values);
                        suits=swap(currentIndex, smallest, suits);    
                        currentIndex++;
                        smallest=currentIndex;                        
                        }
                  }
                  
             bool isFlush(){
                  if (!isRoyalFlush()&&!isFullHouse()){
                     for (int i=0;i<(int)suits.size()-1;i++)
                         if (suits[i]!=suits[i+1])
                            return false;
                     return true;
                     }
                  return false;
                  }
                  
             bool isRoyalFlush(){
                  if (values[0]==10&&values[1]==11&&values[2]==12&&values[3]==13&&values[4]==14){
                      for (int i=0;i<(int)suits.size()-1;i++)
                         if (suits[i]!=suits[i+1])
                            return false;
                     return true;
                      }     
                  return false;
                  }
                  
             bool isStraightFlush(){
                  if (!isRoyalFlush()&&isFlush()){
                     return(values[0]==10&&values[1]==11&&values[2]==12&&values[3]==13&&values[4]==14);
                     }
                  return false;
                  }
                  
              bool isStraight(){
                  if (!isStraightFlush()&&!isRoyalFlush()&&!isFlush()){
                     if (values[0]==2&&values[1]==3&&values[2]==4&&values[3]==5&&values[4]==14)
                        return true;
                     else {
                          for (int i =0;i<(int)values.size()-1;i++){
                              if (values[i+1]!=values[i]+1)
                                 return false;
                                 }
                              return true;
                          }
                          return false;
                     }
                  return false;
                  }
                  
             bool isFourofaKind(){
                  if (values[0]==values[1]&&values[0]==values[2]&&values[0]==values[3]){
                     four = values[0];
                     return true;
                     }
                  else if (values[1]==values[2]&&values[1]==values[3]&&values[1]==values[4]){
                     four = values[1];
                     return true;   
                     }
                  else 
                       return false;
                  }
                  
             bool isThreeofaKind(){
                  if (!isFourofaKind()&&!isFullHouse()){
                      if (values[0]==values[1]&&values[0]==values[2]){
                         threeKind =values[2];
                         return true;
                         }
                      else if (values[1]==values[2]&&values[1]==values[3]){
                         threeKind =values[2];
                         return true;   
                         }
                      else if (values[2]==values[3]&&values[2]==values[4]){
                         threeKind =values[2];
                         return true; 
                         }
                      }   
                  return false;
                  }
                  
             bool isFullHouse(){
                  if (values[0]==values[1]&&values[0]==values[2]){
                     if (values[3]==values[4]){
                        threeKind = values[0];
                        onePairValue = values[3];
                        return true;
                        }
                     else
                         return false;
                     }
                  else if (values[2]==values[3]&&values[2]==values[4]){
                       if (values[0]==values[1]){
                          threeKind = values[2];
                          onePairValue = values[0];
                          return true;
                          }
                       else
                           return false;
                       }
                     return false; 
                  }
                  
             bool isTwoPairs(){
                  if (!isFourofaKind()&&!isFullHouse()){
                      if (values[0]==values[1]){
                         if (values[2]==values[3]||values[3]==values[4]){
                            twoPairsValue=values[3];
                            onePairValue=values[1];
                            return true;
                            }
                         else
                             return false;
                         }
                      else {
                           if (values[1]==values[2]&&values[3]==values[4]){
                              twoPairsValue=values[3];
                              onePairValue=values[1];
                              return true;
                              }
                           else
                               return false;
                           }  
                     }
                  return false;
                  }
                  
             bool isOnePair(){
                  if (!isTwoPairs()&&!isFourofaKind()&&!isThreeofaKind()&&!isFullHouse()&&!isFlush()){
                     for (int i=0;i<(int)values.size()-1;i++){
                         if (values[i]==values[i+1]){
                            onePairValue=values[i];
                            return true;
                            }
                         }
                     }
                  return false;
                  }
             void setRank(){
                  if (isRoyalFlush())
                     rank = 1;
                  else if (isStraightFlush())
                     rank = 2;
                  else if (isFourofaKind())
                     rank = 3;
                  else if (isFullHouse())
                     rank = 4;
                  else if (isFlush())
                     rank = 5;
                  else if (isStraight())
                     rank = 6;
                  else if (isThreeofaKind())
                     rank = 7;
                  else if (isTwoPairs())
                     rank = 8;
                  else if (isOnePair())
                     rank = 9;
                  else
                      rank =10;
                  }
             int getRank(){
                 return rank;
                 }
      };

int convert(char);
int main(int argc, char *argv[])
{
    string lineBuffer;
    ifstream file;
    file.open(argv[1]);
    while (!file.eof()) 
       {
           getline(file, lineBuffer);
           if (lineBuffer.length() == 0)
               continue; //ignore all empty lines
           else 
           {
                vector<int> numbers;
                vector<char> suits;
                vector<int> lNumbers;
                vector<char> lSuits;
                vector<int> rNumbers;
                vector<char> rSuits;
                char str[lineBuffer.length()];
                strcpy(str, lineBuffer.c_str());
                char* pnt;
                pnt = strtok(str, " ");
                while (pnt!=NULL){
                      numbers.push_back(convert(pnt[0]));
                      suits.push_back(pnt[1]);
                      pnt= strtok(NULL, " ");
                      }
                
                for (int i =0;i<5;i++){
                    lNumbers.push_back(numbers[i]);
                    lSuits.push_back(suits[i]);
                    }
                
                for (int i =5;i<(int)numbers.size();i++){
                    rNumbers.push_back(numbers[i]);
                    rSuits.push_back(suits[i]);
                    }
               Hand leftHand = Hand(lNumbers, lSuits);
               Hand rightHand = Hand(rNumbers, rSuits);
               leftHand.setRank();
               rightHand.setRank();
               if (leftHand.getRank()<rightHand.getRank())
                  cout<<"left"<<endl;
               else if (leftHand.getRank()>rightHand.getRank())
                  cout<<"right"<<endl;
               else {
                    switch (leftHand.getRank()){
                           case 1://Royal Flush
                                cout<<"none"<<endl;
                                break;
                           case 2://Straight Flush
                                                                if (leftHand.values[0]==2&&leftHand.values[1]==3&&leftHand.values[2]==4&&leftHand.values[3]==5&&leftHand.values[4]==14){
                                   if (rightHand.values[0]==2&&rightHand.values[1]==3&&rightHand.values[2]==4&&rightHand.values[3]==5&&rightHand.values[4]==14){
                                      cout<<"none"<<endl;
                                      break;
                                      }
                                   else 
                                        cout<<"right"<<endl;
                                        break;
                                   }
                                if (rightHand.values[0]==2&&rightHand.values[1]==3&&rightHand.values[2]==4&&rightHand.values[3]==5&&rightHand.values[4]==14){
                                   if (leftHand.values[0]==2&&leftHand.values[1]==3&&leftHand.values[2]==4&&leftHand.values[3]==5&&leftHand.values[4]==14){
                                      cout<<"none"<<endl;
                                      break;
                                      }
                                   else 
                                        cout<<"left"<<endl;
                                        break;
                                   }
                                if (leftHand.values[leftHand.values.size()-1]>rightHand.values[rightHand.values.size()-1]){
                                   cout<<"left"<<endl;
                                   break;
                                   }
                                else if (leftHand.values[leftHand.values.size()-1]<rightHand.values[rightHand.values.size()-1]){
                                   cout<<"right"<<endl;
                                   break;
                                   }
                                else{
                                     cout<<"none"<<endl;
                                     break;  
                                     }
                           case 3://Four of a Kind
                                if (leftHand.getFour()>rightHand.getFour()){
                                   cout<<"left"<<endl;
                                   break;
                                   }
                                else if (leftHand.getFour()<rightHand.getFour()){
                                   cout<<"right"<<endl;
                                   break;
                                   }
                                else{
                                     int l;
                                     int r;
                                     for (int i=0;i<(int)leftHand.values.size();i++){
                                         if (leftHand.values[i]!=leftHand.getFour())
                                            l=leftHand.values[i];
                                         }
                                     for (int i=0;i<(int)rightHand.values.size();i++){
                                         if (rightHand.values[i]!=rightHand.getFour())
                                            r=rightHand.values[i];
                                         }
                                     if (l>r){
                                        cout<<"left"<<endl;
                                        break;
                                        }
                                     else if (l<r){
                                        cout<<"right"<<endl;
                                        break;
                                        }
                                     else {
                                          cout<<"none"<<endl;
                                          break;
                                          }
                                     }
                                   
                           case 4://Full House:
                                if (leftHand.getThree()>rightHand.getThree()){
                                   cout<<"left"<<endl;
                                   break;
                                   }
                                else if (leftHand.getThree()<rightHand.getThree()){
                                   cout<<"right"<<endl;
                                   break;
                                   }
                                else if(leftHand.getOnePair()>rightHand.getOnePair()){
                                   cout<<"left"<<endl;
                                   break;
                                   }
                                else if (leftHand.getOnePair()<rightHand.getOnePair()){
                                   cout<<"right"<<endl;
                                   break;
                                   }
                                else{
                                     cout<<"none"<<endl;
                                     break;     
                                     }                                
                           case 5://Flush
                                bool answer;
                                answer=false;
                                for (int i=leftHand.values.size()-1;i>=0;i--){
                                    if (leftHand.values[i]>rightHand.values[i]){
                                       cout<<"left"<<endl;
                                       answer=true;
                                        break;
                                       }
                                    else if (leftHand.values[i]<rightHand.values[i]){
                                       cout<<"right"<<endl;
                                        answer=true;
                                        break;
                                       }
                                    }
                                if (!answer){
                                   cout<<"none"<<endl;
                                   break;
                                }
                                break;
                           case 6://Straight
                                if (leftHand.values[0]==2&&leftHand.values[1]==3&&leftHand.values[2]==4&&leftHand.values[3]==5&&leftHand.values[4]==14){
                                   if (rightHand.values[0]==2&&rightHand.values[1]==3&&rightHand.values[2]==4&&rightHand.values[3]==5&&rightHand.values[4]==14){
                                      cout<<"none"<<endl;
                                      break;
                                      }
                                   else 
                                        cout<<"right"<<endl;
                                        break;
                                   }
                                if (rightHand.values[0]==2&&rightHand.values[1]==3&&rightHand.values[2]==4&&rightHand.values[3]==5&&rightHand.values[4]==14){
                                   if (leftHand.values[0]==2&&leftHand.values[1]==3&&leftHand.values[2]==4&&leftHand.values[3]==5&&leftHand.values[4]==14){
                                      cout<<"none"<<endl;
                                      break;
                                      }
                                   else 
                                        cout<<"left"<<endl;
                                        break;
                                   }
                                if (leftHand.values[leftHand.values.size()-1]>rightHand.values[rightHand.values.size()-1]){
                                   cout<<"left"<<endl;
                                   break;
                                   }
                                else if (leftHand.values[leftHand.values.size()-1]<rightHand.values[rightHand.values.size()-1]){
                                   cout<<"right"<<endl;
                                   break;
                                   }
                                else{
                                     cout<<"none"<<endl;
                                     break;  
                                     }
                           case 7://Three of a Kind:
                                if (leftHand.getThree()>rightHand.getThree()){
                                   cout<<"left"<<endl;
                                   break;
                                   }
                                else if (leftHand.getThree()<rightHand.getThree()){
                                   cout<<"right"<<endl;
                                   break;
                                   }
                                else {
                                     int l=0;
                                     int r=0;
                                     int i = 2;
                                     while (i>0){
                                           for (int j=leftHand.values.size()-1;j>=0;j--){
                                               if (leftHand.values[j]!=leftHand.getThree()&&leftHand.values[j]!=l)
                                                  l=leftHand.values[j];
                                               }
                                           for (int j=rightHand.values.size()-1;j>=0;j--){
                                               if (rightHand.values[j]!=rightHand.getThree()&&rightHand.values[j]!=l)
                                                  l=rightHand.values[j];
                                               }
                                           if (l>r){
                                              cout<<"left"<<endl;
                                              break;
                                              }
                                           else if (l<r){
                                              cout<<"right"<<endl;
                                              break;
                                              }
                                           i--;
                                           }
                                     cout<<"none"<<endl;
                                     break;
                                     }
                           case 8://Two Pairs
                                if (leftHand.getTwoPairs()>rightHand.getTwoPairs()){
                                   cout<<"left"<<endl;
                                   break;
                                   }
                                else if (leftHand.getTwoPairs()<rightHand.getTwoPairs()){
                                   cout<<"right"<<endl;
                                   break;
                                   }
                                else if (leftHand.getOnePair()>rightHand.getOnePair()){
                                   cout<<"left"<<endl;
                                   break;
                                   }
                                else if (leftHand.getOnePair()<rightHand.getOnePair()){
                                   cout<<"right"<<endl;
                                   break;
                                   }
                                else {
                                     int l=0;
                                     int r=0;
                                     for (int j=leftHand.values.size()-1;j>=0;j--){
                                         if (leftHand.values[j]!=leftHand.getTwoPairs()&&leftHand.values[j]!=leftHand.getOnePair())
                                            l=leftHand.values[j];
                                            }
                                     for (int j=rightHand.values.size()-1;j>=0;j--){
                                         if (rightHand.values[j]!=rightHand.getTwoPairs()&&rightHand.values[j]!=rightHand.getOnePair())
                                            r=rightHand.values[j];
                                            }
                                     if (l>r){
                                        cout<<"left"<<endl;
                                        break;
                                        }
                                     else if (l<r){
                                          cout<<"right"<<endl;
                                          break;
                                          }
                                     else {
                                          cout<<"none"<<endl;
                                          break;
                                          }
                                     }
                           case 9://One Pair
                                if (leftHand.getOnePair()>rightHand.getOnePair()){
                                   cout<<"left"<<endl;
                                   break;
                                   }
                                else if (leftHand.getOnePair()<rightHand.getOnePair()){
                                     cout<<"right"<<endl;
                                     break;
                                     }
                                else {
                                     int l=0;
                                     int r=0;
                                     int i = 3;
                                     while (i>0){
                                           for (int j=leftHand.values.size()-1;j>=0;j--){
                                               if (leftHand.values[j]!=leftHand.getThree()&&leftHand.values[j]!=l)
                                                  l=leftHand.values[j];
                                               }
                                           for (int j=rightHand.values.size()-1;j>=0;j--){
                                               if (rightHand.values[j]!=rightHand.getThree()&&rightHand.values[j]!=r)
                                                  r=rightHand.values[j];
                                               }
                                           if (l>r){
                                              cout<<"left"<<endl;
                                              break;
                                              }
                                           else if (l<r){
                                              cout<<"right"<<endl;
                                              break;
                                              }
                                           i--;
                                           }
                                     cout<<"none"<<endl;
                                     break;
                                     }
                           case 10://High Card
                                answer = false;
                                for (int i=leftHand.values.size()-1;i>=0;i--){
                                    if (leftHand.values[i]>rightHand.values[i]){
                                       answer = true;                                                                                
                                       cout<<"left"<<endl;
                                       break;
                                       }
                                    else if (leftHand.values[i]<rightHand.values[i]){
                                       answer = true;
                                       cout<<"right"<<endl;
                                        break;
                                       }
                                    }
                                if (!answer){
                                   cout<<"none"<<endl;
                                   break;
                                   }
                                break;
                           }
                    }
           }
    }
}

int convert(char c){
    switch (c){
           case '2':
                return 2;
           case '3':
                return 3;
           case '4':
                return 4;
           case '5':
                return 5;
           case '6':
                return 6;
           case '7':
                return 7;
           case '8':
                return 8;
           case '9':
                return 9;
           case 'T':
                return 10;
           case 'J':
                return 11;
           case 'Q':
                return 12;
           case 'K':
                return 13;
           case 'A':
                return 14;
           }
    return 0;
    }
