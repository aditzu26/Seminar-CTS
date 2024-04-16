import javax.xml.crypto.Data;
import java.io.File;

class Amplifier{

    public void setSurroundSound() {
        System.out.println("surround sound on");
    }

    public void on() {
        System.out.println("amplifier on");
    }

    public void setVolume(int i) {
        System.out.println("setting volume to " + i);
    }

    public void off() {
        System.out.println("amplifier off");
    }
}
class TheaterLights{

    void dim(int amount)
    {
        System.out.println("Dimming light by " + amount);
    }

    public void on() {
        System.out.println("turning on lighjts");
    }
}
class Tuner{

}
class DvdPlayer{

    public void on() {
        System.out.println("Turning on DvdPlayer");
    }

    public void stop() {
        System.out.println("turning off dvd player");
    }

    public void eject() {
    }

    public void off() {
    }

    public void play(String movie) {
        System.out.println("playing " + movie);
    }
}
class Projector{

    void on()
    {
        System.out.println("turning on projector");
    }

    void wideScreenMode()
    {
        System.out.println("using wide screen");
    }

    public void off() {
        System.out.println("turning off projector");
    }
}

class HomeTheaterFacade{
    private Amplifier amp;
    private Tuner tuner;
    private DvdPlayer dvd;
    private Projector projector;
    private TheaterLights lights;

    HomeTheaterFacade(Amplifier amp, Tuner tuner, DvdPlayer dvd, Projector projector, TheaterLights lights)
    {
        this.amp=amp;
        this.tuner=tuner;
        this.dvd=dvd;
        this.projector = projector;
        this.lights = lights;
    }

    void watchMovie(String movie)
    {
        System.out.println("get ready to watch a moivie,,,");
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);

    }

    void endMovie()
    {
        System.out.println("shuttiing down movie theater,,,,");
        lights.on();
        amp.off();
        projector.off();
        dvd.stop();
        dvd.eject();
        dvd.off();


    }

}














public class Main {
    public static void main(String[] args) {


        HomeTheaterFacade homeTheater = new HomeTheaterFacade(new Amplifier(), new Tuner(), new DvdPlayer(), new Projector(), new TheaterLights());
        homeTheater.watchMovie("Prison Break");
        homeTheater.endMovie();


    }
}


////////////////////////////////////////////////////////

interface DataService{
    String fetchData();

}

class DataServiceConcrete implements DataService{


    @Override
    public String fetchData() {
        return "Data";
    }
}

class LoggingDecoreator implements DataService{
    private DataService wrappee;

    LoggingDecoreator(DataService wrappee)
    {
        this.wrappee=wrappee;
    }

    @Override
    public String fetchData() {
        System.out.println("fetching data......");
        return wrappee.fetchData();
    }
}

class Example1{
    public static void main(String[] args)
    {
        DataService myDataService = new LoggingDecoreator(new DataServiceConcrete());
        System.out.println(myDataService.fetchData());

        DataService realDataService = new DataServiceConcrete();

        DataService loggedDataService = new LoggingDecoreator(realDataService);

        String data = loggedDataService.fetchData();
        System.out.println("Data Retreived " + data);



    }
}



interface FileOperation {
    void performOperation();
}

class BaseFileOperation implements FileOperation {
    private File file;

    BaseFileOperation(File file) {
        this.file = file;
    }

    @Override
    public void performOperation() {
        // Perform the base file operation
        System.out.println("Performing base file operation on " + file.getName());
    }
}

class SecurityDecorator implements FileOperation {
    private FileOperation wrappee;

    SecurityDecorator(FileOperation wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void performOperation() {
        // Perform security checks before executing the file operation
        System.out.println("Performing security checks...");
        wrappee.performOperation();
    }
}

 class Example2Decorator {
    public static void main(String[] args) {
        // Creating a file operation with security checks
        File file = new File("example.txt");
        FileOperation secureFileOperation = new SecurityDecorator(new BaseFileOperation(file));
        secureFileOperation.performOperation();

        // Creating a simple file operation without security checks
        FileOperation simpleFileOperation = new BaseFileOperation(file);
        simpleFileOperation.performOperation();
    }
}












