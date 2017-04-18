package trains;

/**
 * A sín osztálya, innen származik le minden osztály, amin a vonat haladhat.
 * Meghatározza, hogy a rajta lévő vonat merre mehet tovább,
 * azáltal, hogy megkapja merről érkezett.
 * Tudja, hogy tartózkodik-e rajta mozdony/kocsi vagy nem.
 */
public class Rail{

    protected Rail nextR;
    protected Rail prevR;
    protected boolean isOccupied;
    protected TrainElement train;
    /**
     * Default constructor
     */
    public Rail() {
        nextR = null;
        prevR = null;
        train = null;
        isOccupied = false;
    }

    /**
     * Kovetkezo elem hozzaadasa
     * @param next
     */
    public void addNext(Rail next) {
        nextR = next;
        if (nextR != null)
            nextR.addPrev(this);
    }

    /**
     * Elozo elem hozzaadasa
     * @param prev
     */
    public void addPrev(Rail prev) {
        prevR = prev;
    }

    /**
     * Következő elem lekérése az előző alapján
     * @param prev előző sín
     * @return
     */
    public Rail next(Rail prev) {
        if (prevR == prev) return nextR;
        else               return prevR;
    }

    /**
     * A sín elfoglalása egy vonat álltal
     * @param trainElement
     * @throws GameOverException
     */
    public void occupy(TrainElement trainElement) throws GameOverException {
        if (isOccupied){
            throw new GameOverException(this);
        }
        else {
            trainElement.moveNext();
            isOccupied = true;
            train = trainElement;
        }
    }

    /**
     * A sín elhagyása egy vonat álltal
     */
    public void leave() {
        isOccupied = false;
        train = null;
    }

    /**
     * A sínen tartózkodó trainElement lekérdezése
     */
    public TrainElement getTrain(){
        return train;
    }

    @Override
    public String toString(){
        return "+";
    }
}
