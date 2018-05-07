import java.awt.Image; 
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Defines a duck player
 * @author (Ricardo Lopez, Sophia Chongtai)
 */
public class Duck extends Player
{
	private int dx;
    private int dy;
    private List <GrapeBul> grapes;

    /**
     * Constructor
     * @pre: none
     * @param: int, int
     * @return: none
     * @post: location set
     */
    public Duck(int x, int y) 
    {
        super(x, y);
        
        makeDuck();
    } // end of constructor

    /**
     * initializes pickle (duck)
     * @pre: none
     * @param: none
     * @return: none
     * @post: image loaded
     */
    private void makeDuck()
    {
        grapes = new ArrayList<>();
        loadImage("src/resources/pickle_spr.gif");
        getImageDimensions();
    } // end of makeDuck

    /**
     * Pickle is moved on the screen
     * @pre: none
     */
    public void walk() 
    {
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
            fire();
        }

        if(key == KeyEvent.VK_A) 
        {
            dx = -5;
        }

        if(key == KeyEvent.VK_D) 
        {
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
} // end of Duck
