package trains;

/**
 * 
 */
public class Tunnel extends Rail {
	
	private static Rail start, end;
	/**
	 * Currently active TPs
	 */
	private static int activeNum;
	private static TunnelPlace first, sec;
	private static Tunnel instance = null;
    
	/**
     * Default private constructor
     */
    private Tunnel() {
    	Logger.logStart("The One-And-Only Tunnel was created.");
    	start = null;
    	end = null;
    	first = null;
    	sec = null;
    	activeNum = 0;
    	Logger.logEnd();
    }
    
    /**
     * Singleton pattern megvalósításához használt "Instance" metódus.
     * Egy olyan "konstruktort" valasótunk meg vele, 
     * amely nem enged több objektumot létrehozódni.
     * @return A lézető (Single) objektumot adja minden esetben.
     */
    public static Tunnel getInstance(){
   	 if(instance == null) {
            instance = new Tunnel();
         }
         return instance;
   }


    /**
     * @param tunnelPlace
     */
    public static void activeTunnelPlace(TunnelPlace tunnelPlace) {
    	switch (activeNum){
	    	case 0:
	    		Logger.logStart("TP activated. There are 1 active.");
	    		first = tunnelPlace;
	    		start.addPrev(first);
	    		activeNum++;
	    		Logger.logEnd();
	    		break;
	    	case 1:
	    		Logger.logStart("TP activated. There are 2 active.");
	    		sec = tunnelPlace;
	    		end.addNext(sec);
	    		first.addNext(start);
	    		sec.addNext(end);
	    		activeNum++;
	    		Logger.logEnd();
	    		break;
	    	case 2:
	    		Logger.logStart("There are 2 active TPs already!");
	    		Logger.logEnd();
	    		break;
	    	default:
	    		Logger.logStart("WTF! How did I get here?!");
        		Logger.logEnd();
	    		break;
	    		
    	}
    }

    /**
     * @return
     */
    public static boolean isOccupied() {
        // TODO implement here
        return false;
    }

    /**
     * @param tunnelPlace
     */
    public static void inactiveTunnelPlace(TunnelPlace tunnelPlace ) {
        switch (activeNum){
        	case 1:
        		Logger.logStart("TP inactivated. There are 0 active.");
        		start.addPrev(null);
	    		first = null;
	    		activeNum--;
			Logger.logEnd();
        		break;
        	case 2:
        		
        		Logger.logStart("TPs was inactivated, Tunnel was destroyed.");
        		end.addNext(null);
        		start.addPrev(null);
	    		first.addNext(null);
	    		sec.addNext(null);
	    		first = null;
	    		sec = null;
	    		activeNum = 0;
	    		Logger.logEnd();
        		break;
        	default:
        		Logger.logStart("WTF! How did I get here?!");
        		Logger.logEnd();
        		break;
        }
        
    }

}
