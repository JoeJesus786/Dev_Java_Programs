package com.example.scb_springboot.controller.productcustomer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scb_springboot.entity.productcustomer.Product;
import com.example.scb_springboot.service.productcustomer.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/price/above/{threshold}")
    public List<Product> getProductsAbovePrice(@PathVariable Double threshold) {
        return productService.getProductsAbovePrice(threshold);
    }

    @GetMapping("/group-by-category")
    public Map<String, List<Product>> groupProductsByCategory() {
        return productService.groupProductsByCategory();
    }

    @GetMapping("/total-price")
    public Double getTotalPrice() {
        return productService.getTotalPrice();
    }

    @GetMapping("/names")
    public String getProductNames() {
        return productService.getProductNames();
    }

    @GetMapping("/average-price-by-category")
    public Map<String, Double> getAveragePriceByCategory() {
        return productService.getAveragePriceByCategory();
    }

    @GetMapping("/count-by-category")
    public Map<String, Long> countProductsByCategory() {
        return productService.countProductsByCategory();
    }

    @GetMapping("/category/{category}/stock-above/{threshold}")
    public List<Product> getProductsByCategoryAndStock(@PathVariable String category, @PathVariable Integer threshold) {
        return productService.getProductsByCategoryAndStock(category, threshold);
    }

    @GetMapping("/top/{n}")
    public List<Product> getTopNExpensiveProducts(@PathVariable int n) {
        return productService.getTopNExpensiveProducts(n);
    }

    @GetMapping("/low-stock/{threshold}")
    public List<Product> getLowStockProducts(@PathVariable Integer threshold) {
        return productService.getLowStockProducts(threshold);
    }
}
