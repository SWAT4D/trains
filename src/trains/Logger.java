package trains;

/**
 * Logger oszály
 *
 * Statikus osztály csak statikus tagjai vannak, ezért könnyen meg lehet
 * hívni a pl: Logger.logStart(), Logger.logEnd() függvényt kiíráshoz.
 *
 * A használata:
 *     + Minden függvény a következő képpen kezdődik:
 *           Logger.logStart("<függvénynév>([<paraméterlista>]) - <tartalmazó osztály>");
 *     + Minden függvényben a return előtt meg kell hívni a Logger.logEnd()-et
 *     + Game over üzenet esetén a Logger.setGameOver(true) függvényt kell meghívni és ezután nem logol mindaddig amég ez true
 * Inicializálás:
 *     + initInc() a futás elején meg kell hívni
 *     + setGameOver(false) minden parancs előtt meg kell hívni
 *
 */

public class Logger {
    private static int tab; //Tabulátorok száma.
    private static boolean gameover; // Game over-t rögzíti

    /**
     * A növeli a tabulátorokat és a kimenetre írja a kapott string-et
     * @param msg - A string amit ki kell írnia (tabulátorok nélkül)
     */
    public static void logStart(String msg){
        if(!gameover){ //Ha a játéknak vége akkor nem logol tovább


            //Tabulátorok hozzáadása a kapott stringhez
            String newStr ="";
            for(int i=0;i<tab;i++)
                newStr += '\t';
            newStr+=msg;

            System.out.println(newStr);

            tab++; //tabulátorok számának növelése
        }
    }

    /**
     * A tabulátorok növelése nélkül kiírja a kapott üzenetet
     * @param msg a kiírandó üzenet
     */
    public static void logMessage(String msg){
        String newStr ="";
        for(int i=0;i<tab;i++)
            newStr += '\t';
        newStr+=msg;

        System.err.println(newStr);
    }


    /**
     * A logger osztály használata előtt kell
     * ennek le kell futnia (pl a Main-ben)
     */
    public static void initInc(){
        tab = -1;
        gameover = false;
    }

    /**
     * Átállítja a gameover értékét
     */
    public static void setGameOver(boolean value){
        gameover = value;
    }

    /**
     * Csökkenti a tabulátorok számát
     * Ezzel kell végződnie minden függvénynek ami meghívja a logStart-ot
     */
    public static void logEnd(){
        tab--;
    }
}
