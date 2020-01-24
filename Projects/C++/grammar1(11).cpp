
//Language L3 = {1,111,11111....}
//Alphabet = {0,1}
//Grammar is: A > B1 | 1
//            B > A1 | 1
//Exple to generate 11111
//a > b > a11 -> b111 > a1111 > 11111





#include <iostream>
#include <cstring>
using namespace std;

const char ZERO = '0';
const char ONE = '1';
#define BELONGS cout <<"Yes it belongs to out language" << endl;
#define DNBELONG cout << "No it does not belong to our language" << endl;

void A(char *exp, char *p);
void B(char *exp, char *p);

int main()
{
    char binaryNr[100];
    char *p;

    while(1)
    {
        cout << "\nEnter a binary number (0 or 1): ";
        cin.getline(binaryNr, 100);

        p = binaryNr + strlen(binaryNr)-1;

        A (binaryNr, p);

    }
    cout << endl << endl;
}

void A(char *exp, char *p)
{
    if(p == exp)
    {
        if (*p == ONE)
        {
            BELONGS;
            return;
        }
        else
        {
            DNBELONG;
            return;
        }
    }
    else if(*p == ZERO)
    {
        DNBELONG;
        return;
    }
    else if (*p == ONE)
    {
        p--;
        B(exp, p);
    }
}

void B(char *exp, char *p)
{
    if(p == exp)
    {
        if (*p == ONE)
        {
            DNBELONG;
            return;
        }
        else
        {
            DNBELONG;
            return;
        }
    }
    else if(*p == ZERO)
    {
        DNBELONG;
        return;
    }
    else if (*p == ONE)
    {
        p--;
        A(exp, p);
    }
}