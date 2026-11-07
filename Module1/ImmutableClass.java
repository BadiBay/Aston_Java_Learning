package Module1;

import java.util.Objects;

class Address {
    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public Address(Address other) {
        this(other.city, other.street);
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}

final class Person {
    private final String name;
    private final Address address;

    public Person(String name, Address address) {
        this.name = Objects.requireNonNull(name, "name");
        this.address = new Address(Objects.requireNonNull(address, "address"));
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return new Address(address);
    }

    public Person changeAddress(Address newAddress) {
        return new Person(name, newAddress);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

public class ImmutableClass{
    static void main(String[] args) {
        Address address = new Address("Киров", "Московская, 1");

        Person person = new Person("Иван", address);
        System.out.println("Исходный профиль: " + person);

        address.setCity("Санкт-Петербург");
        System.out.println("После попытки правки адреса: " + person);

        person.getAddress().setStreet("Тверская, 13");
        System.out.println("После попытки правки через геттер: " + person);

        Person moved = person.changeAddress(new Address("Казань", "Баумана, 5"));
        System.out.println("Новый профиль: " + moved);
        System.out.println("Старый профиль: " + person);
    }
}