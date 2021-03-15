package CarParkManager;

import java.io.IOException;

public interface CarParkManager {
    void addVehicle(Vehicle vehicle);
    void deleteVehicle(String idNumber);
    void printVehicleList();
    void printVehicleOnDay(DateTime dateTime);
    void printStatistics(String id);
    void calculateCharges(Vehicle vehicle, DateTime date,int type);
    void saveData() throws IOException;
    void retrieveData() throws IOException, ClassNotFoundException;
}
