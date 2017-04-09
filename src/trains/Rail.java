package trains;

import java.util.*;

/**
 * 
 */
public class Rail extends Placeable{

    private Rail nextR;
    private Rail prevR;
    
    /**
     * Default constructor
     */
    public Rail() {
        Logger.logStart("Rail created");
        nextR = null;
        prevR = null;
        Logger.logEnd();
    }

    /**
     * Kovetkezo elem hozzaadasa
     * @param next
     */
    public void addNext(Rail next) {
        Logger.logStart("addNext(Rail) - " + this);
        nextR = next;
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
        
        Logger.logMessage("Foglalt már a " + this + " sín?");
        Scanner sc = new Scanner(System.in);
        if (sc.nextBoolean() == true){
            Logger.logMessage("GAME OVER: Ütközés történt, két vonat egy pozíción tartózkodik.");
            //Main.play=false;
        }
        else {
            trainElement.moveNext();
        }
        sc.nextLine(); // Discard '\n'
        Logger.logEnd();
    }

    /**
     * A sín elhagyása egy vonat álltal
     */
    public void leave() {
        Logger.logStart("leave() - " + this);
        
        Logger.logEnd();
    }

}
