import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameWindow extends JPanel
{
	private static final long serialVersionUID = 1L;
	private int winW;
	int winH; 
	private Image ground;
	private Image sky;

	/**
	 * Parameter constructor
	 * @pre: width and height are positive
	 * @param: int w, int h
	 * @return: none
	 * @post: game visuals are set up
	 */
    public GameWindow(int w, int h) 
    {
    	winW = w; 
    	winH = h;
        initBoard();
    } // end of constructor
    
    /**
     * Default constructor
     * @pre: none
     * @param: none
     * @return: none
     * @post: GameWindow constructed
     */
    public GameWindow()
    {
    	initBoard();
    }// end of constructor
    
    /**
     * Creates board
     * @pre: none
     * @param: none
     * @return: none
     * @post: Window dimensions set
     */
    private void initBoard() 
    {        
        loadImage();
        
        setPreferredSize(new Dimension(winW, winH));        
    }// end of initBoard method
    
    private void loadImage() 
    {   
        ImageIcon ii = new ImageIcon("src/resources/ground_spr.png");
        ground = ii.getImage();      
        
        ImageIcon i = new ImageIcon("src/resources/sky_spr.png");
        sky = i.getImage();   
    }

    @Override
    public void paintComponent(Graphics g) 
    {

        g.drawImage(sky, 0, 0, null);
        g.drawImage(ground, 0, winH - ground.getHeight(this), null);
    }
}
