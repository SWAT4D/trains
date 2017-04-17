package trains;

import java.util.*;
import java.util.regex.Pattern;


public class Main {
<<<<<<< HEAD
    //A parancsok tárolására
    private static Stack<String> stack;
    //A sínek összekötésére
    private static Rail prev;

    private static EndVoid ev;

    private static ArrayList<Locomotive> locolist;

    //A pályán elhelyezkedő síneket tárolja a koordinátájukkal
    private static Map<Koo, Rail> map;

    //Csak inicializálja a tagváltozókat
    private static void init() {
        stack = new Stack<>();
        prev = null;
        map = new TreeMap<Koo, Rail>();
        ev = new EndVoid();
        locolist = new ArrayList<>();
    }

    //Köszöntő képernyő
    private static void welcomeScreen() {
        System.out.println("Hello!\nTODO: Welcome Screen\n-----------\n\n\n");
    }
/*
    private static void execute(String cmd) {
        cmd.toLowerCase();
        //Parancs értelmezés

        switch(cmd){

            case "new":
                stack.push(cmd);
                break;
            case "r":
                stack.push(cmd);
                break;
            case "c":
                stack.push(cmd);
                break;
            case "ep":
                stack.push(cmd);
                break;
            case "st":
                stack.push(cmd);
                break;
            case "tp":
                stack.push(cmd);
                break;
            case "on":

                break;
            case "off":
                break;
            case "sw":
                break;
            case "l":
                break;
            default:
                if(cmd.matches("\\([0-9]\\,[0-9]\\)")){
                    //TODO: Regex for koos
                }

                String[] c = cmd.replace('(',' ').replace(')',' ').trim().split(",");
                String prevCmds = "";
                if(!stack.isEmpty()) {
                    if(stack.size()>1) {
                        String element = stack.pop();
                        String newCmd = stack.pop();
                        if (!newCmd.equals("new")) {
                            stack.push(newCmd);
                            stack.push(element);
                        } else {
                            switch (element) {
                                case "rail":
                                    addRailToMap(new Koo(Integer.parseInt(c[0]),Integer.parseInt(c[1])),new Rail());
                                    break;
                                default:

                            }
                            break;
                        }
                    }
                    while (!stack.isEmpty())
                        prevCmds += stack.pop() + " ";
                }
                System.out.println("This command does not exist:\n\t" +prevCmds+ cmd);
        }
    }
*/

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
                break;
            case "tp":
                r = new TunnelPlace();
                break;
            case "c":
                r = new Cross();
                break;
        }
        addRailToMap(pos, r);
    }

    private static void build(String type, Koo pos, String color){

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
=======
    public static boolean play;
    public static boolean isoccupied = false;
    public static void menu1(){
        System.out.println("  _______        _                 _        _      _              	");
        System.out.println(" |__   __|      (_)               | |      | |    | |             	");
        System.out.println("    | |_ __ __ _ _ _ __  ___   ___| | _____| | ___| |_ ___  _ __  	");
        System.out.println("    | | '__/ _` | | '_ \\/ __| / __| |/ / _ \\ |/ _ \\ __/ _ \\| '_ \\ 	");
        System.out.println("    | | | | (_| | | | | \\__ \\ \\__ \\   <  __/ |  __/ || (_) | | | |	");
        System.out.println("    |_|_|  \\__,_|_|_| |_|___/ |___/_|\\_\\___|_|\\___|\\__\\___/|_| |_|	");
        System.out.println("+------------------------------------------------------------------+	");
        System.out.println("|                             MENÜ                                 |	");
        System.out.println("|------------------------------------------------------------------|	");
        System.out.println("|    1. Vakvágányra érkezés                                        |	");
        System.out.println("|    2. Vonat mozgása ütközés detektálással                        |	");
        System.out.println("|    3. Kocsi utassal hagyja el a pályát                           |	");
        System.out.println("|    4. Kocsi állomásra léptetése                                  |	");
        System.out.println("|    5. Váltó váltása                                              |	");
        System.out.println("|    6. Alagút szimulálása                                         |	");
        System.out.println("|    7. Kilépés                                                    |	");
        System.out.println("|                                                                  |	");
        System.out.println("|                                                                  |	");
        System.out.println("+------------------------------------------------------------------+	");
    }

    public static void main (String[] asrg){
        Logger.init();
        int select=0;
        do {
            play = true;
            menu1();
            Scanner scanner = new Scanner(System.in);
            select = scanner.nextInt();
            scanner.nextLine(); // Discard '\n'
            switch (select) {
                case 1:
                    STEP_TO_DEAD_END();
                    Logger.logMessage("Menübe való visszatéréshez nyomj entert");
                    scanner.nextLine(); // Discard '\n'
                    break;
                case 2:
                    OCCUPIED_RAIL();
                    Logger.logMessage("Menübe való visszatéréshez nyomj entert");
                    scanner.nextLine(); // Discard '\n'
                    break;
                case 3:
                    REMAIN_PASSENGER();
                    Logger.logMessage("Menübe való visszatéréshez nyomj entert");
                    scanner.nextLine(); // Discard '\n'
                    break;
                case 4:
                    STEP_TO_STATION();
                    Logger.logMessage("Menübe való visszatéréshez nyomj entert");
                    scanner.nextLine(); // Discard '\n'
                    break;
                    
                case 5:
                    SWITCH_THE_SWITCH();
                    Logger.logMessage("Menübe való visszatéréshez nyomj entert");
                    scanner.nextLine(); // Discard '\n'
                    break;
                case 6:
                    BUILD_TUNNEL();
                    Logger.logMessage("Menübe való visszatéréshez nyomj entert");
                    scanner.nextLine(); // Discard '\n'
                    break;
>>>>>>> refs/remotes/origin/master
            }
        }

<<<<<<< HEAD
=======
        } while (select != 7);
>>>>>>> refs/remotes/origin/master


        //Kírja a pályát
        for(int i=0;i<verticalMax;i++){
            for(int j =0;j<horizontalMax;j++){
                System.out.print(outMap[i][j]);
            }
            System.out.print("\n");
        }
    }

<<<<<<< HEAD
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


    public static void main(String[] args) {
        init();
        welcomeScreen();

        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String commands_line = input.nextLine();
            String regex1 = "(newRail (r||e||sw||tp||c) \\([1-9][1-9]*,[1-9][1-9]*\\))*";
            String regex2 = "(newRail (st||gst) \\([1-9][1-9]*,[1-9][1-9]*\\)) (r||g||b)*";
            String regex3 = "(loco \\([1-9][1-9]*,[1-9][1-9]*\\) [1-9][0-9]*)*";
            String regex4 = "(on||off||switch) \\([1-9][1-9]*,[1-9][1-9]*\\)";
            String regex5 = "move [2-9]*";

            boolean CMDCLASS1 = Pattern.matches(regex1, commands_line);
            boolean CMDCLASS2 = Pattern.matches(regex2, commands_line);
            boolean CMDCLASS3 = Pattern.matches(regex3, commands_line);
            boolean CMDCLASS4 = Pattern.matches(regex4, commands_line);
            boolean CMDCLASS5 = Pattern.matches(regex5, commands_line);
            if(!(CMDCLASS1||CMDCLASS2||CMDCLASS3||CMDCLASS4||CMDCLASS5))
                throw new RuntimeException("Bad command!");
            String[] commands = commands_line.split(" ");
            int i = 0;
            while(true){
                if(CMDCLASS1){
                    build(commands[i+1], Koo.parseKoo(commands[i+2]));
                    i+=3;
                }
                if(CMDCLASS2){
                    build(commands[i+1], Koo.parseKoo(commands[i+2]), commands[i+3]);
                    i+=4;
                }
                if(CMDCLASS3){
                    placetrain(commands[0], Koo.parseKoo(commands[1]).dec(), Integer.parseInt(commands[2]));
                    i+=3;
                }
                if(CMDCLASS4){
                    turner(commands[0], Koo.parseKoo(commands[1]).dec());
                    i+=2;
                }
                if(CMDCLASS5){
                    move(Integer.parseInt(commands[1]));
                    i+=2;
                }
                if(i>(commands.length-1)){
                    break;
                }
            }
            /*
            for (String cmd : commands)
                if(!cmd.equals(""))
                    execute(cmd);*/
            mapWriteOut();
        }


        //test();
    }

    private static void placetrain(String command, Koo koo, int carnum) {
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
                        Car c = new Car(ev);
                        prevCar.addNext(c);
                        c.addNext(null);
                        prevCar = c;
                    }
                    break;
                }catch (ClassCastException ce){
                    System.out.println("You can place a train onto only an entrypoint!");
                }

            }
        }
    }

    private static void move(int num) {
        for(int i = 0;i<num;i++)
            for(Locomotive l : locolist)
                l.step();
    }
=======
    
    static void STEP_TO_DEAD_END (){

        Logger.off();

        /**
         * Pályaelemek létrehozása a teszthez
         * EndVoid -> EntryPoint -> null
         */
        EndVoid ev = new EndVoid();
        EntryPoint ep = new EntryPoint();
        ep.addPrev(ev);

        /**
         * Egy mozdony és hozzá egy kocsi
         *  - létrehozás és összekötés
         *  - mozdony kezdőpontra helyezése
         */
        Locomotive l = new Locomotive(ev);
        Car c = new Car(ev);
        l.addNext(c);
        l.setStartPlace(ep);

        Logger.on();

        l.step();
    }

    static void OCCUPIED_RAIL(){

        Logger.off();

        /**
         * Pályaelemek létrehozása a teszthez alapeset:
         * EndVoid -> EntryPoint -> Rail
         */
        EndVoid ev = new EndVoid();
        EntryPoint ep1 = new EntryPoint();
        ep1.addPrev(ev);
        Rail nextRail = new Rail(); //egy sín létrehozása
        ep1.addNext(nextRail);

        /**
         * Teszt vizsgálata, ha nincs ütközés:
         * EndVoid -> EntryPoint -> Rail -> EntryPoint -> EndVoid
         *
         * A loggolva jelezzük hogy milyen opciót választott a felhasználó
         */
        Logger.on();
        Logger.logMessage("Van ütközés?(i/n)");
        Scanner sc = new Scanner(System.in);
        String ans = sc.next();
        if(ans.equals("i")){
            Main.isoccupied = true;
        }
        Logger.logMessage("A választott opció: " + ans);
        
        Logger.off();
        /**
         * Egy mozdony és hozzá egy kocsi
         *  - létrehozás és összekötés
         *  - mozdony kezdőpontra helyezése
         */
        Locomotive l1 = new Locomotive(ev);
        Car c1 = new Car(ev);
        l1.addNext(c1);
        l1.setStartPlace(ep1);

        Logger.on();

        l1.step();
        Main.isoccupied = false;    //hogy ne lehessen true véletlen
    }

    static void REMAIN_PASSENGER(){
        Logger.off();
        /**
         * Pályaelemek létrehozása a teszthez
         * EndVoid -> EntryPoint -> EndVoid
         */
        EndVoid ev = new EndVoid();
        EntryPoint ep = new EntryPoint();
        ep.addNext(ev);
        ep.addPrev(ev);

        /**
         * Egy mozdony és egy kocsi
         *  -létrehozás és összekötés
         *  -mozdony kezdőpontra helyezése
         */
        Locomotive l = new Locomotive(ev);
        Car c = new Car(ev);
        l.addNext(c);
        l.setStartPlace(ep);
        Logger.on();
        /**
         * Indítás. A futás menete:
         *  1. Mozdony rálép az entrypointról az endvoid-ra
         *  2. Mozdony húz mégegyet
         *  3. Teli kocsi ki akar menni a pályáról.
         */
        l.step();
    }
    
    static void STEP_TO_STATION(){

        Logger.off();
        /**
        * Pályaelemek létrehozása a teszthez
        * Rail -> Station -> Rail
        */
        Rail r1 = new Rail();   //egy sín létrehozása
        Rail r2 = new Rail();
        Station st1 = new Station("valamilyenSzin"); //állomás létrehozása
        Rail r3 = new Rail(); 
        r2.addNext(r2);
        r2.addNext(st1);
        st1.addNext(r3);
        
        Locomotive l1 = new Locomotive(st1, r2); //mozdony létrehozása teszthez
        Car c1 = new Car(r2);
        Car c2 = new Car(r1);
        l1.addNext(c1);
        c1.addNext(c2);

        Logger.on();

        l1.step();
        
    }
                        
    static void SWITCH_THE_SWITCH()
    {
        Logger.off();
        /*
        *Pálya elemek létrehozása a teszthez
        *Rail -> Switch -> Rail
        *               -> Rail
        */
        Rail main = new Rail();   //sínek létrehozása
        Rail alt = new Rail();
        Rail prev = new Rail();
        Switch sw = new Switch(); //váltó létrehozása
        prev.addNext(sw);//sínek összekötése
        sw.addNext(main);
        sw.addNextAlt(alt);
        
        Locomotive l = new Locomotive(sw, prev);//mozdony a teszthez
        Car c = new Car(prev);
        l.addNext(c);
        
        Logger.on();
        /*
        *A váltó az alaphelyzetből a mellékágra vált.
        *A vonat áthalad a váltón
        */
        
        Logger.logMessage("Átakarod váltani a váltót?(i/n)");
        Scanner sc = new Scanner(System.in);
        String ans = sc.next();
        if(ans.equals("i"))
            sw.switchIt();
        l.step();
    }
    
    static void BUILD_TUNNEL(){
    	
    	/**
         * Pályaelemek létrehozása a teszthez
         * EndVoid -> EntryPoint -> null
         */
        Logger.off();
        
    	EndVoid ev = new EndVoid();
    	EntryPoint ep = new EntryPoint();
    	ep.addPrev(ev);
    	Tunnel tt = Tunnel.getInstance();  
    	TunnelPlace t1 = new TunnelPlace(); //create TunnelPlaces
        TunnelPlace t2 = new TunnelPlace();
        TunnelPlace t3 = new TunnelPlace();
        t1.addTunnel(tt);
        t2.addTunnel(tt);
        t3.addTunnel(tt);
        
        Logger.on();
        
    	t1.setActive();
    	t2.setActive();
    	t3.setActive();
    	t2.setActive();
        
        Tunnel.clearInstance();
    }
    
}
>>>>>>> refs/remotes/origin/master

    private static void turner(String command, Koo koo) {
    }
}
