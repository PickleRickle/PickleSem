/**
 * Controls sprites for objects with collision events
 */
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
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

    /**
	 * Constructor
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: SprMain Constructed
	 */
    public SprMain (int x, int y) 
    {
        this.x = x;
        this.y = y;
        vis = true;
    }
    
    /**
     * Loads the object's sprite
     * @pre: none
     * @param: imageName
     * @return: none
     * @post: none
     */
    public void loadImage(String imageName) 
    {
        ImageIcon i = new ImageIcon(imageName);
        img = i.getImage();
    } // end of loadImage method
    
    /**
     * 
     */
    protected void getImageDimensions() 
    {
        w = img.getWidth(null);
        h = img.getHeight(null);
    }    

    /**
     * @return
     */
    public Image getImg() 
    {
        return img;
    }

    /**
     * @return
     */
    public int getW()
    {
    	return img.getWidth(null); 
    } // end of getW
    
    /**
     * @return
     */
    public int getH()
    {
    	return img.getHeight(null);
    } // end of getH
    
    /**
     * @return
     */
    public int getX() 
    {
        return x;
    }

    /**
     * @return
     */
    public int getY() 
    {
        return y;
    }

    /**
     * @return
     */
    public boolean isVis() 
    {
        return vis;
    }

    /**
     * @param vis
     */
    public void setVis(boolean vis) 
    {
        this.vis = vis;
    }
    
    /**
     * @return
     */
    public Rectangle getBnds() 
    {
        return new Rectangle(x, y, w, h);
    }
}
