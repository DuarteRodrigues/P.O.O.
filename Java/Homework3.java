// Duarte Rodrigues - a22206488
// Licenciatura de Engenharia Informática e Aplicações - IPLuso

class Lamp{
    //stores the value for light
    //true if light is on
    // false if light is off
    private boolean isOn;

    //method to turn the light on
    public void turnOn(){
        isOn = true;
        System.out.println("Light on?" + isOn);
    }

    //method to turn the light off
    public void turnOff(){
        isOn = false;
        System.out.println("Light on?" + isOn);
    }
}

class Person{
    private String name;
    private int age;
    

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}

class Phone{
    private double width;
    private double height;
    private String SO;
    private String brand;
    private double price;

    public Phone(double width, double height, String SO, String brand, double price){
        this.width = width;
        this.height = height;
        this.SO = SO;
        this.brand = brand;
        this.price = price;
    }

    public void call(){
        System.out.println("Calling...");
    }

    public void sendMessage(){
        System.out.println("Sending message...");
        System.out.println("Message sent!");
    }

    public void navigate(){
        System.out.println("Opening up the system's internet navigator...");
    }

    public void share(){
        System.out.println("Sharing content...");
    }
}

public class Homework3 {
    // Write a Java program to create an object named "animal" and a method called makeSound().  
    public void makeSound(){
        System.out.println("The animal makes a sound");
    }

    public void speed(){
        System.out.println("The car speed is 150.");
    }
    public static void main(String[] args){
        //Define variables

        // Define Objects
        Homework3 animal = new Homework3();
        Homework3 car = new Homework3();
        Lamp led = new Lamp();
        Lamp halogen = new Lamp();
        Person person1 = new Person("Ean Craig", 11);
        Person person2 = new Person("Evan Ross", 12);
        Phone Samsung_Galaxy_S4 = new Phone(6.98, 13.6, "Android", "Samsung", 1000);
        Phone Iphone = new Phone(5.86, 12.3, "iOS", "Apple", 1200);

        // Apply methods
        animal.makeSound();
        car.speed();
        led.turnOn();
        halogen.turnOff();
        System.out.println(person1.getName() + " is " + person1.getAge() + " years old");
        System.out.println(person2.getName() + " is " + person2.getAge() + " years old");
        Samsung_Galaxy_S4.call();
        Samsung_Galaxy_S4.sendMessage();
        Iphone.navigate();
        Iphone.share();
    
    }
}
