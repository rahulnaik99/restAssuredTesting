package ecomWebsite.pojoPackages;

import java.util.List;

public class orderRequest {
    private List<createOrderRequest> orders;

    public List<createOrderRequest> getOrders() {
        return orders;
    }

    public void setOrders(List<createOrderRequest> orders) {
        this.orders = orders;
    }

}
