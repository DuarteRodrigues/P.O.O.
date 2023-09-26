class Vehicle():
    brand = ""
    model = ""

    def __init__(self, brand, model):
        self.brand = brand
        self.model = model
        pass
    
    def displayInfo(self, ):
        print("Brand: ", self.brand)
        print("Model: ", self.model)
        pass

    def startVehicle(self):
        print("Starting the", self.brand, self.model, "engine...")
        pass

vehicle1 = Vehicle("Toyota", "Corola")
vehicle2 = Vehicle("Honda", "Civic")

print("Vehicle 1:")
vehicle1.displayInfo()

print("\nVehicle 2:")
vehicle2. displayInfo()

print("\nStarting Vehicles:")
vehicle1.startVehicle()
vehicle2.startVehicle()