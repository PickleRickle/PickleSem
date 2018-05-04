/**
 * Sets up the structure of the application
 */

import javax.swing.JFrame;  // handles cursor and window interactions
//import java.awt.EventQueue; // handles the order of executed events
import java.util.ArrayList;

public class App extends JFrame
{
	// constants
	public static final int WINDOW_HEIGHT = 500;
	public static final int WINDOW_WIDTH = 1800;
	private static final long serialVersionUID = 1L; // used with Serializable objects to ensure stability
	private static final int NUM_LEVELS = 1;
	private static final int STARTING_ENEMY = 4;
//	ArrayList<SprMain> items; // keeps track of all of the visible interacting objects on screen
	ArrayList<Enemy> enemies;
	
	
	/**
	 * Constructor
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: App Constructed
	 */
	public App()
	{
//		items = new ArrayList<SprMain>();
// 		numFrames = new ArrayList<Integer>();
		enemies = new ArrayList<Enemy>();
		initUI();
	} // end of constructor
	
	/**
	 * Creates UI Win
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: none
	 */
	private void initUI() 
	{
        add(new GameWindow(WINDOW_WIDTH, WINDOW_HEIGHT));

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setTitle("Pickle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }// end of initUI method   
	
	/**
	 * Controls the events of one level
	 * @pre: numEnemy > 0
	 * @param: int numEnemy
	 * @return: none
	 * @post: new objects are created (characters, projectiles)
	 */
	private void playLvl(int numEnemy)
	{
		addEnemy(numEnemy);
	} // end of playLvl method
	
	/**
	 * Creates enemies
	 * @pre: numEnemy > 0
	 * @param: int numEnemy
	 * @return: none
	 * @post: enemies ArrayList is given more objects
	 */
	private static void addEnemy(int numEnemy)
	{
	//	while(enemies.getSize() < numEnemy)
		{
	//		enemies.add(new Enemy());		
		}// end of while
	} // end of addEnemy method
	
	/**
	 * Controls Game Flow
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: none
	 */
    public static void main(String[] args) 
    {
        // shows window
        //EventQueue.invokeLater
        //(() -> 
	    //    {
	            App ex = new App();
	            ex.setVisible(true);
	     //   }
        //);
        
        // cycle through levels
        for(int curLvl = 0; curLvl < NUM_LEVELS; curLvl++)
        {
        	ex.playLvl(STARTING_ENEMY + curLvl); 
        }// end of for
        
    }// end of main method
}
