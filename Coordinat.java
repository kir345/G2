package units;

import java.util.ArrayList;
import java.util.List;

public class Coordinat {
    int x, y;
    ArrayList<Integer> xy = new ArrayList<>();


    public Coordinat(int x, int y){
        this.x = x;
        this.y = y;
        xy.add(0, x);
        xy.add(1, y);
    }

    public double countDistance(Coordinat coordinat){
        int dx = coordinat.x - x;
        int dy = coordinat. y -y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public Coordinat newPosition(Coordinat targetPosition, List<BaseHero> list){
        Coordinat currentPos = new Coordinat(x, y);
        if (Math.abs(targetPosition.x -x) >= Math.abs(targetPosition.y -y)){
            if(targetPosition.x - x > 0) currentPos.x +=1;
            else currentPos.x -= 1;
        }
        if (Math.abs(targetPosition.x -x) < Math.abs(targetPosition.y -y)){
            if(targetPosition.y - y > 0) currentPos.y +=1;
            else currentPos.y -= 1;
        }
        return currentPos;
    }

    public boolean containsByPos(Coordinat nextPosition, List<BaseHero> list){
        for(BaseHero baseHero : list){
            if (baseHero.coordinat == nextPosition) return true;
        }
        return false;
    }

}
