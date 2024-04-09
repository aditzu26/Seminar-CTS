package Composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemItem{

    private List<FileSystemItem> items = new ArrayList<>();
    private String name;

    public Directory(String name){
        this.name=name;
    }
    public void printName()
    {
        System.out.println("Directory: "+name);
        for (FileSystemItem item : items){
            item.printName();
        }
    }

    public void addItem(FileSystemItem item)
    {
        items.add(item);
    }

}
