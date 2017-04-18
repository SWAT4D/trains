package trains;

import java.awt.*;

public class GiverStation extends Station {
    /**
     * Default constructor
     *
     * @param c
     */
    public GiverStation(String c) { super(c); }

    public void occupy(TrainElement trainElement) throws OccupyException
    {
        if (isOccupied)
        {
            throw new OccupyException(this);
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
