import java.awt.Image;
import javax.swing.ImageIcon;

public class GrapeBul extends SprMain
{
	private final Integer BRD_W = 10000;
    private final Double GRP_SPD = 5.0;

    /**
     * @param x
     * @param y
     */
    public GrapeBul(int x, int y) 
    {
        super(x, y);
        makeGrapes();
    }
    
    /**
     * initializes grapes
     */
    private void makeGrapes() 
    {
        
        loadImage("src/resources/grape_spr.png");  
        getImageDimensions();
    }

    /**
     * moves grape bullets
     */
    public void move() 
    {
        
        x += GRP_SPD;
        
        if (x > BRD_W) 
        {
            vis = false;
        }
    }
    
    /**
     * @return img
     */
    public Image getImage()
    {
    	ImageIcon i = new ImageIcon("src/resources/grape_spr.png");
    	img = i.getImage();
    	
    	return img;
    }
}
