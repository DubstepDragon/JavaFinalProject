package finalproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border.*;
import javax.swing.BorderFactory;


public class MainWindow extends JFrame
{
  JPanel graphicsContainer;
  
  public MainWindow()
  {
    super("Final Project Window");

    graphicsContainer = new JPanel();
    graphicsContainer.setBorder(BorderFactory.createRaisedBevelBorder());
    Container frameContainer = this.getContentPane();
    frameContainer.add(graphicsContainer,BorderLayout.CENTER);

    this.addWindowListener(
      new WindowAdapter() {
        public void windowClosing( WindowEvent e )
        {
          System.exit( 0 );
        }
      }
    );

  }//end constructor
  
  public void update()
  {   
      this.pack();
      this.setSize(400,300);
      this.setVisible(true);
  }
  
  public void myAdd(Component comp)
  {
      this.graphicsContainer.add(comp);
  }
  
  
}//end class


