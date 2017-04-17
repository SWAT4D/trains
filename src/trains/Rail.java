package trains;

/**
 * 
 */
public class Rail{

    protected Rail nextR;
    protected Rail prevR;
    protected TrainElement tr;

<<<<<<< HEAD
=======
    protected Rail nextR;
    protected Rail prevR;
    
>>>>>>> refs/remotes/origin/master
    /**
     * Default constructor
     */
    public Rail() {
        Logger.logStart("Rail created");
        nextR = null;
        prevR = null;
        tr = null;
        Logger.logEnd();
    }

    /**
     * Kovetkezo elem hozzaadasa
     * @param next
     */
    public void addNext(Rail next) {
        Logger.logStart("addNext(Rail) - " + this);
        nextR = next;
        if (nextR != null)
            nextR.addPrev(this);
        Logger.logEnd();
    }

    /**
     * Elozo elem hozzaadasa
     * @param rail
     */
    public void addPrev(Rail rail) {
        Logger.logStart("addPrev(Rail) - " + this);
        prevR = rail;
        Logger.logEnd();
    }

    /**
     * Következő elem lekérése
     * @param prev 
     * @return
     */
    public Rail next(Rail prev) {
        Logger.logStart("next(Rail) - " + this);
        
        if (nextR != prev){
            Logger.logEnd();
            return nextR;
        }
        else {
            Logger.logEnd();
            return prevR;
        }
    }

    /**
     * A sín elfoglalása egy vonat álltal
     * @param trainElement
     */
    public void occupy(TrainElement trainElement) {
        Logger.logStart("occupy(TrainElement) - " + this);

        if (Main.isoccupied){
            Logger.logMessage("GAME OVER: Ütközés történt, két vonat egy pozíción tartózkodik.");
            //Main.play=false;
        }
        else {
            trainElement.moveNext();
            tr = trainElement;
        }

        Logger.logEnd();
    }

    public TrainElement getTrain(){
        return tr;
    }

    /**
     * A sín elhagyása egy vonat álltal
     */
    public void leave() {
        Logger.logStart("leave() - " + this);
<<<<<<< HEAD
        tr = null;
=======
>>>>>>> refs/remotes/origin/master
        Logger.logEnd();
    }

    @Override
    public String toString(){
        return "+";
    }
}
