import java.util.ArrayList;

/**
 * 
 */
public class Locomotive implements TrainElement {

    private Car nextCar;
    private Rail cur;
    private Rail prev;

    /**
     * Locomotive's previous position is the EndVoid
     */
    public Locomotive(EndVoid ev) {
        Logger.logStart("Locomotive created");
        prev = ev;
        Logger.logEnd();
    }



    /**
     * @param car
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
     * 
     */
    public void startCounter() {
        Logger.logStart("void startCounter()");
    }

    /**
     * Does nothing.
     * @param color
     */
    public void empty(String color) {
        Logger.logStart("void empty(String color)");
    }

    /**
     * 
     */
    public void stop(EndVoid endVoid) {
        Logger.logStart("void stop(EndVoid endVoid)");
        moveNext();
        nextCar.move(endVoid);
        Logger.logEnd();
    }

    /**
     *
     */
    public void moveNext() {
        Logger.logStart("void moveNext()");
        nextCar.move(cur); // TODO: prev or cur? Same as in the Car
        Logger.logEnd();
    }

    /**
     * TODO: Later this should be private or implemented by the start method
     * Now we can use this to make the locomotve step only one
     *
     */
    public void moveOne(){
        Logger.logStart("TODO HERE! void moveOne()");
        Rail railNext = cur.next(prev);
        if(railNext == null){
            Logger.logMessage("GAME OVER: Cause: No more rails"); // TODO: Stop the game, not just logStart it.
            System.exit(1);
        }
        cur.leave();
        prev = cur;

        railNext.occupy(this);
        cur = railNext;
        Logger.logEnd();

    }

    @Override
    public void logPos(ArrayList<Rail> railList) {
        Logger.logMessage(this.toString() + " " + Integer.toString(railList.indexOf(this.cur)));
    }

}