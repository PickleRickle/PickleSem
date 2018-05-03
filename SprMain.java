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
    protected int speed;
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
    
    protected void getImageDimensions() 
    {
        w = img.getWidth(null);
        h = img.getHeight(null);
    }    

    public Image getImg() 
    {
        return img;
    }

    public int getW()
    {
    	return img.getWidth(null); 
    } // end of getW
    
    public int getH()
    {
    	return img.getHeight(null);
    } // end of getH
    
    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }

    public boolean isVis() 
    {
        return vis;
    }

    public void setVis(Boolean vis) 
    {
        this.vis = vis;
    }
    
    public Rectangle getBnds() 
    {
        return new Rectangle(x, y, w, h);
    }
}
