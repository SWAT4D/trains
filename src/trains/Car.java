package trains;

import java.awt.*;
import java.util.*;

/**
 * A kocsi osztálya
 */
public class Car implements TrainElement {

    protected Car carBehind;
    protected TrainElement carAhead;
    protected Rail cur;
    protected String color;
    protected boolean isFirst = false;
    protected boolean isFull = true;
    protected boolean inside = false;


    /**
     * Egy endVoid paraméteres konstruktor, a kocsi a játékban endVoidról indul
     * @param endVoid
     */
    public Car(EndVoid endVoid, String color) {
        Logger.logStart("Car created");
        cur = endVoid;
        this.color = color;
        Logger.logEnd();

    }

    /**
     * A kocsihoz csatol egy kocsit
     * @param car ezt a kocsit csatolja a kocsihoz
     */
    public void addNext(Car car) {
        carBehind = car;
        if (carBehind != null)
            carBehind.addPrev(this);
    }

    /**
     * Elozo elem hozzaadasa
     * @param prev
     */
    public void addPrev(TrainElement prev) {
        carAhead = prev;
        isFirst = !carAhead.isFirstForward();
    }

    /**
     * Elmozditja a kocsit
     * @param rail ide mozgatja a kocsit
     */
    public void move(Rail rail) throws OccupyException {
        cur.leave();
        rail.occupy(this);
        cur = rail;
    }

    /**
     * Az osztály isFirst attribútuma a függvény paraméterben kapott értékre változik.
     * Ha van a kocsi mögött még kocsi akkor meghívja ezen is a markFirst függvényt false paraméterrel.
     * Ha üres a és van mögötte még kocsi akkor meghívja ezen is a markFirst függvényt true paraméterrel.
     * @param value erre az értékre állítja
     */
    public void markFirst(boolean value) {
        // Ha üres a kocsi, és első nem üres kocsinak akkarjuk megjelölni,
        // akkor maradjon, hamis az isFirst-je és jelölje a mögötte lévő kocsit első nem üresnek
        if(value || !isFull){
            this.isFirst = false;
            if(carBehind != null){
                carBehind.markFirst(true);
            }
        }
        else{
            this.isFirst = value;
            if(carBehind != null) {
                carBehind.markFirst(false);
            }
        }
    }

    /**
     * Kiüriti a kocsit, ha ez a kocsi az első nem üres kocsi, és a paraméterben kapott szín megegyezik a kocsi színével
     * @param color
     */
    @Override
    public void empty(String color) {
        if (isFirst){
            if(this.color.equals(color)){
                isFull = false; // Kiürítjuk a kocsit
                if(carBehind != null){
                    carBehind.markFirst(true);
                }
            }
        }
    }

    /**
     * A teljes vonat pályaelhagyásáért felelős
     * EndVoid hívja meg, ha ráért az adott TrainElement
     * Ezzel jelzi a TrainElementnek, hogy a pálya szélére ért
     * Ha vannak utasok a kocsin, akkor a vége a játéknak.
     * Ha nincs következő kocsi (tehát ez az utolsó kocsi),
     * akkor meghívja az előtte lévő kocsi finish függvényét.
     * @param endVoid
     */
    @Override
    public void leave(EndVoid endVoid) throws OccupyException {
        if(inside){
            // FULL CHECK
            if(isFull){
                throw new OccupyException("Utasokat tartalmazó kocsi elhagyta a pályát");
            }
            if(carBehind == null){
                carAhead.finish();
            }
        }
    }

    /**
     * Visszatérési értéke egy boolean,
     * ami azt határozza meg hogy ettől a kocsitól kezdve (ezt is beleértve)
     * van-e az első nem üres kocsi.
     * Tehát a visszatérési értékét úgy határozza meg,
     * hogy meghivja az isFirstForward() függvényt az elötte lévő kocsin,
     * és ha ez igazzal tér vissza vagy ez a kocsi az első,
     * akkor igazzal tér vissza különben hamissal.
     */
    @Override
    public boolean isFirstForward(){
        return (isFirst || carAhead.isFirstForward());
    }

    /**
     *  A kocsi mögötti kocsit lépteti
     */
    @Override
    public void moveNext() throws OccupyException {
        if(carBehind != null){
            carBehind.move(cur);
        }
    }


    /**
     *  Hatására meghívja az előtte lévő kocsi finish fügvényét.
     */
    @Override
    public void finish() {
        carAhead.finish();
    }

    @Override
    public void inside() {
        inside = true;
    }


    @Override
    public String toString() {
        return color;
    }


    /**
     * Utasok szállnak fel a kocsira
     */
    @Override
    public void fillCar() {
        isFull = true;
        // Ha az eddig első nem üres kocsi ez a kocsi mögött van,
        // akkor ez lesz az első nem üres kocsi,
        if( !carAhead.isFirstForward()){
            isFirst = true;
            carBehind.markFirst(false);
        }
    }
}

