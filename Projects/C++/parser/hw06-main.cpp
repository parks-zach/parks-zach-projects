/**
 * Name: Zach Parks
 * Date: 10/23/19
 * Desc: Main file for parser.cpp and parser.h for part a
 * */
#include <iostream>
#include <string>

#include "Parser.h"

using namespace std;

int main(){
    string input;
    cout << ">";
    //cin >> input
    getline(cin, input);
    Parser p;
    while(input != "quit"){
        if(p.parser(input)){
            cout << "Accepted!" << endl;
        } else {
            cout << "Not Accepted!" << endl;
        }
        cout << ">";
        getline(cin, input);
    }
}