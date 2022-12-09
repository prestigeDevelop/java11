package _Maps;

import java.time.LocalDateTime;


public class Order {
    private final int orderid;
    private final LocalDateTime createdDate;
    private final int items;
    private final String OrderLocation;

    public Order(int orderid, LocalDateTime createdDate, int items, String orderLocation) {
        this.orderid = orderid;
        this.createdDate = createdDate;
        this.items = items;
        OrderLocation = orderLocation;
    }

    public int getOrderid() {
        return orderid;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public int getItems() {
        return items;
    }

    public String getOrderLocation() {
        return OrderLocation;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", createdDate=" + createdDate +
                ", items=" + items +
                ", OrderLocation='" + OrderLocation + '\'' +
                '}';
    }
}
