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
    protected void loadImage(String imageName) 
    {
        ImageIcon i = new ImageIcon(imageName);
        img = i.getImage();
    } // end of loadImage method
    
    /**
     * Loads the object's sprite (multiple frames)
     * @pre: none
     * @param: nameFrag0, numFrames, nameFrag1
     * @return :none
     * @post: none
     */
    protected void loadImage(String nameFrag0, int numFrames, String nameFrag1)
    {
    	ArrayList<String> frameNames = new ArrayList<String>();
		for(int i = 0; i < numFrames; i++)
		{
			frameNames.add(nameFrag0 + i + nameFrag1); // relies on consistent naming conventions
		}// end of for
		
    	for(int index = 0; index < frameNames.size(); index++)
    	{
    		ImageIcon i = new ImageIcon(frameNames.get(index)); 
    		frames.add(i.getImage());
    	}// end of for loop
    }// end of loadImage method
    
    protected void getImageDimensions() 
    {
        w = img.getWidth(null);
        h = img.getHeight(null);
    }    

    public Image getImg() 
    {
        return img;
    }
    
    /**
     * Returns one frame of the image's sprite
     * @pre: none
     * @param: index
     * @return Image
     * @post: none
     */
    public Image getFrame(int index)
    {
    	return frames.get(index);
    } // end of getFrame method

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
