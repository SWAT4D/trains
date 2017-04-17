package trains;

import java.awt.*;

public class CoalCar extends Car{

    @Override
    public void markFirst(boolean value){
        if(carBehind != null) {
            carBehind.markFirst(false);
        }
    }

    @Override
    public void empty(String color){

    }

    public CoalCar(EndVoid endVoid) {
        super(endVoid, "c");
    }

}
