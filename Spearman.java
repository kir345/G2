package units;


public class Spearman extends BaseShooter {
    public Spearman(int x, int y, int initiative) {
        super(x, y, initiative + 3, 8, 15, 0);
    }

    @Override
    public String getInfo() {
        return "Spearman [" + coordinat.x + ", " + coordinat.y + "] arrows: " + arrows + " HP: " + health + "/" + max_health + " " + state; 
    }

}
