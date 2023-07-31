package units;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseHero implements Interface{
    public int damage;
    public int health;
    public int max_health;
    public String state;
    Coordinat coordinat;
    public int moveDistance;
    public int initiative;
    public boolean isAlive;
   


//Полный конструктор
    
    public BaseHero(int x, int y, int damage, int health, int max_health, int moveDistance, int initiative, boolean isAlive) {
        this.damage = damage;
        this.health = health;
        this.max_health = max_health;
        this.state ="Stand";
        coordinat = new Coordinat(x, y);
        this.moveDistance = moveDistance;
        this.initiative = initiative;
        this.isAlive = isAlive;
    }

    
    public ArrayList<Integer> getCoords(){
        return coordinat.xy;
    }

    @Override
    public String toString(){
        return this.getInfo().split(" ")[0];
    }

    public Object getDamage(){
        return damage;
    }

    public int getHealth(){
        return health;
    }

    public void getDamage(int damage){
            health -= damage;
            if(health <= 0){
                health = 0;
                isAlive = false;
                state = "Dead";
            }
            if (health > max_health) health = max_health; 
        }


    public void move(Coordinat targetPosition, List<BaseHero> list){
        if(!coordinat.containsByPos(coordinat.newPosition(targetPosition, list), list)){
            for(int i = 0; i < moveDistance; i++){
                coordinat = coordinat.newPosition(targetPosition, list);
            }
        }
    }

    public BaseHero nearest(List<BaseHero> units){
        double minDistance = Double. MAX_VALUE;
        BaseHero nearestEnemy = units.get(0);
        for(int i = 0; i < units.size(); i++){
            if(coordinat.countDistance(units.get(i).coordinat) < minDistance && units.get(i).isAlive){
                nearestEnemy = units.get(i);
                minDistance = coordinat.countDistance(units.get(i).coordinat);
            }
        }
        return nearestEnemy;
    }
 
}