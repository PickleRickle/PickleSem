import java.awt.Image; 
import javax.swing.ImageIcon;

public abstract class Enemy extends SprMain implements Character 
{
	/**
	 * @param x
	 * @param y
	 */
	public Enemy(int x, int y)
	{
		super(x, y);
	}
	
	/**
	 * 
	 */
	public abstract Image getImage();
	/**
	 * 
	 */
	public abstract void walk();
}// end of Enemy class
