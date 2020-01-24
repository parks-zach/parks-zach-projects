/*
    ListDivisors_textArea_but_GUI_1a.java
*/

import javax.swing.*;
import java.awt.event.*;

public class ListDiv_1a extends JFrame 
{
    private JPanel myPanel;
    private JLabel msgLabel;
    private JTextField inputTF;
    private JButton clickBtn;

    public static void main(String[] args)
    {
        ListDiv_1b foo=new ListDiv_1a();
    }

    public ListDiv_1a()
    {
        setTitle ("List Divisors");
        setSize (300, 100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildPanel();
        add(myPanel);
        setVisible(true);
    }

    private void buildPanel()
    {
        msgLabel = new JLabel ("Enter a number: ");
        inputTF = new JTectField(5);
        outputTA = new JTextArea(10,10);
        clickBtn = new JButton("Click");
        clickBtn.addActionListener(new myBtnListener());
        myPanel = new JPanel();

        myPanel.add(msgLabel);
        msgPanel.add(inputTF);
        msgPanel.add(clickBtn);
        msgPanel.add(outputTA);
    } //end of build panel

    private class myBtnListener implements ActionListener 
    {
        public void actionPerformed (ActionEvent e)
        {
            String input;
            int num;

            input = inputTF.getText();
            nr = Integer.parseInt(input);

            for(int i=1; i <= nr; i++){
                if (nr%i == 0)
                {
                    String iStr=Integer.toString(i);
                    outputTA.append(" "+iStr);
                }
            }
            System.out.println();
        }
    }
}