/**
 * Controls sprites for objects with collision events
 */
import java.awt.Image;
import java.util.Iterator;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.util.ArrayList;

public class SprMain 
{
	//constants
	protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected Integer speed;
    protected boolean vis; // true if visible
    protected Image img;
    protected ArrayList<Image> frames;
    protected Iterator<Image> it;

    /**
	 * Constructor
	 * @pre: none
	 * @param: int, int
	 * @return: none
	 * @post: SprMain Constructed
	 */
    public SprMain (int x, int y) 
    {
        this.x = x;
        this.y = y;
        vis = true;
        frames = new ArrayList<Image>();
        it = frames.iterator();
    } // end of constructor
    
    /**
     * Loads the object's sprite
     * @pre: none
     * @param: String
     * @return: none
     * @post: none
     */
    public void loadImage(String imageName) 
    {
        ImageIcon i = new ImageIcon(imageName);
        img = i.getImage();
    } // end of loadImage method
    
    /**
     * Saves sprite dimensions
     * @pre: none
     * @param: none
     * @return: none
     * @post: w and h updated
     */
    protected void getImageDimensions() 
    {
        w = img.getWidth(null);
        h = img.getHeight(null);
    } // end of getImageDimensions

    /**
     * Returns the sprite
     * @pre: none
     * @param: none
     * @return: Image
     * @post: none
     */
    public Image getImg() 
    {
        return img;
    } // end of getImg

    /**
     * Returns sprite width
     * @pre: none
     * @param: none
     * @return: int
     * @post: none
     */
    public int getW()
    {
    	return img.getWidth(null); 
    } // end of getW
    
    /**
     * Returns sprite height
     * @pre: none
     * @param: none
     * @return: int
     * @post: none
     */
    public int getH()
    {
    	return img.getHeight(null);
    } // end of getH
    
    /**
     * Returns x coordinate of location
     * @pre: none
     * @param: none
     * @return: int
     * @post: none
     */
    public int getX() 
    {
        return x;
    } // end of getX

    /**
     * Returns y coordinate of location
     * @pre: none
     * @param: none
     * @return: int
     * @post: none
     */
    public int getY() 
    {
        return y;
    } // end of getY

    /**
     * Returns visibility
     * @pre: none
     * @param: none
     * @return: boolean
     * @post: none
     */
    public boolean isVis() 
    {
        return vis;
    }// end of isVis

    /**
     * Sets visibility
     * @pre: none
     * @param: boolean
     * @return: void
     * @pots: vis is updated
     */
    public void setVis(boolean vis) 
    {
        this.vis = vis;
    } // end of setVis
    
    /**
     * Cycles through the sprite's frames
     * @pre: none
     * @param: Graphics
     * @return: none
     * @post: none
     */
    public void cycle(Graphics g)
    {
    	while(it.hasNext())
    	{
    		Image i = it.next();
    		g.drawImage(i, getX(), getY(), (ImageObserver) this);
    	} // end of while
    } // end of cycle
    
    /**
     * Returns bounding box of object
     * @pre: none
     * @param: none
     * @return: Rectangle
     * @post: none
     */
    public Rectangle getBnds() 
    {
        return new Rectangle(x, y, w, h);
    } // end of getBnds
} // end of SprMain
