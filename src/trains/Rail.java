package trains;


public class Rail {

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
     * @throws java.lang.Exception
     */
    public void occupy(TrainElement trainElement) throws Exception{
        // TODO Exception álltalunk csinált leszármazottját dobni
        // TODO összes leszármazottjában is be kell állítani ezt!
        if (isOccupied){
            throw new Exception();
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
}
