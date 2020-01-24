#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Feb 28 12:01:41 2019

@author: zach
"""

from tkinter import *
from random import *

colors = ['green','white','black','blue','khaki']

def setSpeed(event = None):
  global master
  global e
  global go
  global delay
  delay = int(e.get())
  print(delay)
  if not go:
    go = True
    master.after(1000, changeColor)

def changeColor():
  global master
  global delay
  global go
  master.configure(background=colors[randint(0,len(colors)-1)])
  if go:
    print(delay)
    master.after(delay, changeColor)

def stop(event = None):
  global go
  go = not go

master = Tk()
delay = 500
go = False

#box = Label(master, text="There is text here")
#box.grid(column=0, row=0)

e = Entry(master)
e.grid(column = 0, row = 0)
e.insert(0, str(delay))

for i in range(1,20):
  box2 = Label(master, text="here")
  box2.grid(column=i, row=i)

b1 = Button(master, text="Set speed")
b1.grid(column=1,row=0)
b1.bind('<Button>', setSpeed)

b2 = Button(master, text="STOP!!!!!")
b2.grid(column=2,row=0)
b2.bind('<Button>', stop)





mainloop()