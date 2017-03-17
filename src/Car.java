import java.util.ArrayList;

/**
 * 
 */
public class Car implements TrainElement {
    private Car nextCar;
    private Rail cur;
    private Rail prev;
    private boolean isFirst;
    private String color;
    private boolean full;

    /**
     * Cars starts at the endVoid
     */
    public Car(EndVoid endVoid) {
        Logger.logStart("Car created");
        isFirst = false;
        full = true;
        cur = endVoid;
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
     * @param newRail
     */
    public void move(Rail newRail) {
        Logger.logStart("void move(Rail newRail)");

        cur.leave();
        prev = cur;


        newRail.occupy(this);
        cur = newRail;
        Logger.logEnd();
    }

    /**
     * 
     */
    public void markAsFirst() {
        Logger.logStart("void markAsFirst()");
        isFirst = true;
        Logger.logEnd();
    }

    /**
     * @param color
     */
    public void empty(String color) {
        Logger.logStart("void empty(String color)");
        if (isFirst){
            if(color.equals(this.color)){
                full = false;
                if(nextCar != null){
                    nextCar.markAsFirst();
                }
            }
        }
        Logger.logEnd();
    }

    /**
     * When car arrives at the EndVoid it stops
     * 
     */
    public void stop(EndVoid endVoid) {
        Logger.logStart("void stop(EndVoid endVoid)");

        if(full){
            Logger.logMessage("GAME OVER, cause: non-empty car left the game"); // TODO: Stop the game, not just logStart it.
            System.exit(1);
        }

        this.moveNext();

        // If there is a next car we pull it too to the endVoid
        // TODO: Somehow add delay so it won't pull all imediatelly as the loco hits the end void
        // TODO: The delay should be the same as the locomotives delay
        if(nextCar != null){
            nextCar.move(endVoid);
        }
        Logger.logEnd();
    }

    /**
     *
     */
    public void moveNext() {
        Logger.logStart("void moveNext()");

        if(nextCar != null){
            nextCar.move(cur); // TODO: prev or cur?
        }
        Logger.logEnd();
    }

    @Override
    public void logPos(ArrayList<Rail> railList) {
        Logger.logMessage(this.toString() + " " + Integer.toString(railList.indexOf(this.cur)));
    }

}