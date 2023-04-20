import java.util.Comparator;

public class Exercise2303 {
	/** Generic quick sort using Comparable */
	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static <E extends Comparable<E>> 
			void quickSort(E[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	public static <E extends Comparable<E>> 
			int partition(E[] list, int first, int last) {
		E pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) {
			// Search forward from left
			while (low <= high && list[low].compareTo(pivot) <= 0)
				low++;

			// Search backward from right
			while (low <= high && list[high].compareTo(pivot) > 0)
				high--;

			// Swap two elements in the list
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && list[high].compareTo(pivot) >= 0)
			high--;

		// Swap pivot with list[high]
		if (pivot.compareTo(list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}

	public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		quickSort(list, 0, list.length - 1, comparator);
	}

	public static <E> void quickSort(
			E[] list, int first, int last, Comparator<? super E> comparator) {
		if (last > first) {
			int pivotIndex = partition(list, first, last, comparator);
			quickSort(list, first, pivotIndex - 1, comparator);
			quickSort(list, pivotIndex + 1, last, comparator);
		}
	}

	/** Partition the array list[first.. last] */
	public static <E> int partition(
			E[] list, int first, int last, Comparator<? super E> comparator) {
		E pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) {
			// Search forward from left
			while (low <= high && comparator.compare(list[low], pivot) <= 0)
				low++;

			// Search backward from right
			while (low <= high && comparator.compare(list[high], pivot) > 0)
				high--;

			// Swap two elements in the list
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && comparator.compare(list[high], pivot) >= 0)
			high--;

		// Swap pivot with list[high]
		if (comparator.compare(pivot, list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}

	/** A test method */
	public static void main(String[] args) {
		// Create an Integer array
		Integer[] intArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

		// Create a Double array
		Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};

		// Create a Character array
		Character[] charArray = {'a', 'J', 'r'};

		// Create a String array
		String[] stringArray = {"Tom", "Susan", "Kim"};

		// Sort the arrays
		quickSort(intArray);
		quickSort(doubleArray);
		quickSort(charArray);
		quickSort(stringArray);

		// Display the sorted arrays
		printList(intArray);
		printList(doubleArray);
		printList(charArray);
		printList(stringArray);

		// Create an array of 10 GeometricObjects
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), 
			new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
			new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
			new Circle(6.5), new Rectangle(4, 5)};

		// Invoke quick sort using GeometricObjectComparator
		quickSort(list, new GeometricObjectComparator());

		// Display the sorted elements
		printList(list);
	}

	/** Print an array elements */
	public static void printList(Object[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

	/** Print an array of elements */
	public static void printList(GeometricObject[] list) {
		System.out.print("Sorted elements: ");
		for (GeometricObject e: list) {
			System.out.printf("%.2f ", e.getArea());
		}
		System.out.println();
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