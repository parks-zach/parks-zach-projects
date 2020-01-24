import javax.swing.*;      // needed for swing classes
import java.awt.event.*;    // needed for 'events'
import java.awt.*;         // needed for 'color'


public class Main extends JFrame {
    private JPanel myPanel;
    private JLabel msgLabel;
    private JTextField inputTF;
    private JTextArea outputTA;
    private JButton clickBtn;
    private JScrollPane scroller;

    public static void main(String[] args) {
        Main foo = new Main();
    }

    public Main() {
        setTitle("List Divisors");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildPanel();
        add(myPanel);
        setVisible(true);
    }

    private void buildPanel() {
        msgLabel = new JLabel("Enter a number ");
        inputTF = new JTextField(5);

        outputTA = new JTextArea(10, 10);
        scroller = new JScrollPane (outputTA);
        //scroller.setPreferredSize (new Dimension(50,50));

        clickBtn = new JButton("Click");
        clickBtn.addActionListener(new myBtnListener());
        myPanel = new JPanel();

        myPanel.add(msgLabel);
        myPanel.add(inputTF);
        myPanel.add(outputTA);
        myPanel.add(clickBtn);
        myPanel.add(scroller);
    }  //end of buildPanel();

    private class myBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input;
            int num;

            input = inputTF.getText();
            num = Integer.parseInt(input);

            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    String iStr = Integer.toString(i);
                    outputTA.append(" "+ iStr);
          myPanel.setBackground(Color.RED);
          outputTA.setForeground(Color.GREEN);
                }
            System.out.println();
            }
        }
    }
}