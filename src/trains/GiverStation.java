package trains;

/**
 * Felszálló utasok állomásának az osztálya
 */
public class GiverStation extends Station {
    /**
     * Szín paraméterű konstruktor
     * @param c ilyen színű lesz a GiverStation
     */
    public GiverStation(String c) { super(c); }

    /**
     * Az GiverStation elfoglalása egy vonat álltal
     * A Rail occupy által megvalósítottakon fellül jelzi a TrainElementnek,
     * hogy áthaladt egy GiverStationön és ennek a színét.
     * @param trainElement ez a TrainElement foglalja el az EntryPointot
     * @throws GameOverException
     */
    @Override
    public void occupy(TrainElement trainElement) throws GameOverException
    {
        if (isOccupied)
        {
            throw new GameOverException(this);
        }
        else
        {
            trainElement.moveNext();
            isOccupied = true;
            train = trainElement;
            trainElement.fillCar(color);
        }
    }

    @Override
    public String toString()
    {
        return "G";
    }
}
