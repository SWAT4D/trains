/*
Logger oszály

Statikus osztály csak statikus tagjai vannak, ezért könnyen meg lehet
hívni a pl: Logger.write() függvényt kiíráshoz.

A használata:
    + A használat előtt az initInc()-nek le kell futni
    + A kiíráshoz a write() függvényt lehet használni
            (Ami már a beállított tabulátorokkal ír ki)
    + Függvényhívások előtt az inc()-et kell meghívni
    + Függvényhívások után a dec()-t.
 */

public class Logger {
    static int tab; //Tabulátorok száma.

    /**
     * A kimenetre írja a kapott string-et
     * @param str - A string amit ki kell írnia (tabulátorok nélkül)
     */
    static void write(String str){

        char tabChar=11; //A tabulátor ASCII kódja

        String newStr ="";
        //Tabulátorok hozzáadása
        for(int i=0;i<tab;i++)
            newStr += tabChar;
        newStr+=str;

        System.out.println(newStr);

    }

    //A logger osztály használata előtt kell
    // ennek le kell futni a main-ben
    static void initInc(){
        tab = 0;
    }

    //Növeli a tabulátorok számát
    static void inc(){
        tab++;
    }

    //Csökkenti a tabulátorok számát
    static void dec(){
        tab--;
    }
}
