/**
 * Defines an enemy character
 */
import java.util.ArrayList;
public class Enemy extends SprMain implements Character
{
	// instance variables
	private final int NUM_FRAMES = 5;
	
	/**
	 * Constructor
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: Enemy constructed
	 */
	public Enemy()
	{
		super(100, 100);
		
		super.loadImage("src/resources/worm_spr(", NUM_FRAMES, ").png");
		
		walk();
	}// end of constructor
	
	/**
	 * Makes the enemy walk
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: the object is moved
	 */
	public void walk()
	{
		
	} // end of walk method
	
	/**
	 * Defines the enemy's death
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: the object is no longer used or visible
	 */
	public void lose()
	{
		
	}// end of lose method
}// end of Enemy class
