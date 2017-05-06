package trains;

/**
 * A váltó osztálya
 */
public class Switch extends Rail {

    protected Rail nextAltR;
    private boolean isMain;
    /**
     * Default constructor
     */
    public Switch()
    {
        isMain = true;
        nextAltR = null;
    }


    /**
     * Mellékvágány hozzáadása
     * @param next
     */
    public void addNextAlt(Rail next) {
        nextAltR = next;
        if (nextAltR != null)
            nextAltR.addPrev(this);
    }

    /**
     * Váltó váltása
     */
    public void switchIt()
    {
        isMain = !isMain;
    }

    /**
     * Következő elem lekérése
     * @param prev
     * @return
     */
    @Override
    public Rail next(Rail prev)
    {
        if (nextR != prev && nextAltR != prev)
        {
            if (isMain)
            {
                return nextR;
            }
            else
            {
                return nextAltR;
            }
        }
        else
        {
            if (nextR == prev)
            {
                if (isMain)
                {
                    return prevR;
                }
                else return null;
            }
            if (nextAltR == prev)
            {
                if (!isMain)
                {
                    return prevR;
                }
                else return null;
            }
            else
            {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        if(isMain){
            return "F";
        }
        else{
            return "M";
        }

    }
}
