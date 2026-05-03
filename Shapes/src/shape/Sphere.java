package shape;
import java.lang.Math;

public class Sphere extends Shape {
	double surA;
	double vol;
	double radius;
	String results;
	
	public Sphere(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	
	
	@Override
	public double surfaceArea(){
		surA = (4 * Math.PI *Math.pow(this.radius, 2));
		return surA;
	}
	@Override
	public double volume() {
		
		vol = (4.0 / 3.0  * Math.PI * Math.pow(radius, 3));
		
		return vol;
	}
	@Override
	public String toString() {
		
		return String.format("A Sphere with Radius: %.2f has a Surface Area: %.2f, and Volume: %.2f", getRadius(), surfaceArea(), volume());
	}

}
