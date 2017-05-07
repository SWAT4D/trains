package trains;

/**
 * Alagútszájakat valósítja meg.
 * Ezekből egyszerre maximum kettő lehet aktív (ilyenkor alagúttal vannak összekötve),
 * melynek ellenőrzését a Tunnel valósítja meg.
 */
public class TunnelPlace extends Rail {
	private boolean isActive;
   
	/**
     * Alapértelmezett konstruktor.
     */
    public TunnelPlace() {
    	isActive = false;
    }

    /**
     * Ha a következő elem egy TunnelPlace, akkor azt nem adja hozzá (többi mint a Rail)
     * @param next következő elem
     */
    @Override
    public void addNext(Rail next) {
        if (next != null){
            if (next.toString().equals("T") || next.toString().equals("V"))
                return;
        }
        super.addNext(next); //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
     * Ha az előző elem egy TunnelPlace, akkor azt nem adja hozzá (többi mint a Rail)
     * @param prev előző elem
     */
    @Override
    public void addPrev(Rail prev) {
        if (prev != null){
            if (prev.toString().equals("T") || prev.toString().equals("V"))
                return;
        }
        super.addPrev(prev); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Aktiválás
     */
    public void setActive() {
    	if (!isActive){
            Tunnel.getInstance().activeTunnelPlace(this);
    	}
    	else{
            if(!Tunnel.getInstance().isOccupied())
                Tunnel.getInstance().inactiveTunnelPlace(this);
    		
    	}	
    }
    /**
     * Inaktiválás
     * @param value
     */
    public void setIsActive(boolean value){
    	isActive = value;
    }

    @Override
    public String toString(){
        if (isActive)
            return "T";
        else
            return "V";
    }
}
