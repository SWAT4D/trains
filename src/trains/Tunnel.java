package trains;

import java.util.Scanner;

/**
 * Alagút megvalósítása, melyből egyszerre mindig csak egy lehet a pályán.
 */
public class Tunnel extends Rail {
	
	private Rail start, end;
	private int activeNum = 0;
	private TunnelPlace first, sec;
	private static Tunnel instance = null;
    
	/**
     * Alapértelmezett (privát) konstruktor
     */
    private Tunnel() {
    	/*
    	 * TEMP!
    	 */
    	start = new Rail();
    	end = new Rail();
    	first = null;
    	sec = null;
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
    
   /** Csak a teszthez ki lehet törölni az intance-ot
     */
   public static void clearInstance(){
       instance = null;
   } 

    /** Alagútszáj aktiválása.
     * @param tunnelPlace
     */
    public void activeTunnelPlace(TunnelPlace tunnelPlace) {
    	switch (activeNum){
	    	case 0:
	    		first = tunnelPlace;
	    		start.addPrev(tunnelPlace);
	    		activeNum++;
	    		first.setIsActive(true);
	    		break;
	    	case 1:	    		
	    		sec = tunnelPlace;
	    		end.addNext(sec);
	    		first.addNext(start);
	    		sec.addNext(end);
	    		activeNum++;
	    		sec.setIsActive(true);
	    		break;
	    	case 2:
	    		break;
	    	default:
        		break;
	    		
    	}
    }

    /** Alagút foglaltságának lekérdezése
     * @return Foglalt-e az alagút.
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    /** Alagútszáj inaktiválása
     * @param tunnelPlace
     */
    public void inactiveTunnelPlace(TunnelPlace tunnelPlace ) {
    	switch (activeNum){
        	case 1:        		
        		start.addPrev(null);
	    		activeNum--;
        		break;
        	case 2:       		
        		first.setIsActive(false);
        		sec.setIsActive(false);
        		end.addNext(null);
        		start.addPrev(null);
	    		first.addNext(null);
	    		sec.addNext(null);
	    		activeNum = 0;
        		break;
        	default:       		
        		break;
        }
        
    }
    
    @Override
    public String toString(){
        return "~";
    }
    
    int getActiveNum(){
    	return activeNum;
    }
}
