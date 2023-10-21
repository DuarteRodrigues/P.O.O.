import java.util.Date;

class Employee{
    String name;
    int age;
    String designation;
    double salary;

    public Employee(String name, int age, String designation, double salary){
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Designation" + designation);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

class Bike{
    double price;
    String model;
    String colour;

    public Bike(double price, String model, String color){
        this.price = price;
        this.model = model;
        this.colour = color;
    }
    
    public double speed(){
        return price * 0.02;
    }

    public void printDetails(){
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Colour: " + colour);
        System.out.println("Speed: " + speed() + " Mph");
        System.out.println();
    }
}

class Student{
    private int enrollmentNumber;
    private String courseName;
    private Date birthDate;

    public Student(int enrollmentNumber, String courseName, Date birthDate){
        this.enrollmentNumber = enrollmentNumber;
        this.courseName = courseName;
        this.birthDate = birthDate;
    }

    public long calculateAgeInDays(){
        Date currentDate = new Date();
        long ageInMillis = currentDate.getTime() - birthDate.getTime();
        return ageInMillis / (24*60*60*1000);
    }

    public void printDetails(){
        System.out.println("Enrollment Number: " + enrollmentNumber);
        System.out.println("Course Name: " + courseName);
        System.out.println("Age in days: " + calculateAgeInDays() + " days");
        System.out.println();
    }
}

class Data{
    private int day;
    private int month;
    private int year;

    public void setDay(int day) {
        if (isValidDate(day, month, year)) {
            this.day = day;
        } else {
            System.out.println("Invalid day for the given month and year.");
        }
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        if (isValidDate(day, month, year)) {
            this.month = month;
        } else {
            System.out.println("Invalid month for the given day and year.");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        if (isValidDate(day, month, year)) {
            this.year = year;
        } else {
            System.out.println("Invalid year for the given day and month.");
        }
    }

    public int getYear() {
        return year;
    }

    public boolean isValidDate(int day, int month, int year) {
        if (year >= 1 && month >= 1 && month <= 12) {
            int maxDay = 31;
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                maxDay = 30;
            } else if (month == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    maxDay = 29; // Leap year
                } else {
                    maxDay = 28; // Non-leap year
                }
            }
            return day >= 1 && day <= maxDay;
        }
        return false;
    }
}

class Animal{
    private String skinColour;
    private String name;

    public Animal(String skinColor, String name){
        this.skinColour=skinColor;
        this.name = name;
    }

    public void voice(){
        System.out.println(name + " makes a sound");
    }

    public void sleep(){
        System.out.println(name + " sleeps all day long");
    }

    public void printDetails(){
        System.out.println("Name: " +name);
        System.out.println("Skin colour: "+skinColour);
    }
}

class Weather{
    private String season;
    private double temperature;

    public Weather(String season, double temperature){
        this.season=season;
        this.temperature=temperature;
    }

    public void predictRain(){
        if(season.equalsIgnoreCase("Spring") && temperature >= 15 && temperature <=25){
            System.out.println("It may rain today.");
        }
        if(season.equalsIgnoreCase("Summer") && temperature >= 25 && temperature <=35){
            System.out.println("It may rain today.");
        }
        if(season.equalsIgnoreCase("Fall") && temperature >= 10 && temperature <=20){
            System.out.println("It may rain today.");
        }
        if(season.equalsIgnoreCase("Winter") && temperature >= 0 && temperature <=10){
            System.out.println("It may rain today.");
        } else {
            System.out.println("No chance of rain in the current weather conditions.");
        }
    }
}

class Cow{
    String country;
    int age;
    String colour;
    boolean produce_milk;

    public Cow(String country, int age, String colour, boolean produce_milk){
        this.country = country;
        this.age = age;
        this.colour = colour;
        this.produce_milk = produce_milk;
    }

    public void cowInfo(){
        System.out.println("Country: " +country);
        System.out.println("Age" + age);
        System.out.println("Colour: " + colour);
        System.out.println("Produces Milk: "+ (produce_milk ? "Yes" : "No"));
    }
}

public class Homework5 {
    public static void main(String[] args){
        Employee employee1 = new Employee("John Doe", 30, "Manager", 500);
        Employee employee2 = new Employee("Alice Smith", 25, "Engineer", 350);
        Employee employee3 = new Employee("Bob Johnson", 35, "Designer", 420);
        Employee employee4 = new Employee("Eva Green", 28, "Developer", 380);

        Employee[] employees = {employee1, employee2, employee3, employee4};

        Bike bike1 = new Bike(300, "Mountain Bike", "Red");
        Bike bike2 = new Bike(250, "City Bike", "Blue");
        Bike bike3 = new Bike(400, "Road Bike", "Black");
        Bike bike4 = new Bike(350, "Hybrid Bike", "Green");

        Date birthDate1 = new Date(2000-1900, 5, 15);
        Student student1 = new Student(101, "Computer Science", birthDate1);

        Date birthDate2 = new Date(1999-1900, 8, 20);
        Student student2 = new Student(102, "Mathematics", birthDate2);

        Data date = new Data();
        date.setYear(2023);
        date.setMonth(10);
        date.setDay(20);

        Animal animal1 = new Animal("Brown", "Lion");
        Animal animal2 = new Animal("Gray", "Elephant");

        Weather todayWeather = new Weather("Spring", 20.0);

        Cow cow1 = new Cow("India", 5, "Brown", true);
        Cow cow2 = new Cow("USA", 6, "Black & White", false);

        for (Employee employee : employees){
            if (employee.salary < 400){
                employee.displayInfo();
            }
        }

        System.out.println("Details of Bike 1:");
        bike1.printDetails();

        System.out.println("Details of Bike 2:");
        bike2.printDetails();

        System.out.println("Details of Student 1:");
        student1.printDetails();

        System.out.println("Details of Student 2:");
        student2.printDetails();

        System.out.println("Year: " + date.getYear());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Day: " + date.getDay());

        System.out.println("Details of Animal 1: ");
        animal1.printDetails();
        animal1.voice();
        animal1.sleep();

        System.out.println("Details of Animal 2:");
        animal2.printDetails();
        animal2.voice();
        animal2.sleep();

        todayWeather.predictRain();

        System.out.println("Cow 1 Info:");
        cow1.cowInfo();

        System.out.println("Cow 2 Info:");
        cow2.cowInfo();
    }
}
