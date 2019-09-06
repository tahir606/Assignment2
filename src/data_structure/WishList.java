package data_structure;

public class WishList extends PartList {

    public WishList() {
        super();
    }

    public double calculateTotalCost() {
        double price = 0;
        for (int i = 0; i < size(); i++) {
            price = price + get(i).getPrice();
        }
        return price;
    }

    public boolean isValidComputer() {
        System.out.println(super.toString());
        boolean cpu = false, gc = false, mem = false, stg = false;
        for (int i = 0; i < size(); i++) {
            if (get(i).toCSVString().startsWith("CPU"))
                cpu = true;
            if (get(i).toCSVString().startsWith("Graphics Card"))
                gc = true;
            if (get(i).toCSVString().startsWith("Memory"))
                mem = true;
            if (get(i).toCSVString().startsWith("Storage"))
                stg = true;

            if (cpu && gc && mem && stg)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nTotal Cost: " + calculateTotalCost() +
                "\nValidity: " + isValidComputer() + "\n\n";
    }


}
