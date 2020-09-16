package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Dylan Kiss
 */

public class ScrollDemo {
	
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    JFrame myFrame = new JFrame("Demo");
                    JPanel sideBar = new JPanel();
                    JPanel centerPanel = new JPanel();
                    centerPanel.add(new JLabel("This is the center panel."));

                    JPanel buttonContainer = new JPanel();
                    buttonContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                    JButton myButton = null;

                    for (int i = 0; i < 20; i++) 
                    {
                        buttonContainer.setLayout(new GridLayout(20, 1, 0, 0));
                        myButton = new JButton("This is my button nr. " + i);
                        buttonContainer.add(myButton);
                    }

                    sideBar.setLayout(new BorderLayout(0, 0));

                    JScrollPane scrollPane = new JScrollPane(buttonContainer);      

                    sideBar.add(scrollPane);

                    myFrame.getContentPane().add(sideBar, BorderLayout.WEST);
                    myFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);

                    myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    myFrame.pack();
                    myFrame.setLocationByPlatform(true);
                    myFrame.setVisible(true);
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }
}