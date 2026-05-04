package shape;

import java.lang.Math;
//Cone class which extends abstract class shape.
public class Cone extends Shape{
	double radius;
	double height;
	double surA;
	double vol;
	//Constructor for cone requiring radius and height parameters.
	public Cone (double radius, double height) {
		this.radius = radius;
		this.height = height;
		
	}
	//Getter for radius.
	public double getRadius() {
		return radius;
	}
	//Getter for height.
	public double getHeight() {
		return height;
	}
	//Overriden method for surfaceArea() to calculate the surface area of a cone.
	@Override
	public double surfaceArea() {
		surA = Math.PI * this.radius *(this.radius + Math.sqrt(Math.pow(this.height, 2)+ Math.pow(this.radius, 2)));
		
		return surA;
	}
	//Overriden method for volume() to calculat the volume of a cone.
	@Override
	public double volume() {
		vol = ((Math.PI * Math.pow(this.radius, 2)* (this.height/3.0)));
		
		return vol;
	}
	//Overriden toString() method to print out surface area and volume given a radius and height for the cone.
	@Override
	public String toString() {
		
		return String.format("A Cone with Radius: %.2f and Height: %.2f has Surface Area: %.2f and Volume: %.2f", getRadius(), getHeight(), surfaceArea(), volume());
	}
}
