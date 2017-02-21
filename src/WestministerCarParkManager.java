

import com.sun.org.apache.xpath.internal.SourceTree;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// implement the carParkManager interface to the  WestministerCarParkManager class
public class WestministerCarParkManager implements CarParkManager {

    // create a object array list and the type of the arraylist is the vehicle
    // ,and i initiate it with size : 20 name of the array is park
    private static ArrayList<vehicle> park = new ArrayList<vehicle>(20);

    // static vehicle[] park = new vehicle[20];
    // create a static object of the scanner class
    private static Scanner sc = new Scanner(System.in);
    // create static variables
    private static int lotCount = 0;
    private static int freeLots;
    private static int carCount = 0;
    private static int vanCount = 0;
    private static int bikeCount = 0;
    private static int vehicleCount = 0;

    // main method
    public static void main(String args[]) {

        System.out.println("#####################################################################################################################################\n\n");

        System.out.println("\t\t\t#############################################################################################");
        System.out.println("\t\t\t#                                                                                           #");
        System.out.println("\t\t\t#\t|| W e l c o m e _ T o _ W E S T M I N I S T E R _ C a r _ P a r k _ S y s t e m ||     #");
        System.out.println("\t\t\t#                                                                                           #");
        System.out.println("\t\t\t#############################################################################################");

        // log in to access the system
        System.out.println(
                "\n\n\t\t   -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-> L O G _ I N < -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        System.out.println("\n\n\t\t\tPlease Enter username And password.");
        System.out.print("\t\t\t\t*username: ");
        String username = sc.nextLine();
        System.out.print("\t\t\t\t*password: ");
        String password = sc.nextLine();
        // check the users user name and password
        if (username.equals("a") && password.equals("a")) {
            System.out.println("\n\t\t\t\t\t\t#LOG IN SUCCESSFULL");
            System.out.println("#####################################################################################################################################\n\n");
            // if user username and password is correct go to menu method

            WestministerCarParkManager mm = new WestministerCarParkManager();
            mm.mainmenu();

        } else {
            System.out.println("\n\t\t\t\t--->The username or password you've entered doesn't valid<---");
            System.out.println("\n\t\t\t\t         please enter correct username and password\n");
            main(args);

        }

    }

    // read the file using file reading method
    public static void fileReading(String fileName) {
        try {
            // instance of the buffer reader
            BufferedReader br = null;
            // handle unwanted exceptions
            try {
                // current line
                String line;

                br = new BufferedReader(new FileReader(fileName));

                System.out.println("\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_L O G _ H I S T O R Y _ O N " + fileName
                        + "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n\n");

                while ((line = br.readLine()) != null) {
                    System.out.println("\t\t\t\t" + line);
                }
                System.out.println("\n\t\t\tLoading successfully. \n");

            } catch (IOException e) {
                System.out.println("\n\t\t\tThe Log not Existing");
            } finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException ex) {
                    System.out.println("\n \t\t\terror in reading");
                }
            }
        } catch (Exception e) {
            // mainmenu();
        }
    }

    // main menu to prompt main functionality to the user
    public void mainmenu() {
        try {
            String choice;
            do {
                System.out.println("\t\t\t#############################################################################################");
                System.out.println("\t\t\t#                                                                                           #");
                System.out.println("\t\t\t#\t            || W E S T M I N I S T E R _ C a r _ P a r k _ S y s t e m ||               #");
                System.out.println("\t\t\t#                                                                                           #");
                System.out.println("\t\t\t#############################################################################################");
                System.out.println(
                        "\n\n\t   -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_->M A I N _ M E N U< -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n\n");



                System.out.println("\t\t\t\t\t 1: Add a Vehicle");
                System.out.println("\t\t\t\t\t 2: Remove a Vehicle");
                System.out.println("\t\t\t\t\t 3: Current Vehicle List");
                System.out.println("\t\t\t\t\t 4: Car Park Statics");
                System.out.println("\t\t\t\t\t 5: Search Carpark Log History by Date");
                System.out.println("\t\t\t\t\t 6: Charges");
                System.out.println("\t\t\t\t\t 7: Delete Wrong Entry ");
                System.out.println("\t\t\t\t\t 0: Close The System");
                System.out.print("\n\t\t\tplease enter your option: ");

                // choice = sc.next().charAt(0);
                choice = sc.next(); // get the user selection

                // create the object of the westministercarParkManager class
                WestministerCarParkManager cpm = new WestministerCarParkManager();

                // use switch case to select the user's functionality
                switch (choice) {
                    case "1":
                        cpm.addVehicle();
                        break;

                    case "2":
                        cpm.removeVehicle();
                        break;

                    case "3":
                        cpm.vehicleList();
                        break;

                    case "4":
                        cpm.status();
                        break;

                    case "5":
                        cpm.searchParkHistory();
                        break;

                    case "6":
                        cpm.charges();
                        break;

                    case "7":
                        cpm.delEntry();
                        break;
                    case "0":
                        System.exit(0);
                        break;

                    // if cases not match the users input default executed
                    default:
                        System.out.println("\n\n\t\t\t\tinvalid selection please select again");
                        break;

                }
                // while loop to loop the menu until exit
            } while (!(choice.equals("0")));

        } catch (Exception e) {
            mainmenu();
        }
    }

    // add vehicle function to add a vehicle details to the car park
    public void addVehicle() {
        try {
            System.out.println(
                    "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_> A D D _ V E H I C L E <-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
            // to display the fre slot
            freeLots = 19 - lotCount;
            int displayFreeLots = freeLots + 1;
            System.out.println("\t\t\tNumber of Available slots : " + displayFreeLots);
            // if there are no more slot display this
            if (freeLots == 0) {
                System.out.println("\n\n\t\t\t\t\tC A R _ P A R K _ I S _ F U L L _ C A N ' T _ A D D _ V E H I C L E S");

            } else {
                // if there only one slot left prompt vvan cant park in here
                if (freeLots == 1) {
                    System.out.println("\n\n\t\t\t\t\tC A N ' T _ A D D _ V A N _ T O _ T H E _ C A R _ P A R K");
                }
                // char type = 'p';
                String type;
                // System.out.println("add vehicle");
                // get the vehicle details
                System.out.print("\n\t\t\tEnter the vehicle IDPLATE number: ");
                String idPlate = sc.next();

                System.out.print("\n\t\t\tEnter the BRAND of the vehicle: ");
                String vBrand = sc.next();



                System.out.println("\n\t\t\t\t\t 1: CAR\n\n");
                System.out.println("\t\t\t\t\t 2: VAN\n\n");
                System.out.println("\t\t\t\t\t 3: MOTOR_BIKE\n");
                System.out.print("\t\t\tSelect the TYPE of the vehicle: ");
                // select the type of the vehicle using switch case
                type = sc.next(); // get the user input

                switch (type) {

                    case "1":
                        if (lotCount < 19) {
                            // create a object in dateTime class
                            DateTime dtc = new DateTime();
                            // get the entrance details such as date and time in
                            // correct
                            // format
                            System.out.print("\t\t\tEnter the DATE on \"DD/MM/YYYY\" or \"YYYY/MM/DD\" format : ");
                            String inDate = sc.next();
                            dtc.setDate(inDate);
                            // pass the gather information to the class

                            System.out.print("\t\t\tEnter the TIME  on \"HH:mm\" format : ");
                            String inTime = sc.next();
                            dtc.setTime(inTime);
                            // create the object in car class
                            Car cr = new Car(dtc, "Car");
                            cr.setIdPlate(idPlate);
                            cr.setVehicleBrand(vBrand);
                            cr.setType("Car");
                            // get the details of the car

                            System.out.print("\n\t\t\tNumber of DOOR's: ");
                            cr.setNumOfDoor(sc.next());

                            System.out.print("\n\t\t\tCOLOR of the car: ");
                            cr.setColor(sc.next());
                            // add car object to the array
                            park.add(cr);
                            // increase the vehicle count and carcount by one
                            lotCount++;
                            System.out.println("\n\t\t\tcar is added to the park");
                            carCount++;
                            vehicleCount++;
                            System.out.println("\n\t\t\t\t\t" + cr.getDateTime());
                            // cr.getDateTime();
                        } else {
                            // if car park is fulll prompt this
                            System.out.println("\n\t\t\t\t\t\t\t************************");
                            System.out.println("\t\t\t\t\t\t\t*                      *");
                            System.out.println("\t\t\t\t\t\t\t*    CAR PARK IS FULL  *");
                            System.out.println("\t\t\t\t\t\t\t*     can't add a car  *");
                            System.out.println("\t\t\t\t\t\t\t************************");

                        }

                        break;
                    case "2":
                        // if new vehicle s van cant park if there only one slot
                        // left
                        if (lotCount < 18) {
                            // create the van object
                            DateTime dtv = new DateTime();
                            // get the date time information and pass it into the
                            // dattime class using object
                            System.out.print("\t\t\tEnter the DATE on \"DD/MM/YYYY\" or \"YYYY/MM/DD\" format : ");
                            String inDate = sc.next();
                            dtv.setDate(inDate);

                            System.out.print("\t\t\tEnter the TIME  on \"HH:mm\" format : ");
                            String inTime = sc.next();
                            dtv.setTime(inTime);

                            Van vn = new Van(dtv, "Van");

                            vn.setIdPlate(idPlate);
                            vn.setVehicleBrand(vBrand);
                            vn.setType("Van");

                            // get input of the cargo volume of the van
                            System.out.print("\n\t\t\tEnter the CARGO volume: ");
                            vn.setCargoVolume(sc.next());
                            // add vanobject to the park array
                            park.add(vn);
                            // increment slot count by two and van count bye one
                            lotCount = lotCount + 2;
                            vanCount++;
                            vehicleCount++;
                            System.out.println("\n\t\t\t\t\t" + vn.getDateTime());
                            System.out.println("\n\t\t\tvan is added to the park");

                        } else {
                            // if park is fulll
                            System.out.println("\n\t\t\t\t\t\t\t************************");
                            System.out.println("\t\t\t\t\t\t\t*                      *");
                            System.out.println("\t\t\t\t\t\t\t*    CAR PARK IS FULL  *");
                            System.out.println("\t\t\t\t\t\t\t*     can't add a van  *");
                            System.out.println("\t\t\t\t\t\t\t************************");
                        }

                        break;

                    case "3":
                        // if motorcycle executr thuis
                        if (lotCount < 19) {
                            // create object of the datetim class
                            DateTime dtm = new DateTime();
                            // get the enter data of entrane
                            System.out.print("\t\t\tEnter the DATE on \"DD/MM/YYYY\" or \"YYYY/MM/DD\" format : ");
                            String inDate = sc.next();
                            // pass it to datetime class to validate
                            dtm.setDate(inDate);
                            // get the enter time of entrane
                            System.out.print("\t\t\tEnter the TIME  on \"HH:mm\" format : ");
                            String inTime = sc.next();
                            dtm.setTime(inTime);
                            // create a motor bike object
                            Motorbike mb = new Motorbike(dtm, "Motor_Bike");
                            // add bike details ti motorbike class
                            mb.setIdPlate(idPlate);
                            mb.setVehicleBrand(vBrand);
                            mb.setType("Motor_Bike");
                            //get the capacity of the bike
                            System.out.print("\n\t\t\tEnter the Engine CAPACITY : ");
                            mb.setEngineSize(sc.next());
                            // add bike object to the array
                            park.add(mb);
                            // increment the used lot number and bike count by one
                            lotCount++;
                            bikeCount++;
                            vehicleCount++;
                            // print the date and time
                            System.out.println("\n\t\t\t\t\t" + mb.getDateTime());
                            System.out.println("\n\t\t\tmotor bike is added to the park");
                        } else {
                            // display this if full
                            System.out.println("\n\t\t\t\t\t\t\t************************");
                            System.out.println("\t\t\t\t\t\t\t*                      *");
                            System.out.println("\t\t\t\t\t\t\t*    CAR PARK IS FULL  *");
                            System.out.println("\t\t\t\t\t\t\t*                      *");
                            System.out.println("\t\t\t\t\t\t\t************************");

                        }

                        break;

                    default:
                        // if user enter invalid selection for type
                        System.out.println("\t\t\tinvalid selection please select again");
                        addVehicle();
                        break;

                }
                System.out.println("#####################################################################################################################################\n\n");
            }
        } catch (Exception e) {
            mainmenu();
        }
    }

    // to remove the vehicle details from the carpark
    public void removeVehicle() {

        try {
            boolean isExist = false;
            System.out.println(
                    "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_> R E M O V E _ V E H I C L E <-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n\n");
            if(park.isEmpty()){

                System.out.println("\n\n\t\t\t\t\tN O T H I N G _ T O _ R E M O V E  ");
                System.out.println("\t\t\t\t\tC A R _ P A R K _ I S _ E M P T Y\n\n");

            }else {

                // System.out.println("remove vehicle");
                String typeVehicle;

                // if lotcount zero , park is empty
                if (lotCount == 0) {
                    System.out.println("\n\t\t\t\t\t ***NO VEHICLE TO REMOVE***");
                    System.out.println(
                            "\n\n\t\t\t\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n\n");
                } else {

                    System.out.print("\t\t\tEnter ID_PLATE number to remove the VEHICLE :");
                    // prompt user to enter the id plate number to delete
                    String idRemove = sc.next();
                    // use enhanced for loop to iterate the park arrray
                    for (vehicle tempVehicle : park) {
                        // use for loop to ge the correct index of the array
                        //for (int i = 0; i < park.size(); i++) {
//                        int i =-1;
//
//                        i++;
                            // check the id plate number from the objects with the
                            // user
                            // enter id number
                            if (tempVehicle.getIdPlate().equals(idRemove)) {
                                //to after checking that user enter  vehicle id availability and if vehicle not their then display no vehicle on that id message beacuse isexisting not becometrue
                                isExist = true;


                                typeVehicle = tempVehicle.getType();

                                System.out.println("\n\n\t\t\tType Of The Vehicle : " + typeVehicle+"\n\n");
                                // if entered id equals the array id plate number of
                                // the
                                // object then write that object in to the file
                                // Method to write to a file
                                // use try catch to settle the unexpected exceptions
                                try {
//                                    int Year = park.get(i).getDateTimeIn().getYear();
//                                    int Month = park.get(i).getDateTimeIn().getMonth();
//                                    int Day = park.get(i).getDateTimeIn().getDate();

                                    int Year = tempVehicle.getDateTimeIn().getYear();
                                    int Month = tempVehicle.getDateTimeIn().getMonth();
                                    int Day = tempVehicle.getDateTimeIn().getDate();


                                    // create the name of the file
                                    String fileName = String.valueOf(Year) + "-" + String.valueOf(Month) + "-"
                                            + String.valueOf(Day);
                                    // create instance of the file class
                                    File file = new File(fileName);

                                    // Creates the text file if doesn't exist
                                    if (!file.exists()) {
                                        file.createNewFile();
                                    }
                                    // use file writer to append the data
                                    FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                                    // using buffer writter write line by line
                                    BufferedWriter bw = new BufferedWriter(fw);

                                    bw.write(tempVehicle.toString());
                                    bw.newLine();
                                    // close the buffer writer object
                                    bw.close();

                                    System.out.println("\n\t\t\tCar park LOG update successfull.\n");
                                    // catch block
                                } catch (IOException e) {
                                    System.out.println("\t\t\tSorry! The program could not locate the text file");

                                }
                                {
                                switch (typeVehicle) {
                                    case "Car":
                                        carCount--;
                                        lotCount--;
                                        vehicleCount--;
                                        break;
                                    case "Van":
                                        vanCount--;
                                        lotCount = lotCount - 2;
                                        vehicleCount--;
                                        break;
                                    case "Motor_Bike":
                                        bikeCount--;
                                        lotCount--;
                                        vehicleCount--;
                                        break;
                                }}

                                // remve the selected vehicle object from the array
                                //park.remove(i);
                                park.remove(tempVehicle);
                                System.out.println("\n\t\t\tVehicle on "+idRemove+" ID_plate number removed");
                                // user can continue to see chargers from here
                                //System.out.println("\t\t\tContinue to Charges :");
                                //System.out.println("\t\t\t\tY : YES");
                                //System.out.println("\t\t\t\tN : NO");

                                //char con = sc.next().toLowerCase().charAt(0); // get
                                // the
                                // user
                                // switch case to get select // input






                                    DateTime dtRemove = new DateTime();

                                    //System.out.println("Please Enter Valid Vehicle ID Plate No:");
                                    System.out.println("\n\n\n\t\t\t\t Enter Current date and time");
                                    System.out.print("\t\t\t\t #Enter the DATE on \"DD/MM/YYYY\" or \"YYYY/MM/DD\" format :");
                                    String inDate = sc.next();
                                dtRemove.setDate(inDate);
                                    System.out.print("\t\t\t\t #Enter the TIME  on \"HH:mm\" format : ");
                                dtRemove.setTime(sc.next());

                                    int currentHour, currentMinute, currentDate, currentMonth, currentYear;

                                    currentDate = dtRemove.getDate();
                                    currentMonth = dtRemove.getMonth();
                                    currentYear = dtRemove.getYear();
                                    currentHour = dtRemove.getHour();
                                    currentMinute = dtRemove.getMinute();


                                        // for (vehicle carCharge : park) {

                                        System.out.println(
                                                "\t\t\t\t*                                                                                           *");
                                        System.out.println(
                                                "\t\t\t\t*-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_P A R K _ C H A R G E _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                                        System.out.println(
                                                "\t\t\t\t*                                                                                           *");

                                        // iterate through the park array


                                            int noHour = (currentHour - tempVehicle.getDateTimeIn().getHour());
                                            int noDay = (currentDate - tempVehicle.getDateTimeIn().getDate());

                                            if (0 <= noHour && noHour <= 3 && noDay == 0) {
                                                int f3Hour = noHour * 3;

                                                System.out.println("\t\t\t\tVehicle ID_Plate_no " + tempVehicle.getIdPlate()
                                                        + "--------------------------->  Current Price: " + f3Hour + "£");

                                            } else if (3 < noHour && noHour < 24 && noDay == 0) {
                                                noHour = noHour - 3;
                                                int newHourCalc = (noHour * 1) + 9;

                                                System.out.println("\t\t\t\tVehicle ID_Plate_no " + tempVehicle.getIdPlate()
                                                        + "--------------------------->  Current Price: " + newHourCalc + "£");

                                            } else if (noDay == 1) {

                                                System.out.println("\t\t\t\tVehicle ID_Plate_no " + tempVehicle.getIdPlate()
                                                        + "--------------------------->  Current Price: 30£");

                                            }


                                    System.out.println("\n\n\n");









                            } }
                            if(isExist==false){

                                // if entered vehical id plate did not matches the
                                // objects id plate , then prompt this
                                System.out.println("\n\t\t\t\t***********no vehicle on that ID_PLATE number************");
                                System.out.println("\n\t\t\t1 : Continue removing");
                                System.out.println("\t\t\t2 : Back to main menu");

                                System.out.print("\t\t\tEnter your option: ");
                                String rmove = sc.next(); // get
                                // the
                                // user
                                // user can continue in delete or go back to main
                                // menu
                                // // input
                                {
                                switch (rmove) {
                                    case "1":
                                        removeVehicle();
                                        break;
                                    case "2":
                                        mainmenu();
                                        break;
                                    default:
                                        System.out.println("\t\t\t\t\tinvalid input back to MAIN MENU\n");
                                        break;
                                }}
                                System.out.println(
                                        "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n\n");
                            }




                }
            }
        } catch (Exception e) {
            mainmenu();
        }
    }

    // this method to generate the current vehicle list parked in the car park
    public void vehicleList() {
        try {
            System.out.println(
                    "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_ V E H I C L E _ L I S T -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                if(park.isEmpty()){

                    System.out.println("\n\n\t\t\t\t\tN O T H I N G _ T O _ D I S P L A Y  ");
                    System.out.println("\t\t\t\t\t C A R _ P A R K _ I S _ E M P T Y\n\n");

                }else {


                    // use for loop to
                    for (int i = (park.size() - 1); i >= 0; i--) {
                        System.out.format("\n\n\t\t\tVehicle ID_PLATE number :%s", park.get(i).getIdPlate());
                        System.out.format("\t\t\t\t\tVehicle Entrence details :%s", park.get(i).getDateTime());
                        System.out.format("\t\t\t\t\tVehicle BRAND :%s\n\n\n", park.get(i).getVehicleBrand());
                    }
                }
        } catch (Exception e) {
            mainmenu();
        }
    }

    // public void searchDayList() {

    // thi smethod to print some statics about the current car park
    public void status() {
        try {
            // try catch to handle the exceptions
            try {
                System.out.println(
                        "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_C A R _ P A R K _ S T A T U S_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n\n");

                double carPercent = (carCount * 100) / vehicleCount;
                double vanPercent = (vanCount * 100) / vehicleCount;
                double bikePercent = (bikeCount * 100) / vehicleCount;

                System.out.print("\t\t\t\t\tCAR PERCENTAGE: " + carPercent);
                System.out.print("\t\t\t\tVAN PERCENTAGE: " + vanPercent);
                System.out.println("\t\t\t\tMOTOR_BIKE PERCENTAGE: " + bikePercent);
                System.out.print("\t\t\t\t\tNUMBER OF CARS: " + carCount);
                System.out.print("\t\t\t\tNUMBER OF VANS: " + vanCount);
                System.out.print("\t\t\t\tNUMBER OF MOTOR_BIKE: " + bikeCount);
                System.out.println("\n\n\t\t\t\t\t\t\t\tNUMBER OF CURRENT VEHICLE: " + vehicleCount);
                System.out.println(
                        "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n\n");
                // use collection.sort method to the array list,it compare the
                // next
                // object date time and get sorted
                Collections.sort(park, (p1, p2) -> {
                    // chech yera
                    int value;
                    value = p1.getDateTimeIn().getYear() - p2.getDateTimeIn().getYear();
                    // check month
                    if (value == 0)
                        value = p1.getDateTimeIn().getMonth() - p2.getDateTimeIn().getMonth();
                    // check date
                    if (value == 0)
                        value = p1.getDateTimeIn().getDate() - p2.getDateTimeIn().getDate();
                    // check hour
                    if (value == 0)
                        value = p1.getDateTimeIn().getHour() - p2.getDateTimeIn().getHour();
                    if (value == 0)
                        // check minutes
                        value = p1.getDateTimeIn().getMinute() - p2.getDateTimeIn().getMinute();

                    return value;
                });
                // to get the last element of the array
                int newestVehicalIndex = (park.size() - 1);

                System.out.println("\t\t\tVehical that is Parked for the longest time: ");
                System.out.format("\t\t\tVehicle ID_PLATE number :%s", park.get(0).getIdPlate());
                System.out.format("\t\t\t\t\tVehicle Entrence details :%s", park.get(0).getDateTime());
                System.out.format("\t\t\t\t\tVehicle BRAND :%s\n\n\n", park.get(0).getVehicleBrand());

                System.out.println("\t\t\tLast Vehical that was Parked :");
                System.out.format("\t\t\tVehicle ID_PLATE number :%s", park.get(newestVehicalIndex).getIdPlate());
                System.out.format("\t\t\t\t\tVehicle Entrence details :%s", park.get(newestVehicalIndex).getDateTime());
                System.out.format("\t\t\t\t\tVehicle BRAND :%s\n\n\n", park.get(newestVehicalIndex).getVehicleBrand());

                System.out.println(
                        "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n\n");

            } catch (Exception e) {
                System.out.println("\n\n\t\t\t\t\tN O T H I N G _ T O _ D I S P L A Y ");
                System.out.println("\t\t\t\t\tC A R _ P A R K _ I S _ E M P T Y\n\n");
            }
        } catch (Exception e) {
            mainmenu();
        }
    }

    // Retrieving the previous parking details
    public void searchParkHistory() {
        try {
            try {
                System.out.println(
                        "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_L O G _ H I S T O R Y_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n\n");

                System.out.println();
                System.out.println("\t\t\t- - - - - - - - Parking Log - - - - - - - - \n ");

                DateTime serchdt = new DateTime();
                String enteredDate;

                System.out.print("\t\t\tPlease enter the specific DATE on \"DD/MM/YYYY\" or \"YYYY/MM/DD\" format : ");

                enteredDate = sc.next();

                serchdt.setDate(enteredDate);

                int date, month, year;
                // get date and time
                date = serchdt.getDate();
                month = serchdt.getMonth();
                year = serchdt.getYear();

                System.out.println("");
                // create the file name to read
                String fileName = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(date);
                fileReading(fileName);

            } catch (Exception e) {
                System.out.println("\t\t\trestart the programme");
                mainmenu();

            }
        } catch (Exception e) {
            mainmenu();
        }
    }

    // to display the current charges for the vehicles in the park
    public void charges() {
        try {
            System.out.println(
                    "\n\n\t\t\t\t*********************************************************************************************");
            System.out.println(
                    "\t\t\t\t*                                                                                           *");
            System.out.println(
                    "\t\t\t\t*-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_P A R K _ C H A R G E S_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-*");

            System.out.println(
                    "\t\t\t\t*                                                                                           *");
            System.out.println(
                    "\t\t\t\t*                                                                                           *");
            System.out.println(
                    "\t\t\t\t* #charge details:                                                                          *");
            System.out.println(
                    "\t\t\t\t*               ===================================================                         *");
            System.out.println(
                    "\t\t\t\t*               =*       For the first 3 Hours: 3£               *=                         *");
            System.out.println(
                    "\t\t\t\t*               =* The Car Park Charges Additionl 1£ per 1hour   *=                         *");
            System.out.println(
                    "\t\t\t\t*               =*       Max Charges for 24 Hours: 30£           *=                         *");
            System.out.println(
                    "\t\t\t\t*               ===================================================                         *");
            System.out.println(
                    "\t\t\t\t*                                                                                           *");
            System.out.println(
                    "\t\t\t\t*                                                                                           *");
            System.out.println(
                    "\t\t\t\t*********************************************************************************************");


            if(park.isEmpty()){

                System.out.println("\n\n\t\t\t\t\tN O T H I N G _ T O _ D I S P L A Y  ");
                System.out.println("\t\t\t\t\t C A R _ P A R K _ I S _ E M P T Y\n\n");

            }else {
                DateTime dtout = new DateTime();

                //System.out.println("Please Enter Valid Vehicle ID Plate No:");

                System.out.print("\t\t\t\t #Enter the DATE on \"DD/MM/YYYY\" or \"YYYY/MM/DD\" format :");
                String inDate = sc.next();
                dtout.setDate(inDate);
                System.out.print("\t\t\t\t #Enter the TIME  on \"HH:mm\" format : ");
                dtout.setTime(sc.next());

                int currentHour, currentMinute, currentDate, currentMonth, currentYear;

                currentDate = dtout.getDate();
                currentMonth = dtout.getMonth();
                currentYear = dtout.getYear();
                currentHour = dtout.getHour();
                currentMinute = dtout.getMinute();

                if (park.size() != 0) {
                    // for (vehicle carCharge : park) {
                    System.out.println(
                            "\n\n\t\t\t\t*********************************************************************************************");
                    System.out.println(
                            "\t\t\t\t*                                                                                           *");
                    System.out.println(
                            "\t\t\t\t*-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_P A R K _ C H A R G E S_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                    System.out.println(
                            "\t\t\t\t*                                                                                           *");
                    System.out.println(
                            "\t\t\t\t*********************************************************************************************\n\n");
                    // iterate through the park array
                    for (int i = 0; i < park.size(); i++) {

                        int noHour = (currentHour - park.get(i).getDateTimeIn().getHour());
                        int noDay = (currentDate - park.get(i).getDateTimeIn().getDate());

                        if (0 <= noHour && noHour <= 3 && noDay == 0) {
                            int f3Hour = noHour * 3;

                            System.out.println("\t\t\t\tVehicle ID_Plate_no " + park.get(i).getIdPlate()
                                    + "--------------------------->  Current Price: " + f3Hour + "£");

                        } else if (3 < noHour && noHour < 24 && noDay == 0) {
                            noHour = noHour - 3;
                            int newHourCalc = (noHour * 1) + 9;

                            System.out.println("\t\t\t\tVehicle ID_Plate_no " + park.get(i).getIdPlate()
                                    + "--------------------------->  Current Price: " + newHourCalc + "£");

                        } else if (noDay == 1) {

                            System.out.println("\t\t\t\tVehicle ID_Plate_no " + park.get(i).getIdPlate()
                                    + "--------------------------->  Current Price: 30£");

                        }
                    }
                } else if (park.size() == 0) {

                    System.out.println("\n\n\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_CAR PARK IS EMPTY-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n\n\n\n");

                }
                System.out.println("\n\n\n");
            }
        } catch (Exception e) {
            mainmenu();
        }

    }


    public void delEntry(){

    // this mthod is to delete a vehicle from a program with out adding it to the log
        //if user enter wrong entry he can remove that entry using this  method

        try {
            System.out.println(
                    "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_> R E M O V E _ V E H I C L E <-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n\n");
            if(park.isEmpty()){

                System.out.println("\n\n\t\t\t\t\tN O T H I N G _ T O _ D E L E T E  ");
                System.out.println("\t\t\t\t\tC A R _ P A R K _ I S _ E M P T Y\n\n");

            }else {

                // System.out.println("remove vehicle");
                String typeVehicle;


                    System.out.print("\t\t\tEnter ID_PLATE number to remove the VEHICLE :");
                    // prompt user to enter the id plate number to delete
                    String idRemove = sc.next();
                    // use enhanced for loop to iterate the park arrray
                    for (vehicle tempVehicle : park) {
                        // use for loop to ge the correct index of the array
                        for (int i = 0; i < park.size(); i++) {
                            // check the id plate number from the objects with the
                            // user
                            // enter id number
                            if (tempVehicle.getIdPlate().equals(idRemove)) {

                                typeVehicle = tempVehicle.getType();

                                // if entered id equals the array id plate number of
                                // the array


                                vehicleCount--;
                                //decrement the counnt accoding to the vehicle type
                                switch (typeVehicle) {

                                    case "Car":
                                        carCount--;
                                        lotCount--;
                                        break;
                                    case "Motor_Bike":
                                        bikeCount--;
                                        lotCount--;
                                        break;
                                    case "Van":
                                        vanCount--;
                                        lotCount = lotCount - 2;
                                        break;
                                }
                                park.remove(i);

                                System.out.println("\n\t\t\tVehicle on "+idRemove+" ID_plate number removed");


                            } else {
                                // if entered vehical id plate did not matches the
                                // objects id plate , then prompt this
                                System.out.println("\n\t\t\t\t***********no vehicle on that ID_PLATE number************");

                                System.out.println(
                                        "\n\n\t\t\t\t-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n\n");
                            }
                            // break;
                        }
                        break;


                }
            }
        } catch (Exception e) {
            mainmenu();
        }
    }




}
