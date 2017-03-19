package trains;

/**
 * 
 */
public class TunnelPlace extends Rail {
	private boolean isActive;
   
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
    	Logger.logStart("Begin of activation of a TP.");
    	if (!isActive){
    		Tunnel.activeTunnelPlace(this);
    	}
    	else{
    		if(!Tunnel.isOccupied())
    			Tunnel.inactiveTunnelPlace(this);
    		
    	}	
    	Logger.logEnd();
    }
    
    public void setIsActive(boolean value){
    	isActive = value;
    }

    /**
     * 
     */
    public void addTunnel() {
        // Ez mi, és mire jó?
    }

}
