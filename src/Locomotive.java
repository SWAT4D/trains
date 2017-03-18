
import java.util.*;

/**
 * 
 */
public class Locomotive implements TrainElement {

    private Car nextCar;
    private Rail cur;
    private Rail prev;

    /**
     * 2 paraméteres konstruktor teszteléshez használható
     * @param cur A mozdony aktuális pozíciója
     * @param prev A mozdony előző pozíciója
     */
    public Locomotive(Rail cur, Rail prev) {
        Logger.logStart("Locomotive created");
        this.cur = cur;
        this.prev = prev;
        Logger.logEnd();
    }

    /**
     * Egy endVoid paraméteres konstruktor, a mozdony elözö poziciója a játékban az endVoid
     */
    public Locomotive(EndVoid ev) {
        Logger.logStart("Locomotive created");
        prev = ev;
        Logger.logEnd();
    }



    /**
     * A mozdonyhoz csatol egy kocsit
     * @param car ezt a kocsit csatolja a mozdonyhoz
     */
    public void addNext(Car car) {
        Logger.logStart("void addNext(Car car)");
        nextCar = car;
        Logger.logEnd();
    }

    /**
     * @param entryPoint
     */
    public void setStartPlace(EntryPoint entryPoint) {
        Logger.logStart("void setStartPlace(EntryPoint entryPoint)");
        cur = entryPoint;
        Logger.logEnd();
    }

    /**
     * Ezzel lehet a mozdonyt léptetni
     */
    public void step() {
        Logger.logStart("void step()");
        Rail railNext = cur.next(prev);
        if(railNext == null){
            Logger.logMessage("GAME OVER: railNext = NULL");
        }
        else {
            cur.leave();

            railNext.occupy(this);
        }
        Logger.logEnd();
    }

    /**
     * Nem csinál semmit
     * @param color
     */
    public void empty(String color) {
        Logger.logStart("void empty(String color)");
        Logger.logEnd();
    }

    /**
     * HELP PLS
     */
    public void stop(EndVoid endVoid) {
        // TODO implement here
    }

    /**
     * A vonat mögötti kocsit lépteti
     */
    public void moveNext() {
        Logger.logStart("void moveNext()");
        nextCar.move(cur);
        Logger.logEnd();
    }

}