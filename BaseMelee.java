package units;

import java.util.List;

public abstract class BaseMelee extends BaseHero{
    protected int attackSum, attackRange;
    public BaseMelee(int x, int y, int initiative, int damage, int moveDistance, int attackSum, int attackRange) {
        super(x, y, 100, 100, damage, moveDistance, initiative, true);
        this.attackSum = attackSum;
        this.attackRange = attackRange;
    }

    @Override
    public void step(List<BaseHero> enemy, List<BaseHero> list){
        if(!isAlive) return;

        BaseHero tmp = nearest(enemy);

        if(coordinat.countDistance(tmp.coordinat) <= attackRange){
            for(int i = 0; i < attackSum; i++){
                tmp.getDamage(damage);
            }
            state = "Attack";
        }else{
            move(tmp.coordinat,list);
            state = "Moving";
        }
    }
}
