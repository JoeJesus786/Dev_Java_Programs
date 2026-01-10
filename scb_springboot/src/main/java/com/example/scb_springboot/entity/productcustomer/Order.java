package com.example.scb_springboot.entity.productcustomer;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;
    
    @OneToMany
    private List<Product> products;
    
    private LocalDateTime orderDate;
    private Double totalAmount;
    
    // Getters and Setters
    public Order() {
    	
    }

	public Order(Long id, Customer customer, List<Product> products, LocalDateTime orderDate, Double totalAmount) {
		super();
		this.id = id;
		this.customer = customer;
		this.products = products;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", products=" + products + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + "]";
	}
    
    
}