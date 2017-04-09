package trains;

import java.util.*;

public class Main {
    //A parancsok tárolására
    private static Vector<String> cmdFifo;
    //A sínek összekötésére
    private static Rail prev;
    //A pálya (rajta vannak a Railből származtatott osztályok)
    //private static Vector<Vector<Rail>> map;
    private static HashMap<int[], Rail> map; //Egy másik lehetséges megoldás.
    //A pályán mozgó vonat (rajta vannak a TrainElementet implementáló osztályok)
    private static HashMap<int[], TrainElement> positions;

    //Csak inicializálja a tagváltozókat
    private static void init() {
        cmdFifo = new Vector<>();
        prev = null;
        map = new HashMap();
        positions = new HashMap();
    }

    //Köszöntő képernyő
    private static void welcomeScreen() {
        System.out.println("Hello!\nTODO: Welcome Screen\n-----------\n\n\n");
    }

    private static void execute(String cmd) {

        //Parancs értelmezés
        switch(cmd){
            default:
                System.out.println("This command does not exist:\n\t" + cmd);
        }
    }

    private static void mapWriteOut() {
        if(map.isEmpty())
            System.out.println("Your Map is empty!");

        //Pálya magasságát és szélességét határozza meg
        int verticalMax = 0;
        int horizontalMax = 0;
        for(Map.Entry<int[], Rail> entry : map.entrySet()) {
            int[] key = entry.getKey();
            if(key[0] > verticalMax)
                verticalMax = key[0];
            if(key[1] > horizontalMax)
                horizontalMax = key[1];
        }

        //Létrehozza a kiírandó stringet és feltölti . okkal
        String[][] outMap = new String[verticalMax][];
        for(int i=0;i<verticalMax;i++){
            outMap[i] = new String[horizontalMax];
            for(int j =0;j<horizontalMax;j++){
                outMap[i][j] = ".";
            }
        }



        //Kírja a pályát
        for(int i=0;i<verticalMax;i++){
            for(int j =0;j<horizontalMax;j++){
                System.out.print(outMap[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void addRailToMap(Rail r) {
        //Sínt lehet vele elhelyezni a pályán
    }
    public static void addTrainToMap(Locomotive l, EntryPoint ep) {
        //Vonatot lehet vele elhelyezni a pályán
    }
    public static void moveMapLoco(Locomotive l, Rail next){
        //Vonat mozoghat a pályán
    }
    public static void moveMapCar(Car c, Rail next){
        //Kocsi mozoghat a pályán
    }

    //LEADÁS ELŐTT TÖRÖLNI KELL!
    /*Saját tesztelésre*/
    public static void test(){
        map.put(new int[]{4,5}, new Rail());
        map.put(new int[]{1,4}, new Rail());
        map.put(new int[]{10,1}, new Rail());
        mapWriteOut();
    }


    public static void main(String[] args) {
        init();
        welcomeScreen();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String commands_line = input.nextLine();
            String[] commands = commands_line.split(" ");
            for (String cmd : commands)
                if(!cmd.equals(""))
                    execute(cmd);
            mapWriteOut();
        }
    }
}
