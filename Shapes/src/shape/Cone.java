package shape;

import java.lang.Math;

public class Cone extends Shape{
	double radius;
	double height;
	double surA;
	double vol;
	
	public Cone (double radius, double height) {
		this.radius = radius;
		this.height = height;
		
	}
	public double getRadius() {
		return radius;
	}
	
	public double getHeight() {
		return height;
	}
	
	@Override
	public double surfaceArea() {
		surA = Math.PI * this.radius *(this.radius + Math.sqrt(Math.pow(this.height, 2)+ Math.pow(this.radius, 2)));
		
		return surA;
	}
	
	@Override
	public double volume() {
		vol = ((Math.PI * Math.pow(this.radius, 2)* (this.height/3.0)));
		
		return vol;
	}
	@Override
	public String toString() {
		
		return String.format("A Cone with Radius: %.2f and Height: %.2f has Surface Area: %.2f and Volume: %.2f", getRadius(), getHeight(), surfaceArea(), volume());
	}
}
