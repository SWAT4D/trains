/**
 * 
 */
public class Rail {

    protected Rail nextRail;
    protected Rail prevRail;
    protected boolean occupied;

    /**
     * Default constructor
     */
    public Rail() {
        Logger.logStart("Rail created");
        occupied = false;
        Logger.logEnd();
    }

    /**
     * @param rail
     */
    public void addNext(Rail rail) {
        Logger.logStart("void addNext(Rail rail)");
        nextRail = rail;
        rail.addPrev(this);
        Logger.logEnd();
    }

    /**
     * @param rail
     */
    public void addPrev(Rail rail) {
        Logger.logStart("void addPrev(Rail rail)");
        prevRail = rail;
        Logger.logEnd();
    }

    /**
     * @param rail 
     * @return
     */
    public Rail next(Rail rail) {
        Logger.logStart("Rail next(Rail rail)");
        if(rail.equals(prevRail)){
            Logger.logEnd();
            return nextRail;
        }
        else if(rail.equals(nextRail)){
            Logger.logEnd();
            return prevRail;
        }
        else{
            Logger.logMessage("Rail got bad from"); // TODO: what should we do here? maybe exception?
            System.exit(1);
            Logger.logEnd();
            return null;
        }
    }

    /**
     * @param trainElement
     */
    public void occupy(TrainElement trainElement) {
        Logger.logStart("void occupy(TrainElement trainElement)");
        if(occupied){
            Logger.logStart("GAME OVER: COLLISION, Rail occupied by multiple TrainElements\n\n\n");
            System.exit(1);
        }
        occupied = true;
        trainElement.moveNext();
        Logger.logEnd();
    }

    /**
     * 
     */
    public void leave() {
        Logger.logStart("void leave()");
        occupied = false;
        Logger.logEnd();
    }

}