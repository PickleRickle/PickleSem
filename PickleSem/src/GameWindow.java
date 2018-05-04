import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * @author geniu
 *
 */
public class GameWindow extends JPanel implements ActionListener
{
	private int k;
	private Scanner inKey;
	
	private static final long serialVersionUID = -3595680454898980105L;
	private Timer tmr;
	
	private Duck duck;
	private SprMain sky, ground;
	private List <Enemy> worms;
	
	private boolean ingame;
	
	private int winW;
	private int winH; 
	
	private int duckStrtX;
	private int duckStrtY = 200;
	
	private final int DELAY = 15;
	private final int[][] pos = {{-1500, duckStrtY}};
	
	/*private final int[][] pos = {{2380, duckStrtY}, {2500, duckStrtY}, {1380, duckStrtY}, {780, duckStrtY}, {580, duckStrtY}, {680, duckStrtY}, 
	{790, duckStrtY}, {760, duckStrtY}, {790, duckStrtY}, {980, duckStrtY}, {560, duckStrtY}, {510, duckStrtY}, {930, duckStrtY}, 
	{590, duckStrtY}, {530, duckStrtY}, {940, duckStrtY}, {990, duckStrtY}, {920, duckStrtY}, {900, duckStrtY}, {660, duckStrtY}, {540, duckStrtY}, 
	{810, duckStrtY}, {860, duckStrtY}, {740, duckStrtY}, {820, duckStrtY}, {490, duckStrtY}, {700, duckStrtY}};*/


	/**
	* Constructor
	*/
	public GameWindow(int x, int y)
	{
    	winW = x;
    	winH = y;
	    	
	    initWin();
	}// end of constructor
	
	/**
    * Constructor
    */
    public GameWindow()
    {
    	initWin();
    }// end of constructor
    
    /**
     * Initializing Window
     */
    private void initWin() 
    {        
    	addKeyListener(new AdpT());
        setFocusable(true);
        setBackground(Color.BLACK);
        
        setDoubleBuffered(true);
        ingame = true;

        setPreferredSize(new Dimension(winW, winH));
        
        sky = new Environment(0, 0);
        sky.loadImage("src/Resources/sky_spr.png");
        
        ground = new Environment(0, 336);
        ground.loadImage("src/Resources/ground_spr.png");
    	
    	duckStrtX = winW * 3 / 4;

        duck = new Duck(-duckStrtX, duckStrtY);

        makeEnms();

        tmr = new Timer(DELAY, this);
        tmr.start();        
    }// end of initBoard method
    
    /**
     * initalizes the list of enemies, creates new ones
     */
    public void makeEnms()
    {
    	worms = new ArrayList<>();
    	
    	for (int[] x : pos)
    	{
    		worms.add(new Enemy(-x[0], x[1]));
    	}
    }
    
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        if (ingame) 
        {
            drawObjects(g);
        } 
        
        else 
        {

            createGG(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * @param g
     */
    private void drawObjects(Graphics g) {

        if (duck.isVis()) 
        {
        	g.drawImage(sky.getImg(), sky.getX(), sky.getY(), this);
        	g.drawImage(ground.getImg(), ground.getX(), ground.getY(), this);
            g.drawImage(duck.getImage(), duck.getX(), duck.getY(), this);
        }

        List <GrapeBul> grps = duck.getGrape();

        for (GrapeBul grp : grps) 
        {
            if (grp.isVis()) 
            {
                g.drawImage(grp.getImage(), grp.getX(), grp.getY(), this);
            }
        }

        for (Enemy worm : worms) 
        {
            if (worm.isVis()) 
            {
                g.drawImage(worm.getImage(), worm.getX(), worm.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Worms left: " + worms.size(), 5, 15);
    }

    /**
     * creates game over screen
     * @param g
     */
    private void createGG(Graphics g) 
    {

        String endMes = "GG";
        Font font = new Font("Helvetica", Font.BOLD, 44);
        FontMetrics fm = getFontMetrics(font);

        g.setColor(Color.white);
        
        g.setFont(font);
        
        g.drawString(endMes, ((winW - fm.stringWidth(endMes)) / 2), (winH / 2));
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {

        inGame();

        updDuck();
        updGrapes();
        updWorms();

        collCheck();

        repaint();
    }

    /**
     * checks if ingame
     */
    private void inGame() 
    {

        if (!ingame) 
        {
            tmr.stop();
        }
    }

    /**
     * updates the position of duck
     */
    private void updDuck() 
    {

        if (duck.isVis()) 
        {
            duck.walk();
        }
    }

    /**
     * updates the grapes position
     */
    private void updGrapes() 
    {

        List <GrapeBul> grps = duck.getGrape();

        for (int i = 0; i < grps.size(); i++) 
        {

            GrapeBul grp = grps.get(i);

            if (grp.isVis()) 
            {
                grp.move();
            } 
            
            else 
            {
                grps.remove(i);
            }
        }
    }

    /**
     * updates position of worm
     */
    private void updWorms() 
    {

        if (worms.isEmpty()) 
        {

            ingame = false;
            return;
        }

        for (int i = 0; i < worms.size(); i++) 
        {

            Enemy wrm = worms.get(i);
            
            if (wrm.isVis()) 
            {
                wrm.walk();
            } 
            
            else 
            {
                worms.remove(i);
            }
        }
    }

    /**
     * checks for the colliding of objects
     */
    public void collCheck() 
    {

        Rectangle r3 = duck.getBnds();

        for (Enemy worm : worms) 
        {
            
            Rectangle r2 = worm.getBnds();

            if (r3.intersects(r2)) 
            {
                
                duck.setVis(false);
                worm.setVis(false);
                ingame = false;
            }
        }

        List <GrapeBul> grps = duck.getGrape();

        for (GrapeBul grp : grps) 
        {

            Rectangle r1 = grp.getBnds();

            for (Enemy worm : worms) 
            {

                Rectangle r2 = worm.getBnds();

                if (r1.intersects(r2)) 
                {
                    
                    worm.setVis(false);
                    grp.setVis(false);
                }
            }
        }
    }
    
    
    /**
     * @author geniu
     */
    private class AdpT extends KeyAdapter
    {

        @Override
        public void keyReleased(KeyEvent e) 
        {
            duck.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            duck.keyPress(e);
        }
    }
}
