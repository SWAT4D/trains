package trains;

import java.awt.*;

public class CoalCar extends Car{

    //Rogtön továbbadja az első nem üres köcsi jelzést az utána következő kocsinak
    @Override
    public void markFirst(boolean b){
        if(carBehind != null)
            carBehind.markFirst(b);
    }

    //Nem tud feltöltődni
    public void fillCar(String color) {

    }

    //Nem tud kiürülön a kocsi
    @Override
    public void empty(String color){

    }

    public CoalCar(EndVoid endVoid) {
        super(endVoid, "c");
    }

}
