package trains;

import java.util.Scanner;

public class Main {
    public static boolean play;
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
        System.out.println("|    3. Kocsi elhagyja a pályát                                    |	");
        System.out.println("|    4. Alagút szimulálása                                         |	");
        System.out.println("|    5. Kilépés                                                    |	");
        System.out.println("|                                                                  |	");
        System.out.println("+------------------------------------------------------------------+	");
    }
    
    public static void main (String[] asrg){
        int select = 0;
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
                	BUILD_TUNNEL();
                	Logger.logMessage("Menübe való visszatéréshez nyomj entert");
                    scanner.nextLine(); // Discard '\n'
                    break;
                	
            }

        } while (select != 5);

    }
    static void BUILD_TUNNEL(){
    	
    	/**
         * Pályaelemek létrehozása a teszthez
         * EndVoid -> EntryPoint -> null
         */
    	EndVoid ev = new EndVoid();
    	EntryPoint ep = new EntryPoint();
    	ep.addPrev(ev);
    	Tunnel tt = Tunnel.getInstance();  
    	
    	TunnelPlace t1 = new TunnelPlace();
    	t1.setActive();
    	
    	TunnelPlace t2 = new TunnelPlace();
    	t2.setActive();
    	
    	TunnelPlace t3 = new TunnelPlace();
    	t3.setActive();
    	
    	t2.setActive();

    }
    static void STEP_TO_DEAD_END (){
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

        l.step();
    }

    static void OCCUPIED_RAIL(){
        /**
         * Pályaelemek létrehozása a teszthez
         * EndVoid -> EntryPoint -> EntryPoint -> EndVoid
         */
        EndVoid ev = new EndVoid();
        EntryPoint ep = new EntryPoint();
        EntryPoint ep2 = new EntryPoint();

        ep.addPrev(ev);
        ep.addNext(ep2);
        ep2.addNext(ev);

        /**
         * Egy mozdony és hozzá egy kocsi
         *  - létrehozás és összekötés
         *  - mozdony kezdőpontra helyezése
         */
        Locomotive l = new Locomotive(ev);
        Car c = new Car(ev);
        l.addNext(c);
        l.setStartPlace(ep);

        l.step();

    }

    static void REMAIN_PASSENGER(){
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

        /**
         * Indítás. A futás menete:
         *  1. Mozdony rálép az entrypointról az endvoid-ra
         *  2. Mozdony húz mégegyet
         *  3. Teli kocsi ki akar menni a pályáról.
         */
        l.step();
    }
}

