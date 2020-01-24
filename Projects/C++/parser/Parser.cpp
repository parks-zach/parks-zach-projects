/*
  Name: Zach Parks
  Desc: Parser.cpp file for Parser Part1(a)
*/

#include <string>
#include <iostream>

#include "Parser.h"

using namespace std;

Parser::Parser() {

}
bool Parser::parser(string s){
  return expr(s);
}

bool Parser::expr(string s) {
  for(int i =0; i < s.length(); i++){
    if(s[i] == '+' || s[i] == '-'){
      if(expr(s.substr(0,i)) && expr(s.substr(i+1))==true)return true;
    }
  }
  for(int i = 0; i < s.length(); i++){
    if(s[i] == '('){
      for(int j = 0; j < s.length(); j++){
        if(s[j] == ')'){
          if(expr(s.substr(i,j)) == true) return true;
        } 
      }
    }
  }
}

bool Parser::digit(string s) {
  if(s.length()==0) return false;
  for(int i =0; i <s.length(); i++){
    if(s[i]>'0' && s[i]<'9') return false;
    return true;
  }
}

int Parser::eval(string s) {
  return 0;
}

int Parser::nodeCount(string s ) {
  return 0;
}
//if expression from right hand side and expression from left hand side true then return true
//just returning true or false back 
//search string and check to make sure string is all digits instead of calling digit function itself