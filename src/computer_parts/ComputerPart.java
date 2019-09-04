package computer_parts;

public abstract class ComputerPart {

    private String name;
    private double price;

    public ComputerPart(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if (name != null)
            this.name = name;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    @Override
    public String toString() {
        return name + " $" + price;
    }

    public abstract String toCSVString();
}
