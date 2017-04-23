package trains;

/**
 * Az állomás osztálya
 */
public class Station extends Rail {

    protected String color;
    /**
     * Default constructor
     * @param c
     */
    public Station(String c)
    {
        color = c;
    }

    /**
     * Az állomás elfoglalása egy vonat által
     * @param trainElement
     * @throws trains.GameOverException
     */
    @Override
    public void occupy(TrainElement trainElement) throws GameOverException
    {
        //ha foglalt már akkor kivételt dob
        if (isOccupied)
        {
            throw new GameOverException(this);
        }
        //ha nem foglalt, akkor elfoglaljuk és a rálépő elemet megpróbáljuk üríteni
        else
        {
            trainElement.moveNext();
            isOccupied = true;
            train = trainElement;
            train.empty(color);
        }
    }

    @Override
    public String toString() {
        return "S";
    }

    public String getColor(){
        return color;
    }
}
