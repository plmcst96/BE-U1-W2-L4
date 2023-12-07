package CristinaPalmisani;

import CristinaPalmisani.entities.Customer;
import CristinaPalmisani.entities.Order;
import CristinaPalmisani.entities.Product;
import com.github.javafaker.Faker;

import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Product book = new Product("GOT", "Books", 130);
        Product book2 = new Product("Hunger Games", "Books", 120);
        Product book3 = new Product("GOT", "Books", 30);
        Product book4 = new Product("GOT", "Books", 50);
        Product book5 = new Product("Saga Hearry Potter", "Books", 250);
        Product phone = new Product("IPhone 15 Pro Max", "Smartphone", 1467);
        Product baby = new Product("ciuccio", "Baby", 20);
        Product baby2 = new Product("bavaglino", "Baby", 50);
        Product baby3 = new Product("gioco", "Baby", 230);
        Product car = new Product("porche", "Boys", 200020);
        Product car3 = new Product("punto", "Boys", 12000);
        Product car2 = new Product("Range Rover", "Boys", 89000);

        Faker faker = new Faker(Locale.ITALY);

        Customer user1 = new Customer(faker.gameOfThrones().character() + " " + faker.name().lastName(), 5);
        Customer user2 = new Customer(faker.gameOfThrones().character() + " " + faker.name().lastName(), 2);
        Customer user3 = new Customer(faker.gameOfThrones().character() + " " + faker.name().lastName(), 4);
        Customer user4 = new Customer(faker.gameOfThrones().character() + " " + faker.name().lastName(), 1);

        List<Product> cart1 = Arrays.asList(book, book4, car2, book2);
        List<Product> cart2 = Arrays.asList(book2, book3, car, book3, car3);
        List<Product> cart3 = Arrays.asList(book5, phone, baby, baby2, baby3);
        List<Product> cart4 = Arrays.asList(book4, baby,  car3);

        Order order1 = new Order("loadin", LocalDate.now(), cart1, user1);
        Order order2 = new Order("loading", LocalDate.now(), cart2, user2);
        Order order3 = new Order("stop", LocalDate.now(), cart3, user3);
        Order order4 = new Order("start", LocalDate.now(), cart4, user4);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        System.out.println("------------------- Esercizio 1 -----------------");

        Map<Customer, List<Order>> orderCustomerMap = orders.stream().collect(Collectors.groupingBy(Order::getCustomer));
        orderCustomerMap.forEach(((customer, ordersList) -> System.out.println(customer + " - " + ordersList)));
    }

}
