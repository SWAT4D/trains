import java.util.ArrayList;

/**
 * Created by locsi on 16/03/2017.
 */
public class Program {
    public static void main(String [] args) {

        twoLocomotiveCollision();

        /*
        // Creating rails
        ArrayList<Rail> railList = new ArrayList<Rail>();
        for (int i = 0; i < 10; i++) {
            railList.add(new Rail());
        }

        // Connect rails
        connectRailList(railList);

        // Creating 2 EntryPoints
        EntryPoint ep1 = new EntryPoint();
        EntryPoint ep2 = new EntryPoint();

        // Connecting EntryPoints to he 2 ends of the rail
        ep1.addNext(railList.get(0));
        railList.get(railList.size() - 1).addNext(ep2);

        // Creating the EndVoid
        EndVoid ev = new EndVoid();

        // Connecting the EndVoid to the 2 EntryPoints
        ep1.addPrev(ev);
        ep2.addNext(ev);


        // TODO: do it with for
        // car2 -> car1 -> loco ->
        Locomotive loco = new Locomotive(ev);
        Car car1 = new Car(ev);
        Car car2 = new Car(ev);

        loco.addNext(car1);
        car1.addNext(car2);

        loco.setStartPlace(ep1);

        Logger.logMessage("--------------------\n TRY ONE STEP");
        Logger.logMessage("Loco: " +Integer.toString(railList.indexOf(loco.cur)));
        Logger.logMessage("Car1: " +Integer.toString(railList.indexOf(car1.cur)));
        Logger.logMessage("Car2: " +Integer.toString(railList.indexOf(car2.cur)));
        for(int i =0; i<12; i++) {
            loco.moveOne();
            Logger.logMessage("Loco: " +Integer.toString(railList.indexOf(loco.cur)));
            Logger.logMessage("Car1: " +Integer.toString(railList.indexOf(car1.cur)));
            Logger.logMessage("Car2: " +Integer.toString(railList.indexOf(car2.cur)));

        }
        */
    }

    public static void twoLocomotiveCollision(){

        // INITIALIZING TEST MAP
        int railLength = 4;
        Logger.logMessage("INITIALIZING TEST MAP");
        Logger.logMessage("Creating " + railLength + " rails");
        ArrayList<Rail> railList = createLongRail(railLength);
        Logger.logMessage("Creating 2 Entrypoints");
        EntryPoint ep1 = new EntryPoint();
        EntryPoint ep2 = new EntryPoint();
        Logger.logMessage("Connecting EntryPoints to the 2 ends of the rail");
        ep1.addNext(railList.get(0));
        railList.get(railList.size() - 1).addNext(ep2);
        Logger.logMessage("Creating the EndVoid");
        EndVoid ev = new EndVoid();
        Logger.logMessage("Connecting the EndVoid to the 2 EntryPoints");
        ep1.addPrev(ev);
        ep2.addNext(ev);

        // INITIALIZING THE TRAINS
        Logger.logMessage("Creating the FIRST locomotive");
        int loco1Length = 1;
        Locomotive loco1 = new Locomotive(ev);
        loco1.setStartPlace(ep1);
        Logger.logMessage("Creating " + loco1Length + " car list");
        ArrayList<Car> carList1 = createLongCar(loco1Length, ev);
        Logger.logMessage("Connecting the first locomotive to the cars");
        loco1.addNext(carList1.get(0));

        Logger.logMessage("Creating the SECOND locomotive");
        int loco2Length = 1;
        Locomotive loco2 = new Locomotive(ev);
        loco2.setStartPlace(ep2);
        Logger.logMessage("Creating " + loco2Length + " car list");
        ArrayList<Car> carList2 = createLongCar(loco2Length, ev);
        Logger.logMessage("Connecting the second locomotive to the cars");
        loco2.addNext(carList2.get(0));

        // TODO: steps inside locomotive class
        for(int i =0; i<12; i++) {
            loco1.moveOne();
            loco1.logPos(railList);
            for (Car c: carList1) {
                c.logPos(railList);
            }

            loco2.moveOne();
            loco2.logPos(railList);
            for (Car c: carList2) {
                c.logPos(railList);
            }
        }
    }

    public static ArrayList<Rail> createLongRail(int length){
        ArrayList<Rail> railList = new ArrayList<Rail>();
        for (int i = 0; i < length; i++) {
            railList.add(new Rail());
        }
        // Connect rails
        connectRailList(railList);
        return railList;
    }


    public static void connectRailList (ArrayList<Rail> railList){
        for (int i = 0; i<railList.size()-1; i++){
            railList.get(i).addNext(railList.get(i+1));
        }
    }

    public static ArrayList<Car> createLongCar(int length, EndVoid ev){
        ArrayList<Car> carList = new ArrayList<Car>();
        for (int i = 0; i < length; i++) {
            carList.add(new Car(ev));
        }
        // Connect cars
        connectCarList(carList);
        return carList;

    }

    public static void connectCarList (ArrayList<Car> carList){
        for (int i = 0; i<carList.size()-1; i++){
            carList.get(i).addNext(carList.get(i+1));
        }
    }
}
