package user_interface;

import computer_parts.ComputerPart;
import data_structure.PartList;
import data_structure.WishList;

public class CommandPrompt {

    private PartList database;

    public CommandPrompt() {
        this.database = new PartList();
    }

    private void populateDatabase() {

    }

    public void menuPrompt() {
        System.out.println("---- Main Menu ----\n" +
                "1. New Wish List\n" +
                "2. Open Wish List\n" +
                "3. List Database\n" +
                "4. Add Part to Database\n" +
                "5. Close");
        int choice = InputUtil.inputInt("Enter your choice: ", 1, 5);
        switch (choice) {
            case 1:
                newWishList();
                break;
            case 2:
//                openWishList();
                break;
            case 3:
                System.out.println(database);
                break;
            case 4:
                addToDatabase();
                break;
            case 5:
//                database.saveToCSVFile("");
                System.exit(0);
                break;
        }
    }

    private void addToDatabase() {

    }

    private void newWishList() {
        WishList wishList = new WishList();
        wishListMenu(wishList);
    }

    private void wishListMenu(WishList wishList) {
        System.out.println("---- Wish List ----\n" +
                "1. Add From Database\n" +
                "2. Show Wish List\n" +
                "3. Remove from Wish List\n" +
                "4. Save and Close Wish List");
        int choice = InputUtil.inputInt("Enter your choice: ", 1, 4);
        switch (choice) {
            case 1: {
                System.out.println(database.toString());
                String name = InputUtil.inputString("Enter Part Name: ", database.getNamesInArray());
                ComputerPart part = database.get(name);
                wishList.append(part);
                break;
            }
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    private void openWishList(String name) {

    }

    public static void main(String args[]) {
        CommandPrompt cp = new CommandPrompt();
        cp.menuPrompt();
    }
}
