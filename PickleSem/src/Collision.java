import java.awt.EventQueue;
import javax.swing.JFrame;

public class Collision extends JFrame 
{

    public Collision() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new GameWindow());
        
        setResizable(false);
        pack();
        
        setTitle("Collision");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void mCol(String[] args) 
    {
        
        EventQueue.invokeLater
        (
          () -> 
	        {
	            Collision col = new Collision();
	            col.setVisible(true);
	        }
	    );	
    }
}
