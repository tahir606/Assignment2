package data_structure;

import computer_parts.ComputerPart;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class PartList {

    private ComputerPart[] partList;
    private int count;

    public PartList() {
        partList = new ComputerPart[100];
        count = 0;
    }

    public ComputerPart get(int index) {
        if (index >= 0 && index < count)
            return partList[index];
        else
            return null;
    }

    public ComputerPart get(String name) {
        for (int i = 0; i < count; i++) {
            if (partList[i].getName().equals(name)) {
                return partList[i];
            }
        }
        return null;
    }

    public void append(ComputerPart part) {
        partList[count] = part;
        count++;
    }

    public ComputerPart remove(int index) {
        if (index <= count) {
            ComputerPart part = partList[index];
            partList[index] = null;
            removeNulls();
            return part;
        } else {
            return null;
        }
    }

    public ComputerPart remove(String name) {
        for (int i = 0; i < count; i++) {
            if (partList[i].getName().equals(name)) {
                ComputerPart part = partList[i];
                partList[i] = null;
                return part;
            }
        }
        return null;
    }

    private void removeNulls() {
        ArrayList<ComputerPart> removedNull = new ArrayList<>();
        for (ComputerPart part : partList)
            if (part != null)
                removedNull.add(part);
        partList = removedNull.toArray(new ComputerPart[100]);
    }

    public int size() {
        return count;
    }

    public void saveToCSVFile(String filename) {
        String body = "";
        for (int i = 0; i < count; i++) {
            body = body + "\n" + partList[count].getName() + "," + partList[count].getPrice();
        }

        try{
            FileWriter fw=new FileWriter(filename);
            fw.write(body);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");
    }

    @Override
    public String toString() {
        String body = "---- Part List ----";
        for (int i = 0; i < count; i++) {
            body = body + "\n" + partList[count].getName();
        }
        body = body + "--------------------";
        return body;
    }
}
