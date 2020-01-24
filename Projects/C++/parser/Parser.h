#ifndef PARSER_H
#define PARSER_H
/**   Name: Zach Parks
      Date: Oct 16, 2019
      Desc: Class to recognize and parse a language.  See Parser.cpp for language specifics.
      */
#include <iostream>
#include <string>

using namespace std;


class Parser{
  public:
  Parser() {
  }
  
  bool parser(string s);
  bool expr(string s);
  bool digit(string s);
  int eval(string s);
  int nodeCount(string s);
};

#endif