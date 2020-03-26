package com.company;

import java.util.Objects;

public class Customer {
    String firstname;
    String lastname;
    String phone;
    // Конструктор с параметрами
    public Customer (String firstname, String lastname, String phone){
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return firstname.equals(customer.firstname) &&
                lastname.equals(customer.lastname) &&
                phone.equals(customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, phone);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    // Вывод с помощью метода getFullName
    public void getFullName (){
        System.out.print(firstname + " " + lastname + " " + phone);
    }
}
