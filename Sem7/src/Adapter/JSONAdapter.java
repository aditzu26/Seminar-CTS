
package Adapter;

public class JSONAdapter implements DataReader {

    private JSONDataReader jsonReader;

    public JSONAdapter(JSONDataReader jsonReader){
        this.jsonReader=jsonReader;
    }


    @Override
    public String readData()
    {
        return jsonReader.readJSON();
    }
}
