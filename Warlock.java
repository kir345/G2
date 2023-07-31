package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warlock extends BaseSupport {
    public Warlock(int x, int y, int initiative) {
        super(x, y, initiative + 2, 100, 10, 3, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Warlock [" + coordinat.x + ", " + coordinat.y + "] mana: " + mana + "/" + 10 + "HP: " + health + "/" + max_health + " " + state; 
    }

    @Override
    public void step(List<BaseHero> enemy, List<BaseHero> list){
        super.step(enemy, list);
        List<BaseHero> deadBaseHeros = new ArrayList<>();
        BaseHero tmpAlly = list.get(0);
        if(!isAlive) return;
        for(BaseHero unit : list){
            if(!unit.isAlive){
                deadBaseHeros.add(unit);
            }
        }
        if(deadBaseHeros.size() > list.size() / 2 -1 && mana >= 5){
            int random = new Random().nextInt(deadBaseHeros.size() -1);

            deadBaseHeros.get(random).isAlive = true;
            deadBaseHeros.get(random).health = deadBaseHeros.get(random).max_health / 2;
            state = "Revive";
            mana = 0;
            return;
        }
    }
}
