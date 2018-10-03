package finalproject;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class MyButton extends JPanel
{
    boolean buttonDown;
    
  public MyButton()
  {
    super();
    
    this.buttonDown = false;
    this.setPreferredSize(new Dimension(50,50));
    
    //ADD CODE HERE: that adds a mouse listener to 'this'
    //     -Use an anonymous inner class that extends MouseAdapter
    //     -Inside this anonymous inner class, implement mousePressed() and mouseReleased()
    //     -When the mouse is pressed, set buttonDown to true and call MyButton.this.repaint() to repaint
    //     -When the mouse is released, set buttonDown to false and call MyButton.this.repaint() to repaint

    this.addMouseListener(
        new MouseAdapter() {
            
            public void mousePressed(MouseEvent e)
            {
                buttonDown = true;
                MyButton.this.repaint();
            }
            
            
            public void mouseReleased(MouseEvent e)
            {
                buttonDown = false;
                MyButton.this.repaint();
            }
        }
    );
    
    
    
  }//end constructor.

  public void paint(Graphics g)
  {
    Dimension di = this.getSize();
    g.clearRect(0,0,(int)di.getWidth(),(int)di.getHeight());
    g.drawRect(0,0,(int)di.getWidth()-1,(int)di.getHeight()-1);

    //ADD CODE HERE: that will draw a green circle when buttonDown is false and a red circle if buttonDown is true
    if(buttonDown == true)
    {   
        g.setColor(Color.red);
        g.fillOval(di.getWidth().x, di.getHeight().y - 25, 50, 50);
    }
    if(buttonDown == false)
    {
        g.setColor(Color.green);
        g.fillOval(di.getWidth().x, di.getHeight().y - 25, 50, 50);
    }
    
  }

}
