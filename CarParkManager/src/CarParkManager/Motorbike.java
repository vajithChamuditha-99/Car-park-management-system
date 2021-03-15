package CarParkManager;

public class Motorbike extends Vehicle {
    private int engineCapacity;

    public Motorbike(String idPlate, String brand, DateTime entryDateTime, int engineCapacity) {
        super(idPlate, brand, entryDateTime);
        this.engineCapacity = engineCapacity;
    }
    public Motorbike(String idPlate, String brand, DateTime entryDateTime) {
        super(idPlate, brand, entryDateTime);
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Motorbike{" + super.toString() +
                "engineCapacity=" + engineCapacity +
                '}';
    }
}
