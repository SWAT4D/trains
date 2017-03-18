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
 */

public class Logger {
    static int tab; //Tabulátorok száma.

    /**
     * A növeli a tabulátorokat és a kimenetre írja a kapott string-et
     * @param msg - A string amit ki kell írnia (tabulátorok nélkül)
     */
    static void logStart(String msg){
        tab++; //tabulátorok számának növelése

        //Tabulátorok hozzáadása a kapott stringhez
        String newStr ="";
        for(int i=0;i<tab;i++)
            newStr += '\t';
        newStr+=msg;

        System.out.println(newStr);
    }


    /**
     * A logger osztály használata előtt kell
     * ennek le kell futnia (pl a Main-ben)
     */
    static void initInc(){
        tab = -1;
    }

    /**
     * Csökkenti a tabulátorok számát
     * Ezzel kell végződnie minden függvénynek ami meghívja a logStart-ot
     */
    static void logEnd(){
        tab--;
    }
}
