import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Defines a land-moving enemy
 * @author: (Ricardo Lopez, Sophia Chongtai)
 */
public class GrndEnemy extends Enemy
{
	private final Integer INIT_X = 400;
	private final Double INIT_Y = 0.0;
	private Image img;

    /**
     * Constructor
     * @pre: none
     * @param: int, int
     * @return: none
     * @post: object constructed 
     */
    public GrndEnemy(int x, int y) 
    {
        super(x, y);
        
        makeEnm();
    } // end of constructor

    /**
     * initializes the enemy
     * @pre: none
     * @param: none
     * @return: none
     * @post: sprite loaded
     */
    private void makeEnm() 
    {

        loadImage("src/resources/worm_spr.gif");
        getImageDimensions();
    } // end of makeEnm

    
    /** 
     * Enemy moves
     * @pre: none
     * @param: none
     * @return: none
     * @post: location updated
     */
    public void walk() 
    {

        if (x < 0) 
        {
            x = INIT_X;
        } // end of if

        x -= 1;
    } // end of walk
    
    /**
     * returns sprite
     * @pre: none
     * @param: none
     * @return: Image
     * @post: none
     */
    public Image getImage()
    {
    	ImageIcon i = new ImageIcon("src/resources/worm_spr.gif");
    	img = i.getImage();
    	
    	return img;
    } // end of getImage
} // end of GrndEnemy
