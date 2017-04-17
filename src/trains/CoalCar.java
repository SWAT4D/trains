package trains;

import java.awt.*;

public class CoalCar extends Car{

    @Override
    public void markAsFirst(){
        if(nextCar != null)
            nextCar.markAsFirst();
    }

    @Override
    public void empty(Color color){

    }

    public CoalCar(EndVoid endVoid) {
        super(endVoid, "c");
    }
}
