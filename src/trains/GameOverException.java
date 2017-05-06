package trains;

/**
 * Játék vége kivétel
 * Akkor dobódik, ha valami miatt váratlanul vége a játéknak.
 */
public class GameOverException extends Exception{
    private final String message;

    /**
     * Rail paraméteres konstruktor.
     * Ezen a rail-en ütközés történt
     * @param rail
     */
    public GameOverException(Rail rail){
       message = rail.toString() + "-en Ütközés történt";
    }

    /**
     * EntryPoint paraméteres konstruktor.
     * Ezen az entryPointon elhagyta egy utasokat tartalmazó kocsi a pályát
     * @param ep
     */
    public GameOverException(EntryPoint ep){
        message = ep.toString() + "-en utasokat tartalmazó kocsi elhagyta a pályát";
    }

    public GameOverException(){
       message = "Hiba történt";
    }

    /**
     * String paraméteres konstruktor
     * @param s
     */
    public GameOverException(String s){
        message = s;
    }
    
    @Override
    public String getMessage() {
        return message; 
    }
    
}
