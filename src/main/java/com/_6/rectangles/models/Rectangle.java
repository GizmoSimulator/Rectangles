package com._6.rectangles.models;

import jakarta.persistence.*;

@Entity
@Table(name="rectangles")
public class Rectangle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private double width;
    private double height;
    private String color;
    
    public Rectangle(String name, double width, double height, String color) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public Rectangle() {
        // Initialization code if needed
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
   
    
}
