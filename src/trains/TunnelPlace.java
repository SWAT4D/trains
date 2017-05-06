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
