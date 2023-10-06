public class Vehicle {
    private String brand;
    private String model;

    // Constructor to initialize the vehicle's brand and model
    public Vehicle(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    // Method created to display info about the vehicle
    public void displayInfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }

    // Method to star the vehicle
    public void startVehicle(){
        System.out.println("Starting the " + brand + " " + model + " engine...");
    }

    public static void main(String[] args) {
        // Create two objects of the 'Vehicle' class
        Vehicle vehicle1 = new Vehicle("Toyota", "Corola");
        Vehicle vehicle2 = new Vehicle("Honda","Civic");

        // Call the displayInfo method for eact vehicle
        System.out.println("Vehicle 1:");
        vehicle1.displayInfo();

        System.out.println("Vehicle 2:");
        vehicle2.displayInfo();

        System.out.println("\nStarting Vehicles:");
        vehicle1.startVehicle();
        vehicle2.startVehicle();
    }
}