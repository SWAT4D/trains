package trains;

/**
 * Az osztály a pályán látható első síneket valósítja meg.
 * Kezdetben ezen a sínen vannak a mozdonyok.
 * Az egyik vége EndVoid-al a másik vége egy másik típusú sínnel van összekötve.
 */
public class EntryPoint extends Rail {

    /**
     * Konstruktor mely kéri az EndVoidot
     */
    EntryPoint(EndVoid ev){
        prevR = ev;
    }

    /**
     * Kovetkezo elem hozzaadasa
     * @param next
     */
    @Override
    public void addNext(Rail next) {
        nextR = next;
        if (nextR != null)
            nextR.addPrev(this);
    }


    /**
     * Elozo elem hozzaadasa
     * @param prev
     */
    @Override
    public void addPrev(Rail prev) {
        nextR = prev;
    }
    /**
     * @param l ezt a mozdonyt helyezi az EntryPointra
     */
    public void setTrain(Locomotive l){
        train = l;
    }

    /**
     * Az EntryPoint elfoglalása egy vonat álltal
     * A Rail occupy által megvalósítottakon fellül jelzi a TrainElementnek, hogy áthaladt egy EntryPointon.
     * @param trainElement ez a TrainElement foglalja el az EntryPointot
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
            trainElement.inside();
        }
    }

    @Override
    public String toString() {
        return "E";
    }
}
