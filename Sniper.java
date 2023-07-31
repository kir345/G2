package units;


public class Sniper extends BaseShooter {
    public Sniper(int x, int y, int initiative) {
        super(x, y, initiative + 3, 7, 100, 1);
    }

    @Override
    public String getInfo() {
        return "Sniper [" + coordinat.x + ", " + coordinat.y + "] arrows: " + arrows + " HP: " + health + "/" + max_health + " " + state; 
    }

    
}
