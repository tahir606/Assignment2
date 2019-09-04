package computer_parts;

import user_interface.InputUtil;

public class CPU extends ComputerPart {

    private int cores;
    private double frequencyGHz;

    public CPU(String name, double price, int cores, double frequencyGHz) {
        super(name, price);
        this.cores = cores;
        this.frequencyGHz = frequencyGHz;
    }

    @Override
    public String toCSVString() {
        return "CPU," + getName() + "," + getPrice() + "," + cores + "," + frequencyGHz;
    }

    @Override
    public String toString() {
        return getName() + ", " + cores + " cores @ " + frequencyGHz + "GHz for $" + getPrice();
    }

    public static CPU input() {
        System.out.println("Enter CPU Details: \n");
        String name = InputUtil.inputString("Enter Name: ");
        double price = InputUtil.inputDouble("Enter Price: ");
        int cores = InputUtil.inputInt("Enter Cores: ");
        double frequencyGHz = InputUtil.inputDouble("Enter Frequency in GHz: ");
        CPU cpu = new CPU(name, price, cores, frequencyGHz);
        return cpu;
    }

    public static CPU parse(String csvLine) {
        String[] split = csvLine.split(",");
        return new CPU(split[1], Double.parseDouble(split[2]), Integer.parseInt(split[3]), Double.parseDouble(split[4]));
    }

    public int getCores() {
        return cores;
    }

    protected void setCores(int cores) {
        if (cores > 0)
            this.cores = cores;
    }

    public double getFrequencyGHz() {
        return frequencyGHz;
    }

    protected void setFrequencyGHz(double frequencyGHz) {
        if (frequencyGHz > 0)
            this.frequencyGHz = frequencyGHz;
    }
}
