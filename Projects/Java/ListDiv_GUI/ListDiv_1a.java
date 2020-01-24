/*
    ListDivisors_1a.java GUI
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
        ListDiv_1a foo=new ListDiv_1a();
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
        inputTF = new JTectField(10);
        clickBtn = new JButton("Click");
        myPanel = new JPanel();

        myPanel.add(msgLabel);
        msgPanel.add(inputTF);
        msgPanel.add(clickBtn);
    }

        // int nr;
        // Scanner keybd = new Scanner(System.in);
        // System.out.print("Enter a number: ");
        // nr = keybd.nextInt();
        
        // System.out.print("\nThe divisiors of " +nr+" are: ");

    
}