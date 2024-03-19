import javax.print.Doc;

interface Animal {
    void sound();
}

class Dog implements Animal {

    @Override
    public  void sound() {System.out.println("haw haw");}
}

class Cat implements Animal {
    @Override
    public  void sound() {System.out.println("miaaaaaau");}
}

interface AnimalFactory{
    Animal createAnimal();
}

class DogFactory implements AnimalFactory{
    @Override
    public Animal createAnimal()
    {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory{
    @Override
    public Animal createAnimal()
    {
        return new Cat();
    }
}
/*
class MainEx1{

    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.sound();

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.sound();



    }

}

 */

//---------------------------------------------------------------------------------------------------------------------

interface Document {
    void open();
    void save();
}

class TextDocument implements Document{

    @Override
    public void open(){System.out.println("Text Document is opened");}
    @Override
    public void save(){System.out.println("Text Document is saved");}
}

class ImageDocument implements Document{

    @Override
    public void open(){System.out.println("Image is opened");}
    @Override
    public void save(){System.out.println("Image is saved");}
}

interface DocumentFactory{
    Document createDocument();
}

class TextDocumentFactory implements DocumentFactory{
    @Override
    public Document createDocument()
    {
        return new TextDocument();
    }
}

class ImageDocumentFactory implements DocumentFactory{
    @Override
    public Document createDocument()
    {
        return new ImageDocument();
    }
}

/*class MainEx1{

    public static void main(String[] args) {
        TextDocumentFactory textDocumentFactory = new TextDocumentFactory();
        Document txt = textDocumentFactory.createDocument();
        txt.open();
        txt.save();

        ImageDocumentFactory imgDocumentFactory = new ImageDocumentFactory();
        Document img = imgDocumentFactory.createDocument();
        img.open();
        img.save();



    }

}

 */
//---------------------------------------------------------------------------------------------------------------------

interface Chair{
    String sitOn();
}
class ModernChair implements Chair{

    @Override
    public String sitOn(){
        return "Sitting on a modern chair";
    }
}

class VictorianChair implements Chair{
    @Override
    public String sitOn(){
        return "Sitting on a victorian chair";
    }
}

interface Sofa{
    String lieOn();
}

class ModernSofa implements Sofa{

    @Override
    public String lieOn(){
        return "lying on a modern sofa";
    }
}

class VictorianSofa implements Sofa{

    @Override
    public String lieOn(){
        return "lying on a victorian sofa";
    }
}


interface FurnitureFactory{
    Chair createChair();
    Sofa createSofa();

}

class ModerFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair(){return new ModernChair();}

    @Override
    public Sofa createSofa(){return new ModernSofa();}
}

class VictorianFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair(){return new VictorianChair();}

    @Override
    public Sofa createSofa(){return new VictorianSofa();}
}

class Client{

    private final FurnitureFactory furnitureFactory;

    public Client(FurnitureFactory furnitureFactory){
        this.furnitureFactory=furnitureFactory;
    }

    public void useFurniture(){
        Chair chair = furnitureFactory.createChair();
        Sofa sofa = furnitureFactory.createSofa();

        System.out.println(chair.sitOn());
        System.out.println(sofa.lieOn());
    }
}

class MainEx1{

    public static void main(String[] args) {
        FurnitureFactory moderFactory = new ModerFurnitureFactory();
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();

        System.out.println("Client uses moder furniture:");
        Client client1 = new Client(moderFactory);
        client1.useFurniture();

        System.out.println("Client uses victorian furniture:");
        Client client2 = new Client(victorianFactory);
        client1.useFurniture();
    }
}


