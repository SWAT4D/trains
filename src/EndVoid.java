/**
 * 
 */
public class EndVoid extends Rail {

    /**
     * Default constructor
     */
    public EndVoid() {
    }

    /**
     * @param trainElement
     */
    public void occupy(TrainElement trainElement) {
        Logger.logStart("void occupy(TrainElement trainElement)");
        trainElement.stop(this);

        // TODO: According to moveCarEnd sequence diagram
        // TODO: it is the responsibility of this method
        // TODO: to check whether all cars are out of the map,
        // TODO: and if so then stop the game
        // TODO: ^ This should be implemented  here, or we should find a better place for this
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
            return this; // EndVoid does not have a nextRail, so it returns itself
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

}