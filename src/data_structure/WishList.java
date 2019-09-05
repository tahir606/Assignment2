package data_structure;

public class WishList extends PartList {

    public WishList() {
    }

    public double calculateTotalCost() {
        double price = 0;
        for (int i = 0; i < size(); i++) {
            price = price + get(i).getPrice();
        }
        return price;
    }

    public boolean isValidComputer() {
        boolean cpu = false, gc = false, mem = false, stg = false;
        for (int i = 0; i < size(); i++) {
            if (get(size()).toCSVString().startsWith("CPU"))
                cpu = true;
            if (get(size()).toCSVString().startsWith("Graphics Card"))
                gc = true;
            if (get(size()).toCSVString().startsWith("Memory"))
                mem = true;
            if (get(size()).toCSVString().startsWith("Storage"))
                stg = true;

            if (cpu && gc && mem && stg)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Total Cost: " + calculateTotalCost() +
                " Validity: " + isValidComputer();
    }


}
