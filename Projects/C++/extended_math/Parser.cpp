/*   File: Parser.cpp
      Name: Zach Parks
      Date: Nov 4, 2019
      Desc: See Parser.h  
     
*/

#include <string>
#include <iostream>

#include "Parser.h"


using namespace std;

Parser::Parser(){
  head = NULL;
}

bool Parser::parse(string s){
  head = Exp(s);
  return head != NULL;
}

int Parser::nodeCount(){
  if(head)return head->nodeCount();
  return -1;
}

int Parser::eval(){
  if(head)return head->eval();
  return -1;
}

void Parser::trimL(string &s){
  if(s.length() > 0 && s[0] == ' '){
    s = s.substr(1);
    trimL(s);
  }
}

void Parser::trimR(string &s){
  if(s.length() > 0 && s[s.length()-1] == ' '){
    s = s.substr(0,s.length()-1);
    trimR(s);
  }
}

// Exp -> Exp + Exp | Exp - Exp | (Exp) | Val 
Base* Parser::Exp(string s){
  trimL(s);
  trimR(s);
  Base* temp1 = NULL;
  Base* temp2 = NULL;
  //cout << "exp: " << s << endl;
  // Paren
  
  if(s.length() >=2 && s[0] == '(' && s[s.length() - 1] == ')' && (temp1 = Exp(s.substr(1,s.length()-2)))){
    return temp1;  // no wrapping of node needed!
  }
  
  // Plus
  size_t pos = s.find("+");
  while(pos != string::npos){
    //cout << "Found + [" << s.substr(0,pos) << "][" << s.substr(pos+1) << "]" << endl;
    if( (temp1 = Exp(s.substr(0,pos))) && (temp2 = Exp(s.substr(pos+1)))){
      return new Operator(temp1, '+', temp2);
    } 
    pos = s.find("+",pos + 1);
  }
  // Minus
  pos = s.find("-");
  while(pos != string::npos){
    //cout << "Found -" << endl;
    if( (temp1 = Exp(s.substr(0,pos))) && (temp2 = Exp(s.substr(pos+1)))){
      return new Operator(temp1, '-', temp2);
    } 
    pos = s.find("-",pos + 1);
  }

  //Multiply
  size_t pos = s.find("*");
  while(pos != string::npos){
    if( (temp1 = Exp(s.substr(0,pos))) && (temp2 = Exp(s.substr(pos+1)))){
      return new Operator(temp1, '*', temp2);
    } 
    pos = s.find("*",pos + 1);
  }

  //Divide
  size_t pos = s.find("/");
  while(pos != string::npos){
    if( (temp1 = Exp(s.substr(0,pos))) && (temp2 = Exp(s.substr(pos+1)))){
      return new Operator(temp1, '/', temp2);
    } 
    pos = s.find("/",pos + 1);
  }

  //Modulus
  size_t pos = s.find("%");
  while(pos != string::npos){
      if( (temp1 = Exp(s.substr(0,pos))) && (temp2 = Exp(s.substr(pos+1)))){
          return new Operator(temp1, '%', temp2);
      }
  }

  //Power
  size_t pos = s.find("^");
  while(pos != string::npos){
      if( (temp1 = Exp(s.substr(0,pos))) && (temp2 = Exp(s.substr(pos+1)))){
          return new Operator(temp1, '^', temp2);
      }
  }
  // Val
  if( (temp1 = Val(s)) )return temp1; // no wrapping of node needed

  return NULL;
}

// Val -> numerics
Base* Parser::Val(string s){
  trimL(s);
  trimR(s);
  if(s.length() == 0)return NULL;
  for(int i = 0; i < s.length(); i++){
    if(s[i] < '0' ||
       s[i] > '9')return NULL;
  }
  return new Value(s);
} 