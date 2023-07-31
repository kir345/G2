package units;


public class Crossbowman extends BaseShooter{
    
    public Crossbowman(int x, int y, int initiative) {
        super(x, y, initiative + 3, 5, 20, 0);
    }

    @Override
    public String getInfo() {
         return "Crossbowman [" + coordinat.x + ", " + coordinat.y + "] arrows: " + arrows + " HP: " + health + "/" + max_health + " " + state; 
     }

   
    

        

       

        
  
}
