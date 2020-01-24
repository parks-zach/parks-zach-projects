#include <iostream>
#include <cstring>
#include <string.h>
#include <fstream>
using namespace std;

int main() {
  char sentence[100];
  int i;
  ifstream inputFile ("englishinput.txt", ios::in);
  ofstream outputFile ("spanishoutput.txt", ios::out);


  char *english[]={"commands", "are", "language","the", "our", "bless", "you"};

  char *spanish[]={"comandos", "son", "idioma", "los","nuestro", "bendecir", "tu"};

  if(inputFile.is_open()){
    
    while(1){
     cin.getline(sentence, sizeof(sentence));

     //for(i = 0; i<lengthw;i++){
       for(i=0;i<(sizeof(english)/sizeof(english[0]));i++){
         if(strcmp(sentence, english[i])==0){
           outputFile<<spanish[i]<< " ";
         }
        }
      }
      outputFile.close();
  }
  inputFile.close();
};

