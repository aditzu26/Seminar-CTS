 /*interface VehicleWithDoors{
    public void drive();
    public void stop();
    public void refuel();
        }

 interface VehicleWithOutDoors{
public void openDoors();
public void closeDoors();
        }

 class Bike implements VehicleWithOutDoors{
    public void drive(){}
    public void stop(){}
    public void refuel(){}
    public void openDoors(){}
    public void closeDoors(){}
}
*/
/*public class Main{
    public static void main(String[] args){

    }
}

interface Engine{
    public void start();
}
class Car{
    private Engine engine;
    public Car(Engine e){
        engine=e;
    }
    public void start(){
        engine.start();
    }
}
class PetrolEngine implements Engine{
    public void start(){};

}
class DieselEngine implements Engine{
    public void start(){};
}*/



 import java.util.ArrayList;

 public class Main {

     public static void main(String[] args) {
         // write your code here
         OnlineShop o = new OnlineShop("Emag", "logo.jpg", new ArrayList<Product>());

         Product p1 = new Product("Laptop", 3200.5, 1,1, 1123, "");
         Product p2 = new Product("Frigider", 207.95, 1,2, 1245, "");

         Product p3 = new Product(p1);

         p3.setQty(5);
         p3.setProdName("Paine");

         o.addProduct(p1);
         o.addProduct(p2);

         o.removeProduct(p1);
         System.out.println(p1.equals(p2));
     }
 }

 class OnlineShop {
     private String name;
     private String image;
     private ArrayList<Product> products;

     OnlineShop(String Name, String img, ArrayList<Product> products)
     {
         this.products = new ArrayList<Product>();
         this.image = img;
         this.name = Name;
     }

     public void removeProduct(Product p)
     {
         this.products.remove(p);
     }

     public void addProduct(Product p)
     {
         this.products.add(p);
     }



     public String getOnlineShopName() {
         return name;
     }

     public void setOnlineShopName(String onlineShopName) {
         this.name = onlineShopName;
     }

     public String getImage() {
         return image;
     }

     public void setImage(String Image) {
         this.image = Image;
     }
 }

 class Product
 {
     private int id;
     private String name;
     private double price;
     private int type;
     private int category;
     private int quantity;
     private String expiry_Date; //expiry date - only for goods
     private String specifications; // ex.: processor, memory, power, volume (for refrigerators etc)

     public Product(String Name, double Price, int Type, int Category, int Id, String Expiry_Date)
     {
         name = Name;
         price = Price;
         type = Type;
         category = Category;
         this.id = Id;
         this.expiry_Date = Expiry_Date;
     }

     public Product(Product p)
     {
         this.name = p.name;
         this.price = p.price;
         this.type = p.type;
         this.category = p.category;
         this.id = p.id;
     }

     public double getProductPrice() {
         return price;
     }

     public void setProductPrice(double productPrice) {
         this.price = productPrice;
     }

     public String getProdName() {
         return name;
     }

     public void setProdName(String prodName) {
         this.name = prodName;
     }

     public int getProductType() {
         return type;
     }

     public void setProductType(int productType) {
         this.type = productType;
     }

     public boolean equals(Product p)
     {


         if(p.id == this.id && p.name.equals(this.name) && p.price == this.price && p.price == p.type && p.category == this.category )
             return true;
         return false;
     }

     public void modify(boolean flag, double val)
     {
         if(flag)
             this.price+=this.price*val;
         if(!flag)
             this.price-=this.price*val/100;
     }

     public int getQty() {
         return quantity;
     }

     public void setQty(int qty) {
         this.quantity = qty;
     }

     public int getProdId() {
         return id;
     }

     public void setProdId(int prodId) {
         this.id = prodId;
     }

     public String getDetails() {
         return specifications;
     }

     public void setDetails(String details) {
         this.specifications = details;
     }
 }

 class User
 {
     private String username;
     private String Id;
     private ArrayList<Order> o;
     private ArrayList<Order> c;

     public User(String usn, String userId)
     {
         this.username = usn;
         this.Id = userId;
         o=new ArrayList<Order>();
         c=new ArrayList<Order>();
     }

     public void addO1(Order o)
     {
         this.o.add(o);
     }

     public void addO2(Order o)
     {
         this.c.add(o);
     }
 }

 class Order
 {
     private ArrayList<Product> l;
     private String addr;

     public Order()
     {
         l = new ArrayList<Product>();
     }
     public void add(Product p)
     {
         if(l.size() > 99)
             return;

         l.add(p);
     }

     public void remove(Product p)
     {
         l.remove(p);
     }

     public String getAddr() {
         return addr;
     }

     public void setAddr(String addr) {
         this.addr = addr;
     }
 }

 class InventoryP
 {
     private Product p;
     private int quantity;

     public InventoryP(Product p, int q)
     {
         this.p = new Product(p);
         this.quantity = q;
     }
     public Product getP() {
         return p;
     }

     public void setP(Product p) {
         this.p = p;
     }

     public int getQ() {
         return quantity;
     }

     public void setQ(int q) {
         this.quantity = q;
     }
 }


