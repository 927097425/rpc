package Train.Final.Problem1;

import java.time.LocalDateTime;

public class Order {
    private String id;
    private String name;
    private LocalDateTime OrderedTime;
    private Double prices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getOrderedTime() {
        return OrderedTime;
    }

    public void setOrderedTime(LocalDateTime orderedTime) {
        OrderedTime = orderedTime;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", OrderedTime=" + OrderedTime +
                ", prices=" + prices +
                '}';
    }
}
