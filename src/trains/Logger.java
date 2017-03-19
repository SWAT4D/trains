package trains;

/**
 * Logger oszály
 *
 * Statikus osztály csak statikus tagjai vannak, ezért könnyen meg lehet
 * hívni a pl: Logger.logStart(), Logger.logEnd() függvényt kiíráshoz.
 *
 * A használata:
 *     + Minden függvény a következő képpen kezdődik:
 *           Logger.logStart("<függvénynév>([<paraméterlista>]) - <hívó osztálypéldány>");
 *     + Minden függvényben a return előtt meg kell hívni a Logger.logEnd()-et
 *
 */

public class Logger {
    private static int tab; //Tabulátorok száma.
    private static boolean log;

    static void init(){
        tab=0;
        log = true;
    }

    /**
     * A növeli a tabulátorokat és a kimenetre írja a kapott string-et
     * @param msg - A string amit ki kell írnia (tabulátorok nélkül)
     */
    public static void logStart(String msg){
        if(log){
            String msg2 ="";
            if(msg.contains(".")&&msg.contains("@"))
                 msg2 = msg.replace("trains.", "");
            //Tabulátorok hozzáadása a kapott stringhez
            String newStr ="";
            for(int i=0;i<tab;i++)
                newStr += '\t';
            if(msg.contains(".")&&msg.contains("@"))
                newStr+=msg2;
            else
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
        if(log){
            String newStr ="";
            for(int i=0;i<tab;i++)
                newStr += '\t';
            newStr+=msg;

            System.out.println(newStr);
        }
    }

    /**
     * Csökkenti a tabulátorok számát
     * Ezzel kell végződnie minden függvénynek ami meghívja a logStart-ot
     */
    public static void logEnd(){
        if(log)
            tab--;
    }

    public static void on(){
        log = true;
    }

    public static void off(){
        log = false;
    }
}
