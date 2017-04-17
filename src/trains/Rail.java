package trains;

/**
 * 
 */
public class Rail{

    protected Rail nextR;
    protected Rail prevR;
    protected boolean isOccupied;
    /**
     * Default constructor
     */
    public Rail() {
        nextR = null;
        prevR = null;
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
     * @throws trains.OccupyException
     */
    public void occupy(TrainElement trainElement) throws OccupyException{
        if (isOccupied){
            throw new OccupyException(this);
        }
        else {
            trainElement.moveNext();
            isOccupied = true;
        }
    }

    /**
     * A sín elhagyása egy vonat álltal
     */
    public void leave() {
        isOccupied = false;
    }

    @Override
    public String toString(){
        return "+";
    }
}
