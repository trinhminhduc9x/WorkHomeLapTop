package com.example.model;



import javax.persistence.*;
import java.util.Set;

@Entity
public class OrderacsAndPayacs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer payasc;
    private Integer orderasc;


    @OneToMany(mappedBy = "ordersssAndPaysss",cascade = CascadeType.ALL)
    private Set<Book> books;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPayasc() {
        return payasc;
    }

    public void setPayasc(Integer payasc) {
        this.payasc = payasc;
    }

    public Integer getOrderasc() {
        return orderasc;
    }

    public void setOrderasc(Integer orderasc) {
        this.orderasc = orderasc;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "OrderacsAndPayacs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", payasc=" + payasc +
                ", orderasc=" + orderasc +
                ", books=" + books +
                '}';
    }
}
