package shape;
import java.lang.Math;

public class Cylinder extends Shape{
	double radius;
	double height;
	double surA;
	double vol;
	
	public Cylinder(double radius, double height) {
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
		surA = ((2.0 * Math.PI * radius * height)+ (2.0 * Math.PI * Math.pow(radius, 2)));
		
		return surA;
	}
	@Override
	public double volume() {
		vol = (Math.PI * Math.pow(radius, 2)* height);
		return vol;
	}
	
	@Override
	public String toString() {
		
		return String.format("A Cylinder with Radius: %.2f and Height: %.2f has Surface Area: %.2f and Volume: %.2f", getRadius(), getHeight(), surfaceArea(), volume());
	}

}
