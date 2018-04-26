
public class GrapeBul extends SprMain
{
	private final int BRD_W = 390;
    private final int GRP_SPD = 2;

    public GrapeBul(int x, int y) 
    {
        super(x, y);
        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("src/resources/grape_spr");  
        getImageDimensions();
    }

    public void move() {
        
        x += GRP_SPD;
        
        if (x > BRD_W) 
        {
            vis = false;
        }
    }
}
