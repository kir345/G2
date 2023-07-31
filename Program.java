package units;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Program {

    public static List<BaseHero> list1 = new ArrayList<>();
    public static List<BaseHero> list2 = new ArrayList<>();
    public static List<BaseHero> allList = new ArrayList<>();
    
    
    
    public static void main(String[] args) {

        int listCount = 10;
        boolean sortedInitiative = false;
        Random random = new Random();

        for (int i = 0; i < listCount; i++){
            int val = random.nextInt(7);
            addRandomUnit(val, i, list1,1);

            val = random.nextInt(7);
            addRandomUnit(val, i, list2, 10);
        }

        while(!sortedInitiative){
            sortedInitiative = true;
            for(int i = 0; i < list1.size() - 1; i++){
                if(list1.get(i).initiative < list1.get(i + 1).initiative){
                    Collections.swap(list1, i, i + 1);
                    sortedInitiative = false;
                }
            }
        }

        while(!sortedInitiative){
            sortedInitiative = true;
            for(int i = 0; i < list2.size() - 1; i++){
                if(list2.get(i).initiative < list2.get(i + 1).initiative){
                    Collections.swap(list1, i, i + 1);
                    sortedInitiative = false;
                }
            }
        }

        

        allList.addAll(list1);
        allList.addAll(list2);

        View.view();

        Scanner in = new Scanner(System.in);
        while(true){
            in.nextLine();
            String message = " ";

            int init1 = 0, init2 = 0;
            BaseHero tmpList1 = list1.get(init1);
            BaseHero tmpList2 = list2.get(init2);

            
            for (int i = 0; i < listCount * 2; i++){
                if (isTeamDie(list1)){
                    message = "List 2 win!";
                    break;
                }
                if (isTeamDie(list2)){
                    message = "List 1 win!";
                    break;
                }

                if ((tmpList1.initiative >= tmpList2.initiative && init1 < 10) || (tmpList1.initiative < tmpList2.initiative && init2 == 10)){
                   tmpList1.step(list2, list1);
                   init1++;
                   if(init1 < 10) tmpList1 = list1.get(init1);
                } else {
                    tmpList2.step(list1, list2);
                    init2++;
                    if(init2 < 10) tmpList2 = list2.get(init2);
                } 
            }

            View.view();

            if(message.equals("List 2 win!") || message.equals("List 1 win!")){
                System.out.println(message);
                break;
            }
        }
    }

    public static boolean isTeamDie(List<BaseHero> list){
        for(BaseHero baseHero : list){
            if(!baseHero.state.equals("Dead")) return false;
        }
        return true;
    }

    private static void addRandomUnit(int num, int i, List<BaseHero> units, int listPos){
        Random random = new Random();
            switch(num){
                case 0:
                    units.add(new Peasant(listPos, i + 1, random.nextInt(21)));
                    break;
                case 1:
                    units.add(new Rogue(listPos, i + 1, random.nextInt(21)));
                    break;
                case 2:
                    units.add(new Sniper(listPos, i + 1, random.nextInt(21)));
                    break;
                case 3:
                    units.add(new Warlock(listPos, i + 1, random.nextInt(21)));
                    break;
                case 4:
                    units.add(new Spearman(listPos, i + 1, random.nextInt(21)));
                    break;
                case 5:
                    units.add(new Crossbowman(listPos, i + 1, random.nextInt(21)));
                    break;
                case 6:
                    units.add(new Monk(listPos, i + 1, random.nextInt(21)));
                    break;
            }
        }
}
            
        