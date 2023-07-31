package units;

import java.util.List;

public abstract class BaseShooter extends BaseHero {
    protected int arrows, attackRange;


    public BaseShooter(int x, int y, int initiative, int attackRange, int arrows, int timeToload) {
        super(x, y, 50, 50, 5, 1, initiative, true);
        this.attackRange = attackRange;
        this.arrows = arrows;
    }

    @Override
    public void step(List<BaseHero> enemy, List<BaseHero> list){
        BaseHero tmp = nearest(enemy);

        if (isAlive){
            for(BaseHero unit: list){
                if(unit instanceof Peasant && unit.state == "Stand" && arrows < 20 && unit instanceof Spearman){
                    arrows += 1;
                    unit.state = "Busy";
                    return;
                }
            }

            if ((int) coordinat.countDistance(tmp.coordinat) <= attackRange){
                if(arrows > 0 && attackRange != 1){
                    if(attackRange == 1) tmp.getDamage(1);
                    else tmp.getDamage(damage);
                    arrows -= 1;
                    state = "Attack";
                    return;
                } else{
                    attackRange = 1;
                    state = " ->Melee";
                }
            } else{
                move(tmp.coordinat, list);
                state = "Moving";
                return;
            }
        }
        return;
    }
}



   