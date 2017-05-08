package trains;

/**
 *  Olyan kocsi amely nem szállít utasokat,
 *  emiatt nem is lehet első utasokat szállító kocsi.
 *  Egyébként működése megegyezik a kocsikéval.
 */
public class CoalCar extends Car{

    /**
     *  Rogtön továbbadja az első nem üres köcsi jelzést az utána következő kocsinak
     * @param b
     */
    @Override
    public void markFirst(boolean b){
        if(carBehind != null)
            carBehind.markFirst(b);
    }

    @Override
    public void leave(EndVoid endVoid) throws GameOverException {
        if(inside){
            // FULL CHECK
            if(isFull){
                throw new GameOverException("Utasokat tartalmazó kocsi elhagyta a pályát");
            }
            if(carBehind == null){
                carAhead.finish();
            }
        }
    }

    /**
     *  Nem tud feltöltődni
     */
    @Override
    public void fillCar(String color) {}

    /**
     * Nem tud kiürülön a kocsi
     */
    @Override
    public void empty(String color){}

    /**
     * 1 EndVoid paraméteres knstruktor
     * @param endVoid
     */
    public CoalCar(EndVoid endVoid) {
        super(endVoid, "k");
        isFull = false;
    }

    @Override
    public String toString() {
        return "k";
    }
}
