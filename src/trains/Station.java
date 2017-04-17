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
        Logger.logStart("Station created");
        color = c;
        Logger.logEnd();
    }

    /**
     * Az állomás elfoglalása egy vonat által
     * @param trainElement
     */
    public void occupy(TrainElement trainElement)
    {
        /*
        Logger.logStart("occupy(TrainElement) - " + this);
        if (Main.isoccupied == true)
        {
            Logger.logMessage("GAME OVER: Ütközés történt, két vonat egy pozíción tartózkodik.");
            Main.play=false;
        }
        else
        {
            trainElement.empty(color);
            trainElement.moveNext();
        }
        Logger.logEnd();*/
    }

}
