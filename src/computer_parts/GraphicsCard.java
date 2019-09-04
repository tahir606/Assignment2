package computer_parts;

import user_interface.InputUtil;

public class GraphicsCard extends ComputerPart {

    private int frequencyMHz;
    private int memoryGB;

    public GraphicsCard(String name, double price, int frequencyMHz, int memoryGB) {
        super(name, price);
        this.frequencyMHz = frequencyMHz;
        this.memoryGB = memoryGB;
    }

    @Override
    public String toCSVString() {
        return "Graphics Card," + getName() + "," + getPrice() + "," + frequencyMHz + "," + memoryGB;
    }

    @Override
    public String toString() {
        return getName() + ", " + memoryGB + "GB @ " + frequencyMHz + " for $" + getPrice();
    }

    public static GraphicsCard input() {
        System.out.println("Enter Graphics Card Details: \n");
        String name = InputUtil.inputString("Enter Name: ");
        double price = InputUtil.inputDouble("Enter Price: ");
        int frequencyMHz = InputUtil.inputInt("Enter Frequency in MHz: ");
        int memoryGB = InputUtil.inputInt("Enter Memory in GBs: ");
        GraphicsCard graphicsCard = new GraphicsCard(name, price, frequencyMHz, memoryGB);
        return graphicsCard;
    }

    public static GraphicsCard parse(String csvLine) {
        String[] split = csvLine.split(",");
        return new GraphicsCard(split[1], Double.parseDouble(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
    }

    public int getFrequencyMHz() {
        return frequencyMHz;
    }

    protected void setFrequencyMHz(int frequencyMHz) {
        this.frequencyMHz = frequencyMHz;
    }

    public int getMemoryGB() {
        return memoryGB;
    }

    protected void setMemoryGB(int memoryGB) {
        this.memoryGB = memoryGB;
    }
}
