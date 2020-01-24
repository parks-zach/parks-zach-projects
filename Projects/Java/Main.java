package com.company;
import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private static double package1;
    private static double package2;
    private static double package3;
    private static double phone1;
    private static double phone2;
    private static double phone3;
    private static double voicemail;
    private static double texting;

    private JTextField total_cost;

    private JButton clickBtn;
    private JButton exitBtn;

    private JPanel myPanel;

    private JCheckBox p1;
    private JCheckBox p2;
    private JCheckBox p3;
    private JCheckBox ph1;
    private JCheckBox ph2;
    private JCheckBox ph3;
    private JCheckBox v;
    private JCheckBox t;


    public static void main(String[] args) {
        Main foo= new Main();
    }

    public Main(){
        setTitle("Joe's Repairs");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(myPanel);
        setVisible(true);
    }
    private void buildPanel(){
        JLabel package1 = new JLabel("Oil Change");
        p1= new JCheckBox();
        JLabel package2 = new JLabel("Lube Job");
        p2= new JCheckBox();
        JLabel package3 = new JLabel("Radiator Flush");
        p3= new JCheckBox();
        JLabel phone1 = new JLabel("Transmission Flush");
        ph1 = new JCheckBox();
        JLabel phone2 = new JLabel("Inspection Cost");
        ph2= new JCheckBox();
        JLabel phone3 = new JLabel("Muffler Replacement");
        ph3= new JCheckBox();
        JLabel voicemail = new JLabel("Tire Rotation");
        v= new JCheckBox();
        JLabel texting = new JLabel("Other");
        t= new JCheckBox();
        JLabel cost= new JLabel("Total");
        total_cost= new JTextField(10);

        exitBtn= new JButton("Exit");
        exitBtn.addActionListener(new Main.exitBtnListener());
        clickBtn = new JButton("Calculate");
        clickBtn.addActionListener(new Main.myBtnListener());

        myPanel= new JPanel();

        myPanel.add(package1);
        myPanel.add(p1);
        myPanel.add(package2);
        myPanel.add(p2);
        myPanel.add(package3);
        myPanel.add(p3);
        myPanel.add(phone1);
        myPanel.add(ph1);
        myPanel.add(phone2);
        myPanel.add(ph2);
        myPanel.add(phone3);
        myPanel.add(ph3);
        myPanel.add(voicemail);
        myPanel.add(v);
        myPanel.add(other_jobs);
        myPanel.add(other);
        myPanel.add(clickBtn);
        myPanel.add(exitBtn);
        myPanel.add(cost);
        myPanel.add(total_cost);

    }
    private class myBtnListener extends Component implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            float amount=0;

            if(p1.isSelected()){
                amount+=26;
            }
            if(p2.isSelected()){
                amount+=18;
            }
            if(p3.isSelected()){
                amount+=30;
            }
            if(ph1.isSelected()){
                amount+=80;
            }
            if(ph2.isSelected()){
                amount+=15;
            }
            if(ph3.isSelected()){
                amount+=100;
            }
            if(v.isSelected()){
                amount+=20;
            }
            if(other.isSelected()){
                amount+=20;
            }
            total_cost.setText(getWarningString().valueOf(amount));

        }
    }
    private class exitBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            System.exit(0);
        }
    }

}
