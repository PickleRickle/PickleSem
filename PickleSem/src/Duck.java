import java.awt.Image; 
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Duck extends SprMain implements Character
{
	private int dx;
    private int dy;
    private List <GrapeBul> grapes;

    /**
     * @param x
     * @param y
     */
    public Duck(int x, int y) 
    {
        super(x, y);
        
        makeDuck();
    }

    /**
     * initializes pickle (duck)
     */
    private void makeDuck()
    {
        
        grapes = new ArrayList<>();
        loadImage("src/resources/pickle_spr.gif");
        getImageDimensions();
    }

    /* (non-Javadoc)
     * @see Character#walk()
     */
    public void walk() 
    {
    	System.out.println("moving");

        x += dx;
        y += dy;

        if (0 >= x) 
        {
            x = 1;
        }

        if (y <= 0) 
        {
            y = 1;
        }
    }

    /**
     * @return grapes
     */
    public List<GrapeBul> getGrape() 
    {
        return grapes;
    }

    /**
     * @param k
     */
    public void keyPress(KeyEvent k) 
    {

        int key = k.getKeyCode();

        
        if(!(!(key == KeyEvent.VK_SPACE))) 
        {
        	System.out.println("shoot");
            fire();
        }

        if(key == KeyEvent.VK_A) 
        {
        	System.out.println("left");
            dx = -5;
        }

        if(key == KeyEvent.VK_D) 
        {
        	System.out.println("right");
            dx = 5;
        }
/*
        if(key == KeyEvent.VK_W) 
        {
            dy = -1;
        }

        if(key == KeyEvent.VK_S) 
        {
            dy = 1;
        }
*/
    }

    /**
     * adds grapes to list to be launched, fires grapes
     */
    public void fire() 
    {
        grapes.add(new GrapeBul(x + w, y + h/2));
    }

    /**
     * @param e
     */
    public void keyReleased(KeyEvent e) 
    {
    	System.out.println();

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
    
    /* (non-Javadoc)
     * @see Character#getImage()
     */
    public Image getImage()
    {
    	ImageIcon i = new ImageIcon("src/resources/pickle_spr.gif");
    	img = i.getImage();
    	
    	return img;
    }
}
