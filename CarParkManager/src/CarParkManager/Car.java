package CarParkManager;

import java.awt.*;
import java.util.Objects;

public class Car extends Vehicle {
    private int doorNumber;
    private Color color;

    public Car(String idPlate, String brand, DateTime entryDateTime, int doorNumber, Color color) {
        super(idPlate, brand, entryDateTime);
        this.doorNumber = doorNumber;
        this.color = color;
    }
    public Car(String idPlate, String brand, DateTime entryDateTime) {
        super(idPlate, brand, entryDateTime);
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() +
                "doorNumber=" + doorNumber +
                ", color=" + color  +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return doorNumber == car.doorNumber &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doorNumber, color);
    }
}

