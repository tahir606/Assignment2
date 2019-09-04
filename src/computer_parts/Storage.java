package computer_parts;

public class Storage extends ComputerPart {

    private int capacityGB;
    private String type;

    public Storage(String name, double price, int capacityGB, String type) {
        super(name, price);
        this.capacityGB = capacityGB;
        this.type = type;
    }

    @Override
    public String toString() {
        return getName() + ", " + capacityGB + "GB " + type + " for $" + getPrice();
    }

    @Override
    public String toCSVString() {
        return null;
    }

    public static Storage input() {
        return null;
    }

    public static Storage parse(String csvLine) {
        return null;
    }


    public int getCapacityGB() {
        return capacityGB;
    }

    protected void setCapacityGB(int capacityGB) {
        this.capacityGB = capacityGB;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }


}
