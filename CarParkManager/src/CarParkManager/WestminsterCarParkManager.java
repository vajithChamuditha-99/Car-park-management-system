package CarParkManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WestminsterCarParkManager implements CarParkManager {
    private List<Vehicle> allVehicles = new ArrayList<>();
    private int availableSlots = 20;
    public static final int MAX_COUNT = 20;

    @Override
    public void addVehicle(Vehicle vehicle) {
        for(Vehicle vehicle1: allVehicles) {
            if(vehicle.equals(vehicle1)) {
                System.out.println("Vehicle's already in the car park");
                return;
            }
        }
        if(allVehicles.size() < MAX_COUNT) {
            if(vehicle instanceof Van) {
                if (allVehicles.size() < MAX_COUNT - 1) {
                    allVehicles.add(vehicle);
                    availableSlots -= 2;
                    System.out.println("Van has been added");
                    System.out.printf("%s\n", availableSlots == 0 ? "No more slots available" : availableSlots + " slots left");
                } else {
                    System.out.println("No slots available for a van");
                }
            } else if(vehicle instanceof Car || vehicle instanceof Motorbike) {
                allVehicles.add(vehicle);
                System.out.printf("%s has been added\n", vehicle instanceof Car? "Car" : "Bike");
                availableSlots--;
                System.out.printf("%s\n", availableSlots == 0 ? "No more slots available" : availableSlots + " slots left");
            }
        } else {
            System.out.println("No slots available");
        }
    }

    @Override
    public void deleteVehicle(String idNumber) {
        boolean foundVehicle = false;
        for (Vehicle vehicle: allVehicles) {
            if(vehicle.getIdPlate().equals(idNumber)) {
                allVehicles.remove(vehicle);
                foundVehicle = true;
                System.out.printf("%s was removed successfully!\n", vehicle instanceof Van? "Van" : vehicle instanceof Car? "Car" : "Bike");
                availableSlots = vehicle instanceof Van? availableSlots+2 : availableSlots+1;
                System.out.println("Available slots: " + availableSlots);
                break;
            }
        }
        if (!foundVehicle) {
            System.out.printf("Vehicle with %s not available\n", idNumber);
        }
    }

    @Override
    public void printVehicleList() {
        if (allVehicles.isEmpty()) {
            System.out.println("No vehicles found");
            return;
        }
        System.out.println("List of all Vehicles currently available");
        Collections.sort(allVehicles, new DateComparator().reversed());

        for (Vehicle vehicle : allVehicles) {
            System.out.println(vehicle);
        }
    }

    @Override
    public void printVehicleOnDay(DateTime dateTime) {
        if (allVehicles.isEmpty()){
            System.out.println("No vehicles in the Car Park!!!...");
            return;
        }
        //printing all the football clubs using for loop
        for (Vehicle vehicle: allVehicles){
            if (vehicle.getEntryDateTime().equals(dateTime)){
                System.out.println(vehicle);
            }
            else {
                System.out.println("No  matching vehicles in the Car Park!!!...");
            }

        }
    }

    @Override
    public void printStatistics(String id) {
        //checking list is empty
        if (allVehicles.isEmpty()){
            System.out.println("No vehicles to show Statistics!!!...");
            return;
        }

        boolean checker=false;
        //finding the relevent football club throughout the list
        for (Vehicle vehicle : allVehicles){
            //checking details matching or not
            if (vehicle.getIdPlate().equals(id)){
                //printing the statistics
                System.out.println("Vehicle Id:          "
                        + vehicle.getIdPlate());
                System.out.println("Vehicle Brand  :     "
                        + vehicle.getBrand());
                System.out.println("Entry Date and Time: "
                        + vehicle.getEntryDateTime());
                checker=true;
                break;
            }
        }
        //if no matching results found
        if (!checker){
            System.out.println("No Matching vehicles Found!!!...");
        }

    }

    @Override
    public void calculateCharges(Vehicle vehicle, DateTime date,int type) {
        for (Vehicle vehicleExist:allVehicles){
            //DateTime dateTime=((vehicleExist.getEntryDateTime().getDay()-date.getDay()),(vehicleExist.getEntryDateTime().getYear()-date.getYear()),(vehicleExist.getEntryDateTime().getYear()-date.getYear()),);
            if (vehicle.getIdPlate().equals(vehicleExist.getIdPlate())){
                if (type==1){
                    int parkedDays=(date.getDay()-vehicleExist.getEntryDateTime().getDay());
                    int parkedMonths=(date.getMonth()-vehicleExist.getEntryDateTime().getMonth());
                    int parkedYears=(date.getYear()-vehicleExist.getEntryDateTime().getYear());
                    int parkedHours=(date.getHour()-vehicleExist.getEntryDateTime().getHour());
                    int parkedMinutes=(date.getMinutes()-vehicleExist.getEntryDateTime().getMinutes());
                    int sumOfMinutes=((parkedYears*365+parkedMonths*30+parkedDays)*24+(parkedHours*60+parkedMinutes));
                    double charge= (sumOfMinutes*0.50);
                    System.out.println(charge);
                    allVehicles.remove(vehicle);
                }else if (type==2){
                    int parkedDays=(date.getDay()-vehicleExist.getEntryDateTime().getDay());
                    int parkedMonths=(date.getMonth()-vehicleExist.getEntryDateTime().getMonth());
                    int parkedYears=(date.getYear()-vehicleExist.getEntryDateTime().getYear());
                    int parkedHours=(date.getHour()-vehicleExist.getEntryDateTime().getHour());
                    int parkedMinutes=(date.getMinutes()-vehicleExist.getEntryDateTime().getMinutes());
                    int sumOfMinutes=((parkedYears*365+parkedMonths*30+parkedDays)*24+(parkedHours*60+parkedMinutes));
                    double charge= (sumOfMinutes*1.00);
                    System.out.println(charge);
                    allVehicles.remove(vehicle);
                }else{
                    int parkedDays=(date.getDay()-vehicleExist.getEntryDateTime().getDay());
                    int parkedMonths=(date.getMonth()-vehicleExist.getEntryDateTime().getMonth());
                    int parkedYears=(date.getYear()-vehicleExist.getEntryDateTime().getYear());
                    int parkedHours=(date.getHour()-vehicleExist.getEntryDateTime().getHour());
                    int parkedMinutes=(date.getMinutes()-vehicleExist.getEntryDateTime().getMinutes());
                    int sumOfMinutes=((parkedYears*365+parkedMonths*30+parkedDays)*24+(parkedHours*60+parkedMinutes));
                    double charge=(sumOfMinutes*2.50);
                    System.out.println(charge);
                    allVehicles.remove(vehicle);
                }
            }
        }


    }

    @Override
    public void saveData() {
        try {
            //creating the file output stream and setting the file for the vehicle list
            FileOutputStream fileOutputStreamLeague=new FileOutputStream("./DataInTheArray.txt");
            //creating the object output stream for the vehicle list
            ObjectOutputStream objectOutputStreamLeague=new ObjectOutputStream(fileOutputStreamLeague);
            for(Vehicle vehicle : allVehicles){
                if (vehicle!= null){
                    //adding the object to the file
                    objectOutputStreamLeague.writeObject(vehicle);
                }
            }
            System.out.println("Data saved to the file Successfully!!");

            //closing object output streams streams
            objectOutputStreamLeague.close();
            //flushing the streams
            objectOutputStreamLeague.flush();

            //closing the file output streams
            fileOutputStreamLeague.close();

        } catch (FileNotFoundException e) {
            //if file not found
            System.out.println("File not Found");
            //e.printStackTrace();
        }catch(Exception e){
            //if any other error occured
            System.out.println("Something went Wrong");
        }
    }

    @Override
    public void retrieveData() throws IOException {

        try{
            //creating file input stream for vehicle list and accessing the file
            FileInputStream fileInputStreamLeague=new FileInputStream("./DataInTheArray.txt");
            //creating object input stream for vehicle list
            ObjectInputStream objectInputStreamLeague=new ObjectInputStream(fileInputStreamLeague);
            //creating a infinite for loop
            for (;;){
                try {
                    //reading the vehicle objects from the file
                    Vehicle vehicle = (Vehicle) objectInputStreamLeague.readObject();
                    //adding vehicle objects to the vehicle list
                    allVehicles.add(vehicle);
                } catch (IOException e){
                    break;
                }
            }
            //closing the streams
            objectInputStreamLeague.close();
            System.out.println("Data imported Successfully!!!");
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Something went Wrong");
        }
    }

//    public void saveData(String fileName) throws IOException {
//        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//
//        for (Vehicle vehicle : allVehicles) {
//            objectOutputStream.writeObject(vehicle);
//        }
//
//        System.out.println("Vehicles have been saved successfully");
//    }
//
//    public void retrieveData(String fileName) throws IOException, ClassNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream(fileName);
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//        for (;;) {
//            try {
//                allVehicles.add((Vehicle) objectInputStream.readObject());
//            } catch (EOFException e) {
//                break;
//            }
//        }
//        System.out.println("Vehicles have been loaded successfully");
//    }

}
