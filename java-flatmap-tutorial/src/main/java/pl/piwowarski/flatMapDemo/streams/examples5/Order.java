package pl.piwowarski.flatMapDemo.streams.examples5;

import java.util.List;

class Order {
    List<OrderItem> orderItems;

    Order(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
