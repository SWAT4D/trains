package trains;

/**
 * Alagút megvalósítása, melyből egyszerre mindig csak egy lehet a pályán.
 */
public class Tunnel{
	
	private Rail r1,r2,r3;
	private int activeNum = 0;
	private TunnelPlace first, sec;
        private boolean isOccupied = false;
	private static Tunnel instance = null;
    
	/**
     * Alapértelmezett (privát) konstruktor
     */
    private Tunnel() {
    	first = null;
    	sec = null;
    	r1 = r2 = r3 = null;
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
	    		activeNum++;
	    		first.setIsActive(true);
	    		break;
	    	case 1:	    		
	    		sec = tunnelPlace;
	    		activeNum++;
	    		sec.setIsActive(true);
	    		generateTunnel();
	    		break;
	    	case 2:
	    		break;
	    	default:
        		break;
    	}
    }

    /** Alagút foglaltságának lekérdezése
     * akkor van benne vonat, ha bármelyik belső eleme foglalt
     * @return Foglalt-e az alagút.
     */
    public boolean isOccupied() {
        boolean occupied = false;
        try{
            occupied = first.isOccupied || r1.isOccupied || r2.isOccupied || r3.isOccupied || sec.isOccupied;
        }catch(NullPointerException npex){
            //do nothing :), shit happens
        }
        return occupied;
    }

    /** Alagútszáj inaktiválása
     * @param tunnelPlace
     */
    public void inactiveTunnelPlace(TunnelPlace tunnelPlace ) {
    	switch (activeNum){
        	case 1:        		
	    		activeNum--;
                first.setIsActive(false);
        		break;
        	case 2:       		
        		first.setIsActive(false);
        		sec.setIsActive(false); 	
	    		first.addNext(null);
	    		sec.addPrev(null);
	    		activeNum = 0;
	    		deGenerateTunnel();
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

	void generateTunnel(){
		// check this
		r1 = new Rail();
		r2 = new Rail();
		r3 = new Rail();

		if (first.nextR == null)
			first.addNext(r1);
		else
			first.addPrev(r1);

		r1.addPrev(first);

		r1.addNext(r2);
		r2.addPrev(r1);

		r2.addNext(r3);
		r3.addPrev(r2);

		if (sec.nextR == null)
			sec.addNext(r3);
		else
			r3.addNext(sec);
	}
    
    void deGenerateTunnel(){
    	r1 = r2 = r3 = null;
    	first.addNext(null);
    	sec.addPrev(null);
    }
}
