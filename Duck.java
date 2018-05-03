import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Duck extends SprMain
{
	private int dx;
    private int dy;
    private List <GrapeBul> grapes;

    public Duck(int x, int y) 
    {
        super(x, y);
        
        makeDuck();
    }

    private void makeDuck() 
    {
        
        grapes = new ArrayList<>();
        loadImage("src/resources/pickle_spr.gif");
        getImageDimensions();
    }

    public void move() 
    {

        x += dx;
        y += dy;

        if (x < 1) 
        {
            x = 1;
        }

        if (y < 1) 
        {
            y = 1;
        }
    }

    public List<GrapeBul> getGrape() 
    {
        return grapes;
    }

    public void keyPress(KeyEvent k) 
    {

        int key = k.getKeyCode();

        while(key == KeyEvent.VK_SPACE) 
        {
            fire();
        }

        while(key == KeyEvent.VK_A) 
        {
            dx = -1;
        }

        while(key == KeyEvent.VK_D) 
        {
            dx = 1;
        }
/*
        while(key == KeyEvent.VK_W) 
        {
            dy = -1;
        }

        while(key == KeyEvent.VK_S) 
        {
            dy = 1;
        }
*/
    }

    public void fire() 
    {
        grapes.add(new GrapeBul(x + w, y + h/2));
    }

    public void keyReleased(KeyEvent e) 
    {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) 
        {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) 
        {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) 
        {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) 
        {
            dy = 0;
        }        
    }
    
    public Image getImage()
    {
    	ImageIcon i = new ImageIcon("src/resources/pickle_spr.gif");
    	img = i.getImage();
    	
    	return img;
    }
}
