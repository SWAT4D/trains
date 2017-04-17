package trains;

import java.util.*;
import java.util.regex.Pattern;


public class Main {
    //A pályán elhelyezkedő síneket tárolja a koordinátájukkal
    private static Map<Koo, Rail> map;

    //Egy darab EndVoid
    private static EndVoid ev;

    //A sínek lerakásánál, a sínek összekötéséhez kell
    private static Rail prev;

    //Tároljuk a switch-eket mivel ezek összekötése speciális
    private static Map<Koo, Switch> switchlist;

    //Mozgatáshoz tároljuk az összes mozdonyt
    private static ArrayList<Locomotive> locolist;

    //Csak inicializálja a tagváltozókat
    private static void init() {
        switchlist = new TreeMap<>();
        prev = null;
        map = new TreeMap<Koo, Rail>();
        ev = new EndVoid();
        locolist = new ArrayList<>();
    }

    //Köszöntő képernyő
    private static void welcomeScreen() {
        System.out.println("Hello!\nTODO: Welcome Screen\n-----------\n\n\n");
    }

    //Kiírja a pályát
    private static void mapWriteOut() {
        if(map.isEmpty())
            System.out.println("Your Map is empty!");

        //Pálya magasságát és szélességét határozza meg
        int verticalMax = 0;
        int horizontalMax = 0;
        for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
            Koo key = entry.getKey();
            if(key.getX() > horizontalMax)
                horizontalMax = key.getX();
            if(key.getY() > verticalMax)
                verticalMax = key.getY();
        }
        verticalMax++;
        horizontalMax++;

        //Létrehozza a kiírandó stringet és feltölti . okkal
        String[][] outMap = new String[verticalMax][];
        for(int i=0;i<verticalMax;i++){
            outMap[i] = new String[horizontalMax];
            for(int j =0;j<horizontalMax;j++){
                outMap[i][j] = ".";
            }
        }

        //Kiolvassuk a pálya elemeket
        for(int i = 0; i <verticalMax;i++){
            for(int j = 0; j<horizontalMax;j++){
                Koo searched = new Koo(j,i);
                for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
                    if(entry.getKey().compareTo(searched)==0)
                        if(entry.getValue().getTrain() != null)
                            outMap[i][j] = entry.getValue().getTrain().toString();
                        else
                            outMap[i][j] = entry.getValue().toString();
                }
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

    public static void addRailToMap(Koo pos, Rail r) {
        map.put(new Koo(pos.getX()-1, pos.getY()-1), r);
    }

    //LEADÁS ELŐTT TÖRÖLNI KELL!
    /*Saját tesztelésre*/
    public static void test(){
        EntryPoint THE_Rail = new EntryPoint();
        addRailToMap(new Koo(1,1), THE_Rail);
        Locomotive l = new Locomotive(THE_Rail, THE_Rail);
        THE_Rail.setTrain(l);
        addRailToMap(new Koo(4,5), new Rail());
        addRailToMap(new Koo(1,4), new Rail());
        addRailToMap(new Koo(10,1), new Rail());
        mapWriteOut();
    }

    public static void main(String[] args){
        init();
        welcomeScreen();
        try {
            Scanner input = new Scanner(System.in);
            while (input.hasNext()) {
                String commands_line = input.nextLine();
                String regex1 = "(((newRail (r|sw|e|tp) \\([1-9][1-9]*,[1-9][1-9]*\\))|(newRail (st|gst) \\([1-9][1-9]*,[1-9][1-9]*\\) (r|g|b)))( |))*";
                String regex2 = "newRail c (\\([1-9][1-9]*,[1-9][1-9]*\\)){5}";
                String regex3 = "sw (\\([1-9][1-9]*,[1-9][1-9]*\\)){2}";
                String regex4 = "loco \\([1-9][1-9]*,[1-9][1-9]*\\) [1-9][0-9]* (r|g|b|c)*";
                String regex5 = "(act|switch) \\([1-9][0-9]*,[1-9][0-9]*\\)";
                String regex6 = "move [2-9]*";

                boolean CMDCLASS1 = Pattern.matches(regex1, commands_line);
                boolean CMDCLASS2 = Pattern.matches(regex2, commands_line);
                boolean CMDCLASS3 = Pattern.matches(regex3, commands_line);
                boolean CMDCLASS4 = Pattern.matches(regex4, commands_line);
                boolean CMDCLASS5 = Pattern.matches(regex5, commands_line);
                boolean CMDCLASS6 = Pattern.matches(regex6, commands_line);
                if (!(CMDCLASS1 || CMDCLASS2 || CMDCLASS3 || CMDCLASS4 || CMDCLASS5 || CMDCLASS6))
                    throw new RuntimeException("Bad command!");
                String[] commands = commands_line.split(" ");
                int i = 0;
                while (true) {
                    if (CMDCLASS1) {
                        if (commands[1] == "st" || commands[1] == "gst") {
                            build(commands[i + 1], Koo.parseKoo(commands[i + 2]), commands[i + 3]);
                            i += 4;
                        } else {
                            build(commands[i + 1], Koo.parseKoo(commands[i + 2]));
                            i += 3;
                        }
                    }
                    if (CMDCLASS2) {
                        buildcross(Koo.parseKoo(commands[2]), Koo.parseKoo(commands[3]), Koo.parseKoo(commands[4]), Koo.parseKoo(commands[5]), Koo.parseKoo(commands[6]));
                        i += 7;
                    }
                    if (CMDCLASS3) {
                        connectSwitch(Koo.parseKoo(commands[2]), Koo.parseKoo(commands[3]));
                        i += 4;
                    }
                    if (CMDCLASS4) {
                        int carnum=Integer.parseInt(commands[2]);
                        if(carnum!=(commands.length-3))
                            throw new RuntimeException("Bad command!");
                        String[] colors = new String[carnum];
                        for(int clr = 0;i<carnum;i++){
                            colors[clr] = commands[3+clr];
                        }
                        placetrain(commands[0], Koo.parseKoo(commands[1]).dec(), Integer.parseInt(commands[2]), colors);
                        i += 3;
                    }
                    if (CMDCLASS5) {
                        turner(commands[0], Koo.parseKoo(commands[1]).dec());
                        i += 2;
                    }
                    if (CMDCLASS6) {
                        move(Integer.parseInt(commands[1]));
                        i += 2;
                    }

                    if (i > (commands.length - 1)) {
                        break;
                    }
                }
            /*
            for (String cmd : commands)
                if(!cmd.equals(""))
                    execute(cmd);*/
                mapWriteOut();
            }
        }catch (OccupyException oe){
            System.out.println("GAME OVER!");
        }


        //test();
    }

    private static void build(String type, Koo pos){
        Rail r = null;
        switch(type){
            case "r":
                r = new Rail();
                break;
            case "e":
                r = new EntryPoint();
                break;
            case "sw":
                r = new Switch();
                switchlist.put(pos,(Switch)r);
                break;
            case "tp":
                r = new TunnelPlace();
                break;
            case "c":
                r = new Cross();
                break;
        }
        if(prev != null)
            prev.addNext(r);
        prev = r;

        addRailToMap(pos, r);
    }

    private static void build(String type, Koo pos, String color){
        Station s = null;
        switch(type){
            case "st":
                s = new Station(color);
                break;
            case "gst":
                s = new GiverStation(color);
                break;
        }
        addRailToMap(pos, s);
    }

    private static void buildcross(Koo koo, Koo koo1, Koo koo2, Koo koo3, Koo koo4) {
        Cross c = new Cross();
        map.put(koo, c);
        for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
            if (entry.getKey().compareTo(koo1) == 0){
                c.addNext(entry.getValue());
            }
        }
        for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
            if (entry.getKey().compareTo(koo2) == 0){
                c.addNext(entry.getValue());
            }
        }
        for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
            if (entry.getKey().compareTo(koo3) == 0){
                c.addNextAlt(entry.getValue());
            }
        }
        for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
            if (entry.getKey().compareTo(koo4) == 0){
                c.addPrevAlt(entry.getValue());
            }
        }
    }

    private static void connectSwitch(Koo koo, Koo koo1) {
        if(switchlist.isEmpty()){
           throw new RuntimeException("There's no switch on the map!");
        }

        for(Map.Entry<Koo, Switch> sw : switchlist.entrySet()) {
            if (sw.getKey().compareTo(koo) == 0){
                for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
                    if (entry.getKey().compareTo(koo1) == 0){
                        sw.getValue().addNextAlt(entry.getValue());
                        switchlist.remove(koo);
                    }
                }
            }
        }
    }

    private static void placetrain(String command, Koo koo, int carnum, String[] colors) {
        for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
            if (entry.getKey().compareTo(koo) == 0) {
                try{
                    EntryPoint ep = (EntryPoint)entry.getValue();
                    Locomotive l = new Locomotive(ev);
                    locolist.add(l);
                    ep.setTrain(l);
                    Car prevCar = new Car(ev);
                    l.addNext(prevCar);
                    prevCar.addNext(null);
                    for(int i =0;i<carnum-1;i++){
                        if(colors[i]=="c"){
                            CoalCar cc = new CoalCar(ev);
                            prevCar.addNext(cc);
                            cc.addNext(null);
                            prevCar = cc;
                        }else {
                            Car c = new Car(ev, colors[i]);
                            prevCar.addNext(c);
                            c.addNext(null);
                            prevCar = c;
                        }
                    }
                    break;
                }catch (ClassCastException ce){
                    System.out.println("You can place a train onto only an entrypoint!");
                }

            }
        }
    }

    private static void move(int num) throws OccupyException {
        for(int i = 0;i<num;i++)
            for(Locomotive l : locolist)
                l.step();
    }

    private static void turner(String command, Koo koo) {
        for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
            if (entry.getKey().compareTo(koo) == 0){

                if(command == "act"){
                    TunnelPlace sel = (TunnelPlace) entry.getValue();
                    sel.setActive();
                }else{
                    Switch sel = (Switch)entry.getValue();
                    sel.switchIt();
                }
                break;
            }
        }
    }
}
