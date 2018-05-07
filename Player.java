import java.awt.Image;

/**
 * Defines player
 * @author: (Ricardo Lopez, Sophia Chongtai)
 */
public abstract class Player extends SprMain implements Character
{
	/**
	 * Constructor
	 * @pre: none
	 * @param int, int
	 * @return: none 
	 * @post: object constructed
	 */
	public Player(int x, int y)
	{
		super(x, y);
	} // end of constructor
	
	/**
	 * Returns sprite
	 * @pre: none
	 * @param: none
	 * @return: Image
	 * @post: none
	 */
	public abstract Image getImage();
	
	/**
	 * Moves player
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: location updated
	 */
	public abstract void walk();
} // end of Player
