"""
Created on Tue Feb 26 09:27:11 2019

@author: Zach Parks
"""
import socket
import threading
from tkinter import *

port = 5555 #  Send to port above 1024
#host = socket.gethostname()
host = '10.18.101.97'

def sendMessage(socket, destination,  message, label):
  socket.sendto( message.encode('ascii'), destination)

def receiveMessage(socket, label):
  global stop
  while True:
    try:
      (msg, addr) = socket.recvfrom(1024)
    except:
      if stop:
        print("Thread stopping")
        return
      continue
    label['text'] = msg.decode('ascii') + '\n' + label['text']
    
master = Tk()
stop = False

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.settimeout(1)

response = Label(master, text=".")
response.grid(column = 0, row=1)

e = Entry(master)
e.grid(column = 0, row = 0)
e.insert(0, "type stuff here")
e.bind('<Return>', lambda _: sendMessage(s, (host, port), e.get(), response))

b1 = Button(master, text="Send it!")
b1.grid(column=5,row=0)
b1.bind('<Button>', lambda _: sendMessage(s, (host, port), e.get(), response))

thread = threading.Thread(target = receiveMessage, args = (s, response))
thread.start()

#while True:
#  message = input("What do you want to send?")
#  s.sendto( message.encode('ascii'), (host, port))
#  print("Message Sent!")
#  (msg, addr) = s.recvfrom(1024)
#  print("Got {} back".format(msg.decode('ascii')))

try:
  mainloop()
except:
  pass
stop = True