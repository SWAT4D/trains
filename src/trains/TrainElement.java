package trains;

/**
 * 
 */
public interface TrainElement {
    
    /**
     * Ez kezeli azt az eseményt, ha a vonat elem állomásra került
     * @param color állomás színe
     */
    public void empty(String color);

    /**
     * Ez kezeli azt az eseményt, ha a vonat elem endVoidra került
     * @param endVoid erre az állomásra került a vonat
     */
    public void stop(EndVoid endVoid);

    /**
     * A vonat elem mögötti kocsit lépteti
     */
    public void moveNext();

}