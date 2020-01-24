/*
Name: Zach Parks
Desc: CSCI 350 - Programming Languages – HW 5 
L0 = (000)*1   Any bit string with 0 or more groups of 000, ending with a 1.
Date: 11:55PM Monday Sept 21 
*/

#include <string>
#include <iostream>

using namespace std;
bool A (string);
bool B (string);
int main(){
  cout << "-Enter Exit when you are ready to quit-" << endl;
  cout << "-Enter 0 or 1 Binary strings-" << endl;
   cout << " -1 = Accepted && 0 = Not Accepted-" << endl;
  while(1){
     

    string Input;
    cin>> Input;

    

    if(Input == "Exit"){
      return 0;
    }else{
      bool out = A(Input);
      cout << out << endl;
      
    }
  }
}


// A -> 00A
bool A(string s){
  if(s.length() == 1)return B(s);
  if(s.length() >= 3 && s.substr(0,3) == "000")return A(s.substr(3));
  return false;
}

// B -> 1B
bool B(string s){
  if(s.length() == 1 && s == "1")return true ;
  return false;
}