package units;


public class Rogue extends BaseMelee {
    public Rogue(int x, int y, int initiative) {
        super(x, y, initiative + 4, 5, 2, 2, 1);
    }

    @Override
    public String getInfo() {
        return "Rogue [" + coordinat.x + ", " + coordinat.y + "] HP: " + health + "/" + max_health + " " + state; 
    }

   
}
