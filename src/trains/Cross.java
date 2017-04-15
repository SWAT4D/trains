package trains;

public class Cross extends Rail{
    private Rail altnextR;
    private Rail altprevR;
    
    Cross(){
        altnextR = null;
        altprevR = null;
    }
    
    /**
     * Beállítja a következő, keresztbemenő sínt
     * @param next 
     */
    public void addNextAlt(Rail next){
        altnextR = next;
        if (altnextR != null)
            altnextR.addPrev(this);
    }
    
    /**
     * Ha már van következő síne, akkor a keresztbemenőt állítja
     * @param next 
     */
    @Override
    public void addNext(Rail next) {
        if (nextR == null)
            super.addNext(next);
        else
            addNextAlt(next);
    }

    /**
     * Beállítja az előző, keresztbemenő sínt
     * @param prev 
     */
    public void addPrevAlt(Rail prev){
        altprevR = prev;
    }
    
    /**
     * Ha már van előző síne, akkor a keresztbemenőt állítja
     * @param prev 
     */
    @Override
    public void addPrev(Rail prev) {
        if (prevR == null)
            super.addPrev(prev);
        else
            addPrevAlt(prev);
    }

    /**
     * Az alapján hogy a vonatelem merről jött, visszaadja hogy merre menjen tovább.
     * @param prev honnan jött a vonat
     * @return merre menjen tovább
     */
    @Override
    public Rail next(Rail prev) {
        if (prevR == prev)          return nextR;
        else if (nextR == prev)     return prevR;
        else if (altprevR == prev)  return altnextR;
        else                        return altprevR;
    }
    
}
