/**
 * A pályán kívülis sín osztálya.
 * Ha egy vonat erre ér akkor még egy utolsót ránt a vonatokon.
 * Mindig önmagára mutat ha a következő sínre kérdez a hívó.
 */
public class EndVoid extends Rail {
    /**
     * Default constructor
     * Semmit nem tárol így nem történik semmi a konstruktorban
     * ezért nem is kell.
     */
    /**
    public EndVoid() {
    }*/

    /**
     *
     * @param trainElement Azon vonatelem amely rá akar lépni
     */
    public void occupy(TrainElement trainElement) {
        Logger.logStart("occupy(TrainElement) - EndVoid");

        trainElement.stop();

        Logger.logEnd();
    }

    /**
     * Következő sín lekéredezésére szolgáló függvény
     * @param rail - Az a sín amelyikről érkezett a vonat
     * @return Konstans önmagát adja vissza
     */
    public Rail next(Rail rail) {
        Logger.logStart("next(Rail) - Endvoid");
        Logger.logEnd();
        return this;
    }

}