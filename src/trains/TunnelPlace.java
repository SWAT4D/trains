package trains;

/**
 * Alagútszájakat valósítja meg.
 * Ezekből egyszerre maximum kettő lehet aktív (ilyenkor alagúttal vannak összekötve),
 * melynek ellenőrzését a Tunnel valósítja meg.
 */
public class TunnelPlace extends Rail {
	private boolean isActive;
        private Tunnel tunnel;
   
	/**
     * Alapértelmezett konstruktor.
     */
    public TunnelPlace() {
    	isActive = false;
    }


    /**
     * Aktiválás
     */
    public void setActive() {
    	if (!isActive){
    		tunnel.activeTunnelPlace(this);
    	}
    	else{
    		if(!tunnel.isOccupied())
    			tunnel.inactiveTunnelPlace(this);
    		
    	}	
    }
    /**
     * Inaktiválás
     * @param value
     */
    public void setIsActive(boolean value){
    	isActive = value;
    }

    /**
     * Alagút hozzáadása
     * @param t
     */
    public void addTunnel(Tunnel t) {
	tunnel = t;
    }

    @Override
    public String toString(){
        return "T";
    }
}
