package com.infoshare.academy.utils;

import com.infoshare.academy.model.Product;

import java.util.List;

public class ProductsUtils {

    public static Double countTotalPrice(List<Product> productList){
        return productList.stream().map(product -> product.price).reduce(Double::sum).get();
    }
}
