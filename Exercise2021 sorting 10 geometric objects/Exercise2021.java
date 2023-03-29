import java.util.Comparator;

public class Exercise2021 {
	public static void main(String[] args) {
		// Create an array of 10 GeometricObjects
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
			new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
			new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
			new Circle(6.5), new Rectangle(4, 5)};

		// Invoke selection sort using GeometricObjectComparator
		selectionSort(list, new GeometricObjectComparator());
		
		// Display the sorted elements
		System.out.print("Sorted elements: ");
		for (GeometricObject e: list) {
				System.out.printf("%.2f ", e.getArea());
		}
		System.out.println();
	}

	/** Generic selection sort method */
	public static <E> void selectionSort(E[] list,
			Comparator<? super E> comparator) {
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			E currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (comparator.compare(currentMin, list[j]) > 0) {
				currentMin = list[j];
				currentMinIndex = j;
			}
		}

		// Swap list[i] with list[currentMinIndex] if necessary
		if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
}

class Circle
		extends GeometricObject {
	private double radius;
			
	public Circle() {
	}
			
	public Circle(double radius) {
		this.radius = radius;
	}
			
	public Circle(double radius, 
		String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}
			
	/** Return radius */
	public double getRadius() {
		return radius;
	}
			
	/** Set a new radius */
	public void setRadius(double radius) {
		this.radius = radius;
	}
			
	@Override /** Return area */
	public double getArea() {
		return radius * radius * Math.PI;
	}
			
	/** Return diameter */
	public double getDiameter() {
		return 2 * radius;
	}
			
	@Override /** Return perimeter */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
			
	@Override /** Override the toString method in the Object class */
	public String toString() {
		return super.toString() + ", Circle, Created: " 
			+ getDateCreated() + ", Radius: " + radius;
	}
}

abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	/** Construct a default geometric object */
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	/** Construct a geometric object with color and filled value */
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	/** Return color */
	public String getColor() {
		return color;
	}
	
	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}
	
	/** Return filled. Since filled is boolean,
	 *  the get method is named isFilled */
	public boolean isFilled() {
		return filled;
	}
	
	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	/** Get dateCreated */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color +
			" and filled: " + filled;
	}
	
	/** Abstract method getArea */
	public abstract double getArea();
	
	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
}

class GeometricObjectComparator
		implements Comparator<GeometricObject>, java.io.Serializable {
	public int compare(GeometricObject o1, GeometricObject o2) {
		double area1 = o1.getArea();
		double area2 = o2.getArea();
		
		if (area1 < area2)
			return -1;
		else if (area1 == area2)
			return 0;
		else
			return 1;
	}
}

class Rectangle
		extends GeometricObject {
	private double width;
	private double height;
			
	public Rectangle() {
	}
			
	public Rectangle(
		double width, double height) {
		this.width = width;
		this.height = height;
	}
			
	public Rectangle(
		double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
	}
			
	/** Return width */
	public double getWidth() {
		return width;
	}
			
	/** Set a new width */
	public void setWidth(double width) {
		this. width = width;
	}
			
	/** Return height */
	public double getheight() {
		return height;
	}
			
	/** Set a new height */
	public void setheight(double height) {
		this.height = height;
	}
			
	@Override /** Return area */
	public double getArea() {
		return width * height;
	}
			
	@Override /** Return perimeter */
	public double getPerimeter() {
		return 2 * (width * height);
	}
			
	@Override /** Override the toString method in the Object class */
	public String toString() {
		return super.toString() + " Rectangle, Created: " 
			+ getDateCreated() + ", Width: " + width + 
			", Height: " + height;
	}
}