package uz.pdp.Car;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class CarDealership {
    private BlockingQueue<Customer> customerQueue;

    public CarDealership() {
        customerQueue = new LinkedBlockingQueue<>();
    }

    public void addCustomerRequest(Customer customer) {
        try {
            customerQueue.put(customer);
            System.out.println(customer.getName() + " avtomobil sotib olish uchun so'rov qo'shildi.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processCustomerRequest() {
        try {
            Customer customer = customerQueue.take();
            System.out.println("Sotuvchi so'rovni ko'rib chiqmoqda " + customer.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
