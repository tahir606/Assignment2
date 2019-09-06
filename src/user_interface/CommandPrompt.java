package user_interface;

import computer_parts.*;
import data_structure.PartList;
import data_structure.WishList;

import java.io.BufferedReader;
import java.io.FileReader;

public class CommandPrompt {

    private PartList database;

    public CommandPrompt() {
        this.database = new PartList();
        populateDatabase();
    }

    private void populateDatabase() {
        String db = "";
        try {
            db = readStringFromFile("database.db");
            String[] lines = db.split("\n");
            for (String line : lines) {
                ComputerPart part = null;
                if (line.startsWith("CPU")) {
                    part = CPU.parse(line);
                } else if (line.startsWith("GraphicsCard")) {
                    part = GraphicsCard.parse(line);
                } else if (line.startsWith("Memory")) {
                    part = Memory.parse(line);
                } else if (line.startsWith("Storage")) {
                    part = Storage.parse(line);
                }
//                System.out.println(part);
                database.append(part);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menuPrompt() {
        while (true) {
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
                    String fileName = InputUtil.inputString("Enter wishlist file name: ");
                    openWishList(fileName);
                    break;
                case 3:
                    System.out.println(database);
                    break;
                case 4:
                    addToDatabase();
                    break;
                case 5:
                    database.saveToCSVFile("database.db");
                    System.exit(0);
                    break;
            }
        }
    }

    private void addToDatabase() {
        while (true) {
            System.out.println("---- Part Types ----\n" +
                    "1. CPU\n" +
                    "2. Graphics Card\n" +
                    "3. Memory\n" +
                    "4. Storage\n" +
                    "5. Back\n");
            int part = InputUtil.inputInt("Enter Choice: ", 1, 5);
            ComputerPart p = null;
            switch (part) {
                case 1:
                    p = CPU.input();
                    break;
                case 2:
                    p = GraphicsCard.input();
                    break;
                case 3:
                    p = Memory.input();
                    break;
                case 4:
                    p = Storage.input();
                    break;
                case 5:
                    return;
            }
            database.append(p);
        }
    }

    private void newWishList() {
        WishList wishList = new WishList();
        wishListMenu(wishList);
    }

    private void wishListMenu(WishList wishList) {
        while (true) {
            System.out.println("---- Wish List ----\n" +
                    "1. Add From Database\n" +
                    "2. Show Wish List\n" +
                    "3. Remove from Wish List\n" +
                    "4. Save and Close Wish List");
            int choice = InputUtil.inputInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1: {
                    System.out.println(database.toString());
                    String name = InputUtil.inputString("Enter Part Name: ");
                    ComputerPart part = database.get(name);
                    System.out.println("\n\n" + part);
                    if (part != null)
                        wishList.append(part);
                    else
                        return;
                    break;
                }
                case 2: {
                    System.out.println(wishList);
                    break;
                }
                case 3:
                    String name = InputUtil.inputString("Enter Part name you want to delete?", wishList.getNamesInArray());
                    wishList.remove(name);
                    System.out.println(name + " removed");
                    break;
                case 4:
                    String fileName = InputUtil.inputString("Enter file name to save Wish List to File: ");
                    wishList.saveToCSVFile(fileName);
                    return;
            }
        }
    }

    private void openWishList(String name) {
        WishList wishList = new WishList();
        String file = null;
        try {
            file = readStringFromFile(name);
        } catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        String[] split = file.split("\n");
        for (String line : split) {
            ComputerPart part = null;
            if (line.startsWith("CPU")) {
                part = CPU.parse(line);
            } else if (line.startsWith("Graphics Card")) {
                part = GraphicsCard.parse(line);
            } else if (line.startsWith("Memory")) {
                part = Memory.parse(line);
            } else if (line.startsWith("Storage")) {
                part = Storage.parse(line);
            }
            wishList.append(part);
        }

        wishListMenu(wishList);
    }

    private String readStringFromFile(String name) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(name));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        } finally {
            br.close();
        }
    }

    public static void main(String args[]) {
        CommandPrompt cp = new CommandPrompt();
        cp.menuPrompt();
    }
}
