package uz.pdp.Car;

public class Customer {
    private String name;
    private String email;
    private Car carOfInterest;

    public Customer(String name, String email, Car carOfInterest) {
        this.name = name;
        this.email = email;
        this.carOfInterest = carOfInterest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
