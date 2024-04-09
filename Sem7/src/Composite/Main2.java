package Composite;

import Adapter.*;

public class Main2 {

    public static void main(String[] args) {
        //creating files
        File file1 = new File("file1.txt");
        File file2 = new File("File2.docx");
        File file3 = new File("file3.pdf");

        Directory rootDirectory = new Directory("rootDirectory");

        rootDirectory.addItem(file1);
        rootDirectory.addItem(file2);

        Directory subDirectoy = new Directory("subDirectory");

        subDirectoy.addItem(file3);

        rootDirectory.addItem(subDirectoy);

        rootDirectory.printName();

    }
}
