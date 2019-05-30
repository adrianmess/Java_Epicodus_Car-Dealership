import models.Vehicle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

    Vehicle hatchback = new Vehicle(1994, "Subaru", "Legacy", 170000, 4000);
    Vehicle suv = new Vehicle(2002, "Ford", "Explorer", 100000,7000);
    Vehicle sedan = new Vehicle(2015, "Toyota", "Camry", 50000, 30000);
    Vehicle truck = new Vehicle(1999, "Ford", "Ranger", 100000, 4000);

    Vehicle[] allVehicles = {hatchback, suv, sedan, truck};

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("What is your maximum budget for a vehicle?");

    try {
        String stringUserMaxBudget = bufferedReader.readLine();


        int userMaxBudget = Integer.parseInt(stringUserMaxBudget);

        System.out.println("Alright, here's what we have in your price range:");

        for (Vehicle individualVehicle : allVehicles) {
            if (individualVehicle.worthBuying(userMaxBudget)){
                System.out.println("-------------------");
                System.out.println(individualVehicle.year);
                System.out.println(individualVehicle.brand);
                System.out.println(individualVehicle.model);
                System.out.println(individualVehicle.miles);
                System.out.println(individualVehicle.price);
            }


        }

    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    }
}
