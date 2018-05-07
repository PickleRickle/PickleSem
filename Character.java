import java.awt.Image; 

/**
 * Defines the necessary behaviors of "living" objects 
 * @author: (Ricardo Lopez, Sophia Chongtai)
 */
public interface Character 
{
	/**
	 * Returns the sprite
	 * @pre: none
	 * @param: none
	 * @return: Image
	 * @post: none
	 */
	public Image getImage();
	
	/**
	 * Moves the character
	 * @pre: none
	 * @param: none
	 * @return: none
	 * @post: character is moved
	 */
	public void walk();
} // end of Character interface
