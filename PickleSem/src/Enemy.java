import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemy extends SprMain implements Character
{
	private final Integer INIT_X = 400;
	private final Double INIT_Y = 0.0;
	private Image img;

    /**
     * @param x
     * @param y
     */
    public Enemy(int x, int y) 
    {
        super(x, y);
        
        makeEnm();
    }

    /**
     * initializes the enemy
     */
    private void makeEnm() 
    {

        loadImage("src/resources/worm_spr.gif");
        getImageDimensions();
    }

    
    /* (non-Javadoc)
     * @see Character#walk()
     */
    public void walk() 
    {

        if (x < 0) 
        {
            x = INIT_X;
        }

        x -= 1;
    }
    
    /**
     * @return img
     */
    public Image getImage()
    {
    	ImageIcon i = new ImageIcon("src/resources/worm_spr.gif");
    	img = i.getImage();
    	
    	return img;
    }
}// end of Enemy class
