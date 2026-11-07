package Module3.builder;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private final String customer;
    private final String email;
    private final String phone;
    private final String address;
    private final List<String> items;
    private final int itemsTotal;

    public Order(Builder b) {
        this.id = b.id;
        this.customer = b.customer;
        this.email = b.email;
        this.phone = b.phone;
        this.address = b.address;
        this.items = b.items;
        this.itemsTotal = b.itemsTotal;
    }

    public int getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getItems() {
        return items;
    }

    public int getItemsTotal() {
        return itemsTotal;
    }

    @Override
    public String toString() {
        return "Заказ номер " + id +
                ": клиент ='" + customer + '\'' +
                ", email ='" + email + '\'' +
                ", телефон ='" + phone + '\'' +
                ", адрес ='" + address + '\'' +
                ", товары =" + items +
                ", сумма =" + itemsTotal;
    }

    public static class Builder {
        private final int id;
        private final String customer;
        private String email;
        private String phone;
        private String address;
        private final List<String> items = new ArrayList<>();
        private int itemsTotal;

        public Builder(int id, String customer) {
            this.id = id;
            this.customer = customer;
        }

        public Builder email(String email){ this.email = email; return  this;}
        public Builder phone(String phone){ this.phone = phone; return  this;}
        public Builder address(String address){ this.address = address; return  this;}
        public Builder addItem(String name, int price){
            this.items.add(name);
            this.itemsTotal += price;
            return this;
        }

        public Order build(){
            return new Order(this);
        }

    }
}


