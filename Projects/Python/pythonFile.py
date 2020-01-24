#Name: Zachary Parks
#Date: 02/01/2019
#Description: Functions made in python

def hello(n, i):
    print(n * i)

def sumChars(n):
    int counter = 0
    for(char ch:n):
        value = ord(char)
        counter += value
    print(SUM)

def isPrime(n):
    if(n % 2 == 0):
        return False
    return True

def caesarEncrypt(n, i):
    bring_back = ""
    for i in range(len(string)):
        if ((ord(string[n]) % ord('a')) >= 0 and (ord(string[n]) % ord('a')) < 26):
            bring_back += (chr(((ord(string[n]) % ord('a') + number) % 26) + ord('a')))
        elif((ord(string[n]) % ord('A')) >= 0 and (ord(string[n]) % ord('A')) < 26):
            bring_back += (chr(((ord(string[n]) % ord('A') + number) % 26) + ord('A')))
        else:
            bring_back += string[i]

    return ret
print(caesarEncrypt('Xy Z.',1))

def characterStats(file_name):
    file_object = open(filename, "r")
    letter = [0] * 26
    string = file.read()
    for n in range(len(string)):
        counter = ord(string[n].capitalize()) - ord("A")
        word[counter] += 1
    for n in range(26):
        print(chr(ord("A") + i), word[n])
    return word
        
