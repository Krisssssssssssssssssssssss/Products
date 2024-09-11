package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo {
    private List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }
    public void addOrder(Order order) {
        orderList.add(order);
    }
    public void removeOrder(Order order) {
        orderList.remove(order);
    }
    public Order getOrder(int id) {
        for (Order order : orderList) {
            if (order.id() == id) {
                return order;
            }
        }
        return null;
    }
}
