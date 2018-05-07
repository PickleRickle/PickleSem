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
     * @param: none
     * @return: none
     * @post: location updated
     */
    public void walk() 
    {
        x += dx;
        y += dy;

        if (0 >= x) 
        {
            x = 1;
        } // end of if

        if (y <= 0) 
        {
            y = 1;
        } // end of if
    } // end of walk

    /**
     * Returns list of grapes
     * @pre: none
     * @param: none
     * @return: List<GrapeBul>
     * @post: none
     */
    public List<GrapeBul> getGrape() 
    {
        return grapes;
    } // end of getGrape

    /**
     * Controls key commands
     * @pre: none
     * @param: KeyEvent
     * @return: none
     * @post: rate of change of location updated
     */
    public void keyPress(KeyEvent k) 
    {

        int key = k.getKeyCode();

        
        if(!(key != KeyEvent.VK_SPACE)) 
        {
            fire();
        } // end of if

        if(key == KeyEvent.VK_A) 
        {
            dx = -5;
        } // end of if

        if(key == KeyEvent.VK_D) 
        {
            dx = 5;
        } // end of if
/*
        if(key == KeyEvent.VK_W) 
        {
            dy = -1;
        } // end of if

        if(key == KeyEvent.VK_S) 
        {
            dy = 1;
        } // end of if
*/
    }

    /**
     * adds grapes to list to be launched, fires grapes
     * @pre: none
     * @param: none
     * @return: none
     * @post: grapes appended
     */
    public void fire() 
    {
        grapes.add(new GrapeBul(x + w, y + h/2));
    } // end of fire

    /**
     * Stops movement once key released
     * @pre: none
     * @param KeyEvent
     * @return: none
     * @post: movement stopped
     */
    public void keyReleased(KeyEvent e) 
    {
    	int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) 
        {
            dx = 0;
        } // end of if

        if (key == KeyEvent.VK_D) 
        {
            dx = 0;
        } // end of if

        if (key == KeyEvent.VK_W) 
        {
            dy = 0;
        } // end of if

        if (key == KeyEvent.VK_S) 
        {
            dy = 0;
        } // end of if     
    } // end of keyReleased
    
    /**
     * Returns sprite
     * @pre: none
     * @param: none
     * @return: Image
     * @post: none
     */
    public Image getImage()
    {
    	ImageIcon i = new ImageIcon("src/resources/pickle_spr.gif");
    	img = i.getImage();
    	
    	return img;
    } // end of getImage
} // end of Duck
