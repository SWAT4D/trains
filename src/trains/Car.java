package trains;

import java.awt.*;
import java.util.*;

/**
 * A kocsi osztálya
 */
public class Car implements TrainElement {

    private Car nextCar;
    private Rail cur;
    private String clr;

    /**
     * 1 paraméteres konstruktor, teszteléshez használható
     * @param cur A kocs előző pozíciója
     */
    public Car(Rail cur) {
        Logger.logStart("Car created");
        this.cur = cur;
        Logger.logEnd();
    }

    /**
     * Egy endVoid paraméteres konstruktor, a kocsi a játékban endVoidról indul
     * @param endVoid
     */
    public Car(EndVoid endVoid, String color) {
        Logger.logStart("Car created");
        cur = endVoid;
        clr = color;
        Logger.logEnd();

    }


    /**
     * A kocsihoz csatol egy kocsit
     * @param car ezt a kocsit csatolja a kocsihoz
     */
    public void addNext(Car car) {
        Logger.logStart("addNext(Car) - " + this);
        nextCar = car;
        Logger.logEnd();
    }

    /**
     * Elmozditja a kocsit
     * @param rail ide mozgatja a kocsit
     */
    public void move(Rail rail) throws OccupyException {
        Logger.logStart("move(Rail) - " + this);

        cur.leave();
        rail.occupy(this);

        Logger.logEnd();
    }

    /**
     * Ez a kocsi lesz a vonat első nem üres kocsija
     */
    public void markAsFirst() {
        Logger.logStart("markAsFirst() - " + this);
        Logger.logEnd();
    }

    /**
     * Kiüriti a kocsit, ha ez a kocsi az első nem üres kocsi, és a paraméterben kapott szín megegyezik a kocsi színével
     * @param color
     */
    //@Override
    public void empty(Color color) {
        Logger.logStart("empty(String) " + this);

        Scanner scanner = new Scanner(System.in);

        // FIRST CHECK
        Logger.logMessage("A " + this +" kocsi a vonat első, nem üres kocsija? (true/false)");
        if (scanner.nextBoolean()==true){
            // COLOR CHECK
            Logger.logMessage("Meg egyezik-e a " + this +" kocsi színe ezzel: " + color + " (true/false)");
            if(scanner.nextBoolean()==true){
                if(nextCar != null){
                    nextCar.markAsFirst();
                }
            }
        }
        scanner.nextLine(); // Discard '\n'
        Logger.logEnd();
    }

    /**
     * Ha nincsenek utasok a kocsin, akkor mozgatja a mögötte lévő kocsikat az endVoidra.
     * Ha vannak utasok a kocsin, akkor a vége a játéknak.
     * Akkor hívódik meg, ha endVoidra kerül a kocsi.
     * @param endVoid ide mozgatja a kocsikat
     */
    //@Override
    public void stop(EndVoid endVoid) throws OccupyException {
        Logger.logStart("stop(EndVoid) " + this);

        Scanner scanner = new Scanner(System.in);
        Logger.logMessage("Vannak utasok a " + this + " kocsin? (true/false)");
        // FULL CHECK
        if(scanner.nextBoolean()==true){
            Logger.logMessage("GAME OVER: Utasokat tartalmazó kocsi elhagyta a pályát");
            //Main.play=false;
        }
        else{
            this.moveNext();
            // Ha van még kocsi kihuzzuk

            // TODO: Késleltetés majd kéne
            /*if(Main.play) {
=======
            if(Main.play) {
>>>>>>> refs/remotes/origin/master
                if (nextCar != null) {
                    nextCar.move(endVoid);
                }
            }*/
        }
        scanner.nextLine(); // Discard '\n'
        Logger.logEnd();
    }




    @Override
    public void leave(EndVoid endVoid) {

    }

    @Override
    public boolean isFirstForward() {
        return false;
    }

    /**
     *  A kocsi mögötti kocsit lépteti
     */
    @Override
    public void moveNext() throws OccupyException {
        Logger.logStart("moveNext() " + this);

        if(nextCar != null){
            nextCar.move(cur);
        }
        Logger.logEnd();
    }

//<<<<<<< HEAD
    @Override
    public String toString() {
        return clr;
    }
}
/*=======
}
>>>>>>> refs/remotes/origin/master*/
