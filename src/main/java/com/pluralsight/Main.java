package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Static variables accessible by all methods
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize inventory with sample vehicles
        vehicles.add(new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500f));
        vehicles.add(new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000f));
        vehicles.add(new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700f));
        vehicles.add(new Vehicle(101124, "Honda Civic", "White", 70000, 7500f));
        vehicles.add(new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500f));
        vehicles.add(new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000f));

        boolean running = true;

        // Main program loop
        while (running) {
            System.out.println("\nWhat do you want to do?");  // Added newline for better readability
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");

            System.out.print("Enter your command: ");
            int command = scanner.nextInt();
            scanner.nextLine();  // Clear the input buffer

            switch (command) {
                case 1:
                    printVehicles();
                    break;
                case 2:
                    searchVehicle();  // Fixed spelling
                    break;
                case 3:
                    searchPriceRange();
                    break;
                case 4:
                    searchbyColor();
                    break;
                case 5:
                    addVehicle();  // Fixed spelling
                    break;
                case 6:
                    running = false
                    break;
                default:
                    System.out.println("Invalid Entry, Please Try Again");
                    break;
            }
        }
    }

    // Display all vehicles in inventory
    public static void printVehicles() {
        System.out.println("\n----Now Printing out all the vehicles----");
        for (Vehicle v : vehicles) {
            System.out.printf("Vehicle Id: %d, Vehicle Make: %s, Vehicle Color: %s, Vehicle Odometer: %d, Vehicle Price: $%.2f\n",
                    v.getVehicleId(),
                    v.getMakeModel(),
                    v.getColor(),
                    v.getOdometerReading(),
                    v.getPrice());
        }
    }

    // Search vehicles by make/model
    public static void searchVehicle() {
        System.out.println("\n----Searching for a vehicle-----");
        System.out.print("Please Enter the make/model of vehicle: ");  // Changed to print
        boolean found = false;  // Renamed for clarity
        String search = scanner.nextLine();  // Changed to nextLine for full input

        for (Vehicle v : vehicles) {
            if (v.getMakeModel().toLowerCase().contains(search.toLowerCase())) {  // Made case-insensitive
                System.out.printf("Vehicle: %d, Make/Model: %s, Color: %s, Odometer Reading: %d, Price: $%.2f\n",
                        v.getVehicleId(),
                        v.getMakeModel(),
                        v.getColor(),
                        v.getOdometerReading(),
                        v.getPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found matching that make/model.");
        }
    }

    // Search vehicles by price range
    public static void searchPriceRange() {
        System.out.println("\n----Searching by price range-----");
        System.out.print("Please Enter the minimum price range: ");
        int minimum = scanner.nextInt();
        System.out.print("Please Enter the maximum price range: ");
        int maximum = scanner.nextInt();
        scanner.nextLine();  // Clear buffer

        boolean found = false;  // Added to track if any matches are found
        for (Vehicle v : vehicles) {
            if (v.getPrice() >= minimum && v.getPrice() <= maximum) {
                System.out.printf("Vehicle: %d | Make/Model: %s | Color: %s | Odometer Reading: %d | Price: $%.2f\n",
                        v.getVehicleId(),
                        v.getMakeModel(),
                        v.getColor(),
                        v.getOdometerReading(),
                        v.getPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found in this price range.");
        }
    }

    // Search vehicles by color
    public static void searchbyColor() {
        System.out.println("\n----Searching by color-----");
        System.out.print("Please Enter the color of vehicle: ");  // Changed to print
        String color = scanner.nextLine();  // Changed to nextLine

        boolean found = false;  // Added to track if any matches are found
        for (Vehicle v : vehicles) {
            if (v.getColor().toLowerCase().contains(color.toLowerCase())) {  // Made case-insensitive
                System.out.printf("Vehicle: %d | Make/Model: %s | Color: %s | Odometer Reading: %d | Price: $%.2f\n",
                        v.getVehicleId(),
                        v.getMakeModel(),
                        v.getColor(),
                        v.getOdometerReading(),
                        v.getPrice());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No vehicles found with that color.");
        }
    }

    // Add a new vehicle to inventory
    public static void addVehicle() {  // Fixed spelling
        System.out.print("\nEnter vehicle ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();  // Clear the newline

        System.out.print("Enter make and model: ");
        String makeModel = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer reading: ");
        int odometer = scanner.nextInt();

        System.out.print("Enter price: ");
        float price = scanner.nextFloat();

        vehicles.add(new Vehicle(id, makeModel, color, odometer, price));
        System.out.println("Vehicle added successfully!");
    }
}
