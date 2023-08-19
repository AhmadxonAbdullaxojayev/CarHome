package uz.pdp.Car;

public class Main {
    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();

        for (int i = 1; i <= 5; i++) {
            final int customerId = i;
            Thread customerThread = new Thread(() -> {
                String customerName = "Mijoz " + customerId;
                String customerEmail = "mijoz" + customerId + "@example.com";
                Car carOfInterest = new Car("Make" + customerId, "Model" + customerId, 2023, 25000.0 * customerId);
                Customer customer = new Customer(customerName, customerEmail, carOfInterest);
                dealership.addCustomerRequest(customer);
                dealership.processCustomerRequest();
            });
            customerThread.start();
        }
    }
}
