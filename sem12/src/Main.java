import org.w3c.dom.Text;

import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;


interface TextFormatter{
    String format(String text);
}

class UppercaseFormatter implements TextFormatter{
    public String format(String text){
        return text.toUpperCase();
    }
}

class LowercaseFormatter implements TextFormatter{
    public String format(String text){
        return text.toLowerCase();
    }
}

class CamelCaseFormatter implements TextFormatter{
    public String format(String text){
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder(words[0].toLowerCase());
        for(int i =1;i<words.length;i++)
        {
            result.append(words[i].substring(0,1).toUpperCase()).append(words[i].substring(1).toLowerCase());
        }
        return result.toString();
    }
}

class TextEditor{
    private TextFormatter formatter;
    public TextEditor(TextFormatter formatter){
        this.formatter=formatter;
    }

    public void setFormatter(TextFormatter formatter){
        this.formatter = formatter;
    }

    public String formatText(String text){
        return formatter.format(text);
    }
}


 class StrategyPatterExample {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor((new UppercaseFormatter()));

        String text = "Hello World";
        System.out.println("Original text: " + text);
        System.out.println("uppercase text: " + editor.formatText(text));

        editor.setFormatter(new LowercaseFormatter());
        System.out.println("lowercase text: " + editor.formatText(text));

        editor.setFormatter(new CamelCaseFormatter());
        System.out.println("camel case text: " + editor.formatText(text));

    }
}

interface Subject{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}

interface Observer{
    void update(float temperature, float humidity, float pressure);
}

class WeatherDisplay implements Observer{
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure){
        this.humidity= humidity;
        this.pressure=pressure;
        this.temperature=temperature;
        display();

    }

    private void display(){
        System.out.println("Weather display: temperature = " + temperature+ "f, humidity = " + humidity + "%, pressure= " + pressure + "pa");
    }

}

class WeatherStation implements  Subject{
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    public WeatherStation(){
        this.observers= new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(temperature,humidity,pressure);
        }
    }


    public void setMeasurements( float temperature,
     float humidity,
     float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        notifyObservers();
    }




}

class ObserverMain{
    public static void main(String[] args){
        WeatherStation weatherStation = new WeatherStation();
        WeatherDisplay display1 = new WeatherDisplay();
        WeatherDisplay display2 = new WeatherDisplay();

        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        weatherStation.setMeasurements(75,60,30.4f);
        weatherStation.setMeasurements(45,32,56.4f);
    }
}

class TCPConnection {
    private TCPState currentState;
    public TCPConnection(){
        currentState = new TCPClosedState();
    }

    public void setState(TCPState state)
    {
        this.currentState = state;
    }

    public void open()
    {
        currentState.open(this);
    }

    public void close(){
        currentState.close(this);
    }
    public void acknowledge(){
        currentState.acknowledge(this);
    }
}

 interface TCPState{
    void open(TCPConnection connection);
    void close(TCPConnection connection);
    void acknowledge(TCPConnection connection);

}

class TCPOpenState implements TCPState{
    @Override
    public void open(TCPConnection connection){
        System.out.println("connection is open already");
    }
    @Override
    public void close(TCPConnection connection){
        System.out.println("closing connection");
        connection.setState(new TCPClosedState());
    }

    @Override
    public void acknowledge(TCPConnection connection){
        System.out.println("Acknowledging data");
    }

}

class TCPClosedState implements TCPState{
    @Override
    public void open(TCPConnection connection){
        System.out.println("opening connection");
        connection.setState(new TCPOpenState());
    }

    @Override
    public void close(TCPConnection connection){
        System.out.println("connection is closed already");
    }

    @Override
    public void acknowledge(TCPConnection connection){
        System.out.println("cannot acknowledge data. connection is closed");
    }
}


class MainState{
    public static void main(String[] args){
        TCPConnection connection = new TCPConnection();
        connection.open();
        connection.acknowledge();
        connection.close();

    }
}
