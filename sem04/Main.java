class Singleton{
    private static Singleton instance;

    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        if(instance==null);{
        instance = new Singleton();
        }
    return instance;
    }

public void doSomething(){
    System.out.println("Singleton is doing something");}
}

/*class MainEx1{
    public static void main(String[] args)
    {
        Singleton singletonInstance = Singleton.getInstance();
        singletonInstance.doSomething();
    }
}*/



class DatabaseConnection{
    private static volatile DatabaseConnection instance;

    private DatabaseConnection()
    {

    }

    public static DatabaseConnection getInstance()
    {
        if(instance==null)
        {
            synchronized (DatabaseConnection.class)
            {
                if(instance==null)
                {
                    instance=new DatabaseConnection();
                }
            }
        }
        return instance;
    }

}



interface Animal{
    void sound();

}

class Dog implements Animal{

    @Override
    public void sound(){System.out.println("Haw");}

}


class Cat implements Animal{

    @Override
    public void sound(){System.out.println("Miau");}


}


class AnimalFactory{

    public static Animal createAnimal(String type){
        if("Dog".equalsIgnoreCase(type)){
            return new Dog();
        } else if("Cat".equalsIgnoreCase(type)){
            return new Cat();
        } else {
            throw new IllegalArgumentException("Animal invalid");
        }
    }
}

/*class MainEx1_1{
    public static void main(String[]args)
    {
        Animal animalutz = AnimalFactory.createAnimal("Dog");
        animalutz.sound();

         animalutz = AnimalFactory.createAnimal("Cat");
        animalutz.sound();
    }
}*/


interface Shape{
    void draw();

}

class Square implements Shape{

    @Override
    public void draw(){System.out.println("Mare patrat desenat");}

}

class Circle implements Shape{

    @Override
    public void draw(){System.out.println("Mare cerc desenat");}
}

class ShapeFactory{
    public static Shape createShape(String type){
        if("Square".equalsIgnoreCase(type)){
            return new Square();
        } else if("Cerc".equalsIgnoreCase(type)){
            return new Circle();
        } else {
            throw new IllegalArgumentException("forma invalida :(");
        }
    }
}

class MainEx2{
    public static void main(String[] args) {
        Shape forma = ShapeFactory.createShape("Square");
        forma.draw();

        forma = ShapeFactory.createShape("Cerc");
        forma.draw();
    }
}