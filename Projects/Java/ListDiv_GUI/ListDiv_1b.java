/*
    ListDivisors_1b.java GUI
*/
import javax.swing.*;
import java.awt.event.*;

public class ListDiv_1b extends JFrame 
{
    private JPanel myPanel;
    private JLabel msgLabel;
    private JTextField inputTF;
    private JButton clickBtn;

    public static void main(String[] args)
    {
        ListDiv_1b foo=new ListDiv_1b();
    }

    public ListDiv_1b()
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
        inputTF = new JTectField(10);
        clickBtn = new JButton("Click");
        clickBtn.addActionListener(new myBtnListener());
        myPanel = new JPanel();

        myPanel.add(msgLabel);
        msgPanel.add(inputTF);
        msgPanel.add(clickBtn);
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
                if (nr%i == 0){
                    System.out.print(" " +i);
                }
                System.out.println();
            }
        }
    }
}