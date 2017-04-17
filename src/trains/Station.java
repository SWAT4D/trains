package trains;

/**
 * Az állomás osztálya
 */
public class Station extends Rail {

    private String color;
    /**
     * Default constructor
     */
    public Station(String c)
    {
        color = c;
    }

    /**
     * Az állomás elfoglalása egy vonat által
     * @param trainElement
     */
    public void occupy(TrainElement trainElement) throws OccupyException
    {
        //ha foglalt már akkor kivételt dob
        if (isOccupied)
        {
            throw new OccupyException(this);
        }
        //ha nem foglalt, akkor elfoglaljuk és a rálépő elemet megpróbáljuk üríteni
        else
        {
            trainElement.moveNext();
            isOccupied = true;
            train = trainElement;
            //train.empty(color);
        }
    }

    @Override
    public String toString() {
        return "S";
    }
}
