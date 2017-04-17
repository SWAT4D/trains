package trains;

/**
 * 
 */
public class TunnelPlace extends Rail {
	private boolean isActive;
        private Tunnel tunnel;
   
	/**
     * Default constructor
     */
    public TunnelPlace() {
    	
    	Logger.logStart("TunnelPlace Created");
    	isActive = false;
    	Logger.logEnd();
    }


    /**
     * 
     */
    public void setActive() {
    	Logger.logStart("setActive() - " + this);
    	if (!isActive){
    		tunnel.activeTunnelPlace(this);
    	}
    	else{
    		if(!tunnel.isOccupied())
    			tunnel.inactiveTunnelPlace(this);
    		
    	}	
    	Logger.logEnd();
    }
    
    public void setIsActive(boolean value){
    	isActive = value;
    }

    /**
     * 
     */
    public void addTunnel(Tunnel t) {
        Logger.logStart("addTunnel(Tunnel) - " + this);
	tunnel = t;
	Logger.logEnd();
    }

	@Override
	public String toString() {
		return "T";
	}
}
