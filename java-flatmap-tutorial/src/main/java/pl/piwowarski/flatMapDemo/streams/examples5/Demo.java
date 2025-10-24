package pl.piwowarski.flatMapDemo.streams.examples5;

import java.util.List;
import java.util.stream.Collectors;

class Demo {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(List.of(new OrderItem(new Product("Laptop")), new OrderItem(new Product("Mouse")))),
                new Order(List.of(new OrderItem(new Product("Keyboard")), new OrderItem(new Product("Monitor"))))
        );

//        ✅ Example 3: Order → OrderItems → Product Names
        List<Product> productsNoMouse = orders.stream()
                .flatMap(order -> order.orderItems.stream())
                .map(OrderItem::getProduct)
                .filter(product -> !product.name.equals("Mouse"))
                .collect(Collectors.toList());

        System.out.println("productsNoMouse ");
        productsNoMouse.forEach(System.out::println);
    }
}
