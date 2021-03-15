package CarParkManager;

import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApplication {
    private static CarParkManager westminsterCarParkManager = new WestminsterCarParkManager();

    public static void addVehicle() {
        Scanner sc = new Scanner(System.in);
        Vehicle vehicle;

        while (true) {
            System.out.println("What vehicle (car, motorbike or van): ");
            String vehicleType = sc.nextLine().toLowerCase();

            System.out.println("Enter ID Number of Vehicle: ");
            String vehicleIdNumber = sc.nextLine();

            System.out.println("Enter Vehicle Brand name: ");
            String vehicleBrandName = sc.nextLine();

            int day=0;
            System.out.println("Enter Day: ");
            try{
                day = sc.nextInt();
            }catch (InputMismatchException e){
                //
            }

            System.out.println("Enter month: ");
            int month=0;
            try {
                month = sc.nextInt();
            }catch (InputMismatchException e){
                //
            }

            System.out.println("Enter year: ");
            int year =0;
            try {
                year = sc.nextInt();
            }catch (InputMismatchException e){
                //
            }

            System.out.println("Enter hour: ");
            int hour=0;
            try {
                hour = sc.nextInt();
            }catch (InputMismatchException e){
                //
            }

            System.out.println("Enter Minute: ");
            int minute = 0;
            try {
                minute = sc.nextInt();
            }catch (InputMismatchException e){
                //
            }


            DateTime vehicleEntry = new DateTime(day, month, year, hour, minute);

            switch (vehicleType) {
                case "van":
                    System.out.println("Enter Volume: ");
                    int volume = sc.nextInt();
                    vehicle = new Van(vehicleIdNumber, vehicleBrandName, vehicleEntry, volume);
                    break;
                case "car":
                    System.out.println("Enter Red, Green, Blue Values, One after another (numerical value): ");
                    int red = sc.nextInt();
                    int green = sc.nextInt();
                    int blue = sc.nextInt();

                    Color vehicleColor = new Color(red, green, blue);

                    System.out.println("Enter Number of doors: ");
                    int doorNumber = sc.nextInt();
                    vehicle = new Car(vehicleIdNumber, vehicleBrandName, vehicleEntry, doorNumber, vehicleColor);
                    break;
                case "motorbike":
                    System.out.println("Enter Engine Capacity: ");
                    int engineCapacity = sc.nextInt();
                    vehicle = new Motorbike(vehicleIdNumber, vehicleBrandName, vehicleEntry, engineCapacity);
                    break;
                default:
                    System.out.println("Invalid Option!!! Please re-enter...");
                    continue;
            }
            westminsterCarParkManager.addVehicle(vehicle);
            break;
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        westminsterCarParkManager.retrieveData();

        menuLoop:
        while (true) {
            System.out.println("/n /nPress 1 to add Vehicle");
            System.out.println("Press 2 to Delete Vehicle");
            System.out.println("Press 3 to print list of currently available Vehicles in the car park");
            System.out.println("Press 4 to print list of Vehicles by a given day");
            System.out.println("Press 5 to calculate statistics");
            System.out.println("Press 6 to calculate charges");
            System.out.println("Press 7 to quit");

            Scanner sc = new Scanner(System.in);
            int userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    deleteVehicle();
                    break;
                case 3:
                    printListOfVehicles();
                    break;
                case 4:
                    printListOfVehiclesByDay();
                    break;
                case 5:
                    printStatistics();
                    break;
                case 6:
                    calculateCharges();
                    break;
                case 7:
                    westminsterCarParkManager.saveData();
                    break menuLoop;
                default:
                    System.out.println("Choice is invalid!!! Please re-enter...");
            }
        }
    }

    private static void printListOfVehicles() {
        westminsterCarParkManager.printVehicleList();
    }

    private static void calculateCharges() {
        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = null;

        while (true) {
            System.out.println("Enter vehicle to calculate charges (car, motorbike or van): ");
            String vehicleType = sc.nextLine().toLowerCase();

            System.out.println("Enter ID Number of Vehicle: ");
            String vehicleIdNumber = sc.nextLine();

            System.out.println("Enter Vehicle Brand name: ");
            String vehicleBrandName = sc.nextLine();

            System.out.println("Enter leaving Day: ");
            int day = sc.nextInt();

            System.out.println("Enter leaving month: ");
            int month = sc.nextInt();

            System.out.println("Enter leaving year: ");
            int year = sc.nextInt();

            System.out.println("Enter leaving hour: ");
            int hour = sc.nextInt();

            System.out.println("Enter leaving Minute: ");
            int minute = sc.nextInt();

            DateTime vehicleEntry = new DateTime(day, month, year, hour, minute);
            int type=0;

            switch (vehicleType) {
                case "van":
                    type=1;
                    vehicle = new Van(vehicleIdNumber, vehicleBrandName, vehicleEntry);
                    break;
                case "car":
                    type=2;
                    vehicle = new Car(vehicleIdNumber, vehicleBrandName, vehicleEntry);
                    break;
                case "motorbike":
                    type=3;
                    vehicle = new Motorbike(vehicleIdNumber, vehicleBrandName, vehicleEntry);
                    break;
                default:
                    System.out.println("Invalid Option!!! Please re-enter...");
                    continue;
            }
            westminsterCarParkManager.calculateCharges(vehicle,vehicleEntry,type);
            break;
        }
    }

    private static void printStatistics() {
        System.out.println("Enter id plate number:");
        Scanner sc=new Scanner(System.in);
        String id=sc.next();
        westminsterCarParkManager.printStatistics(id);
    }

    private static void printListOfVehiclesByDay() {
        Scanner sc=new Scanner(System.in);
        int day=0;
        System.out.println("Enter Day: ");
        try{
            day = sc.nextInt();
        }catch (InputMismatchException e){
            //
        }

        System.out.println("Enter month: ");
        int month=0;
        try {
            month = sc.nextInt();
        }catch (InputMismatchException e){
            //
        }

        System.out.println("Enter year: ");
        int year =0;
        try {
            year = sc.nextInt();
        }catch (InputMismatchException e){
            //
        }
        DateTime date=new DateTime(day,month,year);
        westminsterCarParkManager.printVehicleOnDay(date);
    }

    private static void deleteVehicle() {
        System.out.println("Please enter the ID of the vehicles you want to remove:");
        Scanner sc = new Scanner(System.in);
        String vehicleNumber = sc.nextLine();
        westminsterCarParkManager.deleteVehicle(vehicleNumber);
    }
}
