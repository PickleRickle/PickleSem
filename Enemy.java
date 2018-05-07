import java.awt.Image; 
import javax.swing.ImageIcon;

/**
 * Defines an enemy
 * @author: (Ricardo Lopez, Sophia Chongtai)
 */
public abstract class Enemy extends SprMain implements Character 
{
	/**
	 * Constructor
	 * @pre: none
	 * @param int, int
	 * @return: none
	 * @post: object constructed
	 */
	public Enemy(int x, int y)
	{
		super(x, y);
	} // end of constructor
	
	/**
	 * Return's objects image
	 * @pre: none
	 * @param: none
	 * @return: Image
	 * @post: none
	 */
	public abstract Image getImage();
	
	/**
	 * Moves the object
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: location changed
	 */
	public abstract void walk();
}// end of Enemy class
