package trains;

import java.util.Scanner;

/**
 * 
 */
public class Tunnel extends Rail {
	
	private static Rail start, end;
	/**
	 * Currently active TPs
	 */
	private static int activeNum = 0;
	private static TunnelPlace first, sec;
	private static Tunnel instance = null;
    
	/**
     * Default private constructor
     */
    private Tunnel() {
    	Logger.logStart("The One-And-Only Tunnel was created.");
    	/*
    	 * TEMP! 
    	 */
    	start = new Rail();
    	end = new Rail();
    	first = null;
    	sec = null;
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
    public void activeTunnelPlace(TunnelPlace tunnelPlace) {
    	Logger.logStart("activeTunnelPlace(TunnelPlace) - " + this);
    	switch (activeNum){
	    	case 0:
	    		Logger.logMessage("TP activated. There is 1 active.");
	    		first = tunnelPlace;
	    		start.addPrev(tunnelPlace);
	    		activeNum++;
	    		first.setIsActive(true);
			Logger.logEnd();
	    		break;
	    	case 1:
	    		Logger.logMessage("TP activated. There are 2 actives.");
	    		sec = tunnelPlace;
	    		end.addNext(sec);
	    		first.addNext(start);
	    		sec.addNext(end);
	    		activeNum++;
	    		sec.setIsActive(true);
	    		Logger.logEnd();
	    		break;
	    	case 2:
	    		Logger.logMessage("There are 2 active TPs already!");
	    		Logger.logEnd();
	    		break;
	    	default:
	    		Logger.logMessage("WTF! How did I get here?!");
        		Logger.logEnd();
        		break;
	    		
    	}
    }

    /**
     * @return
     */
    public boolean isOccupied() {
	Logger.logMessage("isOccupied() - " + this);
        Scanner sc = new Scanner(System.in); 
        Logger.logMessage("Foglalt az alagút? (true/false)");
        if (sc.nextBoolean()==true){
            Logger.logEnd();
            return true;
        }
        else{
            Logger.logEnd();
            return false;
        }
    }

    /**
     * @param tunnelPlace
     */
    public void inactiveTunnelPlace(TunnelPlace tunnelPlace ) {
    	Logger.logStart("inactiveTunnelPlace(TunnelPlace) - " + this);
    	switch (activeNum){
        	case 1:
        		Logger.logMessage("TP inactivated. There are 0 active.");
        		start.addPrev(null);
	    		activeNum--;
        		break;
        	case 2:
        		Logger.logMessage("TPs was inactivated, Tunnel was destroyed.");
        		first.setIsActive(false);
        		sec.setIsActive(false);
        		end.addNext(null);
        		start.addPrev(null);
	    		first.addNext(null);
	    		sec.addNext(null);
	    		activeNum = 0;
        		break;
        	default:
        		Logger.logMessage("WTF! How did I get here?!");
        		break;
        }
	Logger.logEnd();
        
    }

}
