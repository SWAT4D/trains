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
    public void empty(String color);
    
    /**
     * A teljes vonat pályaelhagyásáért felelős
     * EndVoid hívja meg, ha ráért az adott TrainElement
     * Ezzel jelzi a TrainElementnek, hogy a pálya szélére ért
     * @param endVoid 
     */
    public void leave(EndVoid endVoid) throws OccupyException;

    /**
     * Megnézi hogy a kocsi előtt van-e üres kocsi valahol.
     */
    public boolean isFirstForward();

    /**
     * A vonat elem mögötti kocsit lépteti
     */
    public void moveNext() throws OccupyException;

    /**
     * Jelzi a TrainElementnek, hogy a mögötte lévő TrainElementek kiértek a pályáról
     */
    public void finish();

    /**
     * Jelzi a TrainElementnek, hogy beért a pályára
     */
    public void inside();

}