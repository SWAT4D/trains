package trains;

/**
 * A pályán kívüli sín osztálya.
 * Ha egy vonat erre ér akkor még egy utolsót ránt a vonatokon.
 * Mindig önmagára mutat ha a következő sínre kérdez a hívó.
 */
public class EndVoid extends Rail {

    /**
     * @param trainElement Azon vonatelem amely rá akar lépni
     * @throws trains.GameOverException
     */
    @Override
    public void occupy(TrainElement trainElement) throws GameOverException {
            trainElement.moveNext();
            trainElement.leave(this);
    }

    /**
     * Következő sín lekéredezésére szolgáló függvény
     * @param rail - Az a sín amelyikről érkezett a vonat
     * @return Konstans önmagát adja vissza
     */
    @Override
    public Rail next(Rail rail) {
        return this;
    }
}