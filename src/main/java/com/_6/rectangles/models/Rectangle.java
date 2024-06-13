package com._6.rectangles.models;

public class Rectangle {
    private int id;
    private String name;
    private double width;
    private double height;
    private String color;
    
    public Rectangle(int id, String name, double width, double height, String color) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
