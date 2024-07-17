package com.example.productcart.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.productcart.model.*;

import java.util.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
@RequestMapping(value={"/products"})
public class ProductController {
    @Autowired
	ProductService srv;
    @Autowired
    ProductDAO dao;
    @GetMapping()
    public List<ProductWithImage> getAll(){
    	return srv.getAllWithOutImage();
    }
    
	@GetMapping(value={"/productImage"})
	public void productImage(HttpServletRequest request, HttpServletResponse response, 	@RequestParam("code") Integer code) throws IOException {
		byte[] bs=null;
		if (code != null) {
			bs= srv.getImageById(code);
		}
		if (bs != null ) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(bs);
		}
		response.getOutputStream().close();
	}
	@GetMapping("/saveall")
	 public ProductWithImage saveAll() {
   	 srv.insertProductsFromApi();
   	 return dao.findAll().get(0);
    }
    
    @GetMapping("/saveimages")
	 public ProductWithImage saveWithImages() {
   	 try {
			srv.insertProductsImageFromApi();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("save image error:"+e.getMessage());
		}
   	ProductWithImage px=dao.findAll().get(0);
   	px.setPicture(null);
    	return px; 
    }
}

