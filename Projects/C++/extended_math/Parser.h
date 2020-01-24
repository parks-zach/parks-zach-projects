#ifndef PARSER_H
#define PARSER_H  

/*   File: Parser.h
      Name: Zach Parks
      Date: Nov 4, 2019
      Desc: Classes to support the Parser class, which builds and evaluates 
            mathematical expressions from a string.  
     
*/

#include <string>


using namespace std;

class Base{
  public:
  virtual ~Base(){};
  virtual int eval(){
    cout << "Not defined!" << endl;
    return -1;
  }
  virtual int nodeCount(){
    return -1;
  }
};


class Parser{
public:
  Parser();
  
  void trimL(string &s);
  void trimR(string &s);
  
  bool parse(string s);
  int eval();
  int nodeCount();
  

private:
  Base* head;
  Base* Exp(string s);
  Base* Val(string s);
};

class Operator: public Base{
  public:
    Operator(Base* left, char o, Base* right){
      this->op = o;
      this->left = left;
      this->right = right;
    }
    char op;
    Base* left;
    Base* right;
    int eval(){ 
      if(op == '+')return left->eval() + right->eval();
      if(op == '-')return left->eval() - right->eval();
      if(op == '*')return left->eval() * right->eval();
      if(op == '/')return left->eval() / right->eval();
      if(op == '%')return left->eval() % right->eval();
      if(op == '^')return pow(left->eval(),right->eval());
      cout << "NOT IMPLEMENTED: " <<  op << endl;
      return -1;
    }
    int nodeCount(){
      return left->nodeCount() + right->nodeCount() + 1;
    }

};

class Value: public Base{
  public:
    Value(string digits){
      value = stoi(digits);
    }
    int value;
    int eval(){return value;}
    int nodeCount(){return 1;}
};
  
#endif