
import java.util.*;

/**
 * 
 */
public interface TrainElement {

    /**
     * @param color
     */
    public void empty(String color);

    /**
     * 
     */
    public void stop(EndVoid endVoid);

    /**
     * 
     */
    public void moveNext();

    public void logPos(ArrayList<Rail> carList);


}