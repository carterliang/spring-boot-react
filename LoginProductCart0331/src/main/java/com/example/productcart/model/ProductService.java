package com.example.productcart.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

@Service
public class ProductService {
	
	@Autowired
	ProductDAO dao;
	
	public List<ProductWithImage> getAllWithImage(){
		List<ProductWithImage> data=dao.findAll();
		return data;
	}
	
	public List<ProductWithImage> getAllWithOutImage(){
		List<ProductWithImage> data=dao.findAll();
		data.forEach(p-> p.setPicture(null));
		return data;
	}
	
	public byte[] getImageById(Integer id) {
		List<ProductWithImage> data=dao.findAll();
		ProductWithImage px=data.stream().filter(p->p.getId()==id).findAny().orElse(null);
		if(px!= null)
		    return px.getPicture();
		else
			return null;
	}
	public void insertProductsFromApi() {
        RestTemplate restTemplate = new RestTemplate();
        ProductWithImage[] products = restTemplate.getForObject("https://fakestoreapi.com/products", ProductWithImage[].class);
        List<ProductWithImage> productList = Arrays.asList(products);
        dao.saveAll(productList);
    }
    
    public boolean insertProductsImageFromApi() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ProductWithImage[] products = restTemplate.getForObject("https://fakestoreapi.com/products", ProductWithImage[].class);
        List<ProductWithImage> productList = Arrays.asList(products);
        for (ProductWithImage product : productList) {
            URL url = new URL(product.getImage());
            try (InputStream in = url.openStream()) {
                byte[] imageBytes = in.readAllBytes();
                product.setPicture(imageBytes);
            }
        }
        List<ProductWithImage> productList2=dao.saveAll(productList);
        if(productList2.size()>0)
        	return true;
        else
        	return false;
    }

}

