package trains;

public class Main {
    static void main (String[] asrg){

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

        Car c = new Car();
        Locomotive l = new Locomotive();
        l.addNext(c);
        l.setStartPlace(ep);

        /**
         * Indítás. A futás menete:
         *  1. Mozdony rálép az entrypointról az endvoid-ra
         *  2. Mozdony húz mégegyet
         *  3. Teli kocsi ki akar menni a pályáról.
         */
        l.moveNext();
    }
}

