package springapp.service;

import java.util.List;

import springapp.domain.Product;

public interface ProductManager{

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();
    
}