package trains;

public class Main {
    public static void main (String[] asrg){
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

