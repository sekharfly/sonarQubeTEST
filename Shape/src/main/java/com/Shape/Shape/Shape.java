package com.Shape.Shape;

public class Shape {

	private Integer width;
	private Integer height;

	public Shape(Integer width, Integer height) {
		super();
		this.width = width;
		this.height = height;
	}

}

class Triangle extends Shape {

	public Triangle(Integer width, Integer height) {
		super(width, height);
		System.out.println("area of Triangle: " + (width * height) / 2);
	}

}

class Rectangle extends Shape {

	public Rectangle(Integer width, Integer height) {
		super(width, height);
		System.out.println("area of Rectangle: " + width * height);

	}

}

class MainClass {
	public static void main(String[] args) {
		Integer triangle = 10;
		Integer rectangle = 20;
		new Triangle(triangle, rectangle);
		new Rectangle(triangle, rectangle);
	}

}