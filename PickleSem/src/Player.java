import java.awt.Image;

public abstract class Player extends SprMain implements Character
{
	public Player(int x, int y)
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
}
