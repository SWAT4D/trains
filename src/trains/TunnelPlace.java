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
    	Logger.logStart("setActive() - " + this);
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
    public void addTunnel(Tunnel t) {
        Logger.logStart("addTunnel(Tunnel) - " + this);
	//itt most nem csinál semmi publikus dolgot
	Logger.logEnd();
    }

}
