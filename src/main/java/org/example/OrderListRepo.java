package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo {
    private List<Order> orderList = new ArrayList<>();

    public List<Order> getAll() {
        return orderList;
    }

    @Override
    public void addOrder(Order order) {
        orderList.add(order);
    }

    @Override
    public void removeOrder(Order order) {
        orderList.remove(order);
    }

    @Override
    public Order getOrder(int id) {
        for (Order order : orderList) {
            if (order.id() == id) {
                return order;
            }
        }
        return null;
    }
}
