package computer_parts;

import user_interface.InputUtil;

public class Memory extends ComputerPart {

    private int capacityGB;
    private int frequencyMHz;
    private String ddr;

    public Memory(String name, double price, int frequencyMHz, int capacityGB, String ddr) {
        super(name, price);
        this.frequencyMHz = frequencyMHz;
        this.capacityGB = capacityGB;
        this.ddr = ddr;
    }

    @Override
    public String toCSVString() {
        return "Memory," + getName() + "," + getPrice() + "," + capacityGB + "," + frequencyMHz + "," + ddr;
    }

    @Override
    public String toString() {
        return getName() + ", " + capacityGB + "GB, " + ddr + " @ " + frequencyMHz + "MHz for $" + getPrice();
    }

    public static Memory input() {
        System.out.println("Enter Memory Details: \n");
        String name = InputUtil.inputString("Enter Name: ");
        double price = InputUtil.inputDouble("Enter Price: ");
        int capacityGB = InputUtil.inputInt("Enter Memory in GBs: ");
        int frequencyMHz = InputUtil.inputInt("Enter Frequency in MHz: ");
        String ddr = InputUtil.inputString("Enter DDR: ");
        Memory memory = new Memory(name, price, frequencyMHz, capacityGB, ddr);
        return memory;
    }

    public static Memory parse(String csvLine) {
        String[] split = csvLine.split(",");
        return new Memory(split[1], Double.parseDouble(split[2]),
                Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5]);
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

    public boolean setDdr(String ddr) {
        if (ddr.startsWith("DDR")) {
            this.ddr = ddr;
            return true;
        } else
            return false;
    }
}
