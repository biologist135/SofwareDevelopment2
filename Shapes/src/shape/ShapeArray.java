package shape;

import java.lang.Math;

//ShapeArray class.
public class ShapeArray {
	//Main.
	public static void main(String[] args) {
		//Instantiates a sphere, cylinder, and cone and puts them into a Shape array.
		Sphere s1 = new Sphere(Math.random()*9.0);
		Cylinder cy1 = new Cylinder(Math.random()*9.0, Math.random()*9.0);
		Cone c1 = new Cone(Math.random()*9.0,Math.random()*9.0);
		Shape[] shapeArray = {s1, cy1, c1};
	
		//Iterates over the indices of the shapeArray array, and calls toString method for each object.
		for(int i = 0; i < shapeArray.length; ++i) {
			
			System.out.println(shapeArray[i].toString());
		}
		
	}

}
