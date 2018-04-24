import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Duck extends SprMain
{
	private int dx;
    private int dy;
    private List <GrapeBul> grapes;

    public Duck(int x, int y) 
    {
        super(x, y);
        makeDuck();
    }

    private void makeDuck() 
    {
        
        grapes = new ArrayList<>();
        loadImage("src/resources/house.png");
        getImageDimensions();
    }

    public void move() 
    {

        x += dx;
        y += dy;

        if (x < 1) 
        {
            x = 1;
        }

        if (y < 1) 
        {
            y = 1;
        }
    }

    public List<GrapeBul> getGrape() 
    {
        return grapes;
    }

    public void keyPress(KeyEvent k) 
    {

        int key = k.getKeyCode();

        if (key == KeyEvent.VK_SPACE) 
        {
            fire();
        }

        if (key == KeyEvent.VK_A) 
        {
            dx = -1;
        }

        if (key == KeyEvent.VK_D) 
        {
            dx = 1;
        }

        if (key == KeyEvent.VK_W) 
        {
            dy = -1;
        }

        if (key == KeyEvent.VK_S) 
        {
            dy = 1;
        }
    }

    public void fire() 
    {
        grapes.add(new GrapeBul(x + w, y + h/2));
    }

    public void keyReleased(KeyEvent e) 
    {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) 
        {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) 
        {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) 
        {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) 
        {
            dy = 0;
        }
    }
}
