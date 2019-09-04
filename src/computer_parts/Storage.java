package computer_parts;

import user_interface.InputUtil;

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
        return "Storage," + getName() + "," + getPrice() + "," + capacityGB + "," + type;
    }

    public static Storage input() {
        System.out.println("Enter Storage Details: \n");
        String name = InputUtil.inputString("Enter Name: ");
        double price = InputUtil.inputDouble("Enter Price: ");
        int capacityGB = InputUtil.inputInt("Enter Capacity in GBs: ");
        String type = InputUtil.inputString("Enter Type: ");
        Storage storage = new Storage(name, price, capacityGB, type);
        return storage;
    }

    public static Storage parse(String csvLine) {
        String[] split = csvLine.split(",");
        return new Storage(split[1], Double.parseDouble(split[2]),
                Integer.parseInt(split[3]), split[5]);
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

    protected boolean setType(String type) {
        if (type.equalsIgnoreCase("HDD") || type.equalsIgnoreCase("SSD") ||
                type.equalsIgnoreCase("SSHD")) {
            this.type = type;
            return true;
        } else
            return false;
    }


}
