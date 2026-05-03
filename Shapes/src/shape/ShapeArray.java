package shape;

import java.lang.Math;

public class ShapeArray {

	public static void main(String[] args) {
		Sphere s1 = new Sphere(Math.random()*9.0);
		Cylinder cy1 = new Cylinder(Math.random()*9.0, Math.random()*9.0);
		Cone c1 = new Cone(Math.random()*9.0,Math.random()*9.0);
		Shape[] shapeArray = {s1, cy1, c1};
		
		
		
		for(int i = 0; i < shapeArray.length; ++i) {
			
			System.out.println(shapeArray[i].toString());
		}
		
	}

}
