package trains;

/**
 * A pályán kívüli sín osztálya.
 * Ha egy vonat erre ér akkor még egy utolsót ránt a vonatokon.
 * Mindig önmagára mutat ha a következő sínre kérdez a hívó.
 */
public class EndVoid extends Rail {
    /**
     * @param trainElement Azon vonatelem amely rá akar lépni
     */
    public void occupy(TrainElement trainElement) {
        trainElement.stop(this);
    }

    /**
     * Következő sín lekéredezésére szolgáló függvény
     * @param rail - Az a sín amelyikről érkezett a vonat
     * @return Konstans önmagát adja vissza
     */
    public Rail next(EntryPoint rail) {
        return this;
    }
}