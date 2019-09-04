package data_structure;

import computer_parts.ComputerPart;

import java.util.Arrays;

public class PartList {

    private ComputerPart[] partList;
    private int count;

    public PartList() {
        partList = new ComputerPart[100];
        count = 0;
    }

    public ComputerPart get(int index) {
        return null;
    }

    public ComputerPart get(String name) {
        return null;
    }

    public void append(ComputerPart part) {

    }

    public ComputerPart remove(int index) {
        return null;
    }

    public ComputerPart remove(String name) {
        return null;
    }

    private void removeNulls() {

    }

    public int size() {
        return 0;
    }

    public void saveToCSVFile(String filename) {

    }

    @Override
    public String toString() {
        return "PartList{" +
                "partList=" + Arrays.toString(partList) +
                '}';
    }
}
