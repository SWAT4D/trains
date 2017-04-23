package trains;

/**
 * Vonatelem interfész
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
     * @throws trains.GameOverException 
     */
    public void leave(EndVoid endVoid) throws GameOverException;

    /**
     * Megnézi hogy a kocsi előtt van-e üres kocsi valahol.
     * @return 
     */
    public boolean isFirstForward();

    /**
     * A vonat elem mögötti kocsit lépteti
     * @throws trains.GameOverException
     */
    public void moveNext() throws GameOverException;

    /**
     * Jelzi a TrainElementnek, hogy a mögötte lévő TrainElementek kiértek a pályáról
     */
    public void finish();

    /**
     * Jelzi a TrainElementnek, hogy beért a pályára
     */
    public void inside();


    /**
     * Utasok szállnak fel a TrainElementre
     * @param color
     */
    public void fillCar(String color);
}