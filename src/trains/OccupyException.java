package trains;

public class OccupyException extends Exception{
    private final String message;
    //TODO a message csak placeholder, nemtudom hogyan kéne csinálni
    //Továbbá lehet érdemes külön packagebe tenni 
    //(ahogy pl a vonatokat is érdemes lehet majd elválasztani a sinektől, csak hogy szép legyen :) )
    
    public OccupyException(Rail rail){
       message = rail.toString() + "-en Ütközés történt";
    }

    public OccupyException(EntryPoint ep){
        message = ep.toString() + "-en utasokat tartalmazó kocsi elhagyta a pályát";
    }
    
    public OccupyException(){
       message = "Ütközés történt";
    }
    public OccupyException(String s){
        message = s;
    }
    
    @Override
    public String getMessage() {
        return message; 
    }
    
}
