package trains;

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
        Logger.logStart("addNext(Car) " + this);
        nextCar = car;
        Logger.logEnd();
    }

    /**
     * @param entryPoint
     */
    public void setStartPlace(EntryPoint entryPoint) {
        Logger.logStart("setStartPlace(EntryPoint) " + this);
        cur = entryPoint;
        Logger.logEnd();
    }

    /**
     * Ezzel lehet a mozdonyt léptetni
     */
    public void step() {
        Logger.logStart("step() " + this);
        Rail railNext = cur.next(prev);
        if(railNext == null){
            Logger.logMessage("GAME OVER: Egy vonat vakvágányra ért, lefutott a sínről.");
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
        Logger.logStart("empty(String) " + this);
        Logger.logEnd();
    }

    /**
     * Mozgatja a mögötte lévő kocsikat az endVoidra
     * Akkor hívódik meg, ha endVoidra kerül a mozdony
     * @param endVoid ide mozgatja a kocsikat
     */
    public void stop(EndVoid endVoid) {
        Logger.logStart("stop(EndVoid) " + this);
        moveNext();
        nextCar.move(endVoid);
        Logger.logEnd();
    }

    /**
     * A mozdony mögötti kocsit lépteti
     */
    public void moveNext() {
        Logger.logStart("moveNext() " + this);
        nextCar.move(cur);
        Logger.logEnd();
    }

}