import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameWindow extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image ground;
	private Image sky;

    public GameWindow() 
    {
        initBoard();
    }
    
    private void initBoard() 
    {        
        loadImage();
        
        int w = ground.getWidth(this) + sky.getWidth(this);
        int h =  ground.getHeight(this) + sky.getHeight(this);
        setPreferredSize(new Dimension(w, h));        
    }
    
    private void loadImage() 
    {   
        ImageIcon ii = new ImageIcon("src/resources/Ground.png");
        ground = ii.getImage();      
        
        ImageIcon i = new ImageIcon("src/resources/Sky.png");
        sky = i.getImage();   
    }

    @Override
    public void paintComponent(Graphics g) 
    {
        g.drawImage(ground, 0, 100, null);
        g.drawImage(sky, 0, -100, null);
    }
}
