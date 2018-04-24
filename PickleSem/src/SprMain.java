import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class SprMain 
{
	//constants
	protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected boolean vis;
    protected Image img;

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
     * @pre: none
     * @param: imageName
     * @return: none
     * @post: none
     */
    protected void loadImage(String imageName) 
    {

        ImageIcon i = new ImageIcon(imageName);
        img = i.getImage();
    }
    
    protected void getImageDimensions() 
    {

        w = img.getWidth(null);
        h = img.getHeight(null);
    }    

    public Image getImg() 
    {
        return img;
    }

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
