import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemy extends SprMain
{
	private final int INIT_X = 400;
	private Image img;

    public Enemy(int x, int y) 
    {
        super(x, y);
        
        initEnm();
    }

    private void initEnm() {

        loadImage("src/resources/worm_spr.gif");
        getImageDimensions();
    }

    public void move() 
    {

        if (x < 0) 
        {
            x = INIT_X;
        }

        x += 1;
    }
    
    public Image getImage()
    {
    	ImageIcon i = new ImageIcon("src/resources/worm_spr.gif");
    	img = i.getImage();
    	
    	return img;
    }
}// end of Enemy class
