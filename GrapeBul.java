import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Defines a bullet
 * @author: (Ricardo Lopez, Sophia Chongtai)
 */
public class GrapeBul extends SprMain
{
	private final Integer BRD_W = 10000;
    private final Double GRP_SPD = 5.0;

    /**
     * Constructor
     * @pre: none
     * @param: int, int
     * @reutrn: none
     * @post: object constructed
     */
    public GrapeBul(int x, int y) 
    {
        super(x, y);
        makeGrapes();
    } // end of constructor
    
    /**
     * initializes grapes
     * @pre: none
     * @param: none
     * @return: none
     * @post: grape sprite is loaded
     */
    private void makeGrapes() 
    {
        
        loadImage("src/resources/grape_spr.png");  
        getImageDimensions();
    } // end of makeGrapes

    /**
     * moves grape bullets
     * @pre: none
     * @param: none
     * @return: none
     * @post: object location and visibility updated
     */
    public void move() 
    {
        
        x += GRP_SPD;
        
        if (x > BRD_W) 
        {
            vis = false;
        } // end of if
    } // end of move
    
    /**
     * Returns object sprite
     * @pre: none
     * @param: none
     * @return: Image
     * @post: none
     */
    public Image getImage()
    {
    	ImageIcon i = new ImageIcon("src/resources/grape_spr.png");
    	img = i.getImage();
    	
    	return img;
    } // end of getImage
} // end of GrapeBul
