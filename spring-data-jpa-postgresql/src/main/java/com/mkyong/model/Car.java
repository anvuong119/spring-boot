package com.mkyong.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturer;
    private String model;
    private BigDecimal price;
    private LocalDate purchasedDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Author owner;

    // for JPA only, no use
    public Car() {
    }

    public Car(String manufacturer, String model, BigDecimal price, LocalDate purchasedDate) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.purchasedDate = purchasedDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model=" + model +
                ", price=" + price +
                ", purchasedDate=" + purchasedDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Car)) {
            return false;
        }
        Long otherId = ((Car) obj).getId();
        return id == otherId;
    }

    public Author getOwner() {
        return owner;
    }

    public void setOwner(Author owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        this.purchasedDate = purchasedDate;
    }
}
