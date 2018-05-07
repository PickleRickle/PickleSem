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
 * Controls the level
 * @author: (Ricardo Lopez, Sophia Chongtai)
 */
public class GameWindow extends JPanel implements ActionListener
{
	private int k;
	private Scanner inKey;
	
	private static final long serialVersionUID = -3595680454898980105L;
	private Timer tmr;
	
	private Duck duck;
	private SprMain sky, ground, house;
	private List <GrndEnemy> worms;
	
	private boolean ingame;
	
	private int winW;
	private int winH; 
	
	private int duckStrtX;
	private int duckStrtY = 200;
	
	private final int DELAY = 15;
	//private final int[][] pos = {{-1500, duckStrtY}, {-1800, duckStrtY}};
	
	private final int[][] pos = {{-2380, duckStrtY}, {-2500, duckStrtY}, {-1380, duckStrtY}, {-780, duckStrtY}, {-580, duckStrtY}, {-680, duckStrtY}, 
	{-790, duckStrtY}, {-760, duckStrtY}, {-790, duckStrtY}, {-980, duckStrtY}, {-560, duckStrtY}, {-510, duckStrtY}, {-930, duckStrtY}, 
	{-590, duckStrtY}, {-530, duckStrtY}, {-940, duckStrtY}, {-990, duckStrtY}, {-920, duckStrtY}, {-900, duckStrtY}, {-660, duckStrtY}, {-540, duckStrtY}, 
	{-810, duckStrtY}, {-860, duckStrtY}, {-740, duckStrtY}, {-820, duckStrtY}, {-490, duckStrtY}, {-700, duckStrtY}};


	/**
	* Constructor
	* @pre: none
	* @param: int, int
	* @return: none
	* @post: window initialized
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
     * @pre: none
     * @param: none
     * @return: none
     * @post: variables initialized
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
        
        house = new Environment(0, duckStrtY-125);
        house.loadImage("src/Resources/house_spr.png");
    	
    	duckStrtX = winW * 3 / 4;

        duck = new Duck(-duckStrtX, duckStrtY);

        makeEnms();

        tmr = new Timer(DELAY, this);
        tmr.start(); // sends action events to listeners every DELAY milliseconds   
    }// end of initBoard method
    
    /**
     * initializes the list of enemies, creates new ones
     * @pre: none
     * @param: none
     * @return: none
     * @post: worms loaded with enemies
     */
    public void makeEnms()
    {
    	worms = new ArrayList<>();
    	
    	for (int[] x : pos)
    	{
    		worms.add(new GrndEnemy(-x[0], x[1]));
    	} // end of for
    } // end of makeEnms
    
    /**
     * Redraws the screen
     * @pre: none
     * @param: Graphics
     * @return: none
     * @post: none
     */
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        if (ingame) 
        {
            drawObjects(g);
        } // end of if
        
        else 
        {

            createGG(g);
        } // end of else

        Toolkit.getDefaultToolkit().sync();
    } // end of paintComponent

    /**
     * Displays all visible images on screen
     * @pre: none
     * @param: Graphics
     * @reutrn: none
     * @post: none
     */
    private void drawObjects(Graphics g) 
    {
        if (duck.isVis()) 
        { // draws the background and player at specified points
        	g.drawImage(sky.getImg(), sky.getX(), sky.getY(), this);
        	g.drawImage(ground.getImg(), ground.getX(), ground.getY(), this);
            g.drawImage(house.getImg(), house.getX(), house.getY(), this);
            g.drawImage(duck.getImage(), duck.getX(), duck.getY(), this);
        } // end of if

        List <GrapeBul> grps = duck.getGrape(); // holds all visible grapes

        for (GrapeBul grp : grps) 
        { // draws grapes
            if (grp.isVis()) 
            {
                g.drawImage(grp.getImage(), grp.getX(), grp.getY(), this);
            } // end of if
        } // end of if

        for (GrndEnemy worm : worms) 
        { // draws worms
            if (worm.isVis()) 
            {
                g.drawImage(worm.getImage(), worm.getX(), worm.getY(), this);
            } // end of if
        } // end of if

        g.setColor(Color.WHITE);
        g.drawString("Worms left: " + worms.size(), 5, 15);
    }

    /**
     * creates game over screen
     * @pre: none
     * @param: Graphics
     * @return: none
     * @post: none
     */
    private void createGG(Graphics g) 
    {

        String endMes = "GG";
        Font font = new Font("Helvetica", Font.BOLD, 44);
        FontMetrics fm = getFontMetrics(font);

        g.setColor(Color.white);
        
        g.setFont(font);
        
        g.drawString(endMes, ((winW - fm.stringWidth(endMes)) / 2), (winH / 2));
    } // end of createGG

    /**
     * Updates locations, checks, and display
     * @pre: none
     * @param: ActionEvent
     * @return: none
     * @post: none
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
    } // end of actionPerformed

    /**
     * checks if in game
     * @pre: none
     * @param: none
     * @return: none
     * @post: tmr may be stopped
     */
    private void inGame() 
    {

        if (!ingame) 
        {
            tmr.stop();
        } // end of if
    } // end of if

    /**
     * updates the position of duck
     * @pre: none
     * @param: none
     * @return: none
     * @post: duck updated
     */
    private void updDuck() 
    {

        if (duck.isVis()) 
        { // duck can move if alive
            duck.walk();
        } // end of if
    } // end of updDuck

    /**
     * updates the grapes' position(s)
     * @pre: none
     * @param: none
     * @return: none
     * @post: grps updated
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
            } // end of if
            
            else 
            {
                grps.remove(i);
            } // end of else
        } // end of for
    } // end of updGrapes

    /**
     * updates position of worm
     * @pre: none
     * @param: none
     * @return: none
     * @post: worms updated
     */
    private void updWorms() 
    {

        if (worms.isEmpty()) 
        {

            ingame = false;
            return;
        } // end of if

        for (int i = 0; i < worms.size(); i++) 
        {

            GrndEnemy wrm = worms.get(i);
            
            if (wrm.isVis()) 
            {
                wrm.walk();
            } // end of if
            
            else 
            {
                worms.remove(i);
            } // end of else
        } // end of for
    } // end of updWorms

    /**
     * checks for the colliding of objects
     * @pre: none
     * @param: none
     * @return: none
     * @post: worms, duck, and grps may be updated
     */
    public void collCheck() 
    {

        Rectangle r3 = duck.getBnds();

        for (GrndEnemy worm : worms) 
        {
            
            Rectangle r2 = worm.getBnds();

            if (r3.intersects(r2)) 
            {
                
                duck.setVis(false);
                worm.setVis(false);
                ingame = false;
            } // end of if
        } // end of for

        List <GrapeBul> grps = duck.getGrape();

        for (GrapeBul grp : grps) 
        {

            Rectangle r1 = grp.getBnds();

            for (GrndEnemy worm : worms) 
            {

                Rectangle r2 = worm.getBnds();

                if (r1.intersects(r2)) 
                {
                    
                    worm.setVis(false);
                    grp.setVis(false);
                } // end of if
            } // end of for
        } // end of for
    } // end of collCheck

    
    /**
     * Used to gain access to controls defined in Duck class
     */
    private class AdpT extends KeyAdapter
    {

        @Override
        public void keyReleased(KeyEvent e) 
        {
            duck.keyReleased(e);
        } // end of keyReleased

        @Override
        public void keyPressed(KeyEvent e) 
        {
            duck.keyPress(e);
        } // end of keyPressed
    } // end of AdpT
} // end of GameWindow
