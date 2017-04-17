package trains;

import java.awt.Color;

/**
 * 
 */
public interface TrainElement {
    
    /**
     * Ez kezeli azt az eseményt, ha a vonat elem állomásra került
     * @param color állomás színe
     */
    public void empty(Color color);
    
    /**
     * A teljes vonat pályaelhagyásáért felelős
     * @param endVoid 
     */
    public void leave(EndVoid endVoid);

    /**
     * Megnézi hogy a kocsi előtt van-e üres kocsi valahol.
     */
    public boolean isFirstForward();

    /**
     * A vonat elem mögötti kocsit lépteti
     */
    public void moveNext() throws OccupyException;

}