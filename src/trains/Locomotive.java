package trains;

import java.awt.*;

/**
 * A mozdony osztálya, a játékban a mozdonyt reprezentálja.
 * Ismeri aktuális és előző pozícióját (Rail).
 * Képes egyik Rail-ről átlépni a haladási iránya szerinti következőre (step függvény hatására).
 * Lépésekor, húzza a maga után következő kocsit.
 */
public class Locomotive implements TrainElement {

    private Car nextCar;
    private Rail cur;
    private Rail prev;
    boolean finish= false;
    boolean locoOut = false;


    /**
     * 2 paraméteres konstruktor
     * @param cur A mozdony aktuális pozíciója
     * @param prev A mozdony előző pozíciója
     */
    public Locomotive(Rail cur, Rail prev) {
        this.cur = cur;
        this.prev = prev;
        finish = false;
        locoOut = false;
    }

    /**
     * Egy endVoid paraméteres konstruktor, a mozdony elözö poziciója a játékban az endVoid
     */
    public Locomotive(EndVoid ev) {
        prev = ev;
        finish = false;
        locoOut = false;
    }



    /**
     * A mozdonyhoz csatol egy kocsit
     * @param car ezt a kocsit csatolja a mozdonyhoz
     */
    public void addNext(Car car) {
        nextCar = car;
        if (nextCar != null)
            nextCar.addPrev(this);
    }

    /**
     * @param entryPoint
     */
    public void setStartPlace(EntryPoint entryPoint) throws OccupyException {
        cur = entryPoint;
        cur.occupy(this);
    }

    /**
     * Ezzel lehet a mozdonyt léptetni
     */
    public void step() throws OccupyException {
        // Ha még vannak kocsik amik nem értek ki a pályáról, akkor léptetjük csak
        if( !finish ) {
            Rail railNext = cur.next(prev);
            if (railNext == null) {
                throw new OccupyException("Vakvágányra futott a vonat");
            } else {
                cur.leave();
                prev = cur;

                railNext.occupy(this);
                cur = railNext;
            }
        }

    }


    /**
     * Ez kezeli azt az eseményt, ha a vonat elem állomásra került
     * A mozdony ekkor nem csinál semmit
     * @param color állomás színe
     */
    @Override
    public void empty(String color) {}

    /**
     * A teljes vonat pályaelhagyásáért felelős
     * EndVoid hívja meg, ha ráért az adott TrainElement
     * Ezzel jelzi a TrainElementnek, hogy a pálya szélére ért
     * A mozdony megvárja a kocsijai kiérjenek és szoljanak neki, hogy kiértek.
     * @param endVoid
     */
    @Override
    public void leave(EndVoid endVoid) {
        locoOut = true;
    }

    @Override
    public boolean isFirstForward() {
        return false;
    }

    /**
     * A mozdony mögötti kocsit lépteti
     */
    public void moveNext() throws OccupyException {
        nextCar.move(cur);
    }


    /**
     * Hatására átállítja a finish attribútum értékét igazra.
     */
    @Override
    public void finish() {
        if(locoOut){
            finish = true;
        }
    }

    /**
     * Visszatér az mozdony pályán való jelével
     */
    @Override
    public String toString() {
        return "l";
    }

    /*    *
     * Mozgatja a mögötte lévő kocsikat az endVoidra
     * Akkor hívódik meg, ha endVoidra kerül a mozdony
     * @param endVoid ide mozgatja a kocsikat

    public void stop(EndVoid endVoid) throws OccupyException {
        Logger.logStart("stop(EndVoid) " + this);
        moveNext();
        if(Main.play) {
            nextCar.move(endVoid);
        }
        Logger.logEnd();
    }*/
}