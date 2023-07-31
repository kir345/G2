package units;

import java.util.List;

public class Monk extends BaseSupport{
    public Monk(int x, int y, int initiative) {
        super(x, y, initiative + 2, 10, 5, 2, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Monk [" + coordinat.x + ", " + coordinat.y + "] mana: " + mana + "/" + 10 + "HP: " + health + "/" + max_health + " " + state; 
    }

    @Override
    public void step (List<BaseHero> enemy, List<BaseHero> list){
        super.step(enemy, list);
        BaseHero tmpAlly = list.get(0);
        double minAllyHealth = 1;

        if(!isAlive) return;

        for(BaseHero unit: list){
            if(unit.health / unit.max_health < minAllyHealth && unit.isAlive){
                minAllyHealth = unit.health / unit.max_health;
                tmpAlly = unit;
            }
        }

        if (minAllyHealth < 1 && mana > 0){
            tmpAlly.getDamage(-damage);
            mana -= 1;
            state = "Healing";

            return;
        }
    }
}
