package shape;
import java.lang.Math;
//Sphere Class which extends abstract class shape
public class Sphere extends Shape {
	double surA;
	double vol;
	double radius;
	String results;
	//constructor for sphere requiring radius parameter
	public Sphere(double radius) {
		this.radius = radius;
	}
	//getter for radius
	public double getRadius() {
		return radius;
	}
	
	
	//overriding abstract method surfaceArea() for sphere.
	@Override
	public double surfaceArea(){
		surA = (4 * Math.PI *Math.pow(this.radius, 2));
		return surA;
	}
	//overriding abstract method volume() for sphere.
	@Override
	public double volume() {
		
		vol = (4.0 / 3.0  * Math.PI * Math.pow(radius, 3));
		
		return vol;
	}
	//overriding toString() method to print out surface are and volume of a sphere given a radius.
	@Override
	public String toString() {
		
		return String.format("A Sphere with Radius: %.2f has a Surface Area: %.2f, and Volume: %.2f", getRadius(), surfaceArea(), volume());
	}

}
