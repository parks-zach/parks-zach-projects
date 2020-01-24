#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Feb 28 10:52:40 2019

@author: zach
"""
from random import *
from tkinter import *
import time

def b1clicked(event):
    global box
    global b1
    global b2
    global master
    global delay
    global go
    print("Game started")
    b1.grid_forget()
    b2.grid(column = 10, row = 10)
    if not go:
        go = True
        master.after(delay,changeColor)

def b2clicked(event):
    global box
    global b2
    global master
    global stop
    global total_time
    stop
    display_time = str(total_time)
    label.grid_remove()
    time_label.grid(column = 10, row = 2)
    time_label['text'] = label['text'] + display_time

def b3clicked(event):
    global master
    global go
    global start
    global stop
    print("Reset application")
    master.configure(background = 'White')
    b2.grid_forget()
    b1.grid(column = 10, row = 10)
    label.grid(column = 10 , row = 2)
    time_label['text'] = " " 
    time_label.grid_remove()
    go = False
    start = time.process_time()
    stop = time.process_time()

def changeColor():
    global b1
    global master
    global delay
    global go
    global start
    master.configure(background = 'Red')
    if go:
        go = False
        start

master = Tk()
master.configure(background = 'White')
delay = randint(1000,2500)
go = False
start = time.process_time()
stop = time.process_time()
total_time = stop - start

for i in range(1,20):
  box = Label(master, text="  ")
  box.grid(column=i, row=i)

label = Label(master, text = "Your reaction time is: ")
label.grid(column = 10, row = 2)


time_label = Label(master, text = " ")
time_label.grid(column = 10, row = 2)

b1 = Button(master, text="Click To Start", width = 40, height = 20)
b1.grid(column=10, row=10)
b1.bind('<Button>',b1clicked)

b2 = Button(master, text='Click When Background Red', width = 40, height = 20)
b2.bind('<Button>', b2clicked)

b3 = Button(master, text = 'Reset', width = 5, height = 2)
b3.grid(column = 10, row = 15)
b3.bind('<Button>', b3clicked)

mainloop()