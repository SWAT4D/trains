package trains;

/**
 * 
 */
public class TunnelPlace extends Rail {
	private boolean isActive;
	private Rail nextR, prevR;
   
	/**
     * Default constructor
     */
    public TunnelPlace() {
    	
    	Logger.logStart("TunnelPlace Created");
    	isActive = false;
    	nextR = null;
    	prevR = null;
    	Logger.logEnd();
    }


    /**
     * 
     */
    public void setActive() {
    	if (isActive){
    		Tunnel.activeTunnelPlace(this);
    	}
    	else{
    		if(!Tunnel.isOccupied())
    			Tunnel.inactiveTunnelPlace(this);
    		
    	}	
    }

    /**
     * 
     */
    public void addTunnel() {
        // Ez mi, és mire jó?
    }

}
