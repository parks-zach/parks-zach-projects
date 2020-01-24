#include <iostream>
#include <cstring>
#include <string.h>
#include <fstream>
#include <sstream>

using namespace std;

void trans(string line);

int main() {
string line;


ifstream inputFile;

inputFile.open("in.txt");
if(!inputFile){
  cout << "Not able to open file";
  exit(1);
}

if(inputFile){
  while (getline(inputFile,line)){
    trans(line);
    cout << endl;
  }
  inputFile.close();
}
}

void trans(string line){
  int i;
  string w;
  
  ofstream output;
  output.open("out.txt", ios::app);
  
  string english[]={"commands", "are", "language","the", "our", "bless", "you"};

  string spanish[]={"comandos", "son", "idioma", "los","nuestro", "bendecir", "tu"};
  
  istringstream lft(line);
  lft >> w;
  do{
    for(i=0;i<(sizeof(english)/sizeof(english[0]));i++){
     if(strcmp(w.c_str(), english[i].c_str())==0){
       //cout<<spanish[i]<< " ";
       output<<spanish[i]<<" ";
     }
   }
  }while (lft >> w);
  
  output << "\n";
  output.close();
}
