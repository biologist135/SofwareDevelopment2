package shape;
import java.lang.Math;

//Cylinder class which extends abstract shape class.
public class Cylinder extends Shape{
	double radius;
	double height;
	double surA;
	double vol;
	
	//Constructor requiring radius and height parameters.
	public Cylinder(double radius, double height) {
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
	
	//Overriden method for surfaceArea() for cylinder.
	@Override
	public double surfaceArea() {
		surA = ((2.0 * Math.PI * radius * height)+ (2.0 * Math.PI * Math.pow(radius, 2)));
		
		return surA;
	}
	//Overriden method for volume() for a cylinder.
	@Override
	public double volume() {
		vol = (Math.PI * Math.pow(radius, 2)* height);
		return vol;
	}
	//Overriden toString() method to print out surface area and volume given a radius and height for the cylinder.
	@Override
	public String toString() {
		
		return String.format("A Cylinder with Radius: %.2f and Height: %.2f has Surface Area: %.2f and Volume: %.2f", getRadius(), getHeight(), surfaceArea(), volume());
	}

}
