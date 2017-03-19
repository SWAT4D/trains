package trains;

import java.util.Scanner;

public class Main {
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
        System.out.println("|    4. Kilépés                                                    |	");
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
            }

        } while (select != 4);

    }

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
         * EndVoid -> EntryPoint -> EntryPoint -> EndVoid
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
}

