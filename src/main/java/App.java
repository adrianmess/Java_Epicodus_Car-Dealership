import models.Vehicle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Vehicle hatchback = new Vehicle(1994, "Subaru", "Legacy", 170000, 4000);
        Vehicle suv = new Vehicle(2002, "Ford", "Explorer", 100000, 7000);
        Vehicle sedan = new Vehicle(2015, "Toyota", "Camry", 50000, 30000);
        Vehicle truck = new Vehicle(1999, "Ford", "Ranger", 100000, 4000);

        ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
        allVehicles.add(hatchback);
        allVehicles.add(suv);
        allVehicles.add(sedan);
        allVehicles.add(truck);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to our car dealership. What would you like to do? Enter one of the following options: All Vehicles, Search Price, or Add Vehicle");

        try {

            String navigationChoice = bufferedReader.readLine();

            if (navigationChoice.equals("All Vehicles")) {
                for (Vehicle individualVehicle : allVehicles) {

                    System.out.println("-------------------");
                    System.out.println(individualVehicle.year);
                    System.out.println(individualVehicle.brand);
                    System.out.println(individualVehicle.model);
                    System.out.println(individualVehicle.miles);
                    System.out.println(individualVehicle.price);
                }
            } else if (navigationChoice.equals("Search Price")) {
                System.out.println("What is your maximum budget for a vehicle?");
                String stringUserMaxBudget = bufferedReader.readLine();
                int userMaxBudget = Integer.parseInt(stringUserMaxBudget);
                System.out.println("Here are the vehicles in your price range:");
                for (Vehicle individualVehicle : allVehicles) {
                    if (individualVehicle.worthBuying(userMaxBudget)) {
                        System.out.println("----------------------");
                        System.out.println(individualVehicle.year);
                        System.out.println(individualVehicle.brand);
                        System.out.println(individualVehicle.model);
                        System.out.println(individualVehicle.miles);
                        System.out.println(individualVehicle.price);
                    }
                }
            } else if (navigationChoice.equals("Add Vehicle")){
                System.out.println("Ok! Lets add a vehicle. What year was the vehicle made?");
                int userVehicleYear = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Great! Whats the make or brand of the vehicle?");
                String userVehicleBrand = bufferedReader.readLine();
                System.out.println("Got it! Ok, what is the model of the vehicle?");
                String userVehicleModel = bufferedReader.readLine();
                System.out.println("How many miles is on the vehicle?");
                int userVehicleMiles = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Finally, what's its price?");
                int userVehiclePrice = Integer.parseInt(bufferedReader.readLine());
                Vehicle userVehicle = new Vehicle(userVehicleYear, userVehicleBrand, userVehicleModel, userVehicleMiles, userVehiclePrice);
                allVehicles.add(userVehicle);
                System.out.println(userVehicle.year);
                System.out.println(userVehicle.brand);
                System.out.println(userVehicle.model);
                System.out.println(userVehicle.miles);
                System.out.println(userVehicle.price);
            } else {
                System.out.println("I'm sorry, we don't recognize your input");
            }
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    }
}
