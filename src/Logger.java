/**
 * Created by locsi on 16/03/2017.
 */
public class Logger {
    private static int tabs = 0;

    private static void writeTabs(){
        for (int i = 0; i < tabs; i++) {
            System.out.print("\t");
        }
    }

    public static void logStart(String message) {
        System.out.print("\n");
        writeTabs();
        System.out.print(message);
        tabs++;
    }

    public static void logMessage(String message) {
        System.out.print("\n");
        writeTabs();
        System.out.print(message);
    }


    public static void logEnd() {
        tabs--;
    }
}
