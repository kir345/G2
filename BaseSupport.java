package units;

import java.util.List;

public abstract class BaseSupport extends BaseHero{
    protected int mana, magicDamage, attackRange;
    protected static int actionPriority;
    public BaseSupport(int x, int y, int initiative, int mana, int magicDamage, int attackRange, int actionPriority){
        super(x, y, 70, 70, 5, 1, initiative, true);
        this.mana = mana;
        this.magicDamage = magicDamage;
        this.attackRange = attackRange;
        this.actionPriority = actionPriority;
    }

    @Override
    public void step(List<BaseHero> enemy, List<BaseHero> list){
        BaseHero tmp = nearest(enemy);
        if(!isAlive) return;
        if((int) coordinat.countDistance(tmp.coordinat) <= attackRange){
            if(mana > 0){
                tmp.getDamage(damage);
                mana -= 1;
                state = "Attack";
            } else{
                mana += 1;
                state = "Busy";
            }
        } else{
            move(tmp.coordinat, list);
            state = "Moving";
        }
    }
}
