package com.example.productcart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rating")
public class RatingWithImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Integer id;
	double rate;
	int count;
	public RatingWithImage() {
	}
	public RatingWithImage(double rating, int count) {		
		this.rate = rating;
		this.count = count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rating) {
		this.rate = rating;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rate + ", count=" + count + "]";
	}   	
}

 

