package trains;

/**
 * 
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
     */
    public void setIsActive(boolean value){
    	isActive = value;
    }

    /**
     * Alagút hozzáadása
     */
    public void addTunnel(Tunnel t) {
	tunnel = t;
    }
<<<<<<< HEAD

	@Override
	public String toString() {
		return "T";
	}
=======
    
    @Override
    public String toString(){
        return "T";
    }
>>>>>>> refs/remotes/origin/master
}
