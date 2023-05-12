package com.redcom.redcom.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redcom.redcom.dto.Products;
import com.redcom.redcom.Repositories.ProductRepository;;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(value = "/registerProduct", produces = "application/json", consumes = "application/json")
    public Products registerProduct(@RequestBody Map<String, String> body, Products newProduct)
    {
        String productName = body.get("product_name");
        String price = body.get("price");
        String productType = body.get("product_type");
        String productProperties = body.get("product_properties");
        String productDescription = body.get("product_description");
        String category = body.get("category");
        String productImage = body.get("product_image");

        newProduct.setProductName(productName);
        newProduct.setPrice(Integer.parseInt(price));
        newProduct.setProductType(productType);
        newProduct.setProductProperties(productProperties);
        newProduct.setProductDescription(productDescription);
        newProduct.setProductCategory(category);
        newProduct.setProductImage(productImage);

        return productRepository.save(newProduct);
    }

    @GetMapping("/getProductById")
    public List<Products> registerProduct(@RequestParam int id)
    {
        return productRepository.findById(id);
    }

    @GetMapping("/getAllProducts")
    public List<Products> getAllProducts()
    {
        return productRepository.findAll();
    }
}
