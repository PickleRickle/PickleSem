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

public class GameWindow extends JPanel implements ActionListener
{
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
	private final int[][] pos = {{40, duckStrtY}, {200, duckStrtY}};
			/*
	
	private final int[][] pos = {{2380, 29}, {2500, 59}, {1380, 89}, {780, 109}, {580, 139}, {680, 239}, {790, 259}, {760, 50}, {790, 150},
	{980, 209}, {560, 45}, {510, 70}, {930, 159}, {590, 80}, {530, 60}, {940, 59}, {990, 30}, {920, 200}, {900, 259}, {660, 50}, {540, 90},
	{810, 220}, {860, 20}, {740, 180}, {820, 128}, {490, 170}, {700, 30}};
*/

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
    	//addKeyListener(new KeyListener());
        setFocusable(true);
        setBackground(Color.BLACK);
        
        setDoubleBuffered(true);
        ingame = true;

        setPreferredSize(new Dimension(winW, winH));
        
        sky = new SprMain(0, 0);
        sky.loadImage("src/Resources/sky_spr.png");
        
        ground = new SprMain(0, 336);
        ground.loadImage("src/Resources/ground_spr.png");
    	
    	duckStrtX = winW * 3 / 4;

        duck = new Duck(duckStrtX, duckStrtY);

        initEnms();

        tmr = new Timer(DELAY, this);
        tmr.start();        
    }// end of initBoard method
    
    public void initEnms()
    {
    	worms = new ArrayList<>();
    	
    	for (int[] x : pos)
    	{
    		worms.add(new Enemy(x[0], x[1]));
    	}
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

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

    private void drawGameOver(Graphics g) {

        String endMes = "Game Over";
        Font font = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(font);

        g.setColor(Color.white);
        
        g.setFont(font);
        
        g.drawString(endMes, ((winW - fm.stringWidth(endMes)) / 2), (winH / 2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updDuck();
        updGrapes();
        updWorms();

        checkCollisions();

        repaint();
    }

    private void inGame() 
    {

        if (!ingame) 
        {
            tmr.stop();
        }
    }

    private void updDuck() 
    {

        if (duck.isVis()) 
        {
            
            duck.move();
        }
    }

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
                wrm.move();
            } 
            
            else 
            {
                worms.remove(i);
            }
        }
    }

    public void checkCollisions() 
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
                    duck.setVis(false);
                }
            }
        }
    }

    private class adpT extends KeyAdapter 
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
