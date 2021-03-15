package CarParkManager;

import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle> {
    private String idPlate;
    private String brand;
    private DateTime entryDateTime;

    public Vehicle(String idPlate, String brand, DateTime entryDateTime) {
        this.idPlate = idPlate;
        this.brand = brand;
        this.entryDateTime = entryDateTime;
    }

    public String getIdPlate() {
        return idPlate;
    }

    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DateTime getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(DateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    @Override
    public String toString() {
        return "idPlate='" + idPlate + '\'' +
                ", brand='" + brand + '\'' +
                ", entryDateTime='" + entryDateTime + '\'';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(idPlate, vehicle.idPlate) &&
                Objects.equals(brand, vehicle.brand) &&
                Objects.equals(entryDateTime, vehicle.entryDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlate, brand, entryDateTime);
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.getIdPlate().compareTo(o.getIdPlate());
    }
}

