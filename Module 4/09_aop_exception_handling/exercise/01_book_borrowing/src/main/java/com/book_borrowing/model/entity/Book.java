package com.book_borrowing.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer quantity;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<BorrowCode> BorrowCodeList;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<BorrowCode> getBorrowCodeList() {
        return BorrowCodeList;
    }

    public void setBorrowCodeList(List<BorrowCode> BorrowCodeList) {
        this.BorrowCodeList = BorrowCodeList;
    }
}
