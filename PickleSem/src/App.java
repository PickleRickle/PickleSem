/**
 * Sets up the structure of the application
 */

import java.awt.EventQueue; // handles the order of executed events
import javax.swing.JFrame;  // handles cursor and window interactions

public class App extends JFrame
{
	// constants
	public final int WINDOW_HEIGHT = 500;
	public final int WINDOW_WIDTH = 1000;
	public final int NUM_LEVELS = 1;
	
	/**
	 * Constructor
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: the application window is constructed
	 */
	public App()
	{
		initUI();
	}
	
	/**
	 * Creates a window of a specified size
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: none
	 */
	private void initUI() 
	{
        add(new GameWindow());

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setTitle("Pickle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
	/**
	 * Controls the flow of the code for the game
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: none
	 */
    public static void main(String[] args) 
    {
        
        EventQueue.invokeLater
        (() -> 
	        {
	            App ex = new App();
	            ex.setVisible(true);
	        }
        );
    }	
}
