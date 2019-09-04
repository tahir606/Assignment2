package computer_parts;

public class Memory extends ComputerPart {

    private int frequencyMHz;
    private int capacityGB;
    private String ddr;

    public Memory(String name, double price, int frequencyMHz, int capacityGB, String ddr) {
        super(name, price);
        this.frequencyMHz = frequencyMHz;
        this.capacityGB = capacityGB;
        this.ddr = ddr;
    }

    @Override
    public String toCSVString() {
        return null;
    }

    @Override
    public String toString() {
        return " ";
    }

    public static Memory input() {
        return null;
    }

    public static Memory parse(String csvLine) {
        return null;
    }

    public int getFrequencyMHz() {
        return frequencyMHz;
    }

    public void setFrequencyMHz(int frequencyMHz) {
        this.frequencyMHz = frequencyMHz;
    }

    public int getCapacityGB() {
        return capacityGB;
    }

    public void setCapacityGB(int capacityGB) {
        this.capacityGB = capacityGB;
    }

    public String getDdr() {
        return ddr;
    }

    public void setDdr(String ddr) {
        this.ddr = ddr;
    }
}
