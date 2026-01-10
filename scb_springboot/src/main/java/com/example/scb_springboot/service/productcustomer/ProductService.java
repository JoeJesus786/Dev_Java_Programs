package com.example.scb_springboot.service.productcustomer;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scb_springboot.entity.productcustomer.Product;
import com.example.scb_springboot.repository.productcustomer.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsAbovePrice(Double threshold) {
        return productRepository.findAll().stream()
                .filter(p -> p.getPrice() > threshold)
                .collect(Collectors.toList());
    }

    public Map<String, List<Product>> groupProductsByCategory() {
        return productRepository.findAll().stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public Double getTotalPrice() {
        return productRepository.findAll().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public String getProductNames() {
        return productRepository.findAll().stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));
    }

    public Map<String, Double> getAveragePriceByCategory() {
        return productRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));
    }

    public Map<String, Long> countProductsByCategory() {
        return productRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.counting()
                ));
    }

    public List<Product> getProductsByCategoryAndStock(String category, Integer threshold) {
        return productRepository.findAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getQuantityAvailable() > threshold)
                .collect(Collectors.toList());
    }

    public List<Product> getTopNExpensiveProducts(int n) {
        return productRepository.findAll().stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Product> getLowStockProducts(Integer threshold) {
        return productRepository.findAll().stream()
                .filter(p -> p.getQuantityAvailable() < threshold)
                .collect(Collectors.toList());
    }
}
