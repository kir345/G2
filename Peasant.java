package units;

import java.util.List;

public class Peasant extends BaseSupport {
    public Peasant(int x, int y, int initiative) {
        super(x, y, initiative, 0, 0, 1, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Peasant [" + coordinat.x + ", " + coordinat.y + "] HP: " + health + "/" + max_health + " " + state; 
    }

    @Override
    public void step(List<BaseHero> enemy, List<BaseHero> list){
        if(isAlive){
            if(state == "Busy"){
                state = "Stand";
            }
        }
    }

}


    
