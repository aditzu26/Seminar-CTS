
package Adapter;

public class Main {
    public static void main(String[] args) {

        DataReader xmlAdapter = new XMLAdapter(new XMLDataReader());
        DataReader jsonAdapter = new JSONAdapter(new JSONDataReader());
        System.out.println(xmlAdapter.readData());
        System.out.println(jsonAdapter.readData());



    }
}