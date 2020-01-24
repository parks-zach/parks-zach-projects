package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;


public class SavingsAccount extends JFrame
{
    private JPanel panel;             // To reference a panel

    private JTextField depositText;
    private JTextField interestText;
    private JTextField monthsText;
    private JTextField balanceText;

    private JLabel label1;      // To reference a label
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;

    private JButton calculateButton;
    private JButton exitButton;

    private final int WINDOW_WIDTH = 510;  // Window width
    private final int WINDOW_HEIGHT = 300; // Window height

    private static double deposit;
    private static double interest;
    private static double months;
    private static double balance;


    public SavingsAccount()
    {
        setTitle("Savings Account");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();

        label1 = new JLabel("Monthly Deposit");
        label2= new JLabel("Yearly Interest");
        label3 = new JLabel("Number of Months");
        label4 = new JLabel("Final Balance");

        depositText = new JTextField(10);
        interestText = new JTextField(10);
        monthsText = new JTextField(10);
        balanceText = new JTextField(10);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalcButtonListener());
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitButtonListener());

        panel.add(label1);
        panel.add(depositText);
        panel.add(label2);
        panel.add(interestText);
        panel.add(label3);
        panel.add(monthsText);
        panel.add(label4);
        panel.add(balanceText);
        panel.add(calculateButton);
        panel.add(exitButton);

        add(panel);

        setVisible(true);
    }

    private class ExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            System.exit(0);
        }
    }

    private class CalcButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == calculateButton)
            deposit = Double.parseDouble(depositText.getText());
            interest = Double.parseDouble(interestText.getText());
            months = Double.parseDouble(monthsText.getText());
            balance = deposit * (Math.pow((1 + interest), months) - 1) / interest;
            if(balance < 0 || interest < 0) {
                balanceText.setText("Invalid Input");
            } else {
                balanceText.setText(String.valueOf(balance));
            }
        }
    }


    public static void main(String[] args)
    {
        new SavingsAccount();
    }
}