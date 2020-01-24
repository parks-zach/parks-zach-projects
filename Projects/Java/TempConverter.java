package com.company;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

/**
 This class displays a window with a   slider component.
 The user  can convert    the rate    temperatures from
 0 through 100 to rateAmount by moving the slider.
 */

public class TempConverter extends JFrame
{
    private JLabel label1, label2,label3,label4;      // Message labels
    private JTextField total_cost; // rateAmount temp
    private JTextField sales_cost;// rate temp
    private JTextField Sales_tax;
    private JTextField rates;
    private JMenuCheckBox;
    private JMenu
    private JPanel fpanel;            // rateAmount panels
    private JPanel cpanel;            // rate panel
    private JPanel rpanel;
    private JPanel spanel;
    private JPanel sliderPanel;     // Slider    panel
    private JSlider slider;            // Temperature adjuster

    /**
     Constructor
     */

    public TempConverter()
    {
        // Set the title.
        setTitle("Taxes");

        // Specify an action  for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the message labels.
        label1 =   new JLabel("Total Cost: ");
        label2 =   new JLabel("Rate: ");
        label3= new JLabel("Sales Tax:");
        label4= new JLabel("Sales Cost:");

        // Create the read-only   text fields.
        total_cost = new  JTextField("32.0", 10);
        total_cost.setEditable(true);
        sales_cost    = new  JTextField("0.0",  10);
        sales_cost.setEditable(false);
        Sales_tax= new JTextField("0.0",10);
        Sales_tax.setEditable(false);
        rates= new JTextField("0.0",10);
        rates.setEditable(false);


        // Create the slider.
        slider =   new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        slider.setMajorTickSpacing(10); // Major tick every 20
        slider.setMinorTickSpacing(2);  // Minor tick every 5
        slider.setPaintTicks(true);      // Display tick  marks
        slider.setPaintLabels(true);     // Display numbers
        slider.addChangeListener(new SliderListener());

        // Create panels and  place  the components in them.
        fpanel =   new JPanel();
        fpanel.add(label1);
        fpanel.add(total_cost);
        rpanel= new JPanel();
        rpanel.add(label2);
        rpanel.add(rates);
        spanel= new JPanel();
        spanel.add(label3);
        spanel.add(Sales_tax);
        cpanel =   new JPanel();
        cpanel.add(label4);
        cpanel.add(sales_cost);
        sliderPanel    = new  JPanel();
        sliderPanel.add(slider);

        // Create a   GridLayout manager.
        setLayout(new GridLayout(3, 1));

        // Add the panels to the content    pane.
        //TODO: Add fpanel, cpanel,slider panel
        add(fpanel);
        add(rpanel);
        add(spanel);
        add(cpanel);
        add(sliderPanel);

        // Pack and   display the    frame.
        pack();
        setVisible(true);
    }

    /**
     Private inner class to handle the change events
     that are  generated when the slider is moved.
     */

    private class SliderListener implements ChangeListener
    {
        public void    stateChanged(ChangeEvent e)
        {
            double rateAmount, rate,purchase,total;
            purchase=Double.parseDouble(total_cost.getText());
            // Get the slider value.
            rate = slider.getValue();

            // Convert the    value  to rateAmount.
            rateAmount = purchase*(rate/100);
            total= purchase+rateAmount;


            // Store  the rate    temp in its    display field.
            //TODO: set Text of sales_cost with rate variable
            rates.setText(String.format("%.1f", rate));

            // Store  the rateAmount temp in its    display field.
            Sales_tax.setText(String.format("%.1f",   rateAmount));
            sales_cost.setText(String.format("%.1f",total));
        }
    }

   /*
      The main   method creates an instance   of the
      class, which displays a    window with    a slider.
   */

    public static void main(String[]   args)
    {
        new TempConverter();
    }
}

/**
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


   The MenuWindow class demonstrates a menu system.


public class MenuWindow extends JFrame
{
    private JLabel messageLabel; // Displays a message
    private final int LABEL_WIDTH = 400;  // Label's width
    private final int LABEL_HEIGHT = 200; // Label's height

    // The following will reference menu components.
    private JMenuBar menuBar;    // The menu bar
    private JMenu fileMenu;      // The File menu
    private JMenu textMenu;      // The Text menu
    private JMenuItem exitItem;  // To exit
    private JRadioButtonMenuItem blackItem; // Makes text black
    private JRadioButtonMenuItem redItem;   // Makes text red
    private JRadioButtonMenuItem blueItem;  // Makes text blue
    private JCheckBoxMenuItem visibleItem;  // Toggle visibility


     Constructor


    public MenuWindow()
    {
        // Set the title.
        setTitle("Example Menu System");

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the messageLabel label.
        messageLabel = new JLabel("Use the Text menu to " +
                "change my color and make me invisible.",
                SwingConstants.CENTER);

        // Set the label's preferred size.
        messageLabel.setPreferredSize(
                new Dimension(LABEL_WIDTH, LABEL_HEIGHT));

        // Set the label's foreground color.
        messageLabel.setForeground(Color.black);

        // Add the label to the content pane.
        add(messageLabel);

        // Build the menu bar.
        buildMenuBar();

        // Pack and display the window.
        pack();
        setVisible(true);
    }


     The buildMenuBar method builds the menu bar.


    private void buildMenuBar()
    {
        // Create the menu bar.
        menuBar = new JMenuBar();

        // Create the file and text menus.
        //TODO: call buildFileMenu and buildTextMenue methods

        // Add the file and text menus to the menu bar.
        //TODO: add fileMenu, and textmenu to the menuBar

        // Set the window's menu bar.
        setJMenuBar(menuBar);
    }


     The buildFileMenu method builds the File menu
     and returns a reference to its JMenu object.

    private void buildFileMenu()
    {
        // Create an Exit menu item.
        exitItem = new JMenuItem("Exit");
        //TODO: set Mnemonic property of exitItem with Alt+X
        exitItem.addActionListener(new ExitListener());

        // Create a JMenu object for the File menu.
        fileMenu = new JMenu("File");
        //TODO: set Mnemonic property of fileMenu with Alt+F


        // Add the Exit menu item to the File menu.
        fileMenu.add(exitItem);
    }


     The buildTextMenu method builds the Text menu
     and returns a reference to its JMenu object.

    private void buildTextMenu()
    {
        // Create the radio button menu items to change
        // the color of the text. Add an action listener
        // to each one.
        blackItem = new JRadioButtonMenuItem("Black", true);
        blackItem.setMnemonic(KeyEvent.VK_B);
        blackItem.addActionListener(new ColorListener());

        redItem = new JRadioButtonMenuItem("Red");
        redItem.setMnemonic(KeyEvent.VK_R);
        redItem.addActionListener(new ColorListener());

        blueItem = new JRadioButtonMenuItem("Blue");
        blueItem.setMnemonic(KeyEvent.VK_U);
        blueItem.addActionListener(new ColorListener());

        // Create a button group for the radio button items.
        ButtonGroup group = new ButtonGroup();
        //TODO: Add black, red, blue items to the group


        // Create a check box menu item to make the text
        // visible or invisible.
        visibleItem = new JCheckBoxMenuItem("Visible", true);
        visibleItem.setMnemonic(KeyEvent.VK_V);
        visibleItem.addActionListener(new VisibleListener());

        // Create a JMenu object for the Text menu.
        textMenu = new JMenu("Text");
        textMenu.setMnemonic(KeyEvent.VK_T);

        // Add the menu items to the Text menu.
        //TODO: Add black, red, blue items to the textMenu
        textMenu.addSeparator(); // Add a separator bar.
        textMenu.add(visibleItem);
    }


     Private inner class that handles the event that
     is generated when the user selects Exit from
     the File menu.

    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }


     Private inner class that handles the event that
     is generated when the user selects a color from
     the Text menu.


    private class ColorListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (blackItem.isSelected())
                messageLabel.setForeground(Color.black);
            else if (redItem.isSelected())
                messageLabel.setForeground(Color.red);
            else if (blueItem.isSelected())
                messageLabel.setForeground(Color.blue);
        }
    }


     Private inner class that handles the event that
     is generated when the user selects Visible from
     the Text menu.


    private class VisibleListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (visibleItem.isSelected())
                messageLabel.setVisible(true);
            else
                messageLabel.setVisible(false);
        }
    }


     The main method creates an instance of the
     MenuWindow class, which causes it to display
     its window.


    public static void main(String[] args)
    {
        new MenuWindow();
    }
}

 */