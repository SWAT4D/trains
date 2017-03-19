package trains;

/**
 * A váltó osztálya
 */
public class Switch extends Rail {

    private Rail nextAltR;
    private boolean isMain;
    /**
     * Default constructor
     */
    public Switch()
    {
        Logger.logStart("Switch created");
        isMain = true;
        nextAltR = null;
        Logger.logEnd();
    }


    /**
     * Mellékvágány hozzáadása
     * @param next
     */
    public void addNextAlt(Rail next)
    {
        Logger.logStart("addNextAlt(Rail) - " + this);
        nextR = next;
        nextR.addPrev(this);
        Logger.logEnd();
    }

    /**
     * Váltó váltása
     */
    public void switchIt()
    {
        Logger.logStart("switchIt() - " + this);
        if (isMain) isMain = false;
        else isMain = true;
    }

    /**
     * Következő elem lekérése
     * @param next
     * @return
     */
    public Rail next(Rail prev)
    {
        Logger.logStart("next(Rail) - " + this);

        if (nextR != prev && nextAltR != prev)
        {
            if (isMain)
            {
                Logger.logEnd();
                return nextR;
            }
            else
            {
                Logger.logEnd();
                return nextAltR;
            }
        }
        else
        {
            if (nextR == prev)
            {
                if (isMain)
                {
                    Logger.logEnd();
                    return prevR;
                }
                else return null;
            }
            if (nextAltR == prev)
            {
                if (!isMain)
                {
                    Logger.logEnd();
                    return prevR;
                }
                else return null;
            }
        }
    }

}
