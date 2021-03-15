package CarParkManager;

public class Van extends Vehicle {
    private int volume;

    public Van(String idPlate, String brand, DateTime entryDateTime, int volume) {
        super(idPlate, brand, entryDateTime);
        this.volume = volume;
    }
    public Van(String idPlate, String brand, DateTime entryDateTime) {
        super(idPlate, brand, entryDateTime);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Van{" + super.toString() +
                "volume=" + volume +
                '}';
    }
}
